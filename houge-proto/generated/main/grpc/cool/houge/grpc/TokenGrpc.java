package cool.houge.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.43.2)",
    comments = "Source: cool/houge/grpc/token.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class TokenGrpc {

  private TokenGrpc() {}

  public static final String SERVICE_NAME = "Token";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<cool.houge.grpc.VerifyTokenRequest,
      cool.houge.grpc.VerifyTokenResponse> getVerifyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Verify",
      requestType = cool.houge.grpc.VerifyTokenRequest.class,
      responseType = cool.houge.grpc.VerifyTokenResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<cool.houge.grpc.VerifyTokenRequest,
      cool.houge.grpc.VerifyTokenResponse> getVerifyMethod() {
    io.grpc.MethodDescriptor<cool.houge.grpc.VerifyTokenRequest, cool.houge.grpc.VerifyTokenResponse> getVerifyMethod;
    if ((getVerifyMethod = TokenGrpc.getVerifyMethod) == null) {
      synchronized (TokenGrpc.class) {
        if ((getVerifyMethod = TokenGrpc.getVerifyMethod) == null) {
          TokenGrpc.getVerifyMethod = getVerifyMethod =
              io.grpc.MethodDescriptor.<cool.houge.grpc.VerifyTokenRequest, cool.houge.grpc.VerifyTokenResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Verify"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cool.houge.grpc.VerifyTokenRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cool.houge.grpc.VerifyTokenResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TokenMethodDescriptorSupplier("Verify"))
              .build();
        }
      }
    }
    return getVerifyMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TokenStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TokenStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TokenStub>() {
        @java.lang.Override
        public TokenStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TokenStub(channel, callOptions);
        }
      };
    return TokenStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TokenBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TokenBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TokenBlockingStub>() {
        @java.lang.Override
        public TokenBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TokenBlockingStub(channel, callOptions);
        }
      };
    return TokenBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TokenFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TokenFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TokenFutureStub>() {
        @java.lang.Override
        public TokenFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TokenFutureStub(channel, callOptions);
        }
      };
    return TokenFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class TokenImplBase implements io.grpc.BindableService {

    /**
     */
    public void verify(cool.houge.grpc.VerifyTokenRequest request,
        io.grpc.stub.StreamObserver<cool.houge.grpc.VerifyTokenResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getVerifyMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getVerifyMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                cool.houge.grpc.VerifyTokenRequest,
                cool.houge.grpc.VerifyTokenResponse>(
                  this, METHODID_VERIFY)))
          .build();
    }
  }

  /**
   */
  public static final class TokenStub extends io.grpc.stub.AbstractAsyncStub<TokenStub> {
    private TokenStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TokenStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TokenStub(channel, callOptions);
    }

    /**
     */
    public void verify(cool.houge.grpc.VerifyTokenRequest request,
        io.grpc.stub.StreamObserver<cool.houge.grpc.VerifyTokenResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getVerifyMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class TokenBlockingStub extends io.grpc.stub.AbstractBlockingStub<TokenBlockingStub> {
    private TokenBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TokenBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TokenBlockingStub(channel, callOptions);
    }

    /**
     */
    public cool.houge.grpc.VerifyTokenResponse verify(cool.houge.grpc.VerifyTokenRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getVerifyMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class TokenFutureStub extends io.grpc.stub.AbstractFutureStub<TokenFutureStub> {
    private TokenFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TokenFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TokenFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<cool.houge.grpc.VerifyTokenResponse> verify(
        cool.houge.grpc.VerifyTokenRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getVerifyMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_VERIFY = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TokenImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TokenImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_VERIFY:
          serviceImpl.verify((cool.houge.grpc.VerifyTokenRequest) request,
              (io.grpc.stub.StreamObserver<cool.houge.grpc.VerifyTokenResponse>) responseObserver);
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

  private static abstract class TokenBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TokenBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return cool.houge.grpc.TokenOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Token");
    }
  }

  private static final class TokenFileDescriptorSupplier
      extends TokenBaseDescriptorSupplier {
    TokenFileDescriptorSupplier() {}
  }

  private static final class TokenMethodDescriptorSupplier
      extends TokenBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TokenMethodDescriptorSupplier(String methodName) {
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
      synchronized (TokenGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TokenFileDescriptorSupplier())
              .addMethod(getVerifyMethod())
              .build();
        }
      }
    }
    return result;
  }
}
