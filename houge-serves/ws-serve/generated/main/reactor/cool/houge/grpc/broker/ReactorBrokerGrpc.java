package cool.houge.grpc.broker;

import static cool.houge.grpc.broker.BrokerGrpc.getServiceDescriptor;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;


@javax.annotation.Generated(
value = "by ReactorGrpc generator",
comments = "Source: cool/houge/grpc/broker/broker.proto")
public final class ReactorBrokerGrpc {
    private ReactorBrokerGrpc() {}

    public static ReactorBrokerStub newReactorStub(io.grpc.Channel channel) {
        return new ReactorBrokerStub(channel);
    }

    public static final class ReactorBrokerStub extends io.grpc.stub.AbstractStub<ReactorBrokerStub> {
        private BrokerGrpc.BrokerStub delegateStub;

        private ReactorBrokerStub(io.grpc.Channel channel) {
            super(channel);
            delegateStub = BrokerGrpc.newStub(channel);
        }

        private ReactorBrokerStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
            delegateStub = BrokerGrpc.newStub(channel).build(channel, callOptions);
        }

        @Override
        protected ReactorBrokerStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ReactorBrokerStub(channel, callOptions);
        }

        public reactor.core.publisher.Flux<cool.houge.grpc.broker.BrokerPb.AttachResponse> attach(reactor.core.publisher.Mono<cool.houge.grpc.broker.BrokerPb.AttachRequest> reactorRequest) {
            return com.salesforce.reactorgrpc.stub.ClientCalls.oneToMany(reactorRequest, delegateStub::attach, getCallOptions());
        }

        public reactor.core.publisher.Flux<cool.houge.grpc.broker.BrokerPb.AttachResponse> attach(cool.houge.grpc.broker.BrokerPb.AttachRequest reactorRequest) {
           return com.salesforce.reactorgrpc.stub.ClientCalls.oneToMany(reactor.core.publisher.Mono.just(reactorRequest), delegateStub::attach, getCallOptions());
        }

    }

    public static abstract class BrokerImplBase implements io.grpc.BindableService {

        public reactor.core.publisher.Flux<cool.houge.grpc.broker.BrokerPb.AttachResponse> attach(reactor.core.publisher.Mono<cool.houge.grpc.broker.BrokerPb.AttachRequest> request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
            return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
                    .addMethod(
                            cool.houge.grpc.broker.BrokerGrpc.getAttachMethod(),
                            asyncServerStreamingCall(
                                    new MethodHandlers<
                                            cool.houge.grpc.broker.BrokerPb.AttachRequest,
                                            cool.houge.grpc.broker.BrokerPb.AttachResponse>(
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
        private final BrokerImplBase serviceImpl;
        private final int methodId;

        MethodHandlers(BrokerImplBase serviceImpl, int methodId) {
            this.serviceImpl = serviceImpl;
            this.methodId = methodId;
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
                case METHODID_ATTACH:
                    com.salesforce.reactorgrpc.stub.ServerCalls.oneToMany((cool.houge.grpc.broker.BrokerPb.AttachRequest) request,
                            (io.grpc.stub.StreamObserver<cool.houge.grpc.broker.BrokerPb.AttachResponse>) responseObserver,
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
