package cool.houge.grpc;

import static cool.houge.grpc.TokenGrpc.getServiceDescriptor;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;


@javax.annotation.Generated(
value = "by ReactorGrpc generator",
comments = "Source: cool/houge/grpc/token.proto")
public final class ReactorTokenGrpc {
    private ReactorTokenGrpc() {}

    public static ReactorTokenStub newReactorStub(io.grpc.Channel channel) {
        return new ReactorTokenStub(channel);
    }

    public static final class ReactorTokenStub extends io.grpc.stub.AbstractStub<ReactorTokenStub> {
        private TokenGrpc.TokenStub delegateStub;

        private ReactorTokenStub(io.grpc.Channel channel) {
            super(channel);
            delegateStub = TokenGrpc.newStub(channel);
        }

        private ReactorTokenStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
            delegateStub = TokenGrpc.newStub(channel).build(channel, callOptions);
        }

        @Override
        protected ReactorTokenStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ReactorTokenStub(channel, callOptions);
        }

        public reactor.core.publisher.Mono<cool.houge.grpc.CreateTokenResponse> create(reactor.core.publisher.Mono<cool.houge.grpc.CreateTokenRequest> reactorRequest) {
            return com.salesforce.reactorgrpc.stub.ClientCalls.oneToOne(reactorRequest, delegateStub::create, getCallOptions());
        }

        /**
         * <pre>
         *  验证访问令牌
         * </pre>
         */
        public reactor.core.publisher.Mono<cool.houge.grpc.VerifyTokenResponse> verify(reactor.core.publisher.Mono<cool.houge.grpc.VerifyTokenRequest> reactorRequest) {
            return com.salesforce.reactorgrpc.stub.ClientCalls.oneToOne(reactorRequest, delegateStub::verify, getCallOptions());
        }

        public reactor.core.publisher.Mono<cool.houge.grpc.CreateTokenResponse> create(cool.houge.grpc.CreateTokenRequest reactorRequest) {
           return com.salesforce.reactorgrpc.stub.ClientCalls.oneToOne(reactor.core.publisher.Mono.just(reactorRequest), delegateStub::create, getCallOptions());
        }

        /**
         * <pre>
         *  验证访问令牌
         * </pre>
         */
        public reactor.core.publisher.Mono<cool.houge.grpc.VerifyTokenResponse> verify(cool.houge.grpc.VerifyTokenRequest reactorRequest) {
           return com.salesforce.reactorgrpc.stub.ClientCalls.oneToOne(reactor.core.publisher.Mono.just(reactorRequest), delegateStub::verify, getCallOptions());
        }

    }

    public static abstract class TokenImplBase implements io.grpc.BindableService {

        public reactor.core.publisher.Mono<cool.houge.grpc.CreateTokenResponse> create(reactor.core.publisher.Mono<cool.houge.grpc.CreateTokenRequest> request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        /**
         * <pre>
         *  验证访问令牌
         * </pre>
         */
        public reactor.core.publisher.Mono<cool.houge.grpc.VerifyTokenResponse> verify(reactor.core.publisher.Mono<cool.houge.grpc.VerifyTokenRequest> request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
            return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
                    .addMethod(
                            cool.houge.grpc.TokenGrpc.getCreateMethod(),
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            cool.houge.grpc.CreateTokenRequest,
                                            cool.houge.grpc.CreateTokenResponse>(
                                            this, METHODID_CREATE)))
                    .addMethod(
                            cool.houge.grpc.TokenGrpc.getVerifyMethod(),
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            cool.houge.grpc.VerifyTokenRequest,
                                            cool.houge.grpc.VerifyTokenResponse>(
                                            this, METHODID_VERIFY)))
                    .build();
        }

        protected io.grpc.CallOptions getCallOptions(int methodId) {
            return null;
        }

    }

    public static final int METHODID_CREATE = 0;
    public static final int METHODID_VERIFY = 1;

    private static final class MethodHandlers<Req, Resp> implements
            io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
        private final TokenImplBase serviceImpl;
        private final int methodId;

        MethodHandlers(TokenImplBase serviceImpl, int methodId) {
            this.serviceImpl = serviceImpl;
            this.methodId = methodId;
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
                case METHODID_CREATE:
                    com.salesforce.reactorgrpc.stub.ServerCalls.oneToOne((cool.houge.grpc.CreateTokenRequest) request,
                            (io.grpc.stub.StreamObserver<cool.houge.grpc.CreateTokenResponse>) responseObserver,
                            serviceImpl::create);
                    break;
                case METHODID_VERIFY:
                    com.salesforce.reactorgrpc.stub.ServerCalls.oneToOne((cool.houge.grpc.VerifyTokenRequest) request,
                            (io.grpc.stub.StreamObserver<cool.houge.grpc.VerifyTokenResponse>) responseObserver,
                            serviceImpl::verify);
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
