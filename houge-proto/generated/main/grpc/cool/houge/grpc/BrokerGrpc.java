package cool.houge.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.43.2)",
    comments = "Source: cool/houge/grpc/broker.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class BrokerGrpc {

  private BrokerGrpc() {}

  public static final String SERVICE_NAME = "Broker";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<cool.houge.grpc.AttachBrokerRequest,
      cool.houge.grpc.AttachBrokerResponse> getAttachMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Attach",
      requestType = cool.houge.grpc.AttachBrokerRequest.class,
      responseType = cool.houge.grpc.AttachBrokerResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<cool.houge.grpc.AttachBrokerRequest,
      cool.houge.grpc.AttachBrokerResponse> getAttachMethod() {
    io.grpc.MethodDescriptor<cool.houge.grpc.AttachBrokerRequest, cool.houge.grpc.AttachBrokerResponse> getAttachMethod;
    if ((getAttachMethod = BrokerGrpc.getAttachMethod) == null) {
      synchronized (BrokerGrpc.class) {
        if ((getAttachMethod = BrokerGrpc.getAttachMethod) == null) {
          BrokerGrpc.getAttachMethod = getAttachMethod =
              io.grpc.MethodDescriptor.<cool.houge.grpc.AttachBrokerRequest, cool.houge.grpc.AttachBrokerResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Attach"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cool.houge.grpc.AttachBrokerRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cool.houge.grpc.AttachBrokerResponse.getDefaultInstance()))
              .setSchemaDescriptor(new BrokerMethodDescriptorSupplier("Attach"))
              .build();
        }
      }
    }
    return getAttachMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static BrokerStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BrokerStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BrokerStub>() {
        @java.lang.Override
        public BrokerStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BrokerStub(channel, callOptions);
        }
      };
    return BrokerStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BrokerBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BrokerBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BrokerBlockingStub>() {
        @java.lang.Override
        public BrokerBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BrokerBlockingStub(channel, callOptions);
        }
      };
    return BrokerBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static BrokerFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BrokerFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<BrokerFutureStub>() {
        @java.lang.Override
        public BrokerFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new BrokerFutureStub(channel, callOptions);
        }
      };
    return BrokerFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class BrokerImplBase implements io.grpc.BindableService {

    /**
     */
    public void attach(cool.houge.grpc.AttachBrokerRequest request,
        io.grpc.stub.StreamObserver<cool.houge.grpc.AttachBrokerResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAttachMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAttachMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                cool.houge.grpc.AttachBrokerRequest,
                cool.houge.grpc.AttachBrokerResponse>(
                  this, METHODID_ATTACH)))
          .build();
    }
  }

  /**
   */
  public static final class BrokerStub extends io.grpc.stub.AbstractAsyncStub<BrokerStub> {
    private BrokerStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BrokerStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BrokerStub(channel, callOptions);
    }

    /**
     */
    public void attach(cool.houge.grpc.AttachBrokerRequest request,
        io.grpc.stub.StreamObserver<cool.houge.grpc.AttachBrokerResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getAttachMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class BrokerBlockingStub extends io.grpc.stub.AbstractBlockingStub<BrokerBlockingStub> {
    private BrokerBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BrokerBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BrokerBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<cool.houge.grpc.AttachBrokerResponse> attach(
        cool.houge.grpc.AttachBrokerRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getAttachMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class BrokerFutureStub extends io.grpc.stub.AbstractFutureStub<BrokerFutureStub> {
    private BrokerFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BrokerFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BrokerFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_ATTACH = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final BrokerImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(BrokerImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ATTACH:
          serviceImpl.attach((cool.houge.grpc.AttachBrokerRequest) request,
              (io.grpc.stub.StreamObserver<cool.houge.grpc.AttachBrokerResponse>) responseObserver);
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

  private static abstract class BrokerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    BrokerBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return cool.houge.grpc.BrokerOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Broker");
    }
  }

  private static final class BrokerFileDescriptorSupplier
      extends BrokerBaseDescriptorSupplier {
    BrokerFileDescriptorSupplier() {}
  }

  private static final class BrokerMethodDescriptorSupplier
      extends BrokerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    BrokerMethodDescriptorSupplier(String methodName) {
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
      synchronized (BrokerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new BrokerFileDescriptorSupplier())
              .addMethod(getAttachMethod())
              .build();
        }
      }
    }
    return result;
  }
}
