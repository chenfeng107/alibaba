package cool.houge.grpc.broker;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.39.0)",
    comments = "Source: cool/houge/grpc/broker/polygon.proto")
public final class PolygonGrpc {

  private PolygonGrpc() {}

  public static final String SERVICE_NAME = "Polygon";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<cool.houge.grpc.broker.PolygonPb.BrokerAuthRequest,
      cool.houge.grpc.broker.PolygonPb.BrokerAuthResponse> getAuthMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Auth",
      requestType = cool.houge.grpc.broker.PolygonPb.BrokerAuthRequest.class,
      responseType = cool.houge.grpc.broker.PolygonPb.BrokerAuthResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<cool.houge.grpc.broker.PolygonPb.BrokerAuthRequest,
      cool.houge.grpc.broker.PolygonPb.BrokerAuthResponse> getAuthMethod() {
    io.grpc.MethodDescriptor<cool.houge.grpc.broker.PolygonPb.BrokerAuthRequest, cool.houge.grpc.broker.PolygonPb.BrokerAuthResponse> getAuthMethod;
    if ((getAuthMethod = PolygonGrpc.getAuthMethod) == null) {
      synchronized (PolygonGrpc.class) {
        if ((getAuthMethod = PolygonGrpc.getAuthMethod) == null) {
          PolygonGrpc.getAuthMethod = getAuthMethod =
              io.grpc.MethodDescriptor.<cool.houge.grpc.broker.PolygonPb.BrokerAuthRequest, cool.houge.grpc.broker.PolygonPb.BrokerAuthResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Auth"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cool.houge.grpc.broker.PolygonPb.BrokerAuthRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cool.houge.grpc.broker.PolygonPb.BrokerAuthResponse.getDefaultInstance()))
              .setSchemaDescriptor(new PolygonMethodDescriptorSupplier("Auth"))
              .build();
        }
      }
    }
    return getAuthMethod;
  }

