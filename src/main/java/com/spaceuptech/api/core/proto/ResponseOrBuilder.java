// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: server.proto

package com.spaceuptech.api.core.proto;

public interface ResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:proto.Response)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int32 status = 1;</code>
   */
  int getStatus();

  /**
   * <code>string error = 2;</code>
   */
  java.lang.String getError();
  /**
   * <code>string error = 2;</code>
   */
  com.google.protobuf.ByteString
      getErrorBytes();

  /**
   * <code>bytes result = 3;</code>
   */
  com.google.protobuf.ByteString getResult();
}