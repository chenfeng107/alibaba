package cool.houge.grpc;

import static cool.houge.grpc.AgentGrpc.getServiceDescriptor;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;


@javax.annotation.Generated(
value = "by ReactorGrpc generator",
comments = "Source: cool/houge/grpc/agent.proto")
public final class ReactorAgentGrpc {
    private ReactorAgentGrpc() {}

    public static ReactorAgentStub newReactorStub(io.grpc.Channel channel) {
        return new ReactorAgentStub(channel);
    }

    public static final class ReactorAgentStub extends io.grpc.stub.AbstractStub<ReactorAgentStub> {
        private AgentGrpc.AgentStub delegateStub;

        private ReactorAgentStub(io.grpc.Channel channel) {
            super(channel);
            delegateStub = AgentGrpc.newStub(channel);
        }

        private ReactorAgentStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
            delegateStub = AgentGrpc.newStub(channel).build(channel, callOptions);
        }

        @Override
        protected ReactorAgentStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ReactorAgentStub(channel, callOptions);
        }

        /**
         * <pre>
         *  终端的标识名
         * </pre>
         */
        public reactor.core.publisher.Flux<cool.houge.grpc.AgentPb.LinkResponse> link(reactor.core.publisher.Mono<cool.houge.grpc.AgentPb.LinkRequest> reactorRequest) {
            return com.salesforce.reactorgrpc.stub.ClientCalls.oneToMany(reactorRequest, delegateStub::link, getCallOptions());
        }

        /**
         * <pre>
         *  终端的标识名
         * </pre>
         */
        public reactor.core.publisher.Flux<cool.houge.grpc.AgentPb.LinkResponse> link(cool.houge.grpc.AgentPb.LinkRequest reactorRequest) {
           return com.salesforce.reactorgrpc.stub.ClientCalls.oneToMany(reactor.core.publisher.Mono.just(reactorRequest), delegateStub::link, getCallOptions());
        }

    }

    public static abstract class AgentImplBase implements io.grpc.BindableService {

        /**
         * <pre>
         *  终端的标识名
         * </pre>
         */
        public reactor.core.publisher.Flux<cool.houge.grpc.AgentPb.LinkResponse> link(reactor.core.publisher.Mono<cool.houge.grpc.AgentPb.LinkRequest> request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
            return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
                    .addMethod(
                            cool.houge.grpc.AgentGrpc.getLinkMethod(),
                            asyncServerStreamingCall(
                                    new MethodHandlers<
                                            cool.houge.grpc.AgentPb.LinkRequest,
                                            cool.houge.grpc.AgentPb.LinkResponse>(
                                            this, METHODID_LINK)))
                    .build();
        }

        protected io.grpc.CallOptions getCallOptions(int methodId) {
            return null;
        }

    }

    public static final int METHODID_LINK = 0;

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
                    com.salesforce.reactorgrpc.stub.ServerCalls.oneToMany((cool.houge.grpc.AgentPb.LinkRequest) request,
                            (io.grpc.stub.StreamObserver<cool.houge.grpc.AgentPb.LinkResponse>) responseObserver,
                            serviceImpl::link);
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
