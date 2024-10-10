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
// source: google/spanner/admin/database/v1/spanner_database_admin.proto

// Protobuf Java Version: 3.25.5
package com.google.spanner.admin.database.v1;

public interface ListDatabaseOperationsRequestOrBuilder
    extends
    // @@protoc_insertion_point(interface_extends:google.spanner.admin.database.v1.ListDatabaseOperationsRequest)
    com.google.protobuf.MessageOrBuilder {

  /**
   *
   *
   * <pre>
   * Required. The instance of the database operations.
   * Values are of the form `projects/&lt;project&gt;/instances/&lt;instance&gt;`.
   * </pre>
   *
   * <code>
   * string parent = 1 [(.google.api.field_behavior) = REQUIRED, (.google.api.resource_reference) = { ... }
   * </code>
   *
   * @return The parent.
   */
  java.lang.String getParent();
  /**
   *
   *
   * <pre>
   * Required. The instance of the database operations.
   * Values are of the form `projects/&lt;project&gt;/instances/&lt;instance&gt;`.
   * </pre>
   *
   * <code>
   * string parent = 1 [(.google.api.field_behavior) = REQUIRED, (.google.api.resource_reference) = { ... }
   * </code>
   *
   * @return The bytes for parent.
   */
  com.google.protobuf.ByteString getParentBytes();

  /**
   *
   *
   * <pre>
   * An expression that filters the list of returned operations.
   *
   * A filter expression consists of a field name, a
   * comparison operator, and a value for filtering.
   * The value must be a string, a number, or a boolean. The comparison operator
   * must be one of: `&lt;`, `&gt;`, `&lt;=`, `&gt;=`, `!=`, `=`, or `:`.
   * Colon `:` is the contains operator. Filter rules are not case sensitive.
   *
   * The following fields in the [Operation][google.longrunning.Operation]
   * are eligible for filtering:
   *
   *   * `name` - The name of the long-running operation
   *   * `done` - False if the operation is in progress, else true.
   *   * `metadata.&#64;type` - the type of metadata. For example, the type string
   *      for
   *      [RestoreDatabaseMetadata][google.spanner.admin.database.v1.RestoreDatabaseMetadata]
   *      is
   *      `type.googleapis.com/google.spanner.admin.database.v1.RestoreDatabaseMetadata`.
   *   * `metadata.&lt;field_name&gt;` - any field in metadata.value.
   *      `metadata.&#64;type` must be specified first, if filtering on metadata
   *      fields.
   *   * `error` - Error associated with the long-running operation.
   *   * `response.&#64;type` - the type of response.
   *   * `response.&lt;field_name&gt;` - any field in response.value.
   *
   * You can combine multiple expressions by enclosing each expression in
   * parentheses. By default, expressions are combined with AND logic. However,
   * you can specify AND, OR, and NOT logic explicitly.
   *
   * Here are a few examples:
   *
   *   * `done:true` - The operation is complete.
   *   * `(metadata.&#64;type=type.googleapis.com/google.spanner.admin.database.v1.RestoreDatabaseMetadata) AND` &#92;
   *     `(metadata.source_type:BACKUP) AND` &#92;
   *     `(metadata.backup_info.backup:backup_howl) AND` &#92;
   *     `(metadata.name:restored_howl) AND` &#92;
   *     `(metadata.progress.start_time &lt; &#92;"2018-03-28T14:50:00Z&#92;") AND` &#92;
   *     `(error:*)` - Return operations where:
   *     * The operation's metadata type is
   *     [RestoreDatabaseMetadata][google.spanner.admin.database.v1.RestoreDatabaseMetadata].
   *     * The database is restored from a backup.
   *     * The backup name contains "backup_howl".
   *     * The restored database's name contains "restored_howl".
   *     * The operation started before 2018-03-28T14:50:00Z.
   *     * The operation resulted in an error.
   * </pre>
   *
   * <code>string filter = 2;</code>
   *
   * @return The filter.
   */
  java.lang.String getFilter();
  /**
   *
   *
   * <pre>
   * An expression that filters the list of returned operations.
   *
   * A filter expression consists of a field name, a
   * comparison operator, and a value for filtering.
   * The value must be a string, a number, or a boolean. The comparison operator
   * must be one of: `&lt;`, `&gt;`, `&lt;=`, `&gt;=`, `!=`, `=`, or `:`.
   * Colon `:` is the contains operator. Filter rules are not case sensitive.
   *
   * The following fields in the [Operation][google.longrunning.Operation]
   * are eligible for filtering:
   *
   *   * `name` - The name of the long-running operation
   *   * `done` - False if the operation is in progress, else true.
   *   * `metadata.&#64;type` - the type of metadata. For example, the type string
   *      for
   *      [RestoreDatabaseMetadata][google.spanner.admin.database.v1.RestoreDatabaseMetadata]
   *      is
   *      `type.googleapis.com/google.spanner.admin.database.v1.RestoreDatabaseMetadata`.
   *   * `metadata.&lt;field_name&gt;` - any field in metadata.value.
   *      `metadata.&#64;type` must be specified first, if filtering on metadata
   *      fields.
   *   * `error` - Error associated with the long-running operation.
   *   * `response.&#64;type` - the type of response.
   *   * `response.&lt;field_name&gt;` - any field in response.value.
   *
   * You can combine multiple expressions by enclosing each expression in
   * parentheses. By default, expressions are combined with AND logic. However,
   * you can specify AND, OR, and NOT logic explicitly.
   *
   * Here are a few examples:
   *
   *   * `done:true` - The operation is complete.
   *   * `(metadata.&#64;type=type.googleapis.com/google.spanner.admin.database.v1.RestoreDatabaseMetadata) AND` &#92;
   *     `(metadata.source_type:BACKUP) AND` &#92;
   *     `(metadata.backup_info.backup:backup_howl) AND` &#92;
   *     `(metadata.name:restored_howl) AND` &#92;
   *     `(metadata.progress.start_time &lt; &#92;"2018-03-28T14:50:00Z&#92;") AND` &#92;
   *     `(error:*)` - Return operations where:
   *     * The operation's metadata type is
   *     [RestoreDatabaseMetadata][google.spanner.admin.database.v1.RestoreDatabaseMetadata].
   *     * The database is restored from a backup.
   *     * The backup name contains "backup_howl".
   *     * The restored database's name contains "restored_howl".
   *     * The operation started before 2018-03-28T14:50:00Z.
   *     * The operation resulted in an error.
   * </pre>
   *
   * <code>string filter = 2;</code>
   *
   * @return The bytes for filter.
   */
  com.google.protobuf.ByteString getFilterBytes();

  /**
   *
   *
   * <pre>
   * Number of operations to be returned in the response. If 0 or
   * less, defaults to the server's maximum allowed page size.
   * </pre>
   *
   * <code>int32 page_size = 3;</code>
   *
   * @return The pageSize.
   */
  int getPageSize();

  /**
   *
   *
   * <pre>
   * If non-empty, `page_token` should contain a
   * [next_page_token][google.spanner.admin.database.v1.ListDatabaseOperationsResponse.next_page_token]
   * from a previous
   * [ListDatabaseOperationsResponse][google.spanner.admin.database.v1.ListDatabaseOperationsResponse]
   * to the same `parent` and with the same `filter`.
   * </pre>
   *
   * <code>string page_token = 4;</code>
   *
   * @return The pageToken.
   */
  java.lang.String getPageToken();
  /**
   *
   *
   * <pre>
   * If non-empty, `page_token` should contain a
   * [next_page_token][google.spanner.admin.database.v1.ListDatabaseOperationsResponse.next_page_token]
   * from a previous
   * [ListDatabaseOperationsResponse][google.spanner.admin.database.v1.ListDatabaseOperationsResponse]
   * to the same `parent` and with the same `filter`.
   * </pre>
   *
   * <code>string page_token = 4;</code>
   *
   * @return The bytes for pageToken.
   */
  com.google.protobuf.ByteString getPageTokenBytes();
}
