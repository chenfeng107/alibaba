package cool.houge.grpc.communal;

import static cool.houge.grpc.communal.PacketGrpc.getServiceDescriptor;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;


@javax.annotation.Generated(
value = "by ReactorGrpc generator",
comments = "Source: cool/houge/grpc/communal/packet.proto")
public final class ReactorPacketGrpc {
    private ReactorPacketGrpc() {}

    public static ReactorPacketStub newReactorStub(io.grpc.Channel channel) {
        return new ReactorPacketStub(channel);
    }

    public static final class ReactorPacketStub extends io.grpc.stub.AbstractStub<ReactorPacketStub> {
        private PacketGrpc.PacketStub delegateStub;

        private ReactorPacketStub(io.grpc.Channel channel) {
            super(channel);
            delegateStub = PacketGrpc.newStub(channel);
        }

        private ReactorPacketStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
            delegateStub = PacketGrpc.newStub(channel).build(channel, callOptions);
        }

        @Override
        protected ReactorPacketStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ReactorPacketStub(channel, callOptions);
        }

        /**
         * <pre>
         *  发起请求的用户ID
         * </pre>
         */
        public reactor.core.publisher.Mono<cool.houge.grpc.communal.PacketPb.PacketResponse> process(reactor.core.publisher.Mono<cool.houge.grpc.communal.PacketPb.PacketRequest> reactorRequest) {
            return com.salesforce.reactorgrpc.stub.ClientCalls.oneToOne(reactorRequest, delegateStub::process, getCallOptions());
        }

        /**
         * <pre>
         *  发起请求的用户ID
         * </pre>
         */
        public reactor.core.publisher.Mono<cool.houge.grpc.communal.PacketPb.PacketResponse> process(cool.houge.grpc.communal.PacketPb.PacketRequest reactorRequest) {
           return com.salesforce.reactorgrpc.stub.ClientCalls.oneToOne(reactor.core.publisher.Mono.just(reactorRequest), delegateStub::process, getCallOptions());
        }

    }

    public static abstract class PacketImplBase implements io.grpc.BindableService {

        /**
         * <pre>
         *  发起请求的用户ID
         * </pre>
         */
        public reactor.core.publisher.Mono<cool.houge.grpc.communal.PacketPb.PacketResponse> process(reactor.core.publisher.Mono<cool.houge.grpc.communal.PacketPb.PacketRequest> request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
            return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
                    .addMethod(
                            cool.houge.grpc.communal.PacketGrpc.getProcessMethod(),
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            cool.houge.grpc.communal.PacketPb.PacketRequest,
                                            cool.houge.grpc.communal.PacketPb.PacketResponse>(
                                            this, METHODID_PROCESS)))
                    .build();
        }

        protected io.grpc.CallOptions getCallOptions(int methodId) {
            return null;
        }

    }

    public static final int METHODID_PROCESS = 0;

    private static final class MethodHandlers<Req, Resp> implements
            io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
        private final PacketImplBase serviceImpl;
        private final int methodId;

        MethodHandlers(PacketImplBase serviceImpl, int methodId) {
            this.serviceImpl = serviceImpl;
            this.methodId = methodId;
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
                case METHODID_PROCESS:
                    com.salesforce.reactorgrpc.stub.ServerCalls.oneToOne((cool.houge.grpc.communal.PacketPb.PacketRequest) request,
                            (io.grpc.stub.StreamObserver<cool.houge.grpc.communal.PacketPb.PacketResponse>) responseObserver,
                            serviceImpl::process);
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
