/*
 * Copyright 2017 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.spanner;

import com.google.api.gax.rpc.ServerStream;
import com.google.cloud.Timestamp;
import com.google.cloud.spanner.Options.TransactionOption;
import com.google.cloud.spanner.Options.UpdateOption;
import com.google.cloud.spanner.SessionPool.PooledSessionFuture;
import com.google.cloud.spanner.SpannerImpl.ClosedException;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Function;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.spanner.v1.BatchWriteResponse;
import javax.annotation.Nullable;

class DatabaseClientImpl implements DatabaseClient {
  private static final String READ_WRITE_TRANSACTION = "CloudSpanner.ReadWriteTransaction";
  private static final String READ_ONLY_TRANSACTION = "CloudSpanner.ReadOnlyTransaction";
  private static final String PARTITION_DML_TRANSACTION = "CloudSpanner.PartitionDMLTransaction";
  private final TraceWrapper tracer;
  @VisibleForTesting final String clientId;
  @VisibleForTesting final SessionPool pool;
  @VisibleForTesting final MultiplexedSessionDatabaseClient multiplexedSessionDatabaseClient;
  @VisibleForTesting final boolean useMultiplexedSessionForRW;

  final boolean useMultiplexedSessionBlindWrite;

  @VisibleForTesting
  DatabaseClientImpl(SessionPool pool, TraceWrapper tracer) {
    this(
        "",
        pool,
        /* useMultiplexedSessionBlindWrite = */ false,
        /* multiplexedSessionDatabaseClient = */ null,
        tracer,
        false);
  }

  @VisibleForTesting
  DatabaseClientImpl(String clientId, SessionPool pool, TraceWrapper tracer) {
    this(
        clientId,
        pool,
        /* useMultiplexedSessionBlindWrite = */ false,
        /* multiplexedSessionDatabaseClient = */ null,
        tracer,
        false);
  }

  DatabaseClientImpl(
      String clientId,
      SessionPool pool,
      boolean useMultiplexedSessionBlindWrite,
      @Nullable MultiplexedSessionDatabaseClient multiplexedSessionDatabaseClient,
      TraceWrapper tracer,
      boolean useMultiplexedSessionForRW) {
    this.clientId = clientId;
    this.pool = pool;
    this.useMultiplexedSessionBlindWrite = useMultiplexedSessionBlindWrite;
    this.multiplexedSessionDatabaseClient = multiplexedSessionDatabaseClient;
    this.tracer = tracer;
    this.useMultiplexedSessionForRW = useMultiplexedSessionForRW;
  }

  @VisibleForTesting
  PooledSessionFuture getSession() {
    return pool.getSession();
  }

  @VisibleForTesting
  DatabaseClient getMultiplexedSession() {
    if (canUseMultiplexedSessions()) {
      return this.multiplexedSessionDatabaseClient;
    }
    return pool.getMultiplexedSessionWithFallback();
  }
  
  
  @VisibleForTesting
  DatabaseClient getMultiplexedSessionForRW() {
    if (this.useMultiplexedSessionForRW) {
      return getMultiplexedSession();
    }
    return getSession();
  }

  private MultiplexedSessionDatabaseClient getMultiplexedSessionDatabaseClient() {
    return canUseMultiplexedSessions() ? this.multiplexedSessionDatabaseClient : null;
  }

  private boolean canUseMultiplexedSessions() {
    return this.multiplexedSessionDatabaseClient != null
        && this.multiplexedSessionDatabaseClient.isMultiplexedSessionsSupported();
  }

  @Override
  public Dialect getDialect() {
    return pool.getDialect();
  }

  @Override
  @Nullable
  public String getDatabaseRole() {
    return pool.getDatabaseRole();
  }

  @Override
  public Timestamp write(final Iterable<Mutation> mutations) throws SpannerException {
    return writeWithOptions(mutations).getCommitTimestamp();
  }

  @Override
  public CommitResponse writeWithOptions(
      final Iterable<Mutation> mutations, final TransactionOption... options)
      throws SpannerException {
    ISpan span = tracer.spanBuilder(READ_WRITE_TRANSACTION, options);
    try (IScope s = tracer.withSpan(span)) {
      return runWithSessionRetry(session -> session.writeWithOptions(mutations, options));
    } catch (RuntimeException e) {
      span.setStatus(e);
      throw e;
    } finally {
      span.end();
    }
  }

  @Override
  public Timestamp writeAtLeastOnce(final Iterable<Mutation> mutations) throws SpannerException {
    return writeAtLeastOnceWithOptions(mutations).getCommitTimestamp();
  }

  @Override
  public CommitResponse writeAtLeastOnceWithOptions(
      final Iterable<Mutation> mutations, final TransactionOption... options)
      throws SpannerException {
    ISpan span = tracer.spanBuilder(READ_WRITE_TRANSACTION, options);
    try (IScope s = tracer.withSpan(span)) {
      if (useMultiplexedSessionBlindWrite && getMultiplexedSessionDatabaseClient() != null) {
        return getMultiplexedSessionDatabaseClient()
            .writeAtLeastOnceWithOptions(mutations, options);
      }
      return runWithSessionRetry(
          session -> session.writeAtLeastOnceWithOptions(mutations, options));
    } catch (RuntimeException e) {
      span.setStatus(e);
      throw e;
    } finally {
      span.end();
    }
  }

  @Override
  public ServerStream<BatchWriteResponse> batchWriteAtLeastOnce(
      final Iterable<MutationGroup> mutationGroups, final TransactionOption... options)
      throws SpannerException {
    ISpan span = tracer.spanBuilder(READ_WRITE_TRANSACTION, options);
    try (IScope s = tracer.withSpan(span)) {
      return runWithSessionRetry(session -> session.batchWriteAtLeastOnce(mutationGroups, options));
    } catch (RuntimeException e) {
      span.setStatus(e);
      throw e;
    } finally {
      span.end();
    }
  }

  @Override
  public ReadContext singleUse() {
    ISpan span = tracer.spanBuilder(READ_ONLY_TRANSACTION);
    try (IScope s = tracer.withSpan(span)) {
      return getMultiplexedSession().singleUse();
    } catch (RuntimeException e) {
      span.setStatus(e);
      span.end();
      throw e;
    }
  }

  @Override
  public ReadContext singleUse(TimestampBound bound) {
    ISpan span = tracer.spanBuilder(READ_ONLY_TRANSACTION);
    try (IScope s = tracer.withSpan(span)) {
      return getMultiplexedSession().singleUse(bound);
    } catch (RuntimeException e) {
      span.setStatus(e);
      span.end();
      throw e;
    }
  }

  @Override
  public ReadOnlyTransaction singleUseReadOnlyTransaction() {
    ISpan span = tracer.spanBuilder(READ_ONLY_TRANSACTION);
    try (IScope s = tracer.withSpan(span)) {
      return getMultiplexedSession().singleUseReadOnlyTransaction();
    } catch (RuntimeException e) {
      span.setStatus(e);
      span.end();
      throw e;
    }
  }

  @Override
  public ReadOnlyTransaction singleUseReadOnlyTransaction(TimestampBound bound) {
    ISpan span = tracer.spanBuilder(READ_ONLY_TRANSACTION);
    try (IScope s = tracer.withSpan(span)) {
      return getMultiplexedSession().singleUseReadOnlyTransaction(bound);
    } catch (RuntimeException e) {
      span.setStatus(e);
      span.end();
      throw e;
    }
  }

  @Override
  public ReadOnlyTransaction readOnlyTransaction() {
    ISpan span = tracer.spanBuilder(READ_ONLY_TRANSACTION);
    try (IScope s = tracer.withSpan(span)) {
      return getMultiplexedSession().readOnlyTransaction();
    } catch (RuntimeException e) {
      span.setStatus(e);
      span.end();
      throw e;
    }
  }

  @Override
  public ReadOnlyTransaction readOnlyTransaction(TimestampBound bound) {
    ISpan span = tracer.spanBuilder(READ_ONLY_TRANSACTION);
    try (IScope s = tracer.withSpan(span)) {
      return getMultiplexedSession().readOnlyTransaction(bound);
    } catch (RuntimeException e) {
      span.setStatus(e);
      span.end();
      throw e;
    }
  }

  @Override
  public TransactionRunner readWriteTransaction(TransactionOption... options) {
    ISpan span = tracer.spanBuilder(READ_WRITE_TRANSACTION, options);
    try (IScope s = tracer.withSpan(span)) {
      return getMultiplexedSessionForRW().readWriteTransaction(options);
    } catch (RuntimeException e) {
      span.setStatus(e);
      span.end();
      throw e;
    }
  }

  @Override
  public TransactionManager transactionManager(TransactionOption... options) {
    ISpan span = tracer.spanBuilder(READ_WRITE_TRANSACTION, options);
    try (IScope s = tracer.withSpan(span)) {
      return getSession().transactionManager(options);
    } catch (RuntimeException e) {
      span.setStatus(e);
      span.end();
      throw e;
    }
  }

  @Override
  public AsyncRunner runAsync(TransactionOption... options) {
    ISpan span = tracer.spanBuilder(READ_WRITE_TRANSACTION, options);
    try (IScope s = tracer.withSpan(span)) {
      return getSession().runAsync(options);
    } catch (RuntimeException e) {
      span.setStatus(e);
      span.end();
      throw e;
    }
  }

  @Override
  public AsyncTransactionManager transactionManagerAsync(TransactionOption... options) {
    ISpan span = tracer.spanBuilder(READ_WRITE_TRANSACTION, options);
    try (IScope s = tracer.withSpan(span)) {
      return getSession().transactionManagerAsync(options);
    } catch (RuntimeException e) {
      span.setStatus(e);
      span.end();
      throw e;
    }
  }

  @Override
  public long executePartitionedUpdate(final Statement stmt, final UpdateOption... options) {
    ISpan span = tracer.spanBuilder(PARTITION_DML_TRANSACTION);
    try (IScope s = tracer.withSpan(span)) {
      return runWithSessionRetry(session -> session.executePartitionedUpdate(stmt, options));
    } catch (RuntimeException e) {
      span.setStatus(e);
      span.end();
      throw e;
    }
  }

  private <T> T runWithSessionRetry(Function<Session, T> callable) {
    PooledSessionFuture session = getSession();
    while (true) {
      try {
        return callable.apply(session);
      } catch (SessionNotFoundException e) {
        session =
            (PooledSessionFuture)
                pool.getPooledSessionReplacementHandler().replaceSession(e, session);
      }
    }
  }

  boolean isValid() {
    return pool.isValid()
        && (multiplexedSessionDatabaseClient == null
            || multiplexedSessionDatabaseClient.isValid()
            || !multiplexedSessionDatabaseClient.isMultiplexedSessionsSupported());
  }

  ListenableFuture<Void> closeAsync(ClosedException closedException) {
    if (this.multiplexedSessionDatabaseClient != null) {
      // This method is non-blocking.
      this.multiplexedSessionDatabaseClient.close();
    }
    return pool.closeAsync(closedException);
  }
}
