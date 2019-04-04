// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: server.proto

package com.spaceuptech.api.core.proto;

/**
 * Protobuf type {@code proto.Meta}
 */
public  final class Meta extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:proto.Meta)
    MetaOrBuilder {
  // Use Meta.newBuilder() to construct.
  private Meta(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Meta() {
    project_ = "";
    dbType_ = "";
    col_ = "";
    token_ = "";
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private Meta(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    int mutable_bitField0_ = 0;
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!input.skipField(tag)) {
              done = true;
            }
            break;
          }
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            project_ = s;
            break;
          }
          case 18: {
            java.lang.String s = input.readStringRequireUtf8();

            dbType_ = s;
            break;
          }
          case 26: {
            java.lang.String s = input.readStringRequireUtf8();

            col_ = s;
            break;
          }
          case 34: {
            java.lang.String s = input.readStringRequireUtf8();

            token_ = s;
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
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.spaceuptech.api.core.proto.SpaceCloudProto.internal_static_proto_Meta_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.spaceuptech.api.core.proto.SpaceCloudProto.internal_static_proto_Meta_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.spaceuptech.api.core.proto.Meta.class, com.spaceuptech.api.core.proto.Meta.Builder.class);
  }

  public static final int PROJECT_FIELD_NUMBER = 1;
  private volatile java.lang.Object project_;
  /**
   * <code>string project = 1;</code>
   */
  public java.lang.String getProject() {
    java.lang.Object ref = project_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      project_ = s;
      return s;
    }
  }
  /**
   * <code>string project = 1;</code>
   */
  public com.google.protobuf.ByteString
      getProjectBytes() {
    java.lang.Object ref = project_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      project_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int DBTYPE_FIELD_NUMBER = 2;
  private volatile java.lang.Object dbType_;
  /**
   * <code>string dbType = 2;</code>
   */
  public java.lang.String getDbType() {
    java.lang.Object ref = dbType_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      dbType_ = s;
      return s;
    }
  }
  /**
   * <code>string dbType = 2;</code>
   */
  public com.google.protobuf.ByteString
      getDbTypeBytes() {
    java.lang.Object ref = dbType_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      dbType_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int COL_FIELD_NUMBER = 3;
  private volatile java.lang.Object col_;
  /**
   * <code>string col = 3;</code>
   */
  public java.lang.String getCol() {
    java.lang.Object ref = col_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      col_ = s;
      return s;
    }
  }
  /**
   * <code>string col = 3;</code>
   */
  public com.google.protobuf.ByteString
      getColBytes() {
    java.lang.Object ref = col_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      col_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int TOKEN_FIELD_NUMBER = 4;
  private volatile java.lang.Object token_;
  /**
   * <code>string token = 4;</code>
   */
  public java.lang.String getToken() {
    java.lang.Object ref = token_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      token_ = s;
      return s;
    }
  }
  /**
   * <code>string token = 4;</code>
   */
  public com.google.protobuf.ByteString
      getTokenBytes() {
    java.lang.Object ref = token_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      token_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!getProjectBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, project_);
    }
    if (!getDbTypeBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 2, dbType_);
    }
    if (!getColBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, col_);
    }
    if (!getTokenBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 4, token_);
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getProjectBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, project_);
    }
    if (!getDbTypeBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, dbType_);
    }
    if (!getColBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, col_);
    }
    if (!getTokenBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, token_);
    }
    memoizedSize = size;
    return size;
  }

  private static final long serialVersionUID = 0L;
  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.spaceuptech.api.core.proto.Meta)) {
      return super.equals(obj);
    }
    com.spaceuptech.api.core.proto.Meta other = (com.spaceuptech.api.core.proto.Meta) obj;

    boolean result = true;
    result = result && getProject()
        .equals(other.getProject());
    result = result && getDbType()
        .equals(other.getDbType());
    result = result && getCol()
        .equals(other.getCol());
    result = result && getToken()
        .equals(other.getToken());
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + PROJECT_FIELD_NUMBER;
    hash = (53 * hash) + getProject().hashCode();
    hash = (37 * hash) + DBTYPE_FIELD_NUMBER;
    hash = (53 * hash) + getDbType().hashCode();
    hash = (37 * hash) + COL_FIELD_NUMBER;
    hash = (53 * hash) + getCol().hashCode();
    hash = (37 * hash) + TOKEN_FIELD_NUMBER;
    hash = (53 * hash) + getToken().hashCode();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.spaceuptech.api.core.proto.Meta parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.spaceuptech.api.core.proto.Meta parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.spaceuptech.api.core.proto.Meta parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.spaceuptech.api.core.proto.Meta parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.spaceuptech.api.core.proto.Meta parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.spaceuptech.api.core.proto.Meta parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.spaceuptech.api.core.proto.Meta parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.spaceuptech.api.core.proto.Meta parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.spaceuptech.api.core.proto.Meta parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.spaceuptech.api.core.proto.Meta parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.spaceuptech.api.core.proto.Meta prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
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
   * Protobuf type {@code proto.Meta}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:proto.Meta)
      com.spaceuptech.api.core.proto.MetaOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.spaceuptech.api.core.proto.SpaceCloudProto.internal_static_proto_Meta_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.spaceuptech.api.core.proto.SpaceCloudProto.internal_static_proto_Meta_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.spaceuptech.api.core.proto.Meta.class, com.spaceuptech.api.core.proto.Meta.Builder.class);
    }

    // Construct using com.spaceuptech.api.core.proto.Meta.newBuilder()
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
      }
    }
    public Builder clear() {
      super.clear();
      project_ = "";

      dbType_ = "";

      col_ = "";

      token_ = "";

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.spaceuptech.api.core.proto.SpaceCloudProto.internal_static_proto_Meta_descriptor;
    }

    public com.spaceuptech.api.core.proto.Meta getDefaultInstanceForType() {
      return com.spaceuptech.api.core.proto.Meta.getDefaultInstance();
    }

    public com.spaceuptech.api.core.proto.Meta build() {
      com.spaceuptech.api.core.proto.Meta result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public com.spaceuptech.api.core.proto.Meta buildPartial() {
      com.spaceuptech.api.core.proto.Meta result = new com.spaceuptech.api.core.proto.Meta(this);
      result.project_ = project_;
      result.dbType_ = dbType_;
      result.col_ = col_;
      result.token_ = token_;
      onBuilt();
      return result;
    }

    public Builder clone() {
      return (Builder) super.clone();
    }
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.setField(field, value);
    }
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.spaceuptech.api.core.proto.Meta) {
        return mergeFrom((com.spaceuptech.api.core.proto.Meta)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.spaceuptech.api.core.proto.Meta other) {
      if (other == com.spaceuptech.api.core.proto.Meta.getDefaultInstance()) return this;
      if (!other.getProject().isEmpty()) {
        project_ = other.project_;
        onChanged();
      }
      if (!other.getDbType().isEmpty()) {
        dbType_ = other.dbType_;
        onChanged();
      }
      if (!other.getCol().isEmpty()) {
        col_ = other.col_;
        onChanged();
      }
      if (!other.getToken().isEmpty()) {
        token_ = other.token_;
        onChanged();
      }
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.spaceuptech.api.core.proto.Meta parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.spaceuptech.api.core.proto.Meta) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private java.lang.Object project_ = "";
    /**
     * <code>string project = 1;</code>
     */
    public java.lang.String getProject() {
      java.lang.Object ref = project_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        project_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string project = 1;</code>
     */
    public com.google.protobuf.ByteString
        getProjectBytes() {
      java.lang.Object ref = project_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        project_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string project = 1;</code>
     */
    public Builder setProject(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      project_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string project = 1;</code>
     */
    public Builder clearProject() {
      
      project_ = getDefaultInstance().getProject();
      onChanged();
      return this;
    }
    /**
     * <code>string project = 1;</code>
     */
    public Builder setProjectBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      project_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object dbType_ = "";
    /**
     * <code>string dbType = 2;</code>
     */
    public java.lang.String getDbType() {
      java.lang.Object ref = dbType_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        dbType_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string dbType = 2;</code>
     */
    public com.google.protobuf.ByteString
        getDbTypeBytes() {
      java.lang.Object ref = dbType_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        dbType_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string dbType = 2;</code>
     */
    public Builder setDbType(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      dbType_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string dbType = 2;</code>
     */
    public Builder clearDbType() {
      
      dbType_ = getDefaultInstance().getDbType();
      onChanged();
      return this;
    }
    /**
     * <code>string dbType = 2;</code>
     */
    public Builder setDbTypeBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      dbType_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object col_ = "";
    /**
     * <code>string col = 3;</code>
     */
    public java.lang.String getCol() {
      java.lang.Object ref = col_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        col_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string col = 3;</code>
     */
    public com.google.protobuf.ByteString
        getColBytes() {
      java.lang.Object ref = col_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        col_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string col = 3;</code>
     */
    public Builder setCol(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      col_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string col = 3;</code>
     */
    public Builder clearCol() {
      
      col_ = getDefaultInstance().getCol();
      onChanged();
      return this;
    }
    /**
     * <code>string col = 3;</code>
     */
    public Builder setColBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      col_ = value;
      onChanged();
      return this;
    }

    private java.lang.Object token_ = "";
    /**
     * <code>string token = 4;</code>
     */
    public java.lang.String getToken() {
      java.lang.Object ref = token_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        token_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <code>string token = 4;</code>
     */
    public com.google.protobuf.ByteString
        getTokenBytes() {
      java.lang.Object ref = token_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        token_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <code>string token = 4;</code>
     */
    public Builder setToken(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      token_ = value;
      onChanged();
      return this;
    }
    /**
     * <code>string token = 4;</code>
     */
    public Builder clearToken() {
      
      token_ = getDefaultInstance().getToken();
      onChanged();
      return this;
    }
    /**
     * <code>string token = 4;</code>
     */
    public Builder setTokenBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      token_ = value;
      onChanged();
      return this;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }


    // @@protoc_insertion_point(builder_scope:proto.Meta)
  }

  // @@protoc_insertion_point(class_scope:proto.Meta)
  private static final com.spaceuptech.api.core.proto.Meta DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.spaceuptech.api.core.proto.Meta();
  }

  public static com.spaceuptech.api.core.proto.Meta getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Meta>
      PARSER = new com.google.protobuf.AbstractParser<Meta>() {
    public Meta parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new Meta(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<Meta> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<Meta> getParserForType() {
    return PARSER;
  }

  public com.spaceuptech.api.core.proto.Meta getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
