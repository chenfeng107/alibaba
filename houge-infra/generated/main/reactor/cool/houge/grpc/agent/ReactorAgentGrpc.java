package cool.houge.grpc.agent;

import static cool.houge.grpc.agent.AgentGrpc.getServiceDescriptor;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;


@javax.annotation.Generated(
value = "by ReactorGrpc generator",
comments = "Source: cool/houge/grpc/agent/agent.proto")
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

        public reactor.core.publisher.Flux<cool.houge.grpc.agent.AgentPb.AttachResponse> attach(reactor.core.publisher.Mono<cool.houge.grpc.agent.AgentPb.AttachRequest> reactorRequest) {
            return com.salesforce.reactorgrpc.stub.ClientCalls.oneToMany(reactorRequest, delegateStub::attach, getCallOptions());
        }

        public reactor.core.publisher.Flux<cool.houge.grpc.agent.AgentPb.AttachResponse> attach(cool.houge.grpc.agent.AgentPb.AttachRequest reactorRequest) {
           return com.salesforce.reactorgrpc.stub.ClientCalls.oneToMany(reactor.core.publisher.Mono.just(reactorRequest), delegateStub::attach, getCallOptions());
        }

    }

    public static abstract class AgentImplBase implements io.grpc.BindableService {

        public reactor.core.publisher.Flux<cool.houge.grpc.agent.AgentPb.AttachResponse> attach(reactor.core.publisher.Mono<cool.houge.grpc.agent.AgentPb.AttachRequest> request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
            return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
                    .addMethod(
                            cool.houge.grpc.agent.AgentGrpc.getAttachMethod(),
                            asyncServerStreamingCall(
                                    new MethodHandlers<
                                            cool.houge.grpc.agent.AgentPb.AttachRequest,
                                            cool.houge.grpc.agent.AgentPb.AttachResponse>(
                                            this, METHODID_ATTACH)))
                    .build();
        }

        protected io.grpc.CallOptions getCallOptions(int methodId) {
            return null;
        }

    }

    public static final int METHODID_ATTACH = 0;

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
                    com.salesforce.reactorgrpc.stub.ServerCalls.oneToMany((cool.houge.grpc.agent.AgentPb.AttachRequest) request,
                            (io.grpc.stub.StreamObserver<cool.houge.grpc.agent.AgentPb.AttachResponse>) responseObserver,
                            serviceImpl::attach);
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
