package cool.houge.grpc.agent;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.39.0)",
    comments = "Source: cool/houge/grpc/agent/agent.proto")
public final class AgentGrpc {

  private AgentGrpc() {}

  public static final String SERVICE_NAME = "Agent";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<cool.houge.grpc.agent.AgentPb.AttachRequest,
      cool.houge.grpc.agent.AgentPb.AttachResponse> getAttachMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Attach",
      requestType = cool.houge.grpc.agent.AgentPb.AttachRequest.class,
      responseType = cool.houge.grpc.agent.AgentPb.AttachResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<cool.houge.grpc.agent.AgentPb.AttachRequest,
      cool.houge.grpc.agent.AgentPb.AttachResponse> getAttachMethod() {
    io.grpc.MethodDescriptor<cool.houge.grpc.agent.AgentPb.AttachRequest, cool.houge.grpc.agent.AgentPb.AttachResponse> getAttachMethod;
    if ((getAttachMethod = AgentGrpc.getAttachMethod) == null) {
      synchronized (AgentGrpc.class) {
        if ((getAttachMethod = AgentGrpc.getAttachMethod) == null) {
          AgentGrpc.getAttachMethod = getAttachMethod =
              io.grpc.MethodDescriptor.<cool.houge.grpc.agent.AgentPb.AttachRequest, cool.houge.grpc.agent.AgentPb.AttachResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Attach"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cool.houge.grpc.agent.AgentPb.AttachRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cool.houge.grpc.agent.AgentPb.AttachResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AgentMethodDescriptorSupplier("Attach"))
              .build();
        }
      }
    }
    return getAttachMethod;
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
    public void attach(cool.houge.grpc.agent.AgentPb.AttachRequest request,
        io.grpc.stub.StreamObserver<cool.houge.grpc.agent.AgentPb.AttachResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAttachMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getAttachMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                cool.houge.grpc.agent.AgentPb.AttachRequest,
                cool.houge.grpc.agent.AgentPb.AttachResponse>(
                  this, METHODID_ATTACH)))
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
    public void attach(cool.houge.grpc.agent.AgentPb.AttachRequest request,
        io.grpc.stub.StreamObserver<cool.houge.grpc.agent.AgentPb.AttachResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getAttachMethod(), getCallOptions()), request, responseObserver);
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
    public java.util.Iterator<cool.houge.grpc.agent.AgentPb.AttachResponse> attach(
        cool.houge.grpc.agent.AgentPb.AttachRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getAttachMethod(), getCallOptions(), request);
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

  private static final int METHODID_ATTACH = 0;

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
        case METHODID_ATTACH:
          serviceImpl.attach((cool.houge.grpc.agent.AgentPb.AttachRequest) request,
              (io.grpc.stub.StreamObserver<cool.houge.grpc.agent.AgentPb.AttachResponse>) responseObserver);
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
      return cool.houge.grpc.agent.AgentPb.getDescriptor();
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
              .addMethod(getAttachMethod())
              .build();
        }
      }
    }
    return result;
  }
}
