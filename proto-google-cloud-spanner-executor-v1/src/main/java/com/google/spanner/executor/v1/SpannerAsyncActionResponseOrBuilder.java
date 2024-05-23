/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: google/spanner/executor/v1/cloud_executor.proto

// Protobuf Java Version: 3.25.3
package com.google.spanner.executor.v1;

public interface SpannerAsyncActionResponseOrBuilder
    extends
    // @@protoc_insertion_point(interface_extends:google.spanner.executor.v1.SpannerAsyncActionResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   *
   *
   * <pre>
   * Action id corresponds to the request.
   * </pre>
   *
   * <code>int32 action_id = 1;</code>
   *
   * @return The actionId.
   */
  int getActionId();

  /**
   *
   *
   * <pre>
   * If action results are split into multiple responses, only the last response
   * can and should contain status.
   * </pre>
   *
   * <code>.google.spanner.executor.v1.SpannerActionOutcome outcome = 2;</code>
   *
   * @return Whether the outcome field is set.
   */
  boolean hasOutcome();
  /**
   *
   *
   * <pre>
   * If action results are split into multiple responses, only the last response
   * can and should contain status.
   * </pre>
   *
   * <code>.google.spanner.executor.v1.SpannerActionOutcome outcome = 2;</code>
   *
   * @return The outcome.
   */
  com.google.spanner.executor.v1.SpannerActionOutcome getOutcome();
  /**
   *
   *
   * <pre>
   * If action results are split into multiple responses, only the last response
   * can and should contain status.
   * </pre>
   *
   * <code>.google.spanner.executor.v1.SpannerActionOutcome outcome = 2;</code>
   */
  com.google.spanner.executor.v1.SpannerActionOutcomeOrBuilder getOutcomeOrBuilder();
}
