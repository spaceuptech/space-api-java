package com.spaceuptech.api.core.proto;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.4.0)",
    comments = "Source: server.proto")
public final class SpaceCloudGrpc {

  private SpaceCloudGrpc() {}

  public static final String SERVICE_NAME = "proto.SpaceCloud";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.spaceuptech.api.core.proto.CreateRequest,
      com.spaceuptech.api.core.proto.Response> METHOD_CREATE =
      io.grpc.MethodDescriptor.<com.spaceuptech.api.core.proto.CreateRequest, com.spaceuptech.api.core.proto.Response>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "proto.SpaceCloud", "Create"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.spaceuptech.api.core.proto.CreateRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.spaceuptech.api.core.proto.Response.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.spaceuptech.api.core.proto.ReadRequest,
      com.spaceuptech.api.core.proto.Response> METHOD_READ =
      io.grpc.MethodDescriptor.<com.spaceuptech.api.core.proto.ReadRequest, com.spaceuptech.api.core.proto.Response>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "proto.SpaceCloud", "Read"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.spaceuptech.api.core.proto.ReadRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.spaceuptech.api.core.proto.Response.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.spaceuptech.api.core.proto.UpdateRequest,
      com.spaceuptech.api.core.proto.Response> METHOD_UPDATE =
      io.grpc.MethodDescriptor.<com.spaceuptech.api.core.proto.UpdateRequest, com.spaceuptech.api.core.proto.Response>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "proto.SpaceCloud", "Update"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.spaceuptech.api.core.proto.UpdateRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.spaceuptech.api.core.proto.Response.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.spaceuptech.api.core.proto.DeleteRequest,
      com.spaceuptech.api.core.proto.Response> METHOD_DELETE =
      io.grpc.MethodDescriptor.<com.spaceuptech.api.core.proto.DeleteRequest, com.spaceuptech.api.core.proto.Response>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "proto.SpaceCloud", "Delete"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.spaceuptech.api.core.proto.DeleteRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.spaceuptech.api.core.proto.Response.getDefaultInstance()))
          .build();
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.spaceuptech.api.core.proto.AggregateRequest,
      com.spaceuptech.api.core.proto.Response> METHOD_AGGREGATE =
      io.grpc.MethodDescriptor.<com.spaceuptech.api.core.proto.AggregateRequest, com.spaceuptech.api.core.proto.Response>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "proto.SpaceCloud", "Aggregate"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.spaceuptech.api.core.proto.AggregateRequest.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.spaceuptech.api.core.proto.Response.getDefaultInstance()))
          .build();

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
    public void create(com.spaceuptech.api.core.proto.CreateRequest request,
        io.grpc.stub.StreamObserver<com.spaceuptech.api.core.proto.Response> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_CREATE, responseObserver);
    }

    /**
     */
    public void read(com.spaceuptech.api.core.proto.ReadRequest request,
        io.grpc.stub.StreamObserver<com.spaceuptech.api.core.proto.Response> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_READ, responseObserver);
    }

    /**
     */
    public void update(com.spaceuptech.api.core.proto.UpdateRequest request,
        io.grpc.stub.StreamObserver<com.spaceuptech.api.core.proto.Response> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_UPDATE, responseObserver);
    }

    /**
     */
    public void delete(com.spaceuptech.api.core.proto.DeleteRequest request,
        io.grpc.stub.StreamObserver<com.spaceuptech.api.core.proto.Response> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_DELETE, responseObserver);
    }

    /**
     */
    public void aggregate(com.spaceuptech.api.core.proto.AggregateRequest request,
        io.grpc.stub.StreamObserver<com.spaceuptech.api.core.proto.Response> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_AGGREGATE, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_CREATE,
            asyncUnaryCall(
              new MethodHandlers<
                com.spaceuptech.api.core.proto.CreateRequest,
                com.spaceuptech.api.core.proto.Response>(
                  this, METHODID_CREATE)))
          .addMethod(
            METHOD_READ,
            asyncUnaryCall(
              new MethodHandlers<
                com.spaceuptech.api.core.proto.ReadRequest,
                com.spaceuptech.api.core.proto.Response>(
                  this, METHODID_READ)))
          .addMethod(
            METHOD_UPDATE,
            asyncUnaryCall(
              new MethodHandlers<
                com.spaceuptech.api.core.proto.UpdateRequest,
                com.spaceuptech.api.core.proto.Response>(
                  this, METHODID_UPDATE)))
          .addMethod(
            METHOD_DELETE,
            asyncUnaryCall(
              new MethodHandlers<
                com.spaceuptech.api.core.proto.DeleteRequest,
                com.spaceuptech.api.core.proto.Response>(
                  this, METHODID_DELETE)))
          .addMethod(
            METHOD_AGGREGATE,
            asyncUnaryCall(
              new MethodHandlers<
                com.spaceuptech.api.core.proto.AggregateRequest,
                com.spaceuptech.api.core.proto.Response>(
                  this, METHODID_AGGREGATE)))
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
    public void create(com.spaceuptech.api.core.proto.CreateRequest request,
        io.grpc.stub.StreamObserver<com.spaceuptech.api.core.proto.Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_CREATE, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void read(com.spaceuptech.api.core.proto.ReadRequest request,
        io.grpc.stub.StreamObserver<com.spaceuptech.api.core.proto.Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_READ, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void update(com.spaceuptech.api.core.proto.UpdateRequest request,
        io.grpc.stub.StreamObserver<com.spaceuptech.api.core.proto.Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_UPDATE, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void delete(com.spaceuptech.api.core.proto.DeleteRequest request,
        io.grpc.stub.StreamObserver<com.spaceuptech.api.core.proto.Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_DELETE, getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void aggregate(com.spaceuptech.api.core.proto.AggregateRequest request,
        io.grpc.stub.StreamObserver<com.spaceuptech.api.core.proto.Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_AGGREGATE, getCallOptions()), request, responseObserver);
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
    public com.spaceuptech.api.core.proto.Response create(com.spaceuptech.api.core.proto.CreateRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_CREATE, getCallOptions(), request);
    }

    /**
     */
    public com.spaceuptech.api.core.proto.Response read(com.spaceuptech.api.core.proto.ReadRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_READ, getCallOptions(), request);
    }

    /**
     */
    public com.spaceuptech.api.core.proto.Response update(com.spaceuptech.api.core.proto.UpdateRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_UPDATE, getCallOptions(), request);
    }

    /**
     */
    public com.spaceuptech.api.core.proto.Response delete(com.spaceuptech.api.core.proto.DeleteRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_DELETE, getCallOptions(), request);
    }

    /**
     */
    public com.spaceuptech.api.core.proto.Response aggregate(com.spaceuptech.api.core.proto.AggregateRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_AGGREGATE, getCallOptions(), request);
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
    public com.google.common.util.concurrent.ListenableFuture<com.spaceuptech.api.core.proto.Response> create(
        com.spaceuptech.api.core.proto.CreateRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_CREATE, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.spaceuptech.api.core.proto.Response> read(
        com.spaceuptech.api.core.proto.ReadRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_READ, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.spaceuptech.api.core.proto.Response> update(
        com.spaceuptech.api.core.proto.UpdateRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_UPDATE, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.spaceuptech.api.core.proto.Response> delete(
        com.spaceuptech.api.core.proto.DeleteRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_DELETE, getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.spaceuptech.api.core.proto.Response> aggregate(
        com.spaceuptech.api.core.proto.AggregateRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_AGGREGATE, getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE = 0;
  private static final int METHODID_READ = 1;
  private static final int METHODID_UPDATE = 2;
  private static final int METHODID_DELETE = 3;
  private static final int METHODID_AGGREGATE = 4;

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
          serviceImpl.create((com.spaceuptech.api.core.proto.CreateRequest) request,
              (io.grpc.stub.StreamObserver<com.spaceuptech.api.core.proto.Response>) responseObserver);
          break;
        case METHODID_READ:
          serviceImpl.read((com.spaceuptech.api.core.proto.ReadRequest) request,
              (io.grpc.stub.StreamObserver<com.spaceuptech.api.core.proto.Response>) responseObserver);
          break;
        case METHODID_UPDATE:
          serviceImpl.update((com.spaceuptech.api.core.proto.UpdateRequest) request,
              (io.grpc.stub.StreamObserver<com.spaceuptech.api.core.proto.Response>) responseObserver);
          break;
        case METHODID_DELETE:
          serviceImpl.delete((com.spaceuptech.api.core.proto.DeleteRequest) request,
              (io.grpc.stub.StreamObserver<com.spaceuptech.api.core.proto.Response>) responseObserver);
          break;
        case METHODID_AGGREGATE:
          serviceImpl.aggregate((com.spaceuptech.api.core.proto.AggregateRequest) request,
              (io.grpc.stub.StreamObserver<com.spaceuptech.api.core.proto.Response>) responseObserver);
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
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class SpaceCloudDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.spaceuptech.api.core.proto.SpaceCloudProto.getDescriptor();
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
              .setSchemaDescriptor(new SpaceCloudDescriptorSupplier())
              .addMethod(METHOD_CREATE)
              .addMethod(METHOD_READ)
              .addMethod(METHOD_UPDATE)
              .addMethod(METHOD_DELETE)
              .addMethod(METHOD_AGGREGATE)
              .build();
        }
      }
    }
    return result;
  }
}
