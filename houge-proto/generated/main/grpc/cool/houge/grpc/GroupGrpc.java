package cool.houge.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.43.2)",
    comments = "Source: cool/houge/grpc/group.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class GroupGrpc {

  private GroupGrpc() {}

  public static final String SERVICE_NAME = "Group";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<cool.houge.grpc.CreateGroupRequest,
      cool.houge.grpc.CreateGroupResponse> getCreateMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Create",
      requestType = cool.houge.grpc.CreateGroupRequest.class,
      responseType = cool.houge.grpc.CreateGroupResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<cool.houge.grpc.CreateGroupRequest,
      cool.houge.grpc.CreateGroupResponse> getCreateMethod() {
    io.grpc.MethodDescriptor<cool.houge.grpc.CreateGroupRequest, cool.houge.grpc.CreateGroupResponse> getCreateMethod;
    if ((getCreateMethod = GroupGrpc.getCreateMethod) == null) {
      synchronized (GroupGrpc.class) {
        if ((getCreateMethod = GroupGrpc.getCreateMethod) == null) {
          GroupGrpc.getCreateMethod = getCreateMethod =
              io.grpc.MethodDescriptor.<cool.houge.grpc.CreateGroupRequest, cool.houge.grpc.CreateGroupResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Create"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cool.houge.grpc.CreateGroupRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cool.houge.grpc.CreateGroupResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GroupMethodDescriptorSupplier("Create"))
              .build();
        }
      }
    }
    return getCreateMethod;
  }

  private static volatile io.grpc.MethodDescriptor<cool.houge.grpc.DeleteGroupRequest,
      com.google.protobuf.Empty> getDeleteMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Delete",
      requestType = cool.houge.grpc.DeleteGroupRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<cool.houge.grpc.DeleteGroupRequest,
      com.google.protobuf.Empty> getDeleteMethod() {
    io.grpc.MethodDescriptor<cool.houge.grpc.DeleteGroupRequest, com.google.protobuf.Empty> getDeleteMethod;
    if ((getDeleteMethod = GroupGrpc.getDeleteMethod) == null) {
      synchronized (GroupGrpc.class) {
        if ((getDeleteMethod = GroupGrpc.getDeleteMethod) == null) {
          GroupGrpc.getDeleteMethod = getDeleteMethod =
              io.grpc.MethodDescriptor.<cool.houge.grpc.DeleteGroupRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Delete"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cool.houge.grpc.DeleteGroupRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new GroupMethodDescriptorSupplier("Delete"))
              .build();
        }
      }
    }
    return getDeleteMethod;
  }

  private static volatile io.grpc.MethodDescriptor<cool.houge.grpc.JoinMemberGroupRequest,
      com.google.protobuf.Empty> getJoinMemberMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "JoinMember",
      requestType = cool.houge.grpc.JoinMemberGroupRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<cool.houge.grpc.JoinMemberGroupRequest,
      com.google.protobuf.Empty> getJoinMemberMethod() {
    io.grpc.MethodDescriptor<cool.houge.grpc.JoinMemberGroupRequest, com.google.protobuf.Empty> getJoinMemberMethod;
    if ((getJoinMemberMethod = GroupGrpc.getJoinMemberMethod) == null) {
      synchronized (GroupGrpc.class) {
        if ((getJoinMemberMethod = GroupGrpc.getJoinMemberMethod) == null) {
          GroupGrpc.getJoinMemberMethod = getJoinMemberMethod =
              io.grpc.MethodDescriptor.<cool.houge.grpc.JoinMemberGroupRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "JoinMember"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cool.houge.grpc.JoinMemberGroupRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new GroupMethodDescriptorSupplier("JoinMember"))
              .build();
        }
      }
    }
    return getJoinMemberMethod;
  }

  private static volatile io.grpc.MethodDescriptor<cool.houge.grpc.DeleteMemberGroupRequest,
      com.google.protobuf.Empty> getDeleteMemberMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteMember",
      requestType = cool.houge.grpc.DeleteMemberGroupRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<cool.houge.grpc.DeleteMemberGroupRequest,
      com.google.protobuf.Empty> getDeleteMemberMethod() {
    io.grpc.MethodDescriptor<cool.houge.grpc.DeleteMemberGroupRequest, com.google.protobuf.Empty> getDeleteMemberMethod;
    if ((getDeleteMemberMethod = GroupGrpc.getDeleteMemberMethod) == null) {
      synchronized (GroupGrpc.class) {
        if ((getDeleteMemberMethod = GroupGrpc.getDeleteMemberMethod) == null) {
          GroupGrpc.getDeleteMemberMethod = getDeleteMemberMethod =
              io.grpc.MethodDescriptor.<cool.houge.grpc.DeleteMemberGroupRequest, com.google.protobuf.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteMember"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cool.houge.grpc.DeleteMemberGroupRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setSchemaDescriptor(new GroupMethodDescriptorSupplier("DeleteMember"))
              .build();
        }
      }
    }
    return getDeleteMemberMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static GroupStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GroupStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GroupStub>() {
        @java.lang.Override
        public GroupStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GroupStub(channel, callOptions);
        }
      };
    return GroupStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GroupBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GroupBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GroupBlockingStub>() {
        @java.lang.Override
        public GroupBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GroupBlockingStub(channel, callOptions);
        }
      };
    return GroupBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static GroupFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GroupFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GroupFutureStub>() {
        @java.lang.Override
        public GroupFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GroupFutureStub(channel, callOptions);
        }
      };
    return GroupFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class GroupImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * 创建群组.
     * </pre>
     */
    public void create(cool.houge.grpc.CreateGroupRequest request,
        io.grpc.stub.StreamObserver<cool.houge.grpc.CreateGroupResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateMethod(), responseObserver);
    }

    /**
     * <pre>
     * 删除群组.
     * </pre>
     */
    public void delete(cool.houge.grpc.DeleteGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteMethod(), responseObserver);
    }

    /**
     * <pre>
     * 将用户加入到指定的群组
     * </pre>
     */
    public void joinMember(cool.houge.grpc.JoinMemberGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getJoinMemberMethod(), responseObserver);
    }

    /**
     * <pre>
     * 将用户从指定的群组中删除
     * </pre>
     */
    public void deleteMember(cool.houge.grpc.DeleteMemberGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteMemberMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                cool.houge.grpc.CreateGroupRequest,
                cool.houge.grpc.CreateGroupResponse>(
                  this, METHODID_CREATE)))
          .addMethod(
            getDeleteMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                cool.houge.grpc.DeleteGroupRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_DELETE)))
          .addMethod(
            getJoinMemberMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                cool.houge.grpc.JoinMemberGroupRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_JOIN_MEMBER)))
          .addMethod(
            getDeleteMemberMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                cool.houge.grpc.DeleteMemberGroupRequest,
                com.google.protobuf.Empty>(
                  this, METHODID_DELETE_MEMBER)))
          .build();
    }
  }

  /**
   */
  public static final class GroupStub extends io.grpc.stub.AbstractAsyncStub<GroupStub> {
    private GroupStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GroupStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GroupStub(channel, callOptions);
    }

    /**
     * <pre>
     * 创建群组.
     * </pre>
     */
    public void create(cool.houge.grpc.CreateGroupRequest request,
        io.grpc.stub.StreamObserver<cool.houge.grpc.CreateGroupResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * 删除群组.
     * </pre>
     */
    public void delete(cool.houge.grpc.DeleteGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * 将用户加入到指定的群组
     * </pre>
     */
    public void joinMember(cool.houge.grpc.JoinMemberGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getJoinMemberMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * 将用户从指定的群组中删除
     * </pre>
     */
    public void deleteMember(cool.houge.grpc.DeleteMemberGroupRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteMemberMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class GroupBlockingStub extends io.grpc.stub.AbstractBlockingStub<GroupBlockingStub> {
    private GroupBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GroupBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GroupBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * 创建群组.
     * </pre>
     */
    public cool.houge.grpc.CreateGroupResponse create(cool.houge.grpc.CreateGroupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * 删除群组.
     * </pre>
     */
    public com.google.protobuf.Empty delete(cool.houge.grpc.DeleteGroupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * 将用户加入到指定的群组
     * </pre>
     */
    public com.google.protobuf.Empty joinMember(cool.houge.grpc.JoinMemberGroupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getJoinMemberMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * 将用户从指定的群组中删除
     * </pre>
     */
    public com.google.protobuf.Empty deleteMember(cool.houge.grpc.DeleteMemberGroupRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteMemberMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class GroupFutureStub extends io.grpc.stub.AbstractFutureStub<GroupFutureStub> {
    private GroupFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GroupFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GroupFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * 创建群组.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<cool.houge.grpc.CreateGroupResponse> create(
        cool.houge.grpc.CreateGroupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * 删除群组.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> delete(
        cool.houge.grpc.DeleteGroupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * 将用户加入到指定的群组
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> joinMember(
        cool.houge.grpc.JoinMemberGroupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getJoinMemberMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * 将用户从指定的群组中删除
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteMember(
        cool.houge.grpc.DeleteMemberGroupRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteMemberMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE = 0;
  private static final int METHODID_DELETE = 1;
  private static final int METHODID_JOIN_MEMBER = 2;
  private static final int METHODID_DELETE_MEMBER = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final GroupImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(GroupImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE:
          serviceImpl.create((cool.houge.grpc.CreateGroupRequest) request,
              (io.grpc.stub.StreamObserver<cool.houge.grpc.CreateGroupResponse>) responseObserver);
          break;
        case METHODID_DELETE:
          serviceImpl.delete((cool.houge.grpc.DeleteGroupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_JOIN_MEMBER:
          serviceImpl.joinMember((cool.houge.grpc.JoinMemberGroupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_DELETE_MEMBER:
          serviceImpl.deleteMember((cool.houge.grpc.DeleteMemberGroupRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
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

  private static abstract class GroupBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    GroupBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return cool.houge.grpc.GroupOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Group");
    }
  }

  private static final class GroupFileDescriptorSupplier
      extends GroupBaseDescriptorSupplier {
    GroupFileDescriptorSupplier() {}
  }

  private static final class GroupMethodDescriptorSupplier
      extends GroupBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    GroupMethodDescriptorSupplier(String methodName) {
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
      synchronized (GroupGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new GroupFileDescriptorSupplier())
              .addMethod(getCreateMethod())
              .addMethod(getDeleteMethod())
              .addMethod(getJoinMemberMethod())
              .addMethod(getDeleteMemberMethod())
              .build();
        }
      }
    }
    return result;
  }
}
