package cool.houge.grpc;

import static cool.houge.grpc.UserGrpc.getServiceDescriptor;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;


@javax.annotation.Generated(
value = "by ReactorGrpc generator",
comments = "Source: cool/houge/grpc/user.proto")
public final class ReactorUserGrpc {
    private ReactorUserGrpc() {}

    public static ReactorUserStub newReactorStub(io.grpc.Channel channel) {
        return new ReactorUserStub(channel);
    }

    public static final class ReactorUserStub extends io.grpc.stub.AbstractStub<ReactorUserStub> {
        private UserGrpc.UserStub delegateStub;

        private ReactorUserStub(io.grpc.Channel channel) {
            super(channel);
            delegateStub = UserGrpc.newStub(channel);
        }

        private ReactorUserStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
            delegateStub = UserGrpc.newStub(channel).build(channel, callOptions);
        }

        @Override
        protected ReactorUserStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ReactorUserStub(channel, callOptions);
        }

        /**
         * <pre>
         *  用户ID.
         * </pre>
         */
        public reactor.core.publisher.Mono<cool.houge.grpc.CreateUserResponse> create(reactor.core.publisher.Mono<cool.houge.grpc.CreateUserRequest> reactorRequest) {
            return com.salesforce.reactorgrpc.stub.ClientCalls.oneToOne(reactorRequest, delegateStub::create, getCallOptions());
        }

        /**
         * <pre>
         *  用户ID.
         * </pre>
         */
        public reactor.core.publisher.Mono<cool.houge.grpc.CreateUserResponse> create(cool.houge.grpc.CreateUserRequest reactorRequest) {
           return com.salesforce.reactorgrpc.stub.ClientCalls.oneToOne(reactor.core.publisher.Mono.just(reactorRequest), delegateStub::create, getCallOptions());
        }

    }

    public static abstract class UserImplBase implements io.grpc.BindableService {

        /**
         * <pre>
         *  用户ID.
         * </pre>
         */
        public reactor.core.publisher.Mono<cool.houge.grpc.CreateUserResponse> create(reactor.core.publisher.Mono<cool.houge.grpc.CreateUserRequest> request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
            return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
                    .addMethod(
                            cool.houge.grpc.UserGrpc.getCreateMethod(),
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            cool.houge.grpc.CreateUserRequest,
                                            cool.houge.grpc.CreateUserResponse>(
                                            this, METHODID_CREATE)))
                    .build();
        }

        protected io.grpc.CallOptions getCallOptions(int methodId) {
            return null;
        }

    }

    public static final int METHODID_CREATE = 0;

    private static final class MethodHandlers<Req, Resp> implements
            io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
        private final UserImplBase serviceImpl;
        private final int methodId;

        MethodHandlers(UserImplBase serviceImpl, int methodId) {
            this.serviceImpl = serviceImpl;
            this.methodId = methodId;
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
                case METHODID_CREATE:
                    com.salesforce.reactorgrpc.stub.ServerCalls.oneToOne((cool.houge.grpc.CreateUserRequest) request,
                            (io.grpc.stub.StreamObserver<cool.houge.grpc.CreateUserResponse>) responseObserver,
                            serviceImpl::create);
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
