package cool.houge.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.39.0)",
    comments = "Source: cool/houge/grpc/agent.proto")
public final class AgentGrpc {

  private AgentGrpc() {}

  public static final String SERVICE_NAME = "Agent";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<cool.houge.grpc.AgentPb.LinkRequest,
      cool.houge.grpc.AgentPb.LinkResponse> getLinkMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Link",
      requestType = cool.houge.grpc.AgentPb.LinkRequest.class,
      responseType = cool.houge.grpc.AgentPb.LinkResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<cool.houge.grpc.AgentPb.LinkRequest,
      cool.houge.grpc.AgentPb.LinkResponse> getLinkMethod() {
    io.grpc.MethodDescriptor<cool.houge.grpc.AgentPb.LinkRequest, cool.houge.grpc.AgentPb.LinkResponse> getLinkMethod;
    if ((getLinkMethod = AgentGrpc.getLinkMethod) == null) {
      synchronized (AgentGrpc.class) {
        if ((getLinkMethod = AgentGrpc.getLinkMethod) == null) {
          AgentGrpc.getLinkMethod = getLinkMethod =
              io.grpc.MethodDescriptor.<cool.houge.grpc.AgentPb.LinkRequest, cool.houge.grpc.AgentPb.LinkResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Link"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cool.houge.grpc.AgentPb.LinkRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cool.houge.grpc.AgentPb.LinkResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AgentMethodDescriptorSupplier("Link"))
              .build();
        }
      }
    }
    return getLinkMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AgentStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AgentStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AgentStub>() {
        @java.lang.Override
        public AgentStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AgentStub(channel, callOptions);
        }
      };
    return AgentStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AgentBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AgentBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AgentBlockingStub>() {
        @java.lang.Override
        public AgentBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AgentBlockingStub(channel, callOptions);
        }
      };
    return AgentBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AgentFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AgentFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AgentFutureStub>() {
        @java.lang.Override
        public AgentFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AgentFutureStub(channel, callOptions);
        }
      };
    return AgentFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class AgentImplBase implements io.grpc.BindableService {

    /**
     */
    public void link(cool.houge.grpc.AgentPb.LinkRequest request,
        io.grpc.stub.StreamObserver<cool.houge.grpc.AgentPb.LinkResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getLinkMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getLinkMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                cool.houge.grpc.AgentPb.LinkRequest,
                cool.houge.grpc.AgentPb.LinkResponse>(
                  this, METHODID_LINK)))
          .build();
    }
  }

  /**
   */
  public static final class AgentStub extends io.grpc.stub.AbstractAsyncStub<AgentStub> {
    private AgentStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AgentStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AgentStub(channel, callOptions);
    }

    /**
     */
    public void link(cool.houge.grpc.AgentPb.LinkRequest request,
        io.grpc.stub.StreamObserver<cool.houge.grpc.AgentPb.LinkResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getLinkMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class AgentBlockingStub extends io.grpc.stub.AbstractBlockingStub<AgentBlockingStub> {
    private AgentBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AgentBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AgentBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<cool.houge.grpc.AgentPb.LinkResponse> link(
        cool.houge.grpc.AgentPb.LinkRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getLinkMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class AgentFutureStub extends io.grpc.stub.AbstractFutureStub<AgentFutureStub> {
    private AgentFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AgentFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AgentFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_LINK = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AgentImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(AgentImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LINK:
          serviceImpl.link((cool.houge.grpc.AgentPb.LinkRequest) request,
              (io.grpc.stub.StreamObserver<cool.houge.grpc.AgentPb.LinkResponse>) responseObserver);
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

  private static abstract class AgentBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AgentBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return cool.houge.grpc.AgentPb.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Agent");
    }
  }

  private static final class AgentFileDescriptorSupplier
      extends AgentBaseDescriptorSupplier {
    AgentFileDescriptorSupplier() {}
  }

  private static final class AgentMethodDescriptorSupplier
      extends AgentBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    AgentMethodDescriptorSupplier(String methodName) {
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
      synchronized (AgentGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AgentFileDescriptorSupplier())
              .addMethod(getLinkMethod())
              .build();
        }
      }
    }
    return result;
  }
}
