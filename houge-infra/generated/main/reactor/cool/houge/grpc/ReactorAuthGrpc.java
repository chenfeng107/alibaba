package cool.houge.grpc;

import static cool.houge.grpc.AuthGrpc.getServiceDescriptor;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;


@javax.annotation.Generated(
value = "by ReactorGrpc generator",
comments = "Source: cool/houge/grpc/auth.proto")
public final class ReactorAuthGrpc {
    private ReactorAuthGrpc() {}

    public static ReactorAuthStub newReactorStub(io.grpc.Channel channel) {
        return new ReactorAuthStub(channel);
    }

    public static final class ReactorAuthStub extends io.grpc.stub.AbstractStub<ReactorAuthStub> {
        private AuthGrpc.AuthStub delegateStub;

        private ReactorAuthStub(io.grpc.Channel channel) {
            super(channel);
            delegateStub = AuthGrpc.newStub(channel);
        }

        private ReactorAuthStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
            delegateStub = AuthGrpc.newStub(channel).build(channel, callOptions);
        }

        @Override
        protected ReactorAuthStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ReactorAuthStub(channel, callOptions);
        }

        /**
         * <pre>
         *  访问令牌
         * </pre>
         */
        public reactor.core.publisher.Mono<cool.houge.grpc.AuthPb.AuthResponse> auth(reactor.core.publisher.Mono<cool.houge.grpc.AuthPb.AuthRequest> reactorRequest) {
            return com.salesforce.reactorgrpc.stub.ClientCalls.oneToOne(reactorRequest, delegateStub::auth, getCallOptions());
        }

        /**
         * <pre>
         *  访问令牌
         * </pre>
         */
        public reactor.core.publisher.Mono<cool.houge.grpc.AuthPb.AuthResponse> auth(cool.houge.grpc.AuthPb.AuthRequest reactorRequest) {
           return com.salesforce.reactorgrpc.stub.ClientCalls.oneToOne(reactor.core.publisher.Mono.just(reactorRequest), delegateStub::auth, getCallOptions());
        }

    }

    public static abstract class AuthImplBase implements io.grpc.BindableService {

        /**
         * <pre>
         *  访问令牌
         * </pre>
         */
        public reactor.core.publisher.Mono<cool.houge.grpc.AuthPb.AuthResponse> auth(reactor.core.publisher.Mono<cool.houge.grpc.AuthPb.AuthRequest> request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
            return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
                    .addMethod(
                            cool.houge.grpc.AuthGrpc.getAuthMethod(),
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            cool.houge.grpc.AuthPb.AuthRequest,
                                            cool.houge.grpc.AuthPb.AuthResponse>(
                                            this, METHODID_AUTH)))
                    .build();
        }

        protected io.grpc.CallOptions getCallOptions(int methodId) {
            return null;
        }

    }

    public static final int METHODID_AUTH = 0;

    private static final class MethodHandlers<Req, Resp> implements
            io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
        private final AuthImplBase serviceImpl;
        private final int methodId;

        MethodHandlers(AuthImplBase serviceImpl, int methodId) {
            this.serviceImpl = serviceImpl;
            this.methodId = methodId;
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
                case METHODID_AUTH:
                    com.salesforce.reactorgrpc.stub.ServerCalls.oneToOne((cool.houge.grpc.AuthPb.AuthRequest) request,
                            (io.grpc.stub.StreamObserver<cool.houge.grpc.AuthPb.AuthResponse>) responseObserver,
                            serviceImpl::auth);
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
