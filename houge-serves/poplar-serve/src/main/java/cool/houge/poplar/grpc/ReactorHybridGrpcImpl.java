package cool.houge.poplar.grpc;

import cool.houge.grpc.AttachRequest;
import cool.houge.grpc.AttachResponse;
import cool.houge.grpc.AuthRequest;
import cool.houge.grpc.AuthResponse;
import cool.houge.grpc.ListGidsRequest;
import cool.houge.grpc.ListGidsResponse;
import cool.houge.grpc.ReactorHybridGrpc;
import cool.houge.grpc.SendMsgRequest;
import cool.houge.grpc.SendMsgResponse;
import reactor.core.publisher.Mono;

/** @author KK (kzou227@qq.com) */
public class ReactorHybridGrpcImpl extends ReactorHybridGrpc.HybridImplBase {

  @Override
  public Mono<AuthResponse> auth(Mono<AuthRequest> request) {
    return super.auth(request);
  }

  @Override
  public Mono<ListGidsResponse> listGids(Mono<ListGidsRequest> request) {
    return super.listGids(request);
  }

  @Override
  public Mono<SendMsgResponse> sendToUser(Mono<SendMsgRequest> request) {
    return super.sendToUser(request);
  }

  @Override
  public Mono<SendMsgResponse> sendToGroup(Mono<SendMsgRequest> request) {
    return super.sendToGroup(request);
  }

  @Override
  public Mono<AttachResponse> attach(Mono<AttachRequest> request) {
    return super.attach(request);
  }
}
