package cool.houge.grpc;

import static cool.houge.grpc.UserGroupGrpc.getServiceDescriptor;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;


@javax.annotation.Generated(
value = "by ReactorGrpc generator",
comments = "Source: cool/houge/grpc/user_group.proto")
public final class ReactorUserGroupGrpc {
    private ReactorUserGroupGrpc() {}

    public static ReactorUserGroupStub newReactorStub(io.grpc.Channel channel) {
        return new ReactorUserGroupStub(channel);
    }

    public static final class ReactorUserGroupStub extends io.grpc.stub.AbstractStub<ReactorUserGroupStub> {
        private UserGroupGrpc.UserGroupStub delegateStub;

        private ReactorUserGroupStub(io.grpc.Channel channel) {
            super(channel);
            delegateStub = UserGroupGrpc.newStub(channel);
        }

        private ReactorUserGroupStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
            delegateStub = UserGroupGrpc.newStub(channel).build(channel, callOptions);
        }

        @Override
        protected ReactorUserGroupStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ReactorUserGroupStub(channel, callOptions);
        }

        public reactor.core.publisher.Mono<cool.houge.grpc.UserGroupPb.ListGidsResponse> listGids(reactor.core.publisher.Mono<cool.houge.grpc.UserGroupPb.ListGidsRequest> reactorRequest) {
            return com.salesforce.reactorgrpc.stub.ClientCalls.oneToOne(reactorRequest, delegateStub::listGids, getCallOptions());
        }

        public reactor.core.publisher.Mono<cool.houge.grpc.UserGroupPb.ListGidsResponse> listGids(cool.houge.grpc.UserGroupPb.ListGidsRequest reactorRequest) {
           return com.salesforce.reactorgrpc.stub.ClientCalls.oneToOne(reactor.core.publisher.Mono.just(reactorRequest), delegateStub::listGids, getCallOptions());
        }

    }

    public static abstract class UserGroupImplBase implements io.grpc.BindableService {

        public reactor.core.publisher.Mono<cool.houge.grpc.UserGroupPb.ListGidsResponse> listGids(reactor.core.publisher.Mono<cool.houge.grpc.UserGroupPb.ListGidsRequest> request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
            return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
                    .addMethod(
                            cool.houge.grpc.UserGroupGrpc.getListGidsMethod(),
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            cool.houge.grpc.UserGroupPb.ListGidsRequest,
                                            cool.houge.grpc.UserGroupPb.ListGidsResponse>(
                                            this, METHODID_LIST_GIDS)))
                    .build();
        }

        protected io.grpc.CallOptions getCallOptions(int methodId) {
            return null;
        }

    }

    public static final int METHODID_LIST_GIDS = 0;

    private static final class MethodHandlers<Req, Resp> implements
            io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
        private final UserGroupImplBase serviceImpl;
        private final int methodId;

        MethodHandlers(UserGroupImplBase serviceImpl, int methodId) {
            this.serviceImpl = serviceImpl;
            this.methodId = methodId;
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
                case METHODID_LIST_GIDS:
                    com.salesforce.reactorgrpc.stub.ServerCalls.oneToOne((cool.houge.grpc.UserGroupPb.ListGidsRequest) request,
                            (io.grpc.stub.StreamObserver<cool.houge.grpc.UserGroupPb.ListGidsResponse>) responseObserver,
                            serviceImpl::listGids);
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
