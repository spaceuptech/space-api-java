// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: server.proto

package com.spaceuptech.space_api.proto;

public interface RealTimeResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:proto.RealTimeResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string group = 1;</code>
   */
  java.lang.String getGroup();
  /**
   * <code>string group = 1;</code>
   */
  com.google.protobuf.ByteString
      getGroupBytes();

  /**
   * <code>string id = 2;</code>
   */
  java.lang.String getId();
  /**
   * <code>string id = 2;</code>
   */
  com.google.protobuf.ByteString
      getIdBytes();

  /**
   * <code>bool ack = 3;</code>
   */
  boolean getAck();

  /**
   * <code>string error = 4;</code>
   */
  java.lang.String getError();
  /**
   * <code>string error = 4;</code>
   */
  com.google.protobuf.ByteString
      getErrorBytes();

  /**
   * <code>repeated .proto.FeedData feedData = 5;</code>
   */
  java.util.List<com.spaceuptech.space_api.proto.FeedData> 
      getFeedDataList();
  /**
   * <code>repeated .proto.FeedData feedData = 5;</code>
   */
  com.spaceuptech.space_api.proto.FeedData getFeedData(int index);
  /**
   * <code>repeated .proto.FeedData feedData = 5;</code>
   */
  int getFeedDataCount();
  /**
   * <code>repeated .proto.FeedData feedData = 5;</code>
   */
  java.util.List<? extends com.spaceuptech.space_api.proto.FeedDataOrBuilder> 
      getFeedDataOrBuilderList();
  /**
   * <code>repeated .proto.FeedData feedData = 5;</code>
   */
  com.spaceuptech.space_api.proto.FeedDataOrBuilder getFeedDataOrBuilder(
      int index);
}