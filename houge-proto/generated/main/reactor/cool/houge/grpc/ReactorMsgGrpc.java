package cool.houge.grpc;

import static cool.houge.grpc.MsgGrpc.getServiceDescriptor;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;


@javax.annotation.Generated(
value = "by ReactorGrpc generator",
comments = "Source: cool/houge/grpc/msg.proto")
public final class ReactorMsgGrpc {
    private ReactorMsgGrpc() {}

    public static ReactorMsgStub newReactorStub(io.grpc.Channel channel) {
        return new ReactorMsgStub(channel);
    }

    /**
     * <pre>
     *  消息服务
     * </pre>
     */
    public static final class ReactorMsgStub extends io.grpc.stub.AbstractStub<ReactorMsgStub> {
        private MsgGrpc.MsgStub delegateStub;

        private ReactorMsgStub(io.grpc.Channel channel) {
            super(channel);
            delegateStub = MsgGrpc.newStub(channel);
        }

        private ReactorMsgStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
            delegateStub = MsgGrpc.newStub(channel).build(channel, callOptions);
        }

        @Override
        protected ReactorMsgStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ReactorMsgStub(channel, callOptions);
        }

        public reactor.core.publisher.Mono<cool.houge.grpc.CreateMsgIdResponse> createId(reactor.core.publisher.Mono<cool.houge.grpc.CreateMsgIdRequest> reactorRequest) {
            return com.salesforce.reactorgrpc.stub.ClientCalls.oneToOne(reactorRequest, delegateStub::createId, getCallOptions());
        }

        /**
         * <pre>
         *  消息发送者
         * </pre>
         */
        public reactor.core.publisher.Mono<cool.houge.grpc.CreateMsgIdsResponse> createIds(reactor.core.publisher.Mono<cool.houge.grpc.CreateMsgIdsRequest> reactorRequest) {
            return com.salesforce.reactorgrpc.stub.ClientCalls.oneToOne(reactorRequest, delegateStub::createIds, getCallOptions());
        }

        /**
         * <pre>
         *  消息接收者
         * </pre>
         */
        public reactor.core.publisher.Mono<cool.houge.grpc.SendMsgResponse> sendToUser(reactor.core.publisher.Mono<cool.houge.grpc.SendMsgRequest> reactorRequest) {
            return com.salesforce.reactorgrpc.stub.ClientCalls.oneToOne(reactorRequest, delegateStub::sendToUser, getCallOptions());
        }

        /**
         * <pre>
         *  消息内容
         * </pre>
         */
        public reactor.core.publisher.Mono<cool.houge.grpc.SendMsgResponse> sendToGroup(reactor.core.publisher.Mono<cool.houge.grpc.SendMsgRequest> reactorRequest) {
            return com.salesforce.reactorgrpc.stub.ClientCalls.oneToOne(reactorRequest, delegateStub::sendToGroup, getCallOptions());
        }

        public reactor.core.publisher.Mono<cool.houge.grpc.CreateMsgIdResponse> createId(cool.houge.grpc.CreateMsgIdRequest reactorRequest) {
           return com.salesforce.reactorgrpc.stub.ClientCalls.oneToOne(reactor.core.publisher.Mono.just(reactorRequest), delegateStub::createId, getCallOptions());
        }

        /**
         * <pre>
         *  消息发送者
         * </pre>
         */
        public reactor.core.publisher.Mono<cool.houge.grpc.CreateMsgIdsResponse> createIds(cool.houge.grpc.CreateMsgIdsRequest reactorRequest) {
           return com.salesforce.reactorgrpc.stub.ClientCalls.oneToOne(reactor.core.publisher.Mono.just(reactorRequest), delegateStub::createIds, getCallOptions());
        }

        /**
         * <pre>
         *  消息接收者
         * </pre>
         */
        public reactor.core.publisher.Mono<cool.houge.grpc.SendMsgResponse> sendToUser(cool.houge.grpc.SendMsgRequest reactorRequest) {
           return com.salesforce.reactorgrpc.stub.ClientCalls.oneToOne(reactor.core.publisher.Mono.just(reactorRequest), delegateStub::sendToUser, getCallOptions());
        }

        /**
         * <pre>
         *  消息内容
         * </pre>
         */
        public reactor.core.publisher.Mono<cool.houge.grpc.SendMsgResponse> sendToGroup(cool.houge.grpc.SendMsgRequest reactorRequest) {
           return com.salesforce.reactorgrpc.stub.ClientCalls.oneToOne(reactor.core.publisher.Mono.just(reactorRequest), delegateStub::sendToGroup, getCallOptions());
        }

    }

    /**
     * <pre>
     *  消息服务
     * </pre>
     */
    public static abstract class MsgImplBase implements io.grpc.BindableService {

        public reactor.core.publisher.Mono<cool.houge.grpc.CreateMsgIdResponse> createId(reactor.core.publisher.Mono<cool.houge.grpc.CreateMsgIdRequest> request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        /**
         * <pre>
         *  消息发送者
         * </pre>
         */
        public reactor.core.publisher.Mono<cool.houge.grpc.CreateMsgIdsResponse> createIds(reactor.core.publisher.Mono<cool.houge.grpc.CreateMsgIdsRequest> request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        /**
         * <pre>
         *  消息接收者
         * </pre>
         */
        public reactor.core.publisher.Mono<cool.houge.grpc.SendMsgResponse> sendToUser(reactor.core.publisher.Mono<cool.houge.grpc.SendMsgRequest> request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        /**
         * <pre>
         *  消息内容
         * </pre>
         */
        public reactor.core.publisher.Mono<cool.houge.grpc.SendMsgResponse> sendToGroup(reactor.core.publisher.Mono<cool.houge.grpc.SendMsgRequest> request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
            return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
                    .addMethod(
                            cool.houge.grpc.MsgGrpc.getCreateIdMethod(),
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            cool.houge.grpc.CreateMsgIdRequest,
                                            cool.houge.grpc.CreateMsgIdResponse>(
                                            this, METHODID_CREATE_ID)))
                    .addMethod(
                            cool.houge.grpc.MsgGrpc.getCreateIdsMethod(),
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            cool.houge.grpc.CreateMsgIdsRequest,
                                            cool.houge.grpc.CreateMsgIdsResponse>(
                                            this, METHODID_CREATE_IDS)))
                    .addMethod(
                            cool.houge.grpc.MsgGrpc.getSendToUserMethod(),
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            cool.houge.grpc.SendMsgRequest,
                                            cool.houge.grpc.SendMsgResponse>(
                                            this, METHODID_SEND_TO_USER)))
                    .addMethod(
                            cool.houge.grpc.MsgGrpc.getSendToGroupMethod(),
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            cool.houge.grpc.SendMsgRequest,
                                            cool.houge.grpc.SendMsgResponse>(
                                            this, METHODID_SEND_TO_GROUP)))
                    .build();
        }

        protected io.grpc.CallOptions getCallOptions(int methodId) {
            return null;
        }

    }

    public static final int METHODID_CREATE_ID = 0;
    public static final int METHODID_CREATE_IDS = 1;
    public static final int METHODID_SEND_TO_USER = 2;
    public static final int METHODID_SEND_TO_GROUP = 3;

    private static final class MethodHandlers<Req, Resp> implements
            io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
        private final MsgImplBase serviceImpl;
        private final int methodId;

        MethodHandlers(MsgImplBase serviceImpl, int methodId) {
            this.serviceImpl = serviceImpl;
            this.methodId = methodId;
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
                case METHODID_CREATE_ID:
                    com.salesforce.reactorgrpc.stub.ServerCalls.oneToOne((cool.houge.grpc.CreateMsgIdRequest) request,
                            (io.grpc.stub.StreamObserver<cool.houge.grpc.CreateMsgIdResponse>) responseObserver,
                            serviceImpl::createId);
                    break;
                case METHODID_CREATE_IDS:
                    com.salesforce.reactorgrpc.stub.ServerCalls.oneToOne((cool.houge.grpc.CreateMsgIdsRequest) request,
                            (io.grpc.stub.StreamObserver<cool.houge.grpc.CreateMsgIdsResponse>) responseObserver,
                            serviceImpl::createIds);
                    break;
                case METHODID_SEND_TO_USER:
                    com.salesforce.reactorgrpc.stub.ServerCalls.oneToOne((cool.houge.grpc.SendMsgRequest) request,
                            (io.grpc.stub.StreamObserver<cool.houge.grpc.SendMsgResponse>) responseObserver,
                            serviceImpl::sendToUser);
                    break;
                case METHODID_SEND_TO_GROUP:
                    com.salesforce.reactorgrpc.stub.ServerCalls.oneToOne((cool.houge.grpc.SendMsgRequest) request,
                            (io.grpc.stub.StreamObserver<cool.houge.grpc.SendMsgResponse>) responseObserver,
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