  private static volatile io.grpc.MethodDescriptor<cool.houge.grpc.broker.PolygonPb.BrokerListGidsRequest,
      cool.houge.grpc.broker.PolygonPb.BrokerListGidsResponse> getListGidsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListGids",
      requestType = cool.houge.grpc.broker.PolygonPb.BrokerListGidsRequest.class,
      responseType = cool.houge.grpc.broker.PolygonPb.BrokerListGidsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<cool.houge.grpc.broker.PolygonPb.BrokerListGidsRequest,
      cool.houge.grpc.broker.PolygonPb.BrokerListGidsResponse> getListGidsMethod() {
    io.grpc.MethodDescriptor<cool.houge.grpc.broker.PolygonPb.BrokerListGidsRequest, cool.houge.grpc.broker.PolygonPb.BrokerListGidsResponse> getListGidsMethod;
    if ((getListGidsMethod = PolygonGrpc.getListGidsMethod) == null) {
      synchronized (PolygonGrpc.class) {
        if ((getListGidsMethod = PolygonGrpc.getListGidsMethod) == null) {
          PolygonGrpc.getListGidsMethod = getListGidsMethod =
              io.grpc.MethodDescriptor.<cool.houge.grpc.broker.PolygonPb.BrokerListGidsRequest, cool.houge.grpc.broker.PolygonPb.BrokerListGidsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListGids"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cool.houge.grpc.broker.PolygonPb.BrokerListGidsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cool.houge.grpc.broker.PolygonPb.BrokerListGidsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new PolygonMethodDescriptorSupplier("ListGids"))
              .build();
        }
      }
    }
    return getListGidsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<cool.houge.grpc.broker.PolygonPb.BrokerPacketRequest,
      cool.houge.grpc.broker.PolygonPb.BrokerPacketResponse> getProcessPacketMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ProcessPacket",
      requestType = cool.houge.grpc.broker.PolygonPb.BrokerPacketRequest.class,
      responseType = cool.houge.grpc.broker.PolygonPb.BrokerPacketResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<cool.houge.grpc.broker.PolygonPb.BrokerPacketRequest,
      cool.houge.grpc.broker.PolygonPb.BrokerPacketResponse> getProcessPacketMethod() {
    io.grpc.MethodDescriptor<cool.houge.grpc.broker.PolygonPb.BrokerPacketRequest, cool.houge.grpc.broker.PolygonPb.BrokerPacketResponse> getProcessPacketMethod;
    if ((getProcessPacketMethod = PolygonGrpc.getProcessPacketMethod) == null) {
      synchronized (PolygonGrpc.class) {
        if ((getProcessPacketMethod = PolygonGrpc.getProcessPacketMethod) == null) {
          PolygonGrpc.getProcessPacketMethod = getProcessPacketMethod =
              io.grpc.MethodDescriptor.<cool.houge.grpc.broker.PolygonPb.BrokerPacketRequest, cool.houge.grpc.broker.PolygonPb.BrokerPacketResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ProcessPacket"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cool.houge.grpc.broker.PolygonPb.BrokerPacketRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cool.houge.grpc.broker.PolygonPb.BrokerPacketResponse.getDefaultInstance()))
              .setSchemaDescriptor(new PolygonMethodDescriptorSupplier("ProcessPacket"))
              .build();
        }
      }
    }
    return getProcessPacketMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PolygonStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PolygonStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PolygonStub>() {
        @java.lang.Override
        public PolygonStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PolygonStub(channel, callOptions);
        }
      };
    return PolygonStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PolygonBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PolygonBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PolygonBlockingStub>() {
        @java.lang.Override
        public PolygonBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PolygonBlockingStub(channel, callOptions);
        }
      };
    return PolygonBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PolygonFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PolygonFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PolygonFutureStub>() {
        @java.lang.Override
        public PolygonFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PolygonFutureStub(channel, callOptions);
        }
      };
    return PolygonFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class PolygonImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * JWT 用户认证
     * </pre>
     */
    public void auth(cool.houge.grpc.broker.PolygonPb.BrokerAuthRequest request,
        io.grpc.stub.StreamObserver<cool.houge.grpc.broker.PolygonPb.BrokerAuthResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAuthMethod(), responseObserver);
    }

    /**
     * <pre>
     * 查询用户的群组ID列表
     * </pre>
     */
    public void listGids(cool.houge.grpc.broker.PolygonPb.BrokerListGidsRequest request,
        io.grpc.stub.StreamObserver<cool.houge.grpc.broker.PolygonPb.BrokerListGidsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListGidsMethod(), responseObserver);
    }

    /**
     * <pre>
     * 处理 Packet
     * </pre>
     */
    public void processPacket(cool.houge.grpc.broker.PolygonPb.BrokerPacketRequest request,
        io.grpc.stub.StreamObserver<cool.houge.grpc.broker.PolygonPb.BrokerPacketResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getProcessPacketMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAuthMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                cool.houge.grpc.broker.PolygonPb.BrokerAuthRequest,
                cool.houge.grpc.broker.PolygonPb.BrokerAuthResponse>(
                  this, METHODID_AUTH)))
          .addMethod(
            getListGidsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                cool.houge.grpc.broker.PolygonPb.BrokerListGidsRequest,
                cool.houge.grpc.broker.PolygonPb.BrokerListGidsResponse>(
                  this, METHODID_LIST_GIDS)))
          .addMethod(
            getProcessPacketMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                cool.houge.grpc.broker.PolygonPb.BrokerPacketRequest,
                cool.houge.grpc.broker.PolygonPb.BrokerPacketResponse>(
                  this, METHODID_PROCESS_PACKET)))
          .build();
    }
  }

  /**
   */
  public static final class PolygonStub extends io.grpc.stub.AbstractAsyncStub<PolygonStub> {
    private PolygonStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PolygonStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PolygonStub(channel, callOptions);
    }

    /**
     * <pre>
     * JWT 用户认证
     * </pre>
     */
    public void auth(cool.houge.grpc.broker.PolygonPb.BrokerAuthRequest request,
        io.grpc.stub.StreamObserver<cool.houge.grpc.broker.PolygonPb.BrokerAuthResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAuthMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * 查询用户的群组ID列表
     * </pre>
     */
    public void listGids(cool.houge.grpc.broker.PolygonPb.BrokerListGidsRequest request,
        io.grpc.stub.StreamObserver<cool.houge.grpc.broker.PolygonPb.BrokerListGidsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListGidsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * 处理 Packet
     * </pre>
     */
    public void processPacket(cool.houge.grpc.broker.PolygonPb.BrokerPacketRequest request,
        io.grpc.stub.StreamObserver<cool.houge.grpc.broker.PolygonPb.BrokerPacketResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getProcessPacketMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class PolygonBlockingStub extends io.grpc.stub.AbstractBlockingStub<PolygonBlockingStub> {
    private PolygonBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PolygonBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PolygonBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * JWT 用户认证
     * </pre>
     */
    public cool.houge.grpc.broker.PolygonPb.BrokerAuthResponse auth(cool.houge.grpc.broker.PolygonPb.BrokerAuthRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAuthMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * 查询用户的群组ID列表
     * </pre>
     */
    public cool.houge.grpc.broker.PolygonPb.BrokerListGidsResponse listGids(cool.houge.grpc.broker.PolygonPb.BrokerListGidsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListGidsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * 处理 Packet
     * </pre>
     */
    public cool.houge.grpc.broker.PolygonPb.BrokerPacketResponse processPacket(cool.houge.grpc.broker.PolygonPb.BrokerPacketRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getProcessPacketMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class PolygonFutureStub extends io.grpc.stub.AbstractFutureStub<PolygonFutureStub> {
    private PolygonFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PolygonFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PolygonFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * JWT 用户认证
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<cool.houge.grpc.broker.PolygonPb.BrokerAuthResponse> auth(
        cool.houge.grpc.broker.PolygonPb.BrokerAuthRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAuthMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * 查询用户的群组ID列表
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<cool.houge.grpc.broker.PolygonPb.BrokerListGidsResponse> listGids(
        cool.houge.grpc.broker.PolygonPb.BrokerListGidsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListGidsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * 处理 Packet
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<cool.houge.grpc.broker.PolygonPb.BrokerPacketResponse> processPacket(
        cool.houge.grpc.broker.PolygonPb.BrokerPacketRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getProcessPacketMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_AUTH = 0;
  private static final int METHODID_LIST_GIDS = 1;
  private static final int METHODID_PROCESS_PACKET = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final PolygonImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(PolygonImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_AUTH:
          serviceImpl.auth((cool.houge.grpc.broker.PolygonPb.BrokerAuthRequest) request,
              (io.grpc.stub.StreamObserver<cool.houge.grpc.broker.PolygonPb.BrokerAuthResponse>) responseObserver);
          break;
        case METHODID_LIST_GIDS:
          serviceImpl.listGids((cool.houge.grpc.broker.PolygonPb.BrokerListGidsRequest) request,
              (io.grpc.stub.StreamObserver<cool.houge.grpc.broker.PolygonPb.BrokerListGidsResponse>) responseObserver);
          break;
        case METHODID_PROCESS_PACKET:
          serviceImpl.processPacket((cool.houge.grpc.broker.PolygonPb.BrokerPacketRequest) request,
              (io.grpc.stub.StreamObserver<cool.houge.grpc.broker.PolygonPb.BrokerPacketResponse>) responseObserver);
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

  private static abstract class PolygonBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PolygonBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return cool.houge.grpc.broker.PolygonPb.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Polygon");
    }
  }

  private static final class PolygonFileDescriptorSupplier
      extends PolygonBaseDescriptorSupplier {
    PolygonFileDescriptorSupplier() {}
  }

  private static final class PolygonMethodDescriptorSupplier
      extends PolygonBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    PolygonMethodDescriptorSupplier(String methodName) {
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
      synchronized (PolygonGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PolygonFileDescriptorSupplier())
              .addMethod(getAuthMethod())
              .addMethod(getListGidsMethod())
              .addMethod(getProcessPacketMethod())
              .build();
        }
      }
    }
    return result;
  }
}
