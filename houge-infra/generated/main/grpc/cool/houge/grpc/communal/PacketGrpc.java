package cool.houge.grpc.communal;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.39.0)",
    comments = "Source: cool/houge/grpc/communal/packet.proto")
public final class PacketGrpc {

  private PacketGrpc() {}

  public static final String SERVICE_NAME = "Packet";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<cool.houge.grpc.communal.PacketPb.PacketRequest,
      cool.houge.grpc.communal.PacketPb.PacketResponse> getProcessMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Process",
      requestType = cool.houge.grpc.communal.PacketPb.PacketRequest.class,
      responseType = cool.houge.grpc.communal.PacketPb.PacketResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<cool.houge.grpc.communal.PacketPb.PacketRequest,
      cool.houge.grpc.communal.PacketPb.PacketResponse> getProcessMethod() {
    io.grpc.MethodDescriptor<cool.houge.grpc.communal.PacketPb.PacketRequest, cool.houge.grpc.communal.PacketPb.PacketResponse> getProcessMethod;
    if ((getProcessMethod = PacketGrpc.getProcessMethod) == null) {
      synchronized (PacketGrpc.class) {
        if ((getProcessMethod = PacketGrpc.getProcessMethod) == null) {
          PacketGrpc.getProcessMethod = getProcessMethod =
              io.grpc.MethodDescriptor.<cool.houge.grpc.communal.PacketPb.PacketRequest, cool.houge.grpc.communal.PacketPb.PacketResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Process"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cool.houge.grpc.communal.PacketPb.PacketRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cool.houge.grpc.communal.PacketPb.PacketResponse.getDefaultInstance()))
              .setSchemaDescriptor(new PacketMethodDescriptorSupplier("Process"))
              .build();
        }
      }
    }
    return getProcessMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PacketStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PacketStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PacketStub>() {
        @java.lang.Override
        public PacketStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PacketStub(channel, callOptions);
        }
      };
    return PacketStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PacketBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PacketBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PacketBlockingStub>() {
        @java.lang.Override
        public PacketBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PacketBlockingStub(channel, callOptions);
        }
      };
    return PacketBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PacketFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PacketFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PacketFutureStub>() {
        @java.lang.Override
        public PacketFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PacketFutureStub(channel, callOptions);
        }
      };
    return PacketFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class PacketImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * 处理Packet请求
     * </pre>
     */
    public void process(cool.houge.grpc.communal.PacketPb.PacketRequest request,
        io.grpc.stub.StreamObserver<cool.houge.grpc.communal.PacketPb.PacketResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getProcessMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getProcessMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                cool.houge.grpc.communal.PacketPb.PacketRequest,
                cool.houge.grpc.communal.PacketPb.PacketResponse>(
                  this, METHODID_PROCESS)))
          .build();
    }
  }

  /**
   */
  public static final class PacketStub extends io.grpc.stub.AbstractAsyncStub<PacketStub> {
    private PacketStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PacketStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PacketStub(channel, callOptions);
    }

    /**
     * <pre>
     * 处理Packet请求
     * </pre>
     */
    public void process(cool.houge.grpc.communal.PacketPb.PacketRequest request,
        io.grpc.stub.StreamObserver<cool.houge.grpc.communal.PacketPb.PacketResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getProcessMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class PacketBlockingStub extends io.grpc.stub.AbstractBlockingStub<PacketBlockingStub> {
    private PacketBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PacketBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PacketBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * 处理Packet请求
     * </pre>
     */
    public cool.houge.grpc.communal.PacketPb.PacketResponse process(cool.houge.grpc.communal.PacketPb.PacketRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getProcessMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class PacketFutureStub extends io.grpc.stub.AbstractFutureStub<PacketFutureStub> {
    private PacketFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PacketFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PacketFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * 处理Packet请求
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<cool.houge.grpc.communal.PacketPb.PacketResponse> process(
        cool.houge.grpc.communal.PacketPb.PacketRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getProcessMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_PROCESS = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final PacketImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(PacketImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_PROCESS:
          serviceImpl.process((cool.houge.grpc.communal.PacketPb.PacketRequest) request,
              (io.grpc.stub.StreamObserver<cool.houge.grpc.communal.PacketPb.PacketResponse>) responseObserver);
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

  private static abstract class PacketBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PacketBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return cool.houge.grpc.communal.PacketPb.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Packet");
    }
  }

  private static final class PacketFileDescriptorSupplier
      extends PacketBaseDescriptorSupplier {
    PacketFileDescriptorSupplier() {}
  }

  private static final class PacketMethodDescriptorSupplier
      extends PacketBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    PacketMethodDescriptorSupplier(String methodName) {
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
      synchronized (PacketGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PacketFileDescriptorSupplier())
              .addMethod(getProcessMethod())
              .build();
        }
      }
    }
    return result;
  }
}
