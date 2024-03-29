package cool.houge.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * 消息服务
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.43.2)",
    comments = "Source: cool/houge/grpc/msg.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class MsgGrpc {

  private MsgGrpc() {}

  public static final String SERVICE_NAME = "Msg";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<cool.houge.grpc.CreateMsgIdRequest,
      cool.houge.grpc.CreateMsgIdResponse> getCreateIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateId",
      requestType = cool.houge.grpc.CreateMsgIdRequest.class,
      responseType = cool.houge.grpc.CreateMsgIdResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<cool.houge.grpc.CreateMsgIdRequest,
      cool.houge.grpc.CreateMsgIdResponse> getCreateIdMethod() {
    io.grpc.MethodDescriptor<cool.houge.grpc.CreateMsgIdRequest, cool.houge.grpc.CreateMsgIdResponse> getCreateIdMethod;
    if ((getCreateIdMethod = MsgGrpc.getCreateIdMethod) == null) {
      synchronized (MsgGrpc.class) {
        if ((getCreateIdMethod = MsgGrpc.getCreateIdMethod) == null) {
          MsgGrpc.getCreateIdMethod = getCreateIdMethod =
              io.grpc.MethodDescriptor.<cool.houge.grpc.CreateMsgIdRequest, cool.houge.grpc.CreateMsgIdResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateId"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cool.houge.grpc.CreateMsgIdRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cool.houge.grpc.CreateMsgIdResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MsgMethodDescriptorSupplier("CreateId"))
              .build();
        }
      }
    }
    return getCreateIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<cool.houge.grpc.CreateMsgIdsRequest,
      cool.houge.grpc.CreateMsgIdsResponse> getCreateIdsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateIds",
      requestType = cool.houge.grpc.CreateMsgIdsRequest.class,
      responseType = cool.houge.grpc.CreateMsgIdsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<cool.houge.grpc.CreateMsgIdsRequest,
      cool.houge.grpc.CreateMsgIdsResponse> getCreateIdsMethod() {
    io.grpc.MethodDescriptor<cool.houge.grpc.CreateMsgIdsRequest, cool.houge.grpc.CreateMsgIdsResponse> getCreateIdsMethod;
    if ((getCreateIdsMethod = MsgGrpc.getCreateIdsMethod) == null) {
      synchronized (MsgGrpc.class) {
        if ((getCreateIdsMethod = MsgGrpc.getCreateIdsMethod) == null) {
          MsgGrpc.getCreateIdsMethod = getCreateIdsMethod =
              io.grpc.MethodDescriptor.<cool.houge.grpc.CreateMsgIdsRequest, cool.houge.grpc.CreateMsgIdsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateIds"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cool.houge.grpc.CreateMsgIdsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cool.houge.grpc.CreateMsgIdsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MsgMethodDescriptorSupplier("CreateIds"))
              .build();
        }
      }
    }
    return getCreateIdsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<cool.houge.grpc.SendMsgRequest,
      cool.houge.grpc.SendMsgResponse> getSendToUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SendToUser",
      requestType = cool.houge.grpc.SendMsgRequest.class,
      responseType = cool.houge.grpc.SendMsgResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<cool.houge.grpc.SendMsgRequest,
      cool.houge.grpc.SendMsgResponse> getSendToUserMethod() {
    io.grpc.MethodDescriptor<cool.houge.grpc.SendMsgRequest, cool.houge.grpc.SendMsgResponse> getSendToUserMethod;
    if ((getSendToUserMethod = MsgGrpc.getSendToUserMethod) == null) {
      synchronized (MsgGrpc.class) {
        if ((getSendToUserMethod = MsgGrpc.getSendToUserMethod) == null) {
          MsgGrpc.getSendToUserMethod = getSendToUserMethod =
              io.grpc.MethodDescriptor.<cool.houge.grpc.SendMsgRequest, cool.houge.grpc.SendMsgResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SendToUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cool.houge.grpc.SendMsgRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cool.houge.grpc.SendMsgResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MsgMethodDescriptorSupplier("SendToUser"))
              .build();
        }
      }
    }
    return getSendToUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<cool.houge.grpc.SendMsgRequest,
      cool.houge.grpc.SendMsgResponse> getSendToGroupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SendToGroup",
      requestType = cool.houge.grpc.SendMsgRequest.class,
      responseType = cool.houge.grpc.SendMsgResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<cool.houge.grpc.SendMsgRequest,
      cool.houge.grpc.SendMsgResponse> getSendToGroupMethod() {
    io.grpc.MethodDescriptor<cool.houge.grpc.SendMsgRequest, cool.houge.grpc.SendMsgResponse> getSendToGroupMethod;
    if ((getSendToGroupMethod = MsgGrpc.getSendToGroupMethod) == null) {
      synchronized (MsgGrpc.class) {
        if ((getSendToGroupMethod = MsgGrpc.getSendToGroupMethod) == null) {
          MsgGrpc.getSendToGroupMethod = getSendToGroupMethod =
              io.grpc.MethodDescriptor.<cool.houge.grpc.SendMsgRequest, cool.houge.grpc.SendMsgResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SendToGroup"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cool.houge.grpc.SendMsgRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cool.houge.grpc.SendMsgResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MsgMethodDescriptorSupplier("SendToGroup"))
              .build();
        }
      }
    }
    return getSendToGroupMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MsgStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MsgStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MsgStub>() {
        @java.lang.Override
        public MsgStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MsgStub(channel, callOptions);
        }
      };
    return MsgStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MsgBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MsgBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MsgBlockingStub>() {
        @java.lang.Override
        public MsgBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MsgBlockingStub(channel, callOptions);
        }
      };
    return MsgBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static MsgFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MsgFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MsgFutureStub>() {
        @java.lang.Override
        public MsgFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MsgFutureStub(channel, callOptions);
        }
      };
    return MsgFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * 消息服务
   * </pre>
   */
  public static abstract class MsgImplBase implements io.grpc.BindableService {

    /**
     */
    public void createId(cool.houge.grpc.CreateMsgIdRequest request,
        io.grpc.stub.StreamObserver<cool.houge.grpc.CreateMsgIdResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateIdMethod(), responseObserver);
    }

    /**
     */
    public void createIds(cool.houge.grpc.CreateMsgIdsRequest request,
        io.grpc.stub.StreamObserver<cool.houge.grpc.CreateMsgIdsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateIdsMethod(), responseObserver);
    }

    /**
     */
    public void sendToUser(cool.houge.grpc.SendMsgRequest request,
        io.grpc.stub.StreamObserver<cool.houge.grpc.SendMsgResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSendToUserMethod(), responseObserver);
    }

    /**
     */
    public void sendToGroup(cool.houge.grpc.SendMsgRequest request,
        io.grpc.stub.StreamObserver<cool.houge.grpc.SendMsgResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSendToGroupMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateIdMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                cool.houge.grpc.CreateMsgIdRequest,
                cool.houge.grpc.CreateMsgIdResponse>(
                  this, METHODID_CREATE_ID)))
          .addMethod(
            getCreateIdsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                cool.houge.grpc.CreateMsgIdsRequest,
                cool.houge.grpc.CreateMsgIdsResponse>(
                  this, METHODID_CREATE_IDS)))
          .addMethod(
            getSendToUserMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                cool.houge.grpc.SendMsgRequest,
                cool.houge.grpc.SendMsgResponse>(
                  this, METHODID_SEND_TO_USER)))
          .addMethod(
            getSendToGroupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                cool.houge.grpc.SendMsgRequest,
                cool.houge.grpc.SendMsgResponse>(
                  this, METHODID_SEND_TO_GROUP)))
          .build();
    }
  }

  /**
   * <pre>
   * 消息服务
   * </pre>
   */
  public static final class MsgStub extends io.grpc.stub.AbstractAsyncStub<MsgStub> {
    private MsgStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MsgStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MsgStub(channel, callOptions);
    }

    /**
     */
    public void createId(cool.houge.grpc.CreateMsgIdRequest request,
        io.grpc.stub.StreamObserver<cool.houge.grpc.CreateMsgIdResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void createIds(cool.houge.grpc.CreateMsgIdsRequest request,
        io.grpc.stub.StreamObserver<cool.houge.grpc.CreateMsgIdsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateIdsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void sendToUser(cool.houge.grpc.SendMsgRequest request,
        io.grpc.stub.StreamObserver<cool.houge.grpc.SendMsgResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSendToUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void sendToGroup(cool.houge.grpc.SendMsgRequest request,
        io.grpc.stub.StreamObserver<cool.houge.grpc.SendMsgResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSendToGroupMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * 消息服务
   * </pre>
   */
  public static final class MsgBlockingStub extends io.grpc.stub.AbstractBlockingStub<MsgBlockingStub> {
    private MsgBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MsgBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MsgBlockingStub(channel, callOptions);
    }

    /**
     */
    public cool.houge.grpc.CreateMsgIdResponse createId(cool.houge.grpc.CreateMsgIdRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public cool.houge.grpc.CreateMsgIdsResponse createIds(cool.houge.grpc.CreateMsgIdsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateIdsMethod(), getCallOptions(), request);
    }

    /**
     */
    public cool.houge.grpc.SendMsgResponse sendToUser(cool.houge.grpc.SendMsgRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSendToUserMethod(), getCallOptions(), request);
    }

    /**
     */
    public cool.houge.grpc.SendMsgResponse sendToGroup(cool.houge.grpc.SendMsgRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSendToGroupMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * 消息服务
   * </pre>
   */
  public static final class MsgFutureStub extends io.grpc.stub.AbstractFutureStub<MsgFutureStub> {
    private MsgFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MsgFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MsgFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<cool.houge.grpc.CreateMsgIdResponse> createId(
        cool.houge.grpc.CreateMsgIdRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateIdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<cool.houge.grpc.CreateMsgIdsResponse> createIds(
        cool.houge.grpc.CreateMsgIdsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateIdsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<cool.houge.grpc.SendMsgResponse> sendToUser(
        cool.houge.grpc.SendMsgRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSendToUserMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<cool.houge.grpc.SendMsgResponse> sendToGroup(
        cool.houge.grpc.SendMsgRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSendToGroupMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_ID = 0;
  private static final int METHODID_CREATE_IDS = 1;
  private static final int METHODID_SEND_TO_USER = 2;
  private static final int METHODID_SEND_TO_GROUP = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final MsgImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(MsgImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_ID:
          serviceImpl.createId((cool.houge.grpc.CreateMsgIdRequest) request,
              (io.grpc.stub.StreamObserver<cool.houge.grpc.CreateMsgIdResponse>) responseObserver);
          break;
        case METHODID_CREATE_IDS:
          serviceImpl.createIds((cool.houge.grpc.CreateMsgIdsRequest) request,
              (io.grpc.stub.StreamObserver<cool.houge.grpc.CreateMsgIdsResponse>) responseObserver);
          break;
        case METHODID_SEND_TO_USER:
          serviceImpl.sendToUser((cool.houge.grpc.SendMsgRequest) request,
              (io.grpc.stub.StreamObserver<cool.houge.grpc.SendMsgResponse>) responseObserver);
          break;
        case METHODID_SEND_TO_GROUP:
          serviceImpl.sendToGroup((cool.houge.grpc.SendMsgRequest) request,
              (io.grpc.stub.StreamObserver<cool.houge.grpc.SendMsgResponse>) responseObserver);
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

  private static abstract class MsgBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MsgBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return cool.houge.grpc.MsgOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Msg");
    }
  }

  private static final class MsgFileDescriptorSupplier
      extends MsgBaseDescriptorSupplier {
    MsgFileDescriptorSupplier() {}
  }

  private static final class MsgMethodDescriptorSupplier
      extends MsgBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    MsgMethodDescriptorSupplier(String methodName) {
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
      synchronized (MsgGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new MsgFileDescriptorSupplier())
              .addMethod(getCreateIdMethod())
              .addMethod(getCreateIdsMethod())
              .addMethod(getSendToUserMethod())
              .addMethod(getSendToGroupMethod())
              .build();
        }
      }
    }
    return result;
  }
}
