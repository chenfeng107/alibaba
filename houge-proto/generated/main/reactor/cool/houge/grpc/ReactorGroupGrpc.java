package cool.houge.grpc;

import static cool.houge.grpc.GroupGrpc.getServiceDescriptor;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;


@javax.annotation.Generated(
value = "by ReactorGrpc generator",
comments = "Source: cool/houge/grpc/group.proto")
public final class ReactorGroupGrpc {
    private ReactorGroupGrpc() {}

    public static ReactorGroupStub newReactorStub(io.grpc.Channel channel) {
        return new ReactorGroupStub(channel);
    }

    public static final class ReactorGroupStub extends io.grpc.stub.AbstractStub<ReactorGroupStub> {
        private GroupGrpc.GroupStub delegateStub;

        private ReactorGroupStub(io.grpc.Channel channel) {
            super(channel);
            delegateStub = GroupGrpc.newStub(channel);
        }

        private ReactorGroupStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
            delegateStub = GroupGrpc.newStub(channel).build(channel, callOptions);
        }

        @Override
        protected ReactorGroupStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ReactorGroupStub(channel, callOptions);
        }

        /**
         * <pre>
         *  源群组ID
         * </pre>
         */
        public reactor.core.publisher.Mono<cool.houge.grpc.CreateGroupResponse> create(reactor.core.publisher.Mono<cool.houge.grpc.CreateGroupRequest> reactorRequest) {
            return com.salesforce.reactorgrpc.stub.ClientCalls.oneToOne(reactorRequest, delegateStub::create, getCallOptions());
        }

        /**
         * <pre>
         *  成员用户IDs
         * </pre>
         */
        public reactor.core.publisher.Mono<com.google.protobuf.Empty> delete(reactor.core.publisher.Mono<cool.houge.grpc.DeleteGroupRequest> reactorRequest) {
            return com.salesforce.reactorgrpc.stub.ClientCalls.oneToOne(reactorRequest, delegateStub::delete, getCallOptions());
        }

        /**
         * <pre>
         *  将用户加入到指定的群组
         * </pre>
         */
        public reactor.core.publisher.Mono<com.google.protobuf.Empty> joinMember(reactor.core.publisher.Mono<cool.houge.grpc.JoinMemberGroupRequest> reactorRequest) {
            return com.salesforce.reactorgrpc.stub.ClientCalls.oneToOne(reactorRequest, delegateStub::joinMember, getCallOptions());
        }

        /**
         * <pre>
         *  将用户从指定的群组中删除
         * </pre>
         */
        public reactor.core.publisher.Mono<com.google.protobuf.Empty> deleteMember(reactor.core.publisher.Mono<cool.houge.grpc.DeleteMemberGroupRequest> reactorRequest) {
            return com.salesforce.reactorgrpc.stub.ClientCalls.oneToOne(reactorRequest, delegateStub::deleteMember, getCallOptions());
        }

        /**
         * <pre>
         *  源群组ID
         * </pre>
         */
        public reactor.core.publisher.Mono<cool.houge.grpc.CreateGroupResponse> create(cool.houge.grpc.CreateGroupRequest reactorRequest) {
           return com.salesforce.reactorgrpc.stub.ClientCalls.oneToOne(reactor.core.publisher.Mono.just(reactorRequest), delegateStub::create, getCallOptions());
        }

        /**
         * <pre>
         *  成员用户IDs
         * </pre>
         */
        public reactor.core.publisher.Mono<com.google.protobuf.Empty> delete(cool.houge.grpc.DeleteGroupRequest reactorRequest) {
           return com.salesforce.reactorgrpc.stub.ClientCalls.oneToOne(reactor.core.publisher.Mono.just(reactorRequest), delegateStub::delete, getCallOptions());
        }

        /**
         * <pre>
         *  将用户加入到指定的群组
         * </pre>
         */
        public reactor.core.publisher.Mono<com.google.protobuf.Empty> joinMember(cool.houge.grpc.JoinMemberGroupRequest reactorRequest) {
           return com.salesforce.reactorgrpc.stub.ClientCalls.oneToOne(reactor.core.publisher.Mono.just(reactorRequest), delegateStub::joinMember, getCallOptions());
        }

        /**
         * <pre>
         *  将用户从指定的群组中删除
         * </pre>
         */
        public reactor.core.publisher.Mono<com.google.protobuf.Empty> deleteMember(cool.houge.grpc.DeleteMemberGroupRequest reactorRequest) {
           return com.salesforce.reactorgrpc.stub.ClientCalls.oneToOne(reactor.core.publisher.Mono.just(reactorRequest), delegateStub::deleteMember, getCallOptions());
        }

    }

    public static abstract class GroupImplBase implements io.grpc.BindableService {

        /**
         * <pre>
         *  源群组ID
         * </pre>
         */
        public reactor.core.publisher.Mono<cool.houge.grpc.CreateGroupResponse> create(reactor.core.publisher.Mono<cool.houge.grpc.CreateGroupRequest> request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        /**
         * <pre>
         *  成员用户IDs
         * </pre>
         */
        public reactor.core.publisher.Mono<com.google.protobuf.Empty> delete(reactor.core.publisher.Mono<cool.houge.grpc.DeleteGroupRequest> request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        /**
         * <pre>
         *  将用户加入到指定的群组
         * </pre>
         */
        public reactor.core.publisher.Mono<com.google.protobuf.Empty> joinMember(reactor.core.publisher.Mono<cool.houge.grpc.JoinMemberGroupRequest> request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        /**
         * <pre>
         *  将用户从指定的群组中删除
         * </pre>
         */
        public reactor.core.publisher.Mono<com.google.protobuf.Empty> deleteMember(reactor.core.publisher.Mono<cool.houge.grpc.DeleteMemberGroupRequest> request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
            return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
                    .addMethod(
                            cool.houge.grpc.GroupGrpc.getCreateMethod(),
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            cool.houge.grpc.CreateGroupRequest,
                                            cool.houge.grpc.CreateGroupResponse>(
                                            this, METHODID_CREATE)))
                    .addMethod(
                            cool.houge.grpc.GroupGrpc.getDeleteMethod(),
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            cool.houge.grpc.DeleteGroupRequest,
                                            com.google.protobuf.Empty>(
                                            this, METHODID_DELETE)))
                    .addMethod(
                            cool.houge.grpc.GroupGrpc.getJoinMemberMethod(),
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            cool.houge.grpc.JoinMemberGroupRequest,
                                            com.google.protobuf.Empty>(
                                            this, METHODID_JOIN_MEMBER)))
                    .addMethod(
                            cool.houge.grpc.GroupGrpc.getDeleteMemberMethod(),
                            asyncUnaryCall(
                                    new MethodHandlers<
                                            cool.houge.grpc.DeleteMemberGroupRequest,
                                            com.google.protobuf.Empty>(
                                            this, METHODID_DELETE_MEMBER)))
                    .build();
        }

        protected io.grpc.CallOptions getCallOptions(int methodId) {
            return null;
        }

    }

    public static final int METHODID_CREATE = 0;
    public static final int METHODID_DELETE = 1;
    public static final int METHODID_JOIN_MEMBER = 2;
    public static final int METHODID_DELETE_MEMBER = 3;

    private static final class MethodHandlers<Req, Resp> implements
            io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
            io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
        private final GroupImplBase serviceImpl;
        private final int methodId;

        MethodHandlers(GroupImplBase serviceImpl, int methodId) {
            this.serviceImpl = serviceImpl;
            this.methodId = methodId;
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch (methodId) {
                case METHODID_CREATE:
                    com.salesforce.reactorgrpc.stub.ServerCalls.oneToOne((cool.houge.grpc.CreateGroupRequest) request,
                            (io.grpc.stub.StreamObserver<cool.houge.grpc.CreateGroupResponse>) responseObserver,
                            serviceImpl::create);
                    break;
                case METHODID_DELETE:
                    com.salesforce.reactorgrpc.stub.ServerCalls.oneToOne((cool.houge.grpc.DeleteGroupRequest) request,
                            (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver,
                            serviceImpl::delete);
                    break;
                case METHODID_JOIN_MEMBER:
                    com.salesforce.reactorgrpc.stub.ServerCalls.oneToOne((cool.houge.grpc.JoinMemberGroupRequest) request,
                            (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver,
                            serviceImpl::joinMember);
                    break;
                case METHODID_DELETE_MEMBER:
                    com.salesforce.reactorgrpc.stub.ServerCalls.oneToOne((cool.houge.grpc.DeleteMemberGroupRequest) request,
                            (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver,
                            serviceImpl::deleteMember);
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
