package cool.houge.grpc.communal;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * 消息服务
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.39.0)",
    comments = "Source: cool/houge/grpc/communal/message.proto")
public final class MessageGrpc {

  private MessageGrpc() {}

  public static final String SERVICE_NAME = "Message";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<cool.houge.grpc.communal.MessagePb.SendMessageRequest,
      cool.houge.grpc.communal.MessagePb.SendMessageResponse> getSendToUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SendToUser",
      requestType = cool.houge.grpc.communal.MessagePb.SendMessageRequest.class,
      responseType = cool.houge.grpc.communal.MessagePb.SendMessageResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<cool.houge.grpc.communal.MessagePb.SendMessageRequest,
      cool.houge.grpc.communal.MessagePb.SendMessageResponse> getSendToUserMethod() {
    io.grpc.MethodDescriptor<cool.houge.grpc.communal.MessagePb.SendMessageRequest, cool.houge.grpc.communal.MessagePb.SendMessageResponse> getSendToUserMethod;
    if ((getSendToUserMethod = MessageGrpc.getSendToUserMethod) == null) {
      synchronized (MessageGrpc.class) {
        if ((getSendToUserMethod = MessageGrpc.getSendToUserMethod) == null) {
          MessageGrpc.getSendToUserMethod = getSendToUserMethod =
              io.grpc.MethodDescriptor.<cool.houge.grpc.communal.MessagePb.SendMessageRequest, cool.houge.grpc.communal.MessagePb.SendMessageResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SendToUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cool.houge.grpc.communal.MessagePb.SendMessageRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cool.houge.grpc.communal.MessagePb.SendMessageResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MessageMethodDescriptorSupplier("SendToUser"))
              .build();
        }
      }
    }
    return getSendToUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<cool.houge.grpc.communal.MessagePb.SendMessageRequest,
      cool.houge.grpc.communal.MessagePb.SendMessageResponse> getSendToGroupMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SendToGroup",
      requestType = cool.houge.grpc.communal.MessagePb.SendMessageRequest.class,
      responseType = cool.houge.grpc.communal.MessagePb.SendMessageResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<cool.houge.grpc.communal.MessagePb.SendMessageRequest,
      cool.houge.grpc.communal.MessagePb.SendMessageResponse> getSendToGroupMethod() {
    io.grpc.MethodDescriptor<cool.houge.grpc.communal.MessagePb.SendMessageRequest, cool.houge.grpc.communal.MessagePb.SendMessageResponse> getSendToGroupMethod;
    if ((getSendToGroupMethod = MessageGrpc.getSendToGroupMethod) == null) {
      synchronized (MessageGrpc.class) {
        if ((getSendToGroupMethod = MessageGrpc.getSendToGroupMethod) == null) {
          MessageGrpc.getSendToGroupMethod = getSendToGroupMethod =
              io.grpc.MethodDescriptor.<cool.houge.grpc.communal.MessagePb.SendMessageRequest, cool.houge.grpc.communal.MessagePb.SendMessageResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SendToGroup"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cool.houge.grpc.communal.MessagePb.SendMessageRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  cool.houge.grpc.communal.MessagePb.SendMessageResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MessageMethodDescriptorSupplier("SendToGroup"))
              .build();
        }
      }
    }
    return getSendToGroupMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MessageStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MessageStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MessageStub>() {
        @java.lang.Override
        public MessageStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MessageStub(channel, callOptions);
        }
      };
    return MessageStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MessageBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MessageBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MessageBlockingStub>() {
        @java.lang.Override
        public MessageBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MessageBlockingStub(channel, callOptions);
        }
      };
    return MessageBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static MessageFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MessageFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MessageFutureStub>() {
        @java.lang.Override
        public MessageFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MessageFutureStub(channel, callOptions);
        }
      };
    return MessageFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * 消息服务
   * </pre>
   */
  public static abstract class MessageImplBase implements io.grpc.BindableService {

    /**
     */
    public void sendToUser(cool.houge.grpc.communal.MessagePb.SendMessageRequest request,
        io.grpc.stub.StreamObserver<cool.houge.grpc.communal.MessagePb.SendMessageResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSendToUserMethod(), responseObserver);
    }

    /**
     */
    public void sendToGroup(cool.houge.grpc.communal.MessagePb.SendMessageRequest request,
        io.grpc.stub.StreamObserver<cool.houge.grpc.communal.MessagePb.SendMessageResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSendToGroupMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSendToUserMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                cool.houge.grpc.communal.MessagePb.SendMessageRequest,
                cool.houge.grpc.communal.MessagePb.SendMessageResponse>(
                  this, METHODID_SEND_TO_USER)))
          .addMethod(
            getSendToGroupMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                cool.houge.grpc.communal.MessagePb.SendMessageRequest,
                cool.houge.grpc.communal.MessagePb.SendMessageResponse>(
                  this, METHODID_SEND_TO_GROUP)))
          .build();
    }
  }

  /**
   * <pre>
   * 消息服务
   * </pre>
   */
  public static final class MessageStub extends io.grpc.stub.AbstractAsyncStub<MessageStub> {
    private MessageStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MessageStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MessageStub(channel, callOptions);
    }

    /**
     */
    public void sendToUser(cool.houge.grpc.communal.MessagePb.SendMessageRequest request,
        io.grpc.stub.StreamObserver<cool.houge.grpc.communal.MessagePb.SendMessageResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSendToUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void sendToGroup(cool.houge.grpc.communal.MessagePb.SendMessageRequest request,
        io.grpc.stub.StreamObserver<cool.houge.grpc.communal.MessagePb.SendMessageResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSendToGroupMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * 消息服务
   * </pre>
   */
  public static final class MessageBlockingStub extends io.grpc.stub.AbstractBlockingStub<MessageBlockingStub> {
    private MessageBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MessageBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MessageBlockingStub(channel, callOptions);
    }

    /**
     */
    public cool.houge.grpc.communal.MessagePb.SendMessageResponse sendToUser(cool.houge.grpc.communal.MessagePb.SendMessageRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSendToUserMethod(), getCallOptions(), request);
    }

    /**
     */
    public cool.houge.grpc.communal.MessagePb.SendMessageResponse sendToGroup(cool.houge.grpc.communal.MessagePb.SendMessageRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSendToGroupMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * 消息服务
   * </pre>
   */
  public static final class MessageFutureStub extends io.grpc.stub.AbstractFutureStub<MessageFutureStub> {
    private MessageFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MessageFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MessageFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<cool.houge.grpc.communal.MessagePb.SendMessageResponse> sendToUser(
        cool.houge.grpc.communal.MessagePb.SendMessageRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSendToUserMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<cool.houge.grpc.communal.MessagePb.SendMessageResponse> sendToGroup(
        cool.houge.grpc.communal.MessagePb.SendMessageRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSendToGroupMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SEND_TO_USER = 0;
  private static final int METHODID_SEND_TO_GROUP = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final MessageImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(MessageImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SEND_TO_USER:
          serviceImpl.sendToUser((cool.houge.grpc.communal.MessagePb.SendMessageRequest) request,
              (io.grpc.stub.StreamObserver<cool.houge.grpc.communal.MessagePb.SendMessageResponse>) responseObserver);
          break;
        case METHODID_SEND_TO_GROUP:
          serviceImpl.sendToGroup((cool.houge.grpc.communal.MessagePb.SendMessageRequest) request,
              (io.grpc.stub.StreamObserver<cool.houge.grpc.communal.MessagePb.SendMessageResponse>) responseObserver);
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

  private static abstract class MessageBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MessageBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return cool.houge.grpc.communal.MessagePb.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Message");
    }
  }

  private static final class MessageFileDescriptorSupplier
      extends MessageBaseDescriptorSupplier {
    MessageFileDescriptorSupplier() {}
  }

  private static final class MessageMethodDescriptorSupplier
      extends MessageBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    MessageMethodDescriptorSupplier(String methodName) {
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
      synchronized (MessageGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new MessageFileDescriptorSupplier())
              .addMethod(getSendToUserMethod())
              .addMethod(getSendToGroupMethod())
              .build();
        }
      }
    }
    return result;
  }
}
