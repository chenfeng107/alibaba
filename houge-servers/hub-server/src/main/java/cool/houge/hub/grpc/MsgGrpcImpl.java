package cool.houge.hub.grpc;

import cool.houge.domain.model.Group;
import cool.houge.domain.model.GroupMsg;
import cool.houge.domain.model.User;
import cool.houge.domain.model.UserMsg;
import cool.houge.domain.msg.MsgService;
import cool.houge.grpc.BrokerMsg;
import cool.houge.grpc.CreateMsgIdRequest;
import cool.houge.grpc.CreateMsgIdResponse;
import cool.houge.grpc.CreateMsgIdsRequest;
import cool.houge.grpc.CreateMsgIdsResponse;
import cool.houge.grpc.ReactorMsgGrpc;
import cool.houge.grpc.SendMsgRequest;
import cool.houge.grpc.SendMsgResponse;
import cool.houge.infra.id.MsgIdGenerator;
import cool.houge.hub.broker.MsgRouter;
import cool.houge.protos.MsgKind;
import javax.inject.Inject;
import reactor.core.publisher.Mono;

/** @author KK (kzou227@qq.com) */
public class MsgGrpcImpl extends ReactorMsgGrpc.MsgImplBase {

  private final MsgRouter msgRouter;
  private final MsgService msgService;
  private final MsgIdGenerator idGenerator;

  /**
   * @param msgRouter
   * @param msgService
   * @param idGenerator
   */
  public @Inject MsgGrpcImpl(
      MsgRouter msgRouter, MsgService msgService, MsgIdGenerator idGenerator) {
    this.msgRouter = msgRouter;
    this.msgService = msgService;
    this.idGenerator = idGenerator;
  }

  @Override
  public Mono<CreateMsgIdResponse> createId(Mono<CreateMsgIdRequest> request) {
    return request.map(
        req -> {
          var msgId = idGenerator.nextId();
          // FIXME 记录日志
          return CreateMsgIdResponse.newBuilder().setMsgId(msgId).build();
        });
  }

  @Override
  public Mono<CreateMsgIdsResponse> createIds(Mono<CreateMsgIdsRequest> request) {
    return request
        .flatMap(
            req -> {
              return idGenerator.nextIds().take(req.getCount()).collectList();
            })
        .map(ids -> CreateMsgIdsResponse.newBuilder().addAllMsgId(ids).build());
  }

  @Override
  public Mono<SendMsgResponse> sendToUser(Mono<SendMsgRequest> request) {
    return request
        .doOnNext(msg -> sendToBroker(msg, MsgKind.USER))
        .delayUntil(req -> msgService.insert(toUserMsg(req)))
        .thenReturn(SendMsgResponse.getDefaultInstance())
        .onErrorMap(ErrorMaps::map);
  }

  @Override
  public Mono<SendMsgResponse> sendToGroup(Mono<SendMsgRequest> request) {
    return request
        .doOnNext(msg -> sendToBroker(msg, MsgKind.GROUP))
        .delayUntil(req -> msgService.insert(toGroupMsg(req)))
        .thenReturn(SendMsgResponse.getDefaultInstance())
        .onErrorMap(ErrorMaps::map);
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

  UserMsg toUserMsg(SendMsgRequest req) {
    var msg =
        new UserMsg()
            .setId(req.getMsgId())
            //            .setKind(kind.getNumber())
            .setSend(new User().setId(req.getFrom()))
            .setRec(new User().setId(req.getTo()))
            //            .setGroup(group)
            .setContent(req.getContent())
            .setContentType(req.getContentTypeValue())
            .setExtra(req.getExtra());
    return msg;
  }

  GroupMsg toGroupMsg(SendMsgRequest req) {
    var msg =
        new GroupMsg()
            .setId(req.getMsgId())
            .setSend(new User().setId(req.getFrom()))
            .setGroup(new Group().setId(req.getTo()))
            .setContent(req.getContent())
            .setContentType(req.getContentTypeValue())
            .setExtra(req.getExtra());
    return msg;
  }
}
