package com.spaceuptech.api.core.proto;

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
    value = "by gRPC proto compiler (version 1.19.0)",
    comments = "Source: server.proto")
public final class SpaceCloudGrpc {

  private SpaceCloudGrpc() {}

  public static final String SERVICE_NAME = "proto.SpaceCloud";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<CreateRequest,
      Response> getCreateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Create",
      requestType = CreateRequest.class,
      responseType = Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<CreateRequest,
      Response> getCreateMethod() {
    io.grpc.MethodDescriptor<CreateRequest, Response> getCreateMethod;
    if ((getCreateMethod = SpaceCloudGrpc.getCreateMethod) == null) {
      synchronized (SpaceCloudGrpc.class) {
        if ((getCreateMethod = SpaceCloudGrpc.getCreateMethod) == null) {
          SpaceCloudGrpc.getCreateMethod = getCreateMethod = 
              io.grpc.MethodDescriptor.<CreateRequest, Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "proto.SpaceCloud", "Create"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  CreateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Response.getDefaultInstance()))
                  .setSchemaDescriptor(new SpaceCloudMethodDescriptorSupplier("Create"))
                  .build();
          }
        }
     }
     return getCreateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<ReadRequest,
      Response> getReadMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Read",
      requestType = ReadRequest.class,
      responseType = Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<ReadRequest,
      Response> getReadMethod() {
    io.grpc.MethodDescriptor<ReadRequest, Response> getReadMethod;
    if ((getReadMethod = SpaceCloudGrpc.getReadMethod) == null) {
      synchronized (SpaceCloudGrpc.class) {
        if ((getReadMethod = SpaceCloudGrpc.getReadMethod) == null) {
          SpaceCloudGrpc.getReadMethod = getReadMethod = 
              io.grpc.MethodDescriptor.<ReadRequest, Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "proto.SpaceCloud", "Read"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  ReadRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Response.getDefaultInstance()))
                  .setSchemaDescriptor(new SpaceCloudMethodDescriptorSupplier("Read"))
                  .build();
          }
        }
     }
     return getReadMethod;
  }

  private static volatile io.grpc.MethodDescriptor<UpdateRequest,
      Response> getUpdateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Update",
      requestType = UpdateRequest.class,
      responseType = Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<UpdateRequest,
      Response> getUpdateMethod() {
    io.grpc.MethodDescriptor<UpdateRequest, Response> getUpdateMethod;
    if ((getUpdateMethod = SpaceCloudGrpc.getUpdateMethod) == null) {
      synchronized (SpaceCloudGrpc.class) {
        if ((getUpdateMethod = SpaceCloudGrpc.getUpdateMethod) == null) {
          SpaceCloudGrpc.getUpdateMethod = getUpdateMethod = 
              io.grpc.MethodDescriptor.<UpdateRequest, Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "proto.SpaceCloud", "Update"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  UpdateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Response.getDefaultInstance()))
                  .setSchemaDescriptor(new SpaceCloudMethodDescriptorSupplier("Update"))
                  .build();
          }
        }
     }
     return getUpdateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<DeleteRequest,
      Response> getDeleteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Delete",
      requestType = DeleteRequest.class,
      responseType = Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<DeleteRequest,
      Response> getDeleteMethod() {
    io.grpc.MethodDescriptor<DeleteRequest, Response> getDeleteMethod;
    if ((getDeleteMethod = SpaceCloudGrpc.getDeleteMethod) == null) {
      synchronized (SpaceCloudGrpc.class) {
        if ((getDeleteMethod = SpaceCloudGrpc.getDeleteMethod) == null) {
          SpaceCloudGrpc.getDeleteMethod = getDeleteMethod = 
              io.grpc.MethodDescriptor.<DeleteRequest, Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "proto.SpaceCloud", "Delete"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  DeleteRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Response.getDefaultInstance()))
                  .setSchemaDescriptor(new SpaceCloudMethodDescriptorSupplier("Delete"))
                  .build();
          }
        }
     }
     return getDeleteMethod;
  }

  private static volatile io.grpc.MethodDescriptor<AggregateRequest,
      Response> getAggregateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Aggregate",
      requestType = AggregateRequest.class,
      responseType = Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<AggregateRequest,
      Response> getAggregateMethod() {
    io.grpc.MethodDescriptor<AggregateRequest, Response> getAggregateMethod;
    if ((getAggregateMethod = SpaceCloudGrpc.getAggregateMethod) == null) {
      synchronized (SpaceCloudGrpc.class) {
        if ((getAggregateMethod = SpaceCloudGrpc.getAggregateMethod) == null) {
          SpaceCloudGrpc.getAggregateMethod = getAggregateMethod = 
              io.grpc.MethodDescriptor.<AggregateRequest, Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "proto.SpaceCloud", "Aggregate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  AggregateRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Response.getDefaultInstance()))
                  .setSchemaDescriptor(new SpaceCloudMethodDescriptorSupplier("Aggregate"))
                  .build();
          }
        }
     }
     return getAggregateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<BatchRequest,
      Response> getBatchMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Batch",
      requestType = BatchRequest.class,
      responseType = Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<BatchRequest,
      Response> getBatchMethod() {
    io.grpc.MethodDescriptor<BatchRequest, Response> getBatchMethod;
    if ((getBatchMethod = SpaceCloudGrpc.getBatchMethod) == null) {
      synchronized (SpaceCloudGrpc.class) {
        if ((getBatchMethod = SpaceCloudGrpc.getBatchMethod) == null) {
          SpaceCloudGrpc.getBatchMethod = getBatchMethod = 
              io.grpc.MethodDescriptor.<BatchRequest, Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "proto.SpaceCloud", "Batch"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  BatchRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Response.getDefaultInstance()))
                  .setSchemaDescriptor(new SpaceCloudMethodDescriptorSupplier("Batch"))
                  .build();
          }
        }
     }
     return getBatchMethod;
  }

  private static volatile io.grpc.MethodDescriptor<FaaSRequest,
      Response> getCallMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Call",
      requestType = FaaSRequest.class,
      responseType = Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<FaaSRequest,
      Response> getCallMethod() {
    io.grpc.MethodDescriptor<FaaSRequest, Response> getCallMethod;
    if ((getCallMethod = SpaceCloudGrpc.getCallMethod) == null) {
      synchronized (SpaceCloudGrpc.class) {
        if ((getCallMethod = SpaceCloudGrpc.getCallMethod) == null) {
          SpaceCloudGrpc.getCallMethod = getCallMethod = 
              io.grpc.MethodDescriptor.<FaaSRequest, Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "proto.SpaceCloud", "Call"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  FaaSRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Response.getDefaultInstance()))
                  .setSchemaDescriptor(new SpaceCloudMethodDescriptorSupplier("Call"))
                  .build();
          }
        }
     }
     return getCallMethod;
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
    public void create(CreateRequest request,
                       io.grpc.stub.StreamObserver<Response> responseObserver) {
      asyncUnimplementedUnaryCall(getCreateMethod(), responseObserver);
    }

    /**
     */
    public void read(ReadRequest request,
                     io.grpc.stub.StreamObserver<Response> responseObserver) {
      asyncUnimplementedUnaryCall(getReadMethod(), responseObserver);
    }

    /**
     */
    public void update(UpdateRequest request,
                       io.grpc.stub.StreamObserver<Response> responseObserver) {
      asyncUnimplementedUnaryCall(getUpdateMethod(), responseObserver);
    }

    /**
     */
    public void delete(DeleteRequest request,
                       io.grpc.stub.StreamObserver<Response> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteMethod(), responseObserver);
    }

    /**
     */
    public void aggregate(AggregateRequest request,
                          io.grpc.stub.StreamObserver<Response> responseObserver) {
      asyncUnimplementedUnaryCall(getAggregateMethod(), responseObserver);
    }

    /**
     */
    public void batch(BatchRequest request,
                      io.grpc.stub.StreamObserver<Response> responseObserver) {
      asyncUnimplementedUnaryCall(getBatchMethod(), responseObserver);
    }

    /**
     */
    public void call(FaaSRequest request,
                     io.grpc.stub.StreamObserver<Response> responseObserver) {
      asyncUnimplementedUnaryCall(getCallMethod(), responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                CreateRequest,
                Response>(
                  this, METHODID_CREATE)))
          .addMethod(
            getReadMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                ReadRequest,
                Response>(
                  this, METHODID_READ)))
          .addMethod(
            getUpdateMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                UpdateRequest,
                Response>(
                  this, METHODID_UPDATE)))
          .addMethod(
            getDeleteMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                DeleteRequest,
                Response>(
                  this, METHODID_DELETE)))
          .addMethod(
            getAggregateMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                AggregateRequest,
                Response>(
                  this, METHODID_AGGREGATE)))
          .addMethod(
            getBatchMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                BatchRequest,
                Response>(
                  this, METHODID_BATCH)))
          .addMethod(
            getCallMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                FaaSRequest,
                Response>(
                  this, METHODID_CALL)))
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

    @Override
    protected SpaceCloudStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SpaceCloudStub(channel, callOptions);
    }

    /**
     */
    public void create(CreateRequest request,
                       io.grpc.stub.StreamObserver<Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCreateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void read(ReadRequest request,
                     io.grpc.stub.StreamObserver<Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getReadMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void update(UpdateRequest request,
                       io.grpc.stub.StreamObserver<Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getUpdateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void delete(DeleteRequest request,
                       io.grpc.stub.StreamObserver<Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void aggregate(AggregateRequest request,
                          io.grpc.stub.StreamObserver<Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAggregateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void batch(BatchRequest request,
                      io.grpc.stub.StreamObserver<Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getBatchMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void call(FaaSRequest request,
                     io.grpc.stub.StreamObserver<Response> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCallMethod(), getCallOptions()), request, responseObserver);
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

    @Override
    protected SpaceCloudBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SpaceCloudBlockingStub(channel, callOptions);
    }

    /**
     */
    public Response create(CreateRequest request) {
      return blockingUnaryCall(
          getChannel(), getCreateMethod(), getCallOptions(), request);
    }

    /**
     */
    public Response read(ReadRequest request) {
      return blockingUnaryCall(
          getChannel(), getReadMethod(), getCallOptions(), request);
    }

    /**
     */
    public Response update(UpdateRequest request) {
      return blockingUnaryCall(
          getChannel(), getUpdateMethod(), getCallOptions(), request);
    }

    /**
     */
    public Response delete(DeleteRequest request) {
      return blockingUnaryCall(
          getChannel(), getDeleteMethod(), getCallOptions(), request);
    }

    /**
     */
    public Response aggregate(AggregateRequest request) {
      return blockingUnaryCall(
          getChannel(), getAggregateMethod(), getCallOptions(), request);
    }

    /**
     */
    public Response batch(BatchRequest request) {
      return blockingUnaryCall(
          getChannel(), getBatchMethod(), getCallOptions(), request);
    }

    /**
     */
    public Response call(FaaSRequest request) {
      return blockingUnaryCall(
          getChannel(), getCallMethod(), getCallOptions(), request);
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

    @Override
    protected SpaceCloudFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new SpaceCloudFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Response> create(
        CreateRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCreateMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Response> read(
        ReadRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getReadMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Response> update(
        UpdateRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getUpdateMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Response> delete(
        DeleteRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Response> aggregate(
        AggregateRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getAggregateMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Response> batch(
        BatchRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getBatchMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<Response> call(
        FaaSRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCallMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE = 0;
  private static final int METHODID_READ = 1;
  private static final int METHODID_UPDATE = 2;
  private static final int METHODID_DELETE = 3;
  private static final int METHODID_AGGREGATE = 4;
  private static final int METHODID_BATCH = 5;
  private static final int METHODID_CALL = 6;

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

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE:
          serviceImpl.create((CreateRequest) request,
              (io.grpc.stub.StreamObserver<Response>) responseObserver);
          break;
        case METHODID_READ:
          serviceImpl.read((ReadRequest) request,
              (io.grpc.stub.StreamObserver<Response>) responseObserver);
          break;
        case METHODID_UPDATE:
          serviceImpl.update((UpdateRequest) request,
              (io.grpc.stub.StreamObserver<Response>) responseObserver);
          break;
        case METHODID_DELETE:
          serviceImpl.delete((DeleteRequest) request,
              (io.grpc.stub.StreamObserver<Response>) responseObserver);
          break;
        case METHODID_AGGREGATE:
          serviceImpl.aggregate((AggregateRequest) request,
              (io.grpc.stub.StreamObserver<Response>) responseObserver);
          break;
        case METHODID_BATCH:
          serviceImpl.batch((BatchRequest) request,
              (io.grpc.stub.StreamObserver<Response>) responseObserver);
          break;
        case METHODID_CALL:
          serviceImpl.call((FaaSRequest) request,
              (io.grpc.stub.StreamObserver<Response>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @Override
    @SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class SpaceCloudBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SpaceCloudBaseDescriptorSupplier() {}

    @Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return SpaceCloudProto.getDescriptor();
    }

    @Override
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

    @Override
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
              .build();
        }
      }
    }
    return result;
  }
}
