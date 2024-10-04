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
// source: google/spanner/v1/spanner.proto

// Protobuf Java Version: 3.25.5
package com.google.spanner.v1;

public interface BatchCreateSessionsResponseOrBuilder
    extends
    // @@protoc_insertion_point(interface_extends:google.spanner.v1.BatchCreateSessionsResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   *
   *
   * <pre>
   * The freshly created sessions.
   * </pre>
   *
   * <code>repeated .google.spanner.v1.Session session = 1;</code>
   */
  java.util.List<com.google.spanner.v1.Session> getSessionList();
  /**
   *
   *
   * <pre>
   * The freshly created sessions.
   * </pre>
   *
   * <code>repeated .google.spanner.v1.Session session = 1;</code>
   */
  com.google.spanner.v1.Session getSession(int index);
  /**
   *
   *
   * <pre>
   * The freshly created sessions.
   * </pre>
   *
   * <code>repeated .google.spanner.v1.Session session = 1;</code>
   */
  int getSessionCount();
  /**
   *
   *
   * <pre>
   * The freshly created sessions.
   * </pre>
   *
   * <code>repeated .google.spanner.v1.Session session = 1;</code>
   */
  java.util.List<? extends com.google.spanner.v1.SessionOrBuilder> getSessionOrBuilderList();
  /**
   *
   *
   * <pre>
   * The freshly created sessions.
   * </pre>
   *
   * <code>repeated .google.spanner.v1.Session session = 1;</code>
   */
  com.google.spanner.v1.SessionOrBuilder getSessionOrBuilder(int index);
}
