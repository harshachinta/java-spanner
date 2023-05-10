/*
 * Copyright 2020 Google LLC
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

package com.google.spanner.v1;

/**
 *
 *
 * <pre>
 * The response for [PartitionQuery][google.spanner.v1.Spanner.PartitionQuery]
 * or [PartitionRead][google.spanner.v1.Spanner.PartitionRead]
 * </pre>
 *
 * Protobuf type {@code google.spanner.v1.PartitionResponse}
 */
public final class PartitionResponse extends com.google.protobuf.GeneratedMessageV3
    implements
    // @@protoc_insertion_point(message_implements:google.spanner.v1.PartitionResponse)
    PartitionResponseOrBuilder {
  private static final long serialVersionUID = 0L;
  // Use PartitionResponse.newBuilder() to construct.
  private PartitionResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }

  private PartitionResponse() {
    partitions_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(UnusedPrivateParameter unused) {
    return new PartitionResponse();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet getUnknownFields() {
    return this.unknownFields;
  }

  public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
    return com.google.spanner.v1.SpannerProto
        .internal_static_google_spanner_v1_PartitionResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.google.spanner.v1.SpannerProto
        .internal_static_google_spanner_v1_PartitionResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.google.spanner.v1.PartitionResponse.class,
            com.google.spanner.v1.PartitionResponse.Builder.class);
  }

  public static final int PARTITIONS_FIELD_NUMBER = 1;

  @SuppressWarnings("serial")
  private java.util.List<com.google.spanner.v1.Partition> partitions_;
  /**
   *
   *
   * <pre>
   * Partitions created by this request.
   * </pre>
   *
   * <code>repeated .google.spanner.v1.Partition partitions = 1;</code>
   */
  @java.lang.Override
  public java.util.List<com.google.spanner.v1.Partition> getPartitionsList() {
    return partitions_;
  }
  /**
   *
   *
   * <pre>
   * Partitions created by this request.
   * </pre>
   *
   * <code>repeated .google.spanner.v1.Partition partitions = 1;</code>
   */
  @java.lang.Override
  public java.util.List<? extends com.google.spanner.v1.PartitionOrBuilder>
      getPartitionsOrBuilderList() {
    return partitions_;
  }
  /**
   *
   *
   * <pre>
   * Partitions created by this request.
   * </pre>
   *
   * <code>repeated .google.spanner.v1.Partition partitions = 1;</code>
   */
  @java.lang.Override
  public int getPartitionsCount() {
    return partitions_.size();
  }
  /**
   *
   *
   * <pre>
   * Partitions created by this request.
   * </pre>
   *
   * <code>repeated .google.spanner.v1.Partition partitions = 1;</code>
   */
  @java.lang.Override
  public com.google.spanner.v1.Partition getPartitions(int index) {
    return partitions_.get(index);
  }
  /**
   *
   *
   * <pre>
   * Partitions created by this request.
   * </pre>
   *
   * <code>repeated .google.spanner.v1.Partition partitions = 1;</code>
   */
  @java.lang.Override
  public com.google.spanner.v1.PartitionOrBuilder getPartitionsOrBuilder(int index) {
    return partitions_.get(index);
  }

  public static final int TRANSACTION_FIELD_NUMBER = 2;
  private com.google.spanner.v1.Transaction transaction_;
  /**
   *
   *
   * <pre>
   * Transaction created by this request.
   * </pre>
   *
   * <code>.google.spanner.v1.Transaction transaction = 2;</code>
   *
   * @return Whether the transaction field is set.
   */
  @java.lang.Override
  public boolean hasTransaction() {
    return transaction_ != null;
  }
  /**
   *
   *
   * <pre>
   * Transaction created by this request.
   * </pre>
   *
   * <code>.google.spanner.v1.Transaction transaction = 2;</code>
   *
   * @return The transaction.
   */
  @java.lang.Override
  public com.google.spanner.v1.Transaction getTransaction() {
    return transaction_ == null
        ? com.google.spanner.v1.Transaction.getDefaultInstance()
        : transaction_;
  }
  /**
   *
   *
   * <pre>
   * Transaction created by this request.
   * </pre>
   *
   * <code>.google.spanner.v1.Transaction transaction = 2;</code>
   */
  @java.lang.Override
  public com.google.spanner.v1.TransactionOrBuilder getTransactionOrBuilder() {
    return transaction_ == null
        ? com.google.spanner.v1.Transaction.getDefaultInstance()
        : transaction_;
  }

  private byte memoizedIsInitialized = -1;

  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output) throws java.io.IOException {
    for (int i = 0; i < partitions_.size(); i++) {
      output.writeMessage(1, partitions_.get(i));
    }
    if (transaction_ != null) {
      output.writeMessage(2, getTransaction());
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < partitions_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream.computeMessageSize(1, partitions_.get(i));
    }
    if (transaction_ != null) {
      size += com.google.protobuf.CodedOutputStream.computeMessageSize(2, getTransaction());
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
      return true;
    }
    if (!(obj instanceof com.google.spanner.v1.PartitionResponse)) {
      return super.equals(obj);
    }
    com.google.spanner.v1.PartitionResponse other = (com.google.spanner.v1.PartitionResponse) obj;

    if (!getPartitionsList().equals(other.getPartitionsList())) return false;
    if (hasTransaction() != other.hasTransaction()) return false;
    if (hasTransaction()) {
      if (!getTransaction().equals(other.getTransaction())) return false;
    }
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (getPartitionsCount() > 0) {
      hash = (37 * hash) + PARTITIONS_FIELD_NUMBER;
      hash = (53 * hash) + getPartitionsList().hashCode();
    }
    if (hasTransaction()) {
      hash = (37 * hash) + TRANSACTION_FIELD_NUMBER;
      hash = (53 * hash) + getTransaction().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.google.spanner.v1.PartitionResponse parseFrom(java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.google.spanner.v1.PartitionResponse parseFrom(
      java.nio.ByteBuffer data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.google.spanner.v1.PartitionResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.google.spanner.v1.PartitionResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.google.spanner.v1.PartitionResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }

  public static com.google.spanner.v1.PartitionResponse parseFrom(
      byte[] data, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }

  public static com.google.spanner.v1.PartitionResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.google.spanner.v1.PartitionResponse parseFrom(
      java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.google.spanner.v1.PartitionResponse parseDelimitedFrom(
      java.io.InputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(PARSER, input);
  }

  public static com.google.spanner.v1.PartitionResponse parseDelimitedFrom(
      java.io.InputStream input, com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseDelimitedWithIOException(
        PARSER, input, extensionRegistry);
  }

  public static com.google.spanner.v1.PartitionResponse parseFrom(
      com.google.protobuf.CodedInputStream input) throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(PARSER, input);
  }

  public static com.google.spanner.v1.PartitionResponse parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3.parseWithIOException(
        PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() {
    return newBuilder();
  }

  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }

  public static Builder newBuilder(com.google.spanner.v1.PartitionResponse prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }

  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   *
   *
   * <pre>
   * The response for [PartitionQuery][google.spanner.v1.Spanner.PartitionQuery]
   * or [PartitionRead][google.spanner.v1.Spanner.PartitionRead]
   * </pre>
   *
   * Protobuf type {@code google.spanner.v1.PartitionResponse}
   */
  public static final class Builder extends com.google.protobuf.GeneratedMessageV3.Builder<Builder>
      implements
      // @@protoc_insertion_point(builder_implements:google.spanner.v1.PartitionResponse)
      com.google.spanner.v1.PartitionResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor getDescriptor() {
      return com.google.spanner.v1.SpannerProto
          .internal_static_google_spanner_v1_PartitionResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.google.spanner.v1.SpannerProto
          .internal_static_google_spanner_v1_PartitionResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.google.spanner.v1.PartitionResponse.class,
              com.google.spanner.v1.PartitionResponse.Builder.class);
    }

    // Construct using com.google.spanner.v1.PartitionResponse.newBuilder()
    private Builder() {}

    private Builder(com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
    }

    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      if (partitionsBuilder_ == null) {
        partitions_ = java.util.Collections.emptyList();
      } else {
        partitions_ = null;
        partitionsBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000001);
      transaction_ = null;
      if (transactionBuilder_ != null) {
        transactionBuilder_.dispose();
        transactionBuilder_ = null;
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor getDescriptorForType() {
      return com.google.spanner.v1.SpannerProto
          .internal_static_google_spanner_v1_PartitionResponse_descriptor;
    }

    @java.lang.Override
    public com.google.spanner.v1.PartitionResponse getDefaultInstanceForType() {
      return com.google.spanner.v1.PartitionResponse.getDefaultInstance();
    }

    @java.lang.Override
    public com.google.spanner.v1.PartitionResponse build() {
      com.google.spanner.v1.PartitionResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.google.spanner.v1.PartitionResponse buildPartial() {
      com.google.spanner.v1.PartitionResponse result =
          new com.google.spanner.v1.PartitionResponse(this);
      buildPartialRepeatedFields(result);
      if (bitField0_ != 0) {
        buildPartial0(result);
      }
      onBuilt();
      return result;
    }

    private void buildPartialRepeatedFields(com.google.spanner.v1.PartitionResponse result) {
      if (partitionsBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          partitions_ = java.util.Collections.unmodifiableList(partitions_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.partitions_ = partitions_;
      } else {
        result.partitions_ = partitionsBuilder_.build();
      }
    }

    private void buildPartial0(com.google.spanner.v1.PartitionResponse result) {
      int from_bitField0_ = bitField0_;
      if (((from_bitField0_ & 0x00000002) != 0)) {
        result.transaction_ =
            transactionBuilder_ == null ? transaction_ : transactionBuilder_.build();
      }
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }

    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field, java.lang.Object value) {
      return super.setField(field, value);
    }

    @java.lang.Override
    public Builder clearField(com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }

    @java.lang.Override
    public Builder clearOneof(com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }

    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field, int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }

    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field, java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }

    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.google.spanner.v1.PartitionResponse) {
        return mergeFrom((com.google.spanner.v1.PartitionResponse) other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.google.spanner.v1.PartitionResponse other) {
      if (other == com.google.spanner.v1.PartitionResponse.getDefaultInstance()) return this;
      if (partitionsBuilder_ == null) {
        if (!other.partitions_.isEmpty()) {
          if (partitions_.isEmpty()) {
            partitions_ = other.partitions_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensurePartitionsIsMutable();
            partitions_.addAll(other.partitions_);
          }
          onChanged();
        }
      } else {
        if (!other.partitions_.isEmpty()) {
          if (partitionsBuilder_.isEmpty()) {
            partitionsBuilder_.dispose();
            partitionsBuilder_ = null;
            partitions_ = other.partitions_;
            bitField0_ = (bitField0_ & ~0x00000001);
            partitionsBuilder_ =
                com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders
                    ? getPartitionsFieldBuilder()
                    : null;
          } else {
            partitionsBuilder_.addAllMessages(other.partitions_);
          }
        }
      }
      if (other.hasTransaction()) {
        mergeTransaction(other.getTransaction());
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 10:
              {
                com.google.spanner.v1.Partition m =
                    input.readMessage(com.google.spanner.v1.Partition.parser(), extensionRegistry);
                if (partitionsBuilder_ == null) {
                  ensurePartitionsIsMutable();
                  partitions_.add(m);
                } else {
                  partitionsBuilder_.addMessage(m);
                }
                break;
              } // case 10
            case 18:
              {
                input.readMessage(getTransactionFieldBuilder().getBuilder(), extensionRegistry);
                bitField0_ |= 0x00000002;
                break;
              } // case 18
            default:
              {
                if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                  done = true; // was an endgroup tag
                }
                break;
              } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }

    private int bitField0_;

    private java.util.List<com.google.spanner.v1.Partition> partitions_ =
        java.util.Collections.emptyList();

    private void ensurePartitionsIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        partitions_ = new java.util.ArrayList<com.google.spanner.v1.Partition>(partitions_);
        bitField0_ |= 0x00000001;
      }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
            com.google.spanner.v1.Partition,
            com.google.spanner.v1.Partition.Builder,
            com.google.spanner.v1.PartitionOrBuilder>
        partitionsBuilder_;

    /**
     *
     *
     * <pre>
     * Partitions created by this request.
     * </pre>
     *
     * <code>repeated .google.spanner.v1.Partition partitions = 1;</code>
     */
    public java.util.List<com.google.spanner.v1.Partition> getPartitionsList() {
      if (partitionsBuilder_ == null) {
        return java.util.Collections.unmodifiableList(partitions_);
      } else {
        return partitionsBuilder_.getMessageList();
      }
    }
    /**
     *
     *
     * <pre>
     * Partitions created by this request.
     * </pre>
     *
     * <code>repeated .google.spanner.v1.Partition partitions = 1;</code>
     */
    public int getPartitionsCount() {
      if (partitionsBuilder_ == null) {
        return partitions_.size();
      } else {
        return partitionsBuilder_.getCount();
      }
    }
    /**
     *
     *
     * <pre>
     * Partitions created by this request.
     * </pre>
     *
     * <code>repeated .google.spanner.v1.Partition partitions = 1;</code>
     */
    public com.google.spanner.v1.Partition getPartitions(int index) {
      if (partitionsBuilder_ == null) {
        return partitions_.get(index);
      } else {
        return partitionsBuilder_.getMessage(index);
      }
    }
    /**
     *
     *
     * <pre>
     * Partitions created by this request.
     * </pre>
     *
     * <code>repeated .google.spanner.v1.Partition partitions = 1;</code>
     */
    public Builder setPartitions(int index, com.google.spanner.v1.Partition value) {
      if (partitionsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensurePartitionsIsMutable();
        partitions_.set(index, value);
        onChanged();
      } else {
        partitionsBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     *
     *
     * <pre>
     * Partitions created by this request.
     * </pre>
     *
     * <code>repeated .google.spanner.v1.Partition partitions = 1;</code>
     */
    public Builder setPartitions(
        int index, com.google.spanner.v1.Partition.Builder builderForValue) {
      if (partitionsBuilder_ == null) {
        ensurePartitionsIsMutable();
        partitions_.set(index, builderForValue.build());
        onChanged();
      } else {
        partitionsBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     *
     *
     * <pre>
     * Partitions created by this request.
     * </pre>
     *
     * <code>repeated .google.spanner.v1.Partition partitions = 1;</code>
     */
    public Builder addPartitions(com.google.spanner.v1.Partition value) {
      if (partitionsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensurePartitionsIsMutable();
        partitions_.add(value);
        onChanged();
      } else {
        partitionsBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     *
     *
     * <pre>
     * Partitions created by this request.
     * </pre>
     *
     * <code>repeated .google.spanner.v1.Partition partitions = 1;</code>
     */
    public Builder addPartitions(int index, com.google.spanner.v1.Partition value) {
      if (partitionsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensurePartitionsIsMutable();
        partitions_.add(index, value);
        onChanged();
      } else {
        partitionsBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     *
     *
     * <pre>
     * Partitions created by this request.
     * </pre>
     *
     * <code>repeated .google.spanner.v1.Partition partitions = 1;</code>
     */
    public Builder addPartitions(com.google.spanner.v1.Partition.Builder builderForValue) {
      if (partitionsBuilder_ == null) {
        ensurePartitionsIsMutable();
        partitions_.add(builderForValue.build());
        onChanged();
      } else {
        partitionsBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     *
     *
     * <pre>
     * Partitions created by this request.
     * </pre>
     *
     * <code>repeated .google.spanner.v1.Partition partitions = 1;</code>
     */
    public Builder addPartitions(
        int index, com.google.spanner.v1.Partition.Builder builderForValue) {
      if (partitionsBuilder_ == null) {
        ensurePartitionsIsMutable();
        partitions_.add(index, builderForValue.build());
        onChanged();
      } else {
        partitionsBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     *
     *
     * <pre>
     * Partitions created by this request.
     * </pre>
     *
     * <code>repeated .google.spanner.v1.Partition partitions = 1;</code>
     */
    public Builder addAllPartitions(
        java.lang.Iterable<? extends com.google.spanner.v1.Partition> values) {
      if (partitionsBuilder_ == null) {
        ensurePartitionsIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(values, partitions_);
        onChanged();
      } else {
        partitionsBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     *
     *
     * <pre>
     * Partitions created by this request.
     * </pre>
     *
     * <code>repeated .google.spanner.v1.Partition partitions = 1;</code>
     */
    public Builder clearPartitions() {
      if (partitionsBuilder_ == null) {
        partitions_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        partitionsBuilder_.clear();
      }
      return this;
    }
    /**
     *
     *
     * <pre>
     * Partitions created by this request.
     * </pre>
     *
     * <code>repeated .google.spanner.v1.Partition partitions = 1;</code>
     */
    public Builder removePartitions(int index) {
      if (partitionsBuilder_ == null) {
        ensurePartitionsIsMutable();
        partitions_.remove(index);
        onChanged();
      } else {
        partitionsBuilder_.remove(index);
      }
      return this;
    }
    /**
     *
     *
     * <pre>
     * Partitions created by this request.
     * </pre>
     *
     * <code>repeated .google.spanner.v1.Partition partitions = 1;</code>
     */
    public com.google.spanner.v1.Partition.Builder getPartitionsBuilder(int index) {
      return getPartitionsFieldBuilder().getBuilder(index);
    }
    /**
     *
     *
     * <pre>
     * Partitions created by this request.
     * </pre>
     *
     * <code>repeated .google.spanner.v1.Partition partitions = 1;</code>
     */
    public com.google.spanner.v1.PartitionOrBuilder getPartitionsOrBuilder(int index) {
      if (partitionsBuilder_ == null) {
        return partitions_.get(index);
      } else {
        return partitionsBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     *
     *
     * <pre>
     * Partitions created by this request.
     * </pre>
     *
     * <code>repeated .google.spanner.v1.Partition partitions = 1;</code>
     */
    public java.util.List<? extends com.google.spanner.v1.PartitionOrBuilder>
        getPartitionsOrBuilderList() {
      if (partitionsBuilder_ != null) {
        return partitionsBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(partitions_);
      }
    }
    /**
     *
     *
     * <pre>
     * Partitions created by this request.
     * </pre>
     *
     * <code>repeated .google.spanner.v1.Partition partitions = 1;</code>
     */
    public com.google.spanner.v1.Partition.Builder addPartitionsBuilder() {
      return getPartitionsFieldBuilder()
          .addBuilder(com.google.spanner.v1.Partition.getDefaultInstance());
    }
    /**
     *
     *
     * <pre>
     * Partitions created by this request.
     * </pre>
     *
     * <code>repeated .google.spanner.v1.Partition partitions = 1;</code>
     */
    public com.google.spanner.v1.Partition.Builder addPartitionsBuilder(int index) {
      return getPartitionsFieldBuilder()
          .addBuilder(index, com.google.spanner.v1.Partition.getDefaultInstance());
    }
    /**
     *
     *
     * <pre>
     * Partitions created by this request.
     * </pre>
     *
     * <code>repeated .google.spanner.v1.Partition partitions = 1;</code>
     */
    public java.util.List<com.google.spanner.v1.Partition.Builder> getPartitionsBuilderList() {
      return getPartitionsFieldBuilder().getBuilderList();
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
            com.google.spanner.v1.Partition,
            com.google.spanner.v1.Partition.Builder,
            com.google.spanner.v1.PartitionOrBuilder>
        getPartitionsFieldBuilder() {
      if (partitionsBuilder_ == null) {
        partitionsBuilder_ =
            new com.google.protobuf.RepeatedFieldBuilderV3<
                com.google.spanner.v1.Partition,
                com.google.spanner.v1.Partition.Builder,
                com.google.spanner.v1.PartitionOrBuilder>(
                partitions_, ((bitField0_ & 0x00000001) != 0), getParentForChildren(), isClean());
        partitions_ = null;
      }
      return partitionsBuilder_;
    }

    private com.google.spanner.v1.Transaction transaction_;
    private com.google.protobuf.SingleFieldBuilderV3<
            com.google.spanner.v1.Transaction,
            com.google.spanner.v1.Transaction.Builder,
            com.google.spanner.v1.TransactionOrBuilder>
        transactionBuilder_;
    /**
     *
     *
     * <pre>
     * Transaction created by this request.
     * </pre>
     *
     * <code>.google.spanner.v1.Transaction transaction = 2;</code>
     *
     * @return Whether the transaction field is set.
     */
    public boolean hasTransaction() {
      return ((bitField0_ & 0x00000002) != 0);
    }
    /**
     *
     *
     * <pre>
     * Transaction created by this request.
     * </pre>
     *
     * <code>.google.spanner.v1.Transaction transaction = 2;</code>
     *
     * @return The transaction.
     */
    public com.google.spanner.v1.Transaction getTransaction() {
      if (transactionBuilder_ == null) {
        return transaction_ == null
            ? com.google.spanner.v1.Transaction.getDefaultInstance()
            : transaction_;
      } else {
        return transactionBuilder_.getMessage();
      }
    }
    /**
     *
     *
     * <pre>
     * Transaction created by this request.
     * </pre>
     *
     * <code>.google.spanner.v1.Transaction transaction = 2;</code>
     */
    public Builder setTransaction(com.google.spanner.v1.Transaction value) {
      if (transactionBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        transaction_ = value;
      } else {
        transactionBuilder_.setMessage(value);
      }
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     *
     *
     * <pre>
     * Transaction created by this request.
     * </pre>
     *
     * <code>.google.spanner.v1.Transaction transaction = 2;</code>
     */
    public Builder setTransaction(com.google.spanner.v1.Transaction.Builder builderForValue) {
      if (transactionBuilder_ == null) {
        transaction_ = builderForValue.build();
      } else {
        transactionBuilder_.setMessage(builderForValue.build());
      }
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     *
     *
     * <pre>
     * Transaction created by this request.
     * </pre>
     *
     * <code>.google.spanner.v1.Transaction transaction = 2;</code>
     */
    public Builder mergeTransaction(com.google.spanner.v1.Transaction value) {
      if (transactionBuilder_ == null) {
        if (((bitField0_ & 0x00000002) != 0)
            && transaction_ != null
            && transaction_ != com.google.spanner.v1.Transaction.getDefaultInstance()) {
          getTransactionBuilder().mergeFrom(value);
        } else {
          transaction_ = value;
        }
      } else {
        transactionBuilder_.mergeFrom(value);
      }
      bitField0_ |= 0x00000002;
      onChanged();
      return this;
    }
    /**
     *
     *
     * <pre>
     * Transaction created by this request.
     * </pre>
     *
     * <code>.google.spanner.v1.Transaction transaction = 2;</code>
     */
    public Builder clearTransaction() {
      bitField0_ = (bitField0_ & ~0x00000002);
      transaction_ = null;
      if (transactionBuilder_ != null) {
        transactionBuilder_.dispose();
        transactionBuilder_ = null;
      }
      onChanged();
      return this;
    }
    /**
     *
     *
     * <pre>
     * Transaction created by this request.
     * </pre>
     *
     * <code>.google.spanner.v1.Transaction transaction = 2;</code>
     */
    public com.google.spanner.v1.Transaction.Builder getTransactionBuilder() {
      bitField0_ |= 0x00000002;
      onChanged();
      return getTransactionFieldBuilder().getBuilder();
    }
    /**
     *
     *
     * <pre>
     * Transaction created by this request.
     * </pre>
     *
     * <code>.google.spanner.v1.Transaction transaction = 2;</code>
     */
    public com.google.spanner.v1.TransactionOrBuilder getTransactionOrBuilder() {
      if (transactionBuilder_ != null) {
        return transactionBuilder_.getMessageOrBuilder();
      } else {
        return transaction_ == null
            ? com.google.spanner.v1.Transaction.getDefaultInstance()
            : transaction_;
      }
    }
    /**
     *
     *
     * <pre>
     * Transaction created by this request.
     * </pre>
     *
     * <code>.google.spanner.v1.Transaction transaction = 2;</code>
     */
    private com.google.protobuf.SingleFieldBuilderV3<
            com.google.spanner.v1.Transaction,
            com.google.spanner.v1.Transaction.Builder,
            com.google.spanner.v1.TransactionOrBuilder>
        getTransactionFieldBuilder() {
      if (transactionBuilder_ == null) {
        transactionBuilder_ =
            new com.google.protobuf.SingleFieldBuilderV3<
                com.google.spanner.v1.Transaction,
                com.google.spanner.v1.Transaction.Builder,
                com.google.spanner.v1.TransactionOrBuilder>(
                getTransaction(), getParentForChildren(), isClean());
        transaction_ = null;
      }
      return transactionBuilder_;
    }

    @java.lang.Override
    public final Builder setUnknownFields(final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }

    // @@protoc_insertion_point(builder_scope:google.spanner.v1.PartitionResponse)
  }

  // @@protoc_insertion_point(class_scope:google.spanner.v1.PartitionResponse)
  private static final com.google.spanner.v1.PartitionResponse DEFAULT_INSTANCE;

  static {
    DEFAULT_INSTANCE = new com.google.spanner.v1.PartitionResponse();
  }

  public static com.google.spanner.v1.PartitionResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<PartitionResponse> PARSER =
      new com.google.protobuf.AbstractParser<PartitionResponse>() {
        @java.lang.Override
        public PartitionResponse parsePartialFrom(
            com.google.protobuf.CodedInputStream input,
            com.google.protobuf.ExtensionRegistryLite extensionRegistry)
            throws com.google.protobuf.InvalidProtocolBufferException {
          Builder builder = newBuilder();
          try {
            builder.mergeFrom(input, extensionRegistry);
          } catch (com.google.protobuf.InvalidProtocolBufferException e) {
            throw e.setUnfinishedMessage(builder.buildPartial());
          } catch (com.google.protobuf.UninitializedMessageException e) {
            throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
          } catch (java.io.IOException e) {
            throw new com.google.protobuf.InvalidProtocolBufferException(e)
                .setUnfinishedMessage(builder.buildPartial());
          }
          return builder.buildPartial();
        }
      };

  public static com.google.protobuf.Parser<PartitionResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<PartitionResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.spanner.v1.PartitionResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }
}
