// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: server.proto

package com.spaceuptech.space_api.proto;

/**
 * Protobuf type {@code proto.RealTimeResponse}
 */
public  final class RealTimeResponse extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:proto.RealTimeResponse)
    RealTimeResponseOrBuilder {
private static final long serialVersionUID = 0L;
  // Use RealTimeResponse.newBuilder() to construct.
  private RealTimeResponse(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private RealTimeResponse() {
    group_ = "";
    id_ = "";
    error_ = "";
    feedData_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private RealTimeResponse(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            group_ = s;
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            id_ = s;
            break;
          }
          case 24: {

            ack_ = input.readBool();
            break;
          }
          case 34: {
            java.lang.String s = input.readStringRequireUtf8();

            error_ = s;
            break;
          }
          case 42: {
            if (!((mutable_bitField0_ & 0x00000010) != 0)) {
              feedData_ = new java.util.ArrayList<com.spaceuptech.space_api.proto.FeedData>();
              mutable_bitField0_ |= 0x00000010;
            }
            feedData_.add(
                input.readMessage(com.spaceuptech.space_api.proto.FeedData.parser(), extensionRegistry));
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      if (((mutable_bitField0_ & 0x00000010) != 0)) {
        feedData_ = java.util.Collections.unmodifiableList(feedData_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.spaceuptech.space_api.proto.SpaceCloudProto.internal_static_proto_RealTimeResponse_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.spaceuptech.space_api.proto.SpaceCloudProto.internal_static_proto_RealTimeResponse_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.spaceuptech.space_api.proto.RealTimeResponse.class, com.spaceuptech.space_api.proto.RealTimeResponse.Builder.class);
  }

  private int bitField0_;
  public static final int GROUP_FIELD_NUMBER = 1;
  private volatile java.lang.Object group_;
  /**
   * <code>string group = 1;</code>
   */
  public java.lang.String getGroup() {
    java.lang.Object ref = group_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      group_ = s;
      return s;
    }
  }
  /**
   * <code>string group = 1;</code>
   */
  public com.google.protobuf.ByteString
      getGroupBytes() {
    java.lang.Object ref = group_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      group_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int ID_FIELD_NUMBER = 2;
  private volatile java.lang.Object id_;
  /**
   * <code>string id = 2;</code>
   */
  public java.lang.String getId() {
    java.lang.Object ref = id_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      id_ = s;
      return s;
    }
  }
  /**
   * <code>string id = 2;</code>
   */
  public com.google.protobuf.ByteString
      getIdBytes() {
    java.lang.Object ref = id_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      id_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int ACK_FIELD_NUMBER = 3;
  private boolean ack_;
  /**
   * <code>bool ack = 3;</code>
   */
  public boolean getAck() {
    return ack_;
  }

  public static final int ERROR_FIELD_NUMBER = 4;
  private volatile java.lang.Object error_;
  /**
   * <code>string error = 4;</code>
   */
  public java.lang.String getError() {
    java.lang.Object ref = error_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      error_ = s;
      return s;
    }
  }
  /**
   * <code>string error = 4;</code>
   */
  public com.google.protobuf.ByteString
      getErrorBytes() {
    java.lang.Object ref = error_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      error_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int FEEDDATA_FIELD_NUMBER = 5;
  private java.util.List<com.spaceuptech.space_api.proto.FeedData> feedData_;
  /**
   * <code>repeated .proto.FeedData feedData = 5;</code>
   */
  public java.util.List<com.spaceuptech.space_api.proto.FeedData> getFeedDataList() {
    return feedData_;
  }
  /**
   * <code>repeated .proto.FeedData feedData = 5;</code>
   */
  public java.util.List<? extends com.spaceuptech.space_api.proto.FeedDataOrBuilder> 
      getFeedDataOrBuilderList() {
    return feedData_;
  }
  /**
   * <code>repeated .proto.FeedData feedData = 5;</code>
   */
  public int getFeedDataCount() {
    return feedData_.size();
  }
  /**
   * <code>repeated .proto.FeedData feedData = 5;</code>
   */
  public com.spaceuptech.space_api.proto.FeedData getFeedData(int index) {
    return feedData_.get(index);
  }
  /**
   * <code>repeated .proto.FeedData feedData = 5;</code>
   */
  public com.spaceuptech.space_api.proto.FeedDataOrBuilder getFeedDataOrBuilder(
      int index) {
    return feedData_.get(index);
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
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!getGroupBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, group_);
    }
    if (!getIdBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, id_);
    }
    if (ack_ != false) {
      output.writeBool(3, ack_);
    }
    if (!getErrorBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 4, error_);
    }
    for (int i = 0; i < feedData_.size(); i++) {
      output.writeMessage(5, feedData_.get(i));
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getGroupBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, group_);
    }
    if (!getIdBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, id_);
    }
    if (ack_ != false) {
      size += com.google.protobuf.CodedOutputStream
        .computeBoolSize(3, ack_);
    }
    if (!getErrorBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, error_);
    }
    for (int i = 0; i < feedData_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(5, feedData_.get(i));
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.spaceuptech.space_api.proto.RealTimeResponse)) {
      return super.equals(obj);
    }
    com.spaceuptech.space_api.proto.RealTimeResponse other = (com.spaceuptech.space_api.proto.RealTimeResponse) obj;

    if (!getGroup()
        .equals(other.getGroup())) return false;
    if (!getId()
        .equals(other.getId())) return false;
    if (getAck()
        != other.getAck()) return false;
    if (!getError()
        .equals(other.getError())) return false;
    if (!getFeedDataList()
        .equals(other.getFeedDataList())) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + GROUP_FIELD_NUMBER;
    hash = (53 * hash) + getGroup().hashCode();
    hash = (37 * hash) + ID_FIELD_NUMBER;
    hash = (53 * hash) + getId().hashCode();
    hash = (37 * hash) + ACK_FIELD_NUMBER;
    hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
        getAck());
    hash = (37 * hash) + ERROR_FIELD_NUMBER;
    hash = (53 * hash) + getError().hashCode();
    if (getFeedDataCount() > 0) {
      hash = (37 * hash) + FEEDDATA_FIELD_NUMBER;
      hash = (53 * hash) + getFeedDataList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.spaceuptech.space_api.proto.RealTimeResponse parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.spaceuptech.space_api.proto.RealTimeResponse parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.spaceuptech.space_api.proto.RealTimeResponse parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.spaceuptech.space_api.proto.RealTimeResponse parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.spaceuptech.space_api.proto.RealTimeResponse parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.spaceuptech.space_api.proto.RealTimeResponse parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.spaceuptech.space_api.proto.RealTimeResponse parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.spaceuptech.space_api.proto.RealTimeResponse parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.spaceuptech.space_api.proto.RealTimeResponse parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.spaceuptech.space_api.proto.RealTimeResponse parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.spaceuptech.space_api.proto.RealTimeResponse parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.spaceuptech.space_api.proto.RealTimeResponse parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.spaceuptech.space_api.proto.RealTimeResponse prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code proto.RealTimeResponse}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:proto.RealTimeResponse)
      com.spaceuptech.space_api.proto.RealTimeResponseOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.spaceuptech.space_api.proto.SpaceCloudProto.internal_static_proto_RealTimeResponse_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.spaceuptech.space_api.proto.SpaceCloudProto.internal_static_proto_RealTimeResponse_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.spaceuptech.space_api.proto.RealTimeResponse.class, com.spaceuptech.space_api.proto.RealTimeResponse.Builder.class);
    }

    // Construct using com.spaceuptech.space_api.proto.RealTimeResponse.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
        getFeedDataFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      group_ = "";

      id_ = "";

      ack_ = false;

      error_ = "";

      if (feedDataBuilder_ == null) {
        feedData_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000010);
      } else {
        feedDataBuilder_.clear();
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.spaceuptech.space_api.proto.SpaceCloudProto.internal_static_proto_RealTimeResponse_descriptor;
    }

    @java.lang.Override
    public com.spaceuptech.space_api.proto.RealTimeResponse getDefaultInstanceForType() {
      return com.spaceuptech.space_api.proto.RealTimeResponse.getDefaultInstance();
    }

    @java.lang.Override
    public com.spaceuptech.space_api.proto.RealTimeResponse build() {
      com.spaceuptech.space_api.proto.RealTimeResponse result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.spaceuptech.space_api.proto.RealTimeResponse buildPartial() {
      com.spaceuptech.space_api.proto.RealTimeResponse result = new com.spaceuptech.space_api.proto.RealTimeResponse(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      result.group_ = group_;
      result.id_ = id_;
      result.ack_ = ack_;
      result.error_ = error_;
      if (feedDataBuilder_ == null) {
        if (((bitField0_ & 0x00000010) != 0)) {
          feedData_ = java.util.Collections.unmodifiableList(feedData_);
          bitField0_ = (bitField0_ & ~0x00000010);
        }
        result.feedData_ = feedData_;
      } else {
        result.feedData_ = feedDataBuilder_.build();
      }
      result.bitField0_ = to_bitField0_;
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.spaceuptech.space_api.proto.RealTimeResponse) {
        return mergeFrom((com.spaceuptech.space_api.proto.RealTimeResponse)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.spaceuptech.space_api.proto.RealTimeResponse other) {
      if (other == com.spaceuptech.space_api.proto.RealTimeResponse.getDefaultInstance()) return this;
      if (!other.getGroup().isEmpty()) {
        group_ = other.group_;
        onChanged();
      }
      if (!other.getId().isEmpty()) {
        id_ = other.id_;
        onChanged();
      }
      if (other.getAck() != false) {
        setAck(other.getAck());
      }
      if (!other.getError().isEmpty()) {
        error_ = other.error_;
        onChanged();
      }
      if (feedDataBuilder_ == null) {
        if (!other.feedData_.isEmpty()) {
          if (feedData_.isEmpty()) {
            feedData_ = other.feedData_;
            bitField0_ = (bitField0_ & ~0x00000010);
          } else {
            ensureFeedDataIsMutable();
            feedData_.addAll(other.feedData_);
          }
          onChanged();
        }
      } else {
        if (!other.feedData_.isEmpty()) {
          if (feedDataBuilder_.isEmpty()) {
            feedDataBuilder_.dispose();
            feedDataBuilder_ = null;
            feedData_ = other.feedData_;
            bitField0_ = (bitField0_ & ~0x00000010);
            feedDataBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getFeedDataFieldBuilder() : null;
          } else {
            feedDataBuilder_.addAllMessages(other.feedData_);
          }
        }
      }
      this.mergeUnknownFields(other.unknownFields);
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
      com.spaceuptech.space_api.proto.RealTimeResponse parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.spaceuptech.space_api.proto.RealTimeResponse) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.lang.Object group_ = "";
    /**
     * <code>string group = 1;</code>
     */
    public java.lang.String getGroup() {
      java.lang.Object ref = group_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        group_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string group = 1;</code>
     */
    public com.google.protobuf.ByteString
        getGroupBytes() {
      java.lang.Object ref = group_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        group_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string group = 1;</code>
     */
    public Builder setGroup(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      group_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string group = 1;</code>
     */
    public Builder clearGroup() {
      
      group_ = getDefaultInstance().getGroup();
      onChanged();
      return this;
    }
    /**
     * <code>string group = 1;</code>
     */
    public Builder setGroupBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      group_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object id_ = "";
    /**
     * <code>string id = 2;</code>
     */
    public java.lang.String getId() {
      java.lang.Object ref = id_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        id_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string id = 2;</code>
     */
    public com.google.protobuf.ByteString
        getIdBytes() {
      java.lang.Object ref = id_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        id_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string id = 2;</code>
     */
    public Builder setId(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      id_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string id = 2;</code>
     */
    public Builder clearId() {
      
      id_ = getDefaultInstance().getId();
      onChanged();
      return this;
    }
    /**
     * <code>string id = 2;</code>
     */
    public Builder setIdBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      id_ = value;
      onChanged();
      return this;
    }

    private boolean ack_ ;
    /**
     * <code>bool ack = 3;</code>
     */
    public boolean getAck() {
      return ack_;
    }
    /**
     * <code>bool ack = 3;</code>
     */
    public Builder setAck(boolean value) {
      
      ack_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>bool ack = 3;</code>
     */
    public Builder clearAck() {
      
      ack_ = false;
      onChanged();
      return this;
    }

    private java.lang.Object error_ = "";
    /**
     * <code>string error = 4;</code>
     */
    public java.lang.String getError() {
      java.lang.Object ref = error_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        error_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string error = 4;</code>
     */
    public com.google.protobuf.ByteString
        getErrorBytes() {
      java.lang.Object ref = error_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        error_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string error = 4;</code>
     */
    public Builder setError(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      error_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string error = 4;</code>
     */
    public Builder clearError() {
      
      error_ = getDefaultInstance().getError();
      onChanged();
      return this;
    }
    /**
     * <code>string error = 4;</code>
     */
    public Builder setErrorBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      error_ = value;
      onChanged();
      return this;
    }

    private java.util.List<com.spaceuptech.space_api.proto.FeedData> feedData_ =
      java.util.Collections.emptyList();
    private void ensureFeedDataIsMutable() {
      if (!((bitField0_ & 0x00000010) != 0)) {
        feedData_ = new java.util.ArrayList<com.spaceuptech.space_api.proto.FeedData>(feedData_);
        bitField0_ |= 0x00000010;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.spaceuptech.space_api.proto.FeedData, com.spaceuptech.space_api.proto.FeedData.Builder, com.spaceuptech.space_api.proto.FeedDataOrBuilder> feedDataBuilder_;

    /**
     * <code>repeated .proto.FeedData feedData = 5;</code>
     */
    public java.util.List<com.spaceuptech.space_api.proto.FeedData> getFeedDataList() {
      if (feedDataBuilder_ == null) {
        return java.util.Collections.unmodifiableList(feedData_);
      } else {
        return feedDataBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .proto.FeedData feedData = 5;</code>
     */
    public int getFeedDataCount() {
      if (feedDataBuilder_ == null) {
        return feedData_.size();
      } else {
        return feedDataBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .proto.FeedData feedData = 5;</code>
     */
    public com.spaceuptech.space_api.proto.FeedData getFeedData(int index) {
      if (feedDataBuilder_ == null) {
        return feedData_.get(index);
      } else {
        return feedDataBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .proto.FeedData feedData = 5;</code>
     */
    public Builder setFeedData(
        int index, com.spaceuptech.space_api.proto.FeedData value) {
      if (feedDataBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureFeedDataIsMutable();
        feedData_.set(index, value);
        onChanged();
      } else {
        feedDataBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .proto.FeedData feedData = 5;</code>
     */
    public Builder setFeedData(
        int index, com.spaceuptech.space_api.proto.FeedData.Builder builderForValue) {
      if (feedDataBuilder_ == null) {
        ensureFeedDataIsMutable();
        feedData_.set(index, builderForValue.build());
        onChanged();
      } else {
        feedDataBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .proto.FeedData feedData = 5;</code>
     */
    public Builder addFeedData(com.spaceuptech.space_api.proto.FeedData value) {
      if (feedDataBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureFeedDataIsMutable();
        feedData_.add(value);
        onChanged();
      } else {
        feedDataBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .proto.FeedData feedData = 5;</code>
     */
    public Builder addFeedData(
        int index, com.spaceuptech.space_api.proto.FeedData value) {
      if (feedDataBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureFeedDataIsMutable();
        feedData_.add(index, value);
        onChanged();
      } else {
        feedDataBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .proto.FeedData feedData = 5;</code>
     */
    public Builder addFeedData(
        com.spaceuptech.space_api.proto.FeedData.Builder builderForValue) {
      if (feedDataBuilder_ == null) {
        ensureFeedDataIsMutable();
        feedData_.add(builderForValue.build());
        onChanged();
      } else {
        feedDataBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .proto.FeedData feedData = 5;</code>
     */
    public Builder addFeedData(
        int index, com.spaceuptech.space_api.proto.FeedData.Builder builderForValue) {
      if (feedDataBuilder_ == null) {
        ensureFeedDataIsMutable();
        feedData_.add(index, builderForValue.build());
        onChanged();
      } else {
        feedDataBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .proto.FeedData feedData = 5;</code>
     */
    public Builder addAllFeedData(
        java.lang.Iterable<? extends com.spaceuptech.space_api.proto.FeedData> values) {
      if (feedDataBuilder_ == null) {
        ensureFeedDataIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, feedData_);
        onChanged();
      } else {
        feedDataBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .proto.FeedData feedData = 5;</code>
     */
    public Builder clearFeedData() {
      if (feedDataBuilder_ == null) {
        feedData_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000010);
        onChanged();
      } else {
        feedDataBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .proto.FeedData feedData = 5;</code>
     */
    public Builder removeFeedData(int index) {
      if (feedDataBuilder_ == null) {
        ensureFeedDataIsMutable();
        feedData_.remove(index);
        onChanged();
      } else {
        feedDataBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .proto.FeedData feedData = 5;</code>
     */
    public com.spaceuptech.space_api.proto.FeedData.Builder getFeedDataBuilder(
        int index) {
      return getFeedDataFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .proto.FeedData feedData = 5;</code>
     */
    public com.spaceuptech.space_api.proto.FeedDataOrBuilder getFeedDataOrBuilder(
        int index) {
      if (feedDataBuilder_ == null) {
        return feedData_.get(index);  } else {
        return feedDataBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .proto.FeedData feedData = 5;</code>
     */
    public java.util.List<? extends com.spaceuptech.space_api.proto.FeedDataOrBuilder> 
         getFeedDataOrBuilderList() {
      if (feedDataBuilder_ != null) {
        return feedDataBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(feedData_);
      }
    }
    /**
     * <code>repeated .proto.FeedData feedData = 5;</code>
     */
    public com.spaceuptech.space_api.proto.FeedData.Builder addFeedDataBuilder() {
      return getFeedDataFieldBuilder().addBuilder(
          com.spaceuptech.space_api.proto.FeedData.getDefaultInstance());
    }
    /**
     * <code>repeated .proto.FeedData feedData = 5;</code>
     */
    public com.spaceuptech.space_api.proto.FeedData.Builder addFeedDataBuilder(
        int index) {
      return getFeedDataFieldBuilder().addBuilder(
          index, com.spaceuptech.space_api.proto.FeedData.getDefaultInstance());
    }
    /**
     * <code>repeated .proto.FeedData feedData = 5;</code>
     */
    public java.util.List<com.spaceuptech.space_api.proto.FeedData.Builder> 
         getFeedDataBuilderList() {
      return getFeedDataFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.spaceuptech.space_api.proto.FeedData, com.spaceuptech.space_api.proto.FeedData.Builder, com.spaceuptech.space_api.proto.FeedDataOrBuilder> 
        getFeedDataFieldBuilder() {
      if (feedDataBuilder_ == null) {
        feedDataBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            com.spaceuptech.space_api.proto.FeedData, com.spaceuptech.space_api.proto.FeedData.Builder, com.spaceuptech.space_api.proto.FeedDataOrBuilder>(
                feedData_,
                ((bitField0_ & 0x00000010) != 0),
                getParentForChildren(),
                isClean());
        feedData_ = null;
      }
      return feedDataBuilder_;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:proto.RealTimeResponse)
  }

  // @@protoc_insertion_point(class_scope:proto.RealTimeResponse)
  private static final com.spaceuptech.space_api.proto.RealTimeResponse DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.spaceuptech.space_api.proto.RealTimeResponse();
  }

  public static com.spaceuptech.space_api.proto.RealTimeResponse getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<RealTimeResponse>
      PARSER = new com.google.protobuf.AbstractParser<RealTimeResponse>() {
    @java.lang.Override
    public RealTimeResponse parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new RealTimeResponse(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<RealTimeResponse> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<RealTimeResponse> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.spaceuptech.space_api.proto.RealTimeResponse getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

