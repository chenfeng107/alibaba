package cool.houge.poplar.grpc;

import cool.houge.domain.model.Group;
import cool.houge.domain.model.User;
import cool.houge.domain.model.UserMsg;
import cool.houge.domain.msg.MsgService;
import cool.houge.grpc.BrokerMsg;
import cool.houge.grpc.CreateMsgIdRequest;
import cool.houge.grpc.CreateMsgIdResponse;
import cool.houge.grpc.ReactorMsgGrpc;
import cool.houge.grpc.SendMsgRequest;
import cool.houge.grpc.SendMsgResponse;
import cool.houge.infra.id.MsgIdGenerator;
import cool.houge.poplar.broker.MsgRouter;
import cool.houge.protos.MsgKind;
import javax.inject.Inject;
import reactor.core.publisher.Mono;

/** @author KK (kzou227@qq.com) */
public class MsgGrpcImpl extends ReactorMsgGrpc.MsgImplBase {

  private final MsgRouter msgRouter;
  private final MsgService msgService;
  private final MsgIdGenerator msgIdGenerator;

  /**
   * @param msgRouter
   * @param msgService
   * @param msgIdGenerator
   */
  public @Inject MsgGrpcImpl(
      MsgRouter msgRouter, MsgService msgService, MsgIdGenerator msgIdGenerator) {
    this.msgRouter = msgRouter;
    this.msgService = msgService;
    this.msgIdGenerator = msgIdGenerator;
  }

  @Override
  public Mono<CreateMsgIdResponse> createId(Mono<CreateMsgIdRequest> request) {
    return request.map(
        req -> {
          var msgId = msgIdGenerator.nextId();
          // FIXME 记录日志
          return CreateMsgIdResponse.newBuilder().setMsgId(msgId).build();
        });
  }

  @Override
  public Mono<SendMsgResponse> sendToUser(Mono<SendMsgRequest> request) {
    return execute(request, MsgKind.USER).onErrorMap(ErrorMaps::map);
  }

  @Override
  public Mono<SendMsgResponse> sendToGroup(Mono<SendMsgRequest> request) {
    return execute(request, MsgKind.GROUP).onErrorMap(ErrorMaps::map);
  }

  Mono<SendMsgResponse> execute(Mono<SendMsgRequest> request, MsgKind kind) {
    return request
        .doOnNext(msg -> sendToBroker(msg, kind))
        .flatMap(
            msg -> {
              // 保存消息
              return saveMsg(msg, kind);
            })
        .thenReturn(SendMsgResponse.getDefaultInstance());
  }

  Mono<Void> saveMsg(SendMsgRequest req, MsgKind kind) {
    User receiver = null;
    if (kind == MsgKind.USER) {
      receiver = new User().setId(req.getTo());
    }
    Group group = null;
    if (kind == MsgKind.GROUP) {
      group = new Group().setId(req.getTo());
    }

    var msg =
        new UserMsg()
            .setId(req.getMsgId())
            //            .setKind(kind.getNumber())
            .setSend(new User().setId(req.getFrom()))
            .setRec(receiver)
            //            .setGroup(group)
            .setContent(req.getContent())
            .setContentType(req.getContentTypeValue())
            .setExtra(req.getExtra());
    return msgService.insert(msg);
  }

  void sendToBroker(SendMsgRequest req, MsgKind kind) {
    var builder = BrokerMsg.newBuilder();
    builder
        .setKind(kind)
        .setMsgId(req.getMsgId())
        .setFrom(req.getFrom())
        .setTo(req.getTo())
        .setContentBytes(req.getContentBytes())
        .setContentType(req.getContentType())
        .setExtraBytes(req.getExtraBytes());
    msgRouter.run(builder.build());
  }
}
