package cool.houge.grpc.communal;

import static cool.houge.grpc.communal.MessageGrpc.getServiceDescriptor;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;


@javax.annotation.Generated(
value = "by ReactorGrpc generator",
comments = "Source: cool/houge/grpc/communal/message.proto")
public final class ReactorMessageGrpc {
    private ReactorMessageGrpc() {}

    public static ReactorMessageStub newReactorStub(io.grpc.Channel channel) {
        return new ReactorMessageStub(channel);
    }

    /**
     * <pre>
     *  消息服务
     * </pre>
     */
    public static final class ReactorMessageStub extends io.grpc.stub.AbstractStub<ReactorMessageStub> {
        private MessageGrpc.MessageStub delegateStub;

        private ReactorMessageStub(io.grpc.Channel channel) {
            super(channel);
            delegateStub = MessageGrpc.newStub(channel);
        }

        private ReactorMessageStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
            delegateStub = MessageGrpc.newStub(channel).build(channel, callOptions);
        }

        @Override
        protected ReactorMessageStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ReactorMessageStub(channel, callOptions);
        }

        /**
         * <pre>
         *  消息发送者
         * </pre>
         */
        public reactor.core.publisher.Mono<cool.houge.grpc.communal.MessagePb.SendMessageResponse> sendToUser(reactor.core.publisher.Mono<cool.houge.grpc.communal.MessagePb.SendMessageRequest> reactorRequest) {
            return com.salesforce.reactorgrpc.stub.ClientCalls.oneToOne(reactorRequest, delegateStub::sendToUser, getCallOptions());
        }

        /**
         * <pre>
         *  消息接收者
         * </pre>
         */
        public reactor.core.publisher.Mono<cool.houge.grpc.communal.MessagePb.SendMessageResponse> sendToGroup(reactor.core.publisher.Mono<cool.houge.grpc.communal.MessagePb.SendMessageRequest> reactorRequest) {
            return com.salesforce.reactorgrpc.stub.ClientCalls.oneToOne(reactorRequest, delegateStub::sendToGroup, getCallOptions());
        }

        /**
         * <pre>
         *  消息发送者
         * </pre>
         */
        public reactor.core.publisher.Mono<cool.houge.grpc.communal.MessagePb.SendMessageResponse> sendToUser(cool.houge.grpc.communal.MessagePb.SendMessageRequest reactorRequest) {
           return com.salesforce.reactorgrpc.stub.ClientCalls.oneToOne(reactor.core.publisher.Mono.just(reactorRequest), delegateStub::sendToUser, getCallOptions());
        }

        /**
         * <pre>
         *  消息接收者
         * </pre>
         */
        public reactor.core.publisher.Mono<cool.houge.grpc.communal.MessagePb.SendMessageResponse> sendToGroup(cool.houge.grpc.communal.MessagePb.SendMessageRequest reactorRequest) {
           return com.salesforce.reactorgrpc.stub.ClientCalls.oneToOne(reactor.core.publisher.Mono.just(reactorRequest), delegateStub::sendToGroup, getCallOptions());
        }

    }

    /**
     * <pre>
     *  消息服务
     * </pre>
     */
    public static abstract class MessageImplBase implements io.grpc.BindableService {

        /**
         * <pre>
         *  消息发送者
         * </pre>
         */
        public reactor.core.publisher.Mono<cool.houge.grpc.communal.MessagePb.SendMessageResponse> sendToUser(reactor.core.publisher.Mono<cool.houge.grpc.communal.MessagePb.SendMessageRequest> request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        /**
         * <pre>
         *  消息接收者
         * </pre>
         */
        public reactor.core.publisher.Mono<cool.houge.grpc.communal.MessagePb.SendMessageResponse> sendToGroup(reactor.core.publisher.Mono<cool.houge.grpc.communal.MessagePb.SendMessageRequest> request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
            return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
                    .addMethod(
                            cool.houge.grpc.communal.MessageGrpc.getSendToUserMethod(),
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            cool.houge.grpc.communal.MessagePb.SendMessageRequest,
                                            cool.houge.grpc.communal.MessagePb.SendMessageResponse>(
                                            this, METHODID_SEND_TO_USER)))
                    .addMethod(
                            cool.houge.grpc.communal.MessageGrpc.getSendToGroupMethod(),
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            cool.houge.grpc.communal.MessagePb.SendMessageRequest,
                                            cool.houge.grpc.communal.MessagePb.SendMessageResponse>(
                                            this, METHODID_SEND_TO_GROUP)))
                    .build();
        }

        protected io.grpc.CallOptions getCallOptions(int methodId) {
            return null;
        }

    }

    public static final int METHODID_SEND_TO_USER = 0;
    public static final int METHODID_SEND_TO_GROUP = 1;

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
                    com.salesforce.reactorgrpc.stub.ServerCalls.oneToOne((cool.houge.grpc.communal.MessagePb.SendMessageRequest) request,
                            (io.grpc.stub.StreamObserver<cool.houge.grpc.communal.MessagePb.SendMessageResponse>) responseObserver,
                            serviceImpl::sendToUser);
                    break;
                case METHODID_SEND_TO_GROUP:
                    com.salesforce.reactorgrpc.stub.ServerCalls.oneToOne((cool.houge.grpc.communal.MessagePb.SendMessageRequest) request,
                            (io.grpc.stub.StreamObserver<cool.houge.grpc.communal.MessagePb.SendMessageResponse>) responseObserver,
                            serviceImpl::sendToGroup);
                    break;
                default:
                    throw new java.lang.AssertionError();
            }
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public io.grpc.stub.StreamObserver<Req> invoke(io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
                default:
                    throw new java.lang.AssertionError();
            }
        }
    }

}
