package cool.houge.poplar.grpc;

import cool.houge.grpc.ReactorMsgGrpc;
import cool.houge.grpc.SendMsgRequest;
import cool.houge.grpc.SendMsgResponse;
import reactor.core.publisher.Mono;

/** @author KK (kzou227@qq.com) */
public class MsgGrpcImpl extends ReactorMsgGrpc.MsgImplBase {

  @Override
  public Mono<SendMsgResponse> sendToUser(Mono<SendMsgRequest> request) {
    // 1. 存储消息
    // 2. 分发消息
    return super.sendToUser(request);
  }

  @Override
  public Mono<SendMsgResponse> sendToGroup(Mono<SendMsgRequest> request) {
    return super.sendToGroup(request);
  }
}
