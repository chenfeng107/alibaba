package cool.houge.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.39.0)",
    comments = "Source: cool/houge/grpc/user_group.proto")
public final class UserGroupGrpc {

  private UserGroupGrpc() {}

  public static final String SERVICE_NAME = "UserGroup";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<cool.houge.grpc.UserGroupPb.ListGidsRequest,
      cool.houge.grpc.UserGroupPb.ListGidsResponse> getListGidsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListGids",
      requestType = cool.houge.grpc.UserGroupPb.ListGidsRequest.class,
      responseType = cool.houge.grpc.UserGroupPb.ListGidsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<cool.houge.grpc.UserGroupPb.ListGidsRequest,
      cool.houge.grpc.UserGroupPb.ListGidsResponse> getListGidsMethod() {
    io.grpc.MethodDescriptor<cool.houge.grpc.UserGroupPb.ListGidsRequest, cool.houge.grpc.UserGroupPb.ListGidsResponse> getListGidsMethod;
    if ((getListGidsMethod = UserGroupGrpc.getListGidsMethod) == null) {
      synchronized (UserGroupGrpc.class) {
        if ((getListGidsMethod = UserGroupGrpc.getListGidsMethod) == null) {
          UserGroupGrpc.getListGidsMethod = getListGidsMethod =
              io.grpc.MethodDescriptor.<cool.houge.grpc.UserGroupPb.ListGidsRequest, cool.houge.grpc.UserGroupPb.ListGidsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListGids"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cool.houge.grpc.UserGroupPb.ListGidsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cool.houge.grpc.UserGroupPb.ListGidsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new UserGroupMethodDescriptorSupplier("ListGids"))
              .build();
        }
      }
    }
    return getListGidsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static UserGroupStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserGroupStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UserGroupStub>() {
        @java.lang.Override
        public UserGroupStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UserGroupStub(channel, callOptions);
        }
      };
    return UserGroupStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static UserGroupBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserGroupBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UserGroupBlockingStub>() {
        @java.lang.Override
        public UserGroupBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UserGroupBlockingStub(channel, callOptions);
        }
      };
    return UserGroupBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static UserGroupFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<UserGroupFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<UserGroupFutureStub>() {
        @java.lang.Override
        public UserGroupFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new UserGroupFutureStub(channel, callOptions);
        }
      };
    return UserGroupFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class UserGroupImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * 查询用户的群组ID列表
     * </pre>
     */
    public void listGids(cool.houge.grpc.UserGroupPb.ListGidsRequest request,
        io.grpc.stub.StreamObserver<cool.houge.grpc.UserGroupPb.ListGidsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListGidsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getListGidsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                cool.houge.grpc.UserGroupPb.ListGidsRequest,
                cool.houge.grpc.UserGroupPb.ListGidsResponse>(
                  this, METHODID_LIST_GIDS)))
          .build();
    }
  }

  /**
   */
  public static final class UserGroupStub extends io.grpc.stub.AbstractAsyncStub<UserGroupStub> {
    private UserGroupStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserGroupStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserGroupStub(channel, callOptions);
    }

    /**
     * <pre>
     * 查询用户的群组ID列表
     * </pre>
     */
    public void listGids(cool.houge.grpc.UserGroupPb.ListGidsRequest request,
        io.grpc.stub.StreamObserver<cool.houge.grpc.UserGroupPb.ListGidsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListGidsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class UserGroupBlockingStub extends io.grpc.stub.AbstractBlockingStub<UserGroupBlockingStub> {
    private UserGroupBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserGroupBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserGroupBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * 查询用户的群组ID列表
     * </pre>
     */
    public cool.houge.grpc.UserGroupPb.ListGidsResponse listGids(cool.houge.grpc.UserGroupPb.ListGidsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListGidsMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class UserGroupFutureStub extends io.grpc.stub.AbstractFutureStub<UserGroupFutureStub> {
    private UserGroupFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserGroupFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new UserGroupFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * 查询用户的群组ID列表
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<cool.houge.grpc.UserGroupPb.ListGidsResponse> listGids(
        cool.houge.grpc.UserGroupPb.ListGidsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListGidsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_GIDS = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final UserGroupImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(UserGroupImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_GIDS:
          serviceImpl.listGids((cool.houge.grpc.UserGroupPb.ListGidsRequest) request,
              (io.grpc.stub.StreamObserver<cool.houge.grpc.UserGroupPb.ListGidsResponse>) responseObserver);
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

  private static abstract class UserGroupBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    UserGroupBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return cool.houge.grpc.UserGroupPb.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("UserGroup");
    }
  }

  private static final class UserGroupFileDescriptorSupplier
      extends UserGroupBaseDescriptorSupplier {
    UserGroupFileDescriptorSupplier() {}
  }

  private static final class UserGroupMethodDescriptorSupplier
      extends UserGroupBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    UserGroupMethodDescriptorSupplier(String methodName) {
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
      synchronized (UserGroupGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new UserGroupFileDescriptorSupplier())
              .addMethod(getListGidsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
