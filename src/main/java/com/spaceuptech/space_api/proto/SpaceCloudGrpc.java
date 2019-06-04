package com.spaceuptech.space_api.proto;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.21.0)",
    comments = "Source: server.proto")
public final class SpaceCloudGrpc {

  private SpaceCloudGrpc() {}

  public static final String SERVICE_NAME = "proto.SpaceCloud";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.spaceuptech.space_api.proto.CreateRequest,
      com.spaceuptech.space_api.proto.Response> getCreateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Create",
      requestType = com.spaceuptech.space_api.proto.CreateRequest.class,
      responseType = com.spaceuptech.space_api.proto.Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.spaceuptech.space_api.proto.CreateRequest,
      com.spaceuptech.space_api.proto.Response> getCreateMethod() {
    io.grpc.MethodDescriptor<com.spaceuptech.space_api.proto.CreateRequest, com.spaceuptech.space_api.proto.Response> getCreateMethod;
    if ((getCreateMethod = SpaceCloudGrpc.getCreateMethod) == null) {
      synchronized (SpaceCloudGrpc.class) {
        if ((getCreateMethod = SpaceCloudGrpc.getCreateMethod) == null) {
          SpaceCloudGrpc.getCreateMethod = getCreateMethod = 
              io.grpc.MethodDescriptor.<com.spaceuptech.space_api.proto.CreateRequest, com.spaceuptech.space_api.proto.Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "proto.SpaceCloud", "Create"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.spaceuptech.space_api.proto.CreateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.spaceuptech.space_api.proto.Response.getDefaultInstance()))
                  .setSchemaDescriptor(new SpaceCloudMethodDescriptorSupplier("Create"))
                  .build();
          }
        }
     }
     return getCreateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.spaceuptech.space_api.proto.ReadRequest,
      com.spaceuptech.space_api.proto.Response> getReadMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Read",
      requestType = com.spaceuptech.space_api.proto.ReadRequest.class,
      responseType = com.spaceuptech.space_api.proto.Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.spaceuptech.space_api.proto.ReadRequest,
      com.spaceuptech.space_api.proto.Response> getReadMethod() {
    io.grpc.MethodDescriptor<com.spaceuptech.space_api.proto.ReadRequest, com.spaceuptech.space_api.proto.Response> getReadMethod;
    if ((getReadMethod = SpaceCloudGrpc.getReadMethod) == null) {
      synchronized (SpaceCloudGrpc.class) {
        if ((getReadMethod = SpaceCloudGrpc.getReadMethod) == null) {
          SpaceCloudGrpc.getReadMethod = getReadMethod = 
              io.grpc.MethodDescriptor.<com.spaceuptech.space_api.proto.ReadRequest, com.spaceuptech.space_api.proto.Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "proto.SpaceCloud", "Read"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.spaceuptech.space_api.proto.ReadRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.spaceuptech.space_api.proto.Response.getDefaultInstance()))
                  .setSchemaDescriptor(new SpaceCloudMethodDescriptorSupplier("Read"))
                  .build();
          }
        }
     }
     return getReadMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.spaceuptech.space_api.proto.UpdateRequest,
      com.spaceuptech.space_api.proto.Response> getUpdateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Update",
      requestType = com.spaceuptech.space_api.proto.UpdateRequest.class,
      responseType = com.spaceuptech.space_api.proto.Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.spaceuptech.space_api.proto.UpdateRequest,
      com.spaceuptech.space_api.proto.Response> getUpdateMethod() {
    io.grpc.MethodDescriptor<com.spaceuptech.space_api.proto.UpdateRequest, com.spaceuptech.space_api.proto.Response> getUpdateMethod;
    if ((getUpdateMethod = SpaceCloudGrpc.getUpdateMethod) == null) {
      synchronized (SpaceCloudGrpc.class) {
        if ((getUpdateMethod = SpaceCloudGrpc.getUpdateMethod) == null) {
          SpaceCloudGrpc.getUpdateMethod = getUpdateMethod = 
              io.grpc.MethodDescriptor.<com.spaceuptech.space_api.proto.UpdateRequest, com.spaceuptech.space_api.proto.Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "proto.SpaceCloud", "Update"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.spaceuptech.space_api.proto.UpdateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.spaceuptech.space_api.proto.Response.getDefaultInstance()))
                  .setSchemaDescriptor(new SpaceCloudMethodDescriptorSupplier("Update"))
                  .build();
          }
        }
     }
     return getUpdateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.spaceuptech.space_api.proto.DeleteRequest,
      com.spaceuptech.space_api.proto.Response> getDeleteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Delete",
      requestType = com.spaceuptech.space_api.proto.DeleteRequest.class,
      responseType = com.spaceuptech.space_api.proto.Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.spaceuptech.space_api.proto.DeleteRequest,
      com.spaceuptech.space_api.proto.Response> getDeleteMethod() {
    io.grpc.MethodDescriptor<com.spaceuptech.space_api.proto.DeleteRequest, com.spaceuptech.space_api.proto.Response> getDeleteMethod;
    if ((getDeleteMethod = SpaceCloudGrpc.getDeleteMethod) == null) {
      synchronized (SpaceCloudGrpc.class) {
        if ((getDeleteMethod = SpaceCloudGrpc.getDeleteMethod) == null) {
          SpaceCloudGrpc.getDeleteMethod = getDeleteMethod = 
              io.grpc.MethodDescriptor.<com.spaceuptech.space_api.proto.DeleteRequest, com.spaceuptech.space_api.proto.Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "proto.SpaceCloud", "Delete"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.spaceuptech.space_api.proto.DeleteRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.spaceuptech.space_api.proto.Response.getDefaultInstance()))
                  .setSchemaDescriptor(new SpaceCloudMethodDescriptorSupplier("Delete"))
                  .build();
          }
        }
     }
     return getDeleteMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.spaceuptech.space_api.proto.AggregateRequest,
      com.spaceuptech.space_api.proto.Response> getAggregateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Aggregate",
      requestType = com.spaceuptech.space_api.proto.AggregateRequest.class,
      responseType = com.spaceuptech.space_api.proto.Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.spaceuptech.space_api.proto.AggregateRequest,
      com.spaceuptech.space_api.proto.Response> getAggregateMethod() {
    io.grpc.MethodDescriptor<com.spaceuptech.space_api.proto.AggregateRequest, com.spaceuptech.space_api.proto.Response> getAggregateMethod;
    if ((getAggregateMethod = SpaceCloudGrpc.getAggregateMethod) == null) {
      synchronized (SpaceCloudGrpc.class) {
        if ((getAggregateMethod = SpaceCloudGrpc.getAggregateMethod) == null) {
          SpaceCloudGrpc.getAggregateMethod = getAggregateMethod = 
              io.grpc.MethodDescriptor.<com.spaceuptech.space_api.proto.AggregateRequest, com.spaceuptech.space_api.proto.Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "proto.SpaceCloud", "Aggregate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.spaceuptech.space_api.proto.AggregateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.spaceuptech.space_api.proto.Response.getDefaultInstance()))
                  .setSchemaDescriptor(new SpaceCloudMethodDescriptorSupplier("Aggregate"))
                  .build();
          }
        }
     }
     return getAggregateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.spaceuptech.space_api.proto.BatchRequest,
      com.spaceuptech.space_api.proto.Response> getBatchMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Batch",
      requestType = com.spaceuptech.space_api.proto.BatchRequest.class,
      responseType = com.spaceuptech.space_api.proto.Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.spaceuptech.space_api.proto.BatchRequest,
      com.spaceuptech.space_api.proto.Response> getBatchMethod() {
    io.grpc.MethodDescriptor<com.spaceuptech.space_api.proto.BatchRequest, com.spaceuptech.space_api.proto.Response> getBatchMethod;
    if ((getBatchMethod = SpaceCloudGrpc.getBatchMethod) == null) {
      synchronized (SpaceCloudGrpc.class) {
        if ((getBatchMethod = SpaceCloudGrpc.getBatchMethod) == null) {
          SpaceCloudGrpc.getBatchMethod = getBatchMethod = 
              io.grpc.MethodDescriptor.<com.spaceuptech.space_api.proto.BatchRequest, com.spaceuptech.space_api.proto.Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "proto.SpaceCloud", "Batch"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.spaceuptech.space_api.proto.BatchRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.spaceuptech.space_api.proto.Response.getDefaultInstance()))
                  .setSchemaDescriptor(new SpaceCloudMethodDescriptorSupplier("Batch"))
                  .build();
          }
        }
     }
     return getBatchMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.spaceuptech.space_api.proto.FunctionsRequest,
      com.spaceuptech.space_api.proto.Response> getCallMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Call",
      requestType = com.spaceuptech.space_api.proto.FunctionsRequest.class,
      responseType = com.spaceuptech.space_api.proto.Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.spaceuptech.space_api.proto.FunctionsRequest,
      com.spaceuptech.space_api.proto.Response> getCallMethod() {
    io.grpc.MethodDescriptor<com.spaceuptech.space_api.proto.FunctionsRequest, com.spaceuptech.space_api.proto.Response> getCallMethod;
    if ((getCallMethod = SpaceCloudGrpc.getCallMethod) == null) {
      synchronized (SpaceCloudGrpc.class) {
        if ((getCallMethod = SpaceCloudGrpc.getCallMethod) == null) {
          SpaceCloudGrpc.getCallMethod = getCallMethod = 
              io.grpc.MethodDescriptor.<com.spaceuptech.space_api.proto.FunctionsRequest, com.spaceuptech.space_api.proto.Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "proto.SpaceCloud", "Call"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.spaceuptech.space_api.proto.FunctionsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.spaceuptech.space_api.proto.Response.getDefaultInstance()))
                  .setSchemaDescriptor(new SpaceCloudMethodDescriptorSupplier("Call"))
                  .build();
          }
        }
     }
     return getCallMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.spaceuptech.space_api.proto.RealTimeRequest,
      com.spaceuptech.space_api.proto.RealTimeResponse> getRealTimeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RealTime",
      requestType = com.spaceuptech.space_api.proto.RealTimeRequest.class,
      responseType = com.spaceuptech.space_api.proto.RealTimeResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.spaceuptech.space_api.proto.RealTimeRequest,
      com.spaceuptech.space_api.proto.RealTimeResponse> getRealTimeMethod() {
    io.grpc.MethodDescriptor<com.spaceuptech.space_api.proto.RealTimeRequest, com.spaceuptech.space_api.proto.RealTimeResponse> getRealTimeMethod;
    if ((getRealTimeMethod = SpaceCloudGrpc.getRealTimeMethod) == null) {
      synchronized (SpaceCloudGrpc.class) {
        if ((getRealTimeMethod = SpaceCloudGrpc.getRealTimeMethod) == null) {
          SpaceCloudGrpc.getRealTimeMethod = getRealTimeMethod = 
              io.grpc.MethodDescriptor.<com.spaceuptech.space_api.proto.RealTimeRequest, com.spaceuptech.space_api.proto.RealTimeResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "proto.SpaceCloud", "RealTime"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.spaceuptech.space_api.proto.RealTimeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.spaceuptech.space_api.proto.RealTimeResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new SpaceCloudMethodDescriptorSupplier("RealTime"))
                  .build();
          }
        }
     }
     return getRealTimeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.spaceuptech.space_api.proto.FunctionsPayload,
      com.spaceuptech.space_api.proto.FunctionsPayload> getServiceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Service",
      requestType = com.spaceuptech.space_api.proto.FunctionsPayload.class,
      responseType = com.spaceuptech.space_api.proto.FunctionsPayload.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.spaceuptech.space_api.proto.FunctionsPayload,
      com.spaceuptech.space_api.proto.FunctionsPayload> getServiceMethod() {
    io.grpc.MethodDescriptor<com.spaceuptech.space_api.proto.FunctionsPayload, com.spaceuptech.space_api.proto.FunctionsPayload> getServiceMethod;
    if ((getServiceMethod = SpaceCloudGrpc.getServiceMethod) == null) {
      synchronized (SpaceCloudGrpc.class) {
        if ((getServiceMethod = SpaceCloudGrpc.getServiceMethod) == null) {
          SpaceCloudGrpc.getServiceMethod = getServiceMethod = 
              io.grpc.MethodDescriptor.<com.spaceuptech.space_api.proto.FunctionsPayload, com.spaceuptech.space_api.proto.FunctionsPayload>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "proto.SpaceCloud", "Service"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.spaceuptech.space_api.proto.FunctionsPayload.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.spaceuptech.space_api.proto.FunctionsPayload.getDefaultInstance()))
                  .setSchemaDescriptor(new SpaceCloudMethodDescriptorSupplier("Service"))
                  .build();
          }
        }
     }
     return getServiceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.spaceuptech.space_api.proto.ProfileRequest,
      com.spaceuptech.space_api.proto.Response> getProfileMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Profile",
      requestType = com.spaceuptech.space_api.proto.ProfileRequest.class,
      responseType = com.spaceuptech.space_api.proto.Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.spaceuptech.space_api.proto.ProfileRequest,
      com.spaceuptech.space_api.proto.Response> getProfileMethod() {
    io.grpc.MethodDescriptor<com.spaceuptech.space_api.proto.ProfileRequest, com.spaceuptech.space_api.proto.Response> getProfileMethod;
    if ((getProfileMethod = SpaceCloudGrpc.getProfileMethod) == null) {
      synchronized (SpaceCloudGrpc.class) {
        if ((getProfileMethod = SpaceCloudGrpc.getProfileMethod) == null) {
          SpaceCloudGrpc.getProfileMethod = getProfileMethod = 
              io.grpc.MethodDescriptor.<com.spaceuptech.space_api.proto.ProfileRequest, com.spaceuptech.space_api.proto.Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "proto.SpaceCloud", "Profile"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.spaceuptech.space_api.proto.ProfileRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.spaceuptech.space_api.proto.Response.getDefaultInstance()))
                  .setSchemaDescriptor(new SpaceCloudMethodDescriptorSupplier("Profile"))
                  .build();
          }
        }
     }
     return getProfileMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.spaceuptech.space_api.proto.ProfilesRequest,
      com.spaceuptech.space_api.proto.Response> getProfilesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Profiles",
      requestType = com.spaceuptech.space_api.proto.ProfilesRequest.class,
      responseType = com.spaceuptech.space_api.proto.Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.spaceuptech.space_api.proto.ProfilesRequest,
      com.spaceuptech.space_api.proto.Response> getProfilesMethod() {
    io.grpc.MethodDescriptor<com.spaceuptech.space_api.proto.ProfilesRequest, com.spaceuptech.space_api.proto.Response> getProfilesMethod;
    if ((getProfilesMethod = SpaceCloudGrpc.getProfilesMethod) == null) {
      synchronized (SpaceCloudGrpc.class) {
        if ((getProfilesMethod = SpaceCloudGrpc.getProfilesMethod) == null) {
          SpaceCloudGrpc.getProfilesMethod = getProfilesMethod = 
              io.grpc.MethodDescriptor.<com.spaceuptech.space_api.proto.ProfilesRequest, com.spaceuptech.space_api.proto.Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "proto.SpaceCloud", "Profiles"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.spaceuptech.space_api.proto.ProfilesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.spaceuptech.space_api.proto.Response.getDefaultInstance()))
                  .setSchemaDescriptor(new SpaceCloudMethodDescriptorSupplier("Profiles"))
                  .build();
          }
        }
     }
     return getProfilesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.spaceuptech.space_api.proto.EditProfileRequest,
      com.spaceuptech.space_api.proto.Response> getEditProfileMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "EditProfile",
      requestType = com.spaceuptech.space_api.proto.EditProfileRequest.class,
      responseType = com.spaceuptech.space_api.proto.Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.spaceuptech.space_api.proto.EditProfileRequest,
      com.spaceuptech.space_api.proto.Response> getEditProfileMethod() {
    io.grpc.MethodDescriptor<com.spaceuptech.space_api.proto.EditProfileRequest, com.spaceuptech.space_api.proto.Response> getEditProfileMethod;
    if ((getEditProfileMethod = SpaceCloudGrpc.getEditProfileMethod) == null) {
      synchronized (SpaceCloudGrpc.class) {
        if ((getEditProfileMethod = SpaceCloudGrpc.getEditProfileMethod) == null) {
          SpaceCloudGrpc.getEditProfileMethod = getEditProfileMethod = 
              io.grpc.MethodDescriptor.<com.spaceuptech.space_api.proto.EditProfileRequest, com.spaceuptech.space_api.proto.Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "proto.SpaceCloud", "EditProfile"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.spaceuptech.space_api.proto.EditProfileRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.spaceuptech.space_api.proto.Response.getDefaultInstance()))
                  .setSchemaDescriptor(new SpaceCloudMethodDescriptorSupplier("EditProfile"))
                  .build();
          }
        }
     }
     return getEditProfileMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.spaceuptech.space_api.proto.SignInRequest,
      com.spaceuptech.space_api.proto.Response> getSignInMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SignIn",
      requestType = com.spaceuptech.space_api.proto.SignInRequest.class,
      responseType = com.spaceuptech.space_api.proto.Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.spaceuptech.space_api.proto.SignInRequest,
      com.spaceuptech.space_api.proto.Response> getSignInMethod() {
    io.grpc.MethodDescriptor<com.spaceuptech.space_api.proto.SignInRequest, com.spaceuptech.space_api.proto.Response> getSignInMethod;
    if ((getSignInMethod = SpaceCloudGrpc.getSignInMethod) == null) {
      synchronized (SpaceCloudGrpc.class) {
        if ((getSignInMethod = SpaceCloudGrpc.getSignInMethod) == null) {
          SpaceCloudGrpc.getSignInMethod = getSignInMethod = 
              io.grpc.MethodDescriptor.<com.spaceuptech.space_api.proto.SignInRequest, com.spaceuptech.space_api.proto.Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "proto.SpaceCloud", "SignIn"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.spaceuptech.space_api.proto.SignInRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.spaceuptech.space_api.proto.Response.getDefaultInstance()))
                  .setSchemaDescriptor(new SpaceCloudMethodDescriptorSupplier("SignIn"))
                  .build();
          }
        }
     }
     return getSignInMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.spaceuptech.space_api.proto.SignUpRequest,
      com.spaceuptech.space_api.proto.Response> getSignUpMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SignUp",
      requestType = com.spaceuptech.space_api.proto.SignUpRequest.class,
      responseType = com.spaceuptech.space_api.proto.Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.spaceuptech.space_api.proto.SignUpRequest,
      com.spaceuptech.space_api.proto.Response> getSignUpMethod() {
    io.grpc.MethodDescriptor<com.spaceuptech.space_api.proto.SignUpRequest, com.spaceuptech.space_api.proto.Response> getSignUpMethod;
    if ((getSignUpMethod = SpaceCloudGrpc.getSignUpMethod) == null) {
      synchronized (SpaceCloudGrpc.class) {
        if ((getSignUpMethod = SpaceCloudGrpc.getSignUpMethod) == null) {
          SpaceCloudGrpc.getSignUpMethod = getSignUpMethod = 
              io.grpc.MethodDescriptor.<com.spaceuptech.space_api.proto.SignUpRequest, com.spaceuptech.space_api.proto.Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "proto.SpaceCloud", "SignUp"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.spaceuptech.space_api.proto.SignUpRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.spaceuptech.space_api.proto.Response.getDefaultInstance()))
                  .setSchemaDescriptor(new SpaceCloudMethodDescriptorSupplier("SignUp"))
                  .build();
          }
        }
     }
     return getSignUpMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SpaceCloudStub newStub(io.grpc.Channel channel) {
    return new SpaceCloudStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SpaceCloudBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new SpaceCloudBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SpaceCloudFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new SpaceCloudFutureStub(channel);
  }

  /**
   */
  public static abstract class SpaceCloudImplBase implements io.grpc.BindableService {

    /**
     */
    public void create(com.spaceuptech.space_api.proto.CreateRequest request,
        io.grpc.stub.StreamObserver<com.spaceuptech.space_api.proto.Response> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateMethod(), responseObserver);
    }

    /**
     */
    public void read(com.spaceuptech.space_api.proto.ReadRequest request,
        io.grpc.stub.StreamObserver<com.spaceuptech.space_api.proto.Response> responseObserver) {
      asyncUnimplementedUnaryCall(getReadMethod(), responseObserver);
    }

    /**
     */
    public void update(com.spaceuptech.space_api.proto.UpdateRequest request,
        io.grpc.stub.StreamObserver<com.spaceuptech.space_api.proto.Response> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateMethod(), responseObserver);
    }

    /**
     */
    public void delete(com.spaceuptech.space_api.proto.DeleteRequest request,
        io.grpc.stub.StreamObserver<com.spaceuptech.space_api.proto.Response> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteMethod(), responseObserver);
    }

    /**
     */
    public void aggregate(com.spaceuptech.space_api.proto.AggregateRequest request,
        io.grpc.stub.StreamObserver<com.spaceuptech.space_api.proto.Response> responseObserver) {
      asyncUnimplementedUnaryCall(getAggregateMethod(), responseObserver);
    }

    /**
     */
    public void batch(com.spaceuptech.space_api.proto.BatchRequest request,
        io.grpc.stub.StreamObserver<com.spaceuptech.space_api.proto.Response> responseObserver) {
      asyncUnimplementedUnaryCall(getBatchMethod(), responseObserver);
    }

    /**
     */
    public void call(com.spaceuptech.space_api.proto.FunctionsRequest request,
        io.grpc.stub.StreamObserver<com.spaceuptech.space_api.proto.Response> responseObserver) {
      asyncUnimplementedUnaryCall(getCallMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.spaceuptech.space_api.proto.RealTimeRequest> realTime(
        io.grpc.stub.StreamObserver<com.spaceuptech.space_api.proto.RealTimeResponse> responseObserver) {
      return asyncUnimplementedStreamingCall(getRealTimeMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.spaceuptech.space_api.proto.FunctionsPayload> service(
        io.grpc.stub.StreamObserver<com.spaceuptech.space_api.proto.FunctionsPayload> responseObserver) {
      return asyncUnimplementedStreamingCall(getServiceMethod(), responseObserver);
    }

    /**
     */
    public void profile(com.spaceuptech.space_api.proto.ProfileRequest request,
        io.grpc.stub.StreamObserver<com.spaceuptech.space_api.proto.Response> responseObserver) {
      asyncUnimplementedUnaryCall(getProfileMethod(), responseObserver);
    }

    /**
     */
    public void profiles(com.spaceuptech.space_api.proto.ProfilesRequest request,
        io.grpc.stub.StreamObserver<com.spaceuptech.space_api.proto.Response> responseObserver) {
      asyncUnimplementedUnaryCall(getProfilesMethod(), responseObserver);
    }

    /**
     */
    public void editProfile(com.spaceuptech.space_api.proto.EditProfileRequest request,
        io.grpc.stub.StreamObserver<com.spaceuptech.space_api.proto.Response> responseObserver) {
      asyncUnimplementedUnaryCall(getEditProfileMethod(), responseObserver);
    }

    /**
     */
    public void signIn(com.spaceuptech.space_api.proto.SignInRequest request,
        io.grpc.stub.StreamObserver<com.spaceuptech.space_api.proto.Response> responseObserver) {
      asyncUnimplementedUnaryCall(getSignInMethod(), responseObserver);
    }

    /**
     */
    public void signUp(com.spaceuptech.space_api.proto.SignUpRequest request,
        io.grpc.stub.StreamObserver<com.spaceuptech.space_api.proto.Response> responseObserver) {
      asyncUnimplementedUnaryCall(getSignUpMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.spaceuptech.space_api.proto.CreateRequest,
                com.spaceuptech.space_api.proto.Response>(
                  this, METHODID_CREATE)))
          .addMethod(
            getReadMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.spaceuptech.space_api.proto.ReadRequest,
                com.spaceuptech.space_api.proto.Response>(
                  this, METHODID_READ)))
          .addMethod(
            getUpdateMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.spaceuptech.space_api.proto.UpdateRequest,
                com.spaceuptech.space_api.proto.Response>(
                  this, METHODID_UPDATE)))
          .addMethod(
            getDeleteMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.spaceuptech.space_api.proto.DeleteRequest,
                com.spaceuptech.space_api.proto.Response>(
                  this, METHODID_DELETE)))
          .addMethod(
            getAggregateMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.spaceuptech.space_api.proto.AggregateRequest,
                com.spaceuptech.space_api.proto.Response>(
                  this, METHODID_AGGREGATE)))
          .addMethod(
            getBatchMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.spaceuptech.space_api.proto.BatchRequest,
                com.spaceuptech.space_api.proto.Response>(
                  this, METHODID_BATCH)))
          .addMethod(
            getCallMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.spaceuptech.space_api.proto.FunctionsRequest,
                com.spaceuptech.space_api.proto.Response>(
                  this, METHODID_CALL)))
          .addMethod(
            getRealTimeMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                com.spaceuptech.space_api.proto.RealTimeRequest,
                com.spaceuptech.space_api.proto.RealTimeResponse>(
                  this, METHODID_REAL_TIME)))
          .addMethod(
            getServiceMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                com.spaceuptech.space_api.proto.FunctionsPayload,
                com.spaceuptech.space_api.proto.FunctionsPayload>(
                  this, METHODID_SERVICE)))
          .addMethod(
            getProfileMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.spaceuptech.space_api.proto.ProfileRequest,
                com.spaceuptech.space_api.proto.Response>(
                  this, METHODID_PROFILE)))
          .addMethod(
            getProfilesMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.spaceuptech.space_api.proto.ProfilesRequest,
                com.spaceuptech.space_api.proto.Response>(
                  this, METHODID_PROFILES)))
          .addMethod(
            getEditProfileMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.spaceuptech.space_api.proto.EditProfileRequest,
                com.spaceuptech.space_api.proto.Response>(
                  this, METHODID_EDIT_PROFILE)))
          .addMethod(
            getSignInMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.spaceuptech.space_api.proto.SignInRequest,
                com.spaceuptech.space_api.proto.Response>(
                  this, METHODID_SIGN_IN)))
          .addMethod(
            getSignUpMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.spaceuptech.space_api.proto.SignUpRequest,
                com.spaceuptech.space_api.proto.Response>(
                  this, METHODID_SIGN_UP)))
          .build();
    }
  }

  /**
   */
  public static final class SpaceCloudStub extends io.grpc.stub.AbstractStub<SpaceCloudStub> {
    private SpaceCloudStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SpaceCloudStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SpaceCloudStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SpaceCloudStub(channel, callOptions);
    }

    /**
     */
    public void create(com.spaceuptech.space_api.proto.CreateRequest request,
        io.grpc.stub.StreamObserver<com.spaceuptech.space_api.proto.Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void read(com.spaceuptech.space_api.proto.ReadRequest request,
        io.grpc.stub.StreamObserver<com.spaceuptech.space_api.proto.Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void update(com.spaceuptech.space_api.proto.UpdateRequest request,
        io.grpc.stub.StreamObserver<com.spaceuptech.space_api.proto.Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void delete(com.spaceuptech.space_api.proto.DeleteRequest request,
        io.grpc.stub.StreamObserver<com.spaceuptech.space_api.proto.Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void aggregate(com.spaceuptech.space_api.proto.AggregateRequest request,
        io.grpc.stub.StreamObserver<com.spaceuptech.space_api.proto.Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAggregateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void batch(com.spaceuptech.space_api.proto.BatchRequest request,
        io.grpc.stub.StreamObserver<com.spaceuptech.space_api.proto.Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getBatchMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void call(com.spaceuptech.space_api.proto.FunctionsRequest request,
        io.grpc.stub.StreamObserver<com.spaceuptech.space_api.proto.Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCallMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.spaceuptech.space_api.proto.RealTimeRequest> realTime(
        io.grpc.stub.StreamObserver<com.spaceuptech.space_api.proto.RealTimeResponse> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getRealTimeMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.spaceuptech.space_api.proto.FunctionsPayload> service(
        io.grpc.stub.StreamObserver<com.spaceuptech.space_api.proto.FunctionsPayload> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getServiceMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public void profile(com.spaceuptech.space_api.proto.ProfileRequest request,
        io.grpc.stub.StreamObserver<com.spaceuptech.space_api.proto.Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getProfileMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void profiles(com.spaceuptech.space_api.proto.ProfilesRequest request,
        io.grpc.stub.StreamObserver<com.spaceuptech.space_api.proto.Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getProfilesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void editProfile(com.spaceuptech.space_api.proto.EditProfileRequest request,
        io.grpc.stub.StreamObserver<com.spaceuptech.space_api.proto.Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getEditProfileMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void signIn(com.spaceuptech.space_api.proto.SignInRequest request,
        io.grpc.stub.StreamObserver<com.spaceuptech.space_api.proto.Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSignInMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void signUp(com.spaceuptech.space_api.proto.SignUpRequest request,
        io.grpc.stub.StreamObserver<com.spaceuptech.space_api.proto.Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getSignUpMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class SpaceCloudBlockingStub extends io.grpc.stub.AbstractStub<SpaceCloudBlockingStub> {
    private SpaceCloudBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SpaceCloudBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SpaceCloudBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SpaceCloudBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.spaceuptech.space_api.proto.Response create(com.spaceuptech.space_api.proto.CreateRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.spaceuptech.space_api.proto.Response read(com.spaceuptech.space_api.proto.ReadRequest request) {
      return blockingUnaryCall(
          getChannel(), getReadMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.spaceuptech.space_api.proto.Response update(com.spaceuptech.space_api.proto.UpdateRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.spaceuptech.space_api.proto.Response delete(com.spaceuptech.space_api.proto.DeleteRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.spaceuptech.space_api.proto.Response aggregate(com.spaceuptech.space_api.proto.AggregateRequest request) {
      return blockingUnaryCall(
          getChannel(), getAggregateMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.spaceuptech.space_api.proto.Response batch(com.spaceuptech.space_api.proto.BatchRequest request) {
      return blockingUnaryCall(
          getChannel(), getBatchMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.spaceuptech.space_api.proto.Response call(com.spaceuptech.space_api.proto.FunctionsRequest request) {
      return blockingUnaryCall(
          getChannel(), getCallMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.spaceuptech.space_api.proto.Response profile(com.spaceuptech.space_api.proto.ProfileRequest request) {
      return blockingUnaryCall(
          getChannel(), getProfileMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.spaceuptech.space_api.proto.Response profiles(com.spaceuptech.space_api.proto.ProfilesRequest request) {
      return blockingUnaryCall(
          getChannel(), getProfilesMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.spaceuptech.space_api.proto.Response editProfile(com.spaceuptech.space_api.proto.EditProfileRequest request) {
      return blockingUnaryCall(
          getChannel(), getEditProfileMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.spaceuptech.space_api.proto.Response signIn(com.spaceuptech.space_api.proto.SignInRequest request) {
      return blockingUnaryCall(
          getChannel(), getSignInMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.spaceuptech.space_api.proto.Response signUp(com.spaceuptech.space_api.proto.SignUpRequest request) {
      return blockingUnaryCall(
          getChannel(), getSignUpMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class SpaceCloudFutureStub extends io.grpc.stub.AbstractStub<SpaceCloudFutureStub> {
    private SpaceCloudFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private SpaceCloudFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SpaceCloudFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SpaceCloudFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.spaceuptech.space_api.proto.Response> create(
        com.spaceuptech.space_api.proto.CreateRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.spaceuptech.space_api.proto.Response> read(
        com.spaceuptech.space_api.proto.ReadRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getReadMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.spaceuptech.space_api.proto.Response> update(
        com.spaceuptech.space_api.proto.UpdateRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.spaceuptech.space_api.proto.Response> delete(
        com.spaceuptech.space_api.proto.DeleteRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.spaceuptech.space_api.proto.Response> aggregate(
        com.spaceuptech.space_api.proto.AggregateRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getAggregateMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.spaceuptech.space_api.proto.Response> batch(
        com.spaceuptech.space_api.proto.BatchRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getBatchMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.spaceuptech.space_api.proto.Response> call(
        com.spaceuptech.space_api.proto.FunctionsRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCallMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.spaceuptech.space_api.proto.Response> profile(
        com.spaceuptech.space_api.proto.ProfileRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getProfileMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.spaceuptech.space_api.proto.Response> profiles(
        com.spaceuptech.space_api.proto.ProfilesRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getProfilesMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.spaceuptech.space_api.proto.Response> editProfile(
        com.spaceuptech.space_api.proto.EditProfileRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getEditProfileMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.spaceuptech.space_api.proto.Response> signIn(
        com.spaceuptech.space_api.proto.SignInRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSignInMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.spaceuptech.space_api.proto.Response> signUp(
        com.spaceuptech.space_api.proto.SignUpRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getSignUpMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE = 0;
  private static final int METHODID_READ = 1;
  private static final int METHODID_UPDATE = 2;
  private static final int METHODID_DELETE = 3;
  private static final int METHODID_AGGREGATE = 4;
  private static final int METHODID_BATCH = 5;
  private static final int METHODID_CALL = 6;
  private static final int METHODID_PROFILE = 7;
  private static final int METHODID_PROFILES = 8;
  private static final int METHODID_EDIT_PROFILE = 9;
  private static final int METHODID_SIGN_IN = 10;
  private static final int METHODID_SIGN_UP = 11;
  private static final int METHODID_REAL_TIME = 12;
  private static final int METHODID_SERVICE = 13;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SpaceCloudImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SpaceCloudImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE:
          serviceImpl.create((com.spaceuptech.space_api.proto.CreateRequest) request,
              (io.grpc.stub.StreamObserver<com.spaceuptech.space_api.proto.Response>) responseObserver);
          break;
        case METHODID_READ:
          serviceImpl.read((com.spaceuptech.space_api.proto.ReadRequest) request,
              (io.grpc.stub.StreamObserver<com.spaceuptech.space_api.proto.Response>) responseObserver);
          break;
        case METHODID_UPDATE:
          serviceImpl.update((com.spaceuptech.space_api.proto.UpdateRequest) request,
              (io.grpc.stub.StreamObserver<com.spaceuptech.space_api.proto.Response>) responseObserver);
          break;
        case METHODID_DELETE:
          serviceImpl.delete((com.spaceuptech.space_api.proto.DeleteRequest) request,
              (io.grpc.stub.StreamObserver<com.spaceuptech.space_api.proto.Response>) responseObserver);
          break;
        case METHODID_AGGREGATE:
          serviceImpl.aggregate((com.spaceuptech.space_api.proto.AggregateRequest) request,
              (io.grpc.stub.StreamObserver<com.spaceuptech.space_api.proto.Response>) responseObserver);
          break;
        case METHODID_BATCH:
          serviceImpl.batch((com.spaceuptech.space_api.proto.BatchRequest) request,
              (io.grpc.stub.StreamObserver<com.spaceuptech.space_api.proto.Response>) responseObserver);
          break;
        case METHODID_CALL:
          serviceImpl.call((com.spaceuptech.space_api.proto.FunctionsRequest) request,
              (io.grpc.stub.StreamObserver<com.spaceuptech.space_api.proto.Response>) responseObserver);
          break;
        case METHODID_PROFILE:
          serviceImpl.profile((com.spaceuptech.space_api.proto.ProfileRequest) request,
              (io.grpc.stub.StreamObserver<com.spaceuptech.space_api.proto.Response>) responseObserver);
          break;
        case METHODID_PROFILES:
          serviceImpl.profiles((com.spaceuptech.space_api.proto.ProfilesRequest) request,
              (io.grpc.stub.StreamObserver<com.spaceuptech.space_api.proto.Response>) responseObserver);
          break;
        case METHODID_EDIT_PROFILE:
          serviceImpl.editProfile((com.spaceuptech.space_api.proto.EditProfileRequest) request,
              (io.grpc.stub.StreamObserver<com.spaceuptech.space_api.proto.Response>) responseObserver);
          break;
        case METHODID_SIGN_IN:
          serviceImpl.signIn((com.spaceuptech.space_api.proto.SignInRequest) request,
              (io.grpc.stub.StreamObserver<com.spaceuptech.space_api.proto.Response>) responseObserver);
          break;
        case METHODID_SIGN_UP:
          serviceImpl.signUp((com.spaceuptech.space_api.proto.SignUpRequest) request,
              (io.grpc.stub.StreamObserver<com.spaceuptech.space_api.proto.Response>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_REAL_TIME:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.realTime(
              (io.grpc.stub.StreamObserver<com.spaceuptech.space_api.proto.RealTimeResponse>) responseObserver);
        case METHODID_SERVICE:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.service(
              (io.grpc.stub.StreamObserver<com.spaceuptech.space_api.proto.FunctionsPayload>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class SpaceCloudBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SpaceCloudBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.spaceuptech.space_api.proto.SpaceCloudProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SpaceCloud");
    }
  }

  private static final class SpaceCloudFileDescriptorSupplier
      extends SpaceCloudBaseDescriptorSupplier {
    SpaceCloudFileDescriptorSupplier() {}
  }

  private static final class SpaceCloudMethodDescriptorSupplier
      extends SpaceCloudBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SpaceCloudMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (SpaceCloudGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SpaceCloudFileDescriptorSupplier())
              .addMethod(getCreateMethod())
              .addMethod(getReadMethod())
              .addMethod(getUpdateMethod())
              .addMethod(getDeleteMethod())
              .addMethod(getAggregateMethod())
              .addMethod(getBatchMethod())
              .addMethod(getCallMethod())
              .addMethod(getRealTimeMethod())
              .addMethod(getServiceMethod())
              .addMethod(getProfileMethod())
              .addMethod(getProfilesMethod())
              .addMethod(getEditProfileMethod())
              .addMethod(getSignInMethod())
              .addMethod(getSignUpMethod())
              .build();
        }
      }
    }
    return result;
  }
}
