package cool.houge.grpc.agent;

import static cool.houge.grpc.agent.PolygonGrpc.getServiceDescriptor;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;


@javax.annotation.Generated(
value = "by ReactorGrpc generator",
comments = "Source: cool/houge/grpc/agent/polygon.proto")
public final class ReactorPolygonGrpc {
    private ReactorPolygonGrpc() {}

    public static ReactorPolygonStub newReactorStub(io.grpc.Channel channel) {
        return new ReactorPolygonStub(channel);
    }

    public static final class ReactorPolygonStub extends io.grpc.stub.AbstractStub<ReactorPolygonStub> {
        private PolygonGrpc.PolygonStub delegateStub;

        private ReactorPolygonStub(io.grpc.Channel channel) {
            super(channel);
            delegateStub = PolygonGrpc.newStub(channel);
        }

        private ReactorPolygonStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
            delegateStub = PolygonGrpc.newStub(channel).build(channel, callOptions);
        }

        @Override
        protected ReactorPolygonStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ReactorPolygonStub(channel, callOptions);
        }

        /**
         * <pre>
         *  访问令牌
         * </pre>
         */
        public reactor.core.publisher.Mono<cool.houge.grpc.agent.PolygonPb.AgentAuthResponse> auth(reactor.core.publisher.Mono<cool.houge.grpc.agent.PolygonPb.AgentAuthRequest> reactorRequest) {
            return com.salesforce.reactorgrpc.stub.ClientCalls.oneToOne(reactorRequest, delegateStub::auth, getCallOptions());
        }

        /**
         * <pre>
         *  Packet数据
         * </pre>
         */
        public reactor.core.publisher.Mono<cool.houge.grpc.agent.PolygonPb.AgentListGidsResponse> listGids(reactor.core.publisher.Mono<cool.houge.grpc.agent.PolygonPb.AgentListGidsRequest> reactorRequest) {
            return com.salesforce.reactorgrpc.stub.ClientCalls.oneToOne(reactorRequest, delegateStub::listGids, getCallOptions());
        }

        /**
         * <pre>
         *  过滤终端的标识
         * </pre>
         */
        public reactor.core.publisher.Mono<cool.houge.grpc.agent.PolygonPb.AgentPacketResponse> processPacket(reactor.core.publisher.Mono<cool.houge.grpc.agent.PolygonPb.AgentPacketRequest> reactorRequest) {
            return com.salesforce.reactorgrpc.stub.ClientCalls.oneToOne(reactorRequest, delegateStub::processPacket, getCallOptions());
        }

        /**
         * <pre>
         *  访问令牌
         * </pre>
         */
        public reactor.core.publisher.Mono<cool.houge.grpc.agent.PolygonPb.AgentAuthResponse> auth(cool.houge.grpc.agent.PolygonPb.AgentAuthRequest reactorRequest) {
           return com.salesforce.reactorgrpc.stub.ClientCalls.oneToOne(reactor.core.publisher.Mono.just(reactorRequest), delegateStub::auth, getCallOptions());
        }

        /**
         * <pre>
         *  Packet数据
         * </pre>
         */
        public reactor.core.publisher.Mono<cool.houge.grpc.agent.PolygonPb.AgentListGidsResponse> listGids(cool.houge.grpc.agent.PolygonPb.AgentListGidsRequest reactorRequest) {
           return com.salesforce.reactorgrpc.stub.ClientCalls.oneToOne(reactor.core.publisher.Mono.just(reactorRequest), delegateStub::listGids, getCallOptions());
        }

        /**
         * <pre>
         *  过滤终端的标识
         * </pre>
         */
        public reactor.core.publisher.Mono<cool.houge.grpc.agent.PolygonPb.AgentPacketResponse> processPacket(cool.houge.grpc.agent.PolygonPb.AgentPacketRequest reactorRequest) {
           return com.salesforce.reactorgrpc.stub.ClientCalls.oneToOne(reactor.core.publisher.Mono.just(reactorRequest), delegateStub::processPacket, getCallOptions());
        }

    }

    public static abstract class PolygonImplBase implements io.grpc.BindableService {

        /**
         * <pre>
         *  访问令牌
         * </pre>
         */
        public reactor.core.publisher.Mono<cool.houge.grpc.agent.PolygonPb.AgentAuthResponse> auth(reactor.core.publisher.Mono<cool.houge.grpc.agent.PolygonPb.AgentAuthRequest> request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        /**
         * <pre>
         *  Packet数据
         * </pre>
         */
        public reactor.core.publisher.Mono<cool.houge.grpc.agent.PolygonPb.AgentListGidsResponse> listGids(reactor.core.publisher.Mono<cool.houge.grpc.agent.PolygonPb.AgentListGidsRequest> request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        /**
         * <pre>
         *  过滤终端的标识
         * </pre>
         */
        public reactor.core.publisher.Mono<cool.houge.grpc.agent.PolygonPb.AgentPacketResponse> processPacket(reactor.core.publisher.Mono<cool.houge.grpc.agent.PolygonPb.AgentPacketRequest> request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
            return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
                    .addMethod(
                            cool.houge.grpc.agent.PolygonGrpc.getAuthMethod(),
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            cool.houge.grpc.agent.PolygonPb.AgentAuthRequest,
                                            cool.houge.grpc.agent.PolygonPb.AgentAuthResponse>(
                                            this, METHODID_AUTH)))
                    .addMethod(
                            cool.houge.grpc.agent.PolygonGrpc.getListGidsMethod(),
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            cool.houge.grpc.agent.PolygonPb.AgentListGidsRequest,
                                            cool.houge.grpc.agent.PolygonPb.AgentListGidsResponse>(
                                            this, METHODID_LIST_GIDS)))
                    .addMethod(
                            cool.houge.grpc.agent.PolygonGrpc.getProcessPacketMethod(),
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            cool.houge.grpc.agent.PolygonPb.AgentPacketRequest,
                                            cool.houge.grpc.agent.PolygonPb.AgentPacketResponse>(
                                            this, METHODID_PROCESS_PACKET)))
                    .build();
        }

        protected io.grpc.CallOptions getCallOptions(int methodId) {
            return null;
        }

    }

    public static final int METHODID_AUTH = 0;
    public static final int METHODID_LIST_GIDS = 1;
    public static final int METHODID_PROCESS_PACKET = 2;

    private static final class MethodHandlers<Req, Resp> implements
            io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
        private final PolygonImplBase serviceImpl;
        private final int methodId;

        MethodHandlers(PolygonImplBase serviceImpl, int methodId) {
            this.serviceImpl = serviceImpl;
            this.methodId = methodId;
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
                case METHODID_AUTH:
                    com.salesforce.reactorgrpc.stub.ServerCalls.oneToOne((cool.houge.grpc.agent.PolygonPb.AgentAuthRequest) request,
                            (io.grpc.stub.StreamObserver<cool.houge.grpc.agent.PolygonPb.AgentAuthResponse>) responseObserver,
                            serviceImpl::auth);
                    break;
                case METHODID_LIST_GIDS:
                    com.salesforce.reactorgrpc.stub.ServerCalls.oneToOne((cool.houge.grpc.agent.PolygonPb.AgentListGidsRequest) request,
                            (io.grpc.stub.StreamObserver<cool.houge.grpc.agent.PolygonPb.AgentListGidsResponse>) responseObserver,
                            serviceImpl::listGids);
                    break;
                case METHODID_PROCESS_PACKET:
                    com.salesforce.reactorgrpc.stub.ServerCalls.oneToOne((cool.houge.grpc.agent.PolygonPb.AgentPacketRequest) request,
                            (io.grpc.stub.StreamObserver<cool.houge.grpc.agent.PolygonPb.AgentPacketResponse>) responseObserver,
                            serviceImpl::processPacket);
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
