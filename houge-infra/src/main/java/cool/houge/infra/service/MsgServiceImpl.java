package cool.houge.infra.service;

import cool.houge.domain.BizCodes;
import cool.houge.domain.model.GroupMsg;
import cool.houge.domain.model.UserMsg;
import cool.houge.domain.msg.GroupMsgDao;
import cool.houge.domain.msg.MsgService;
import cool.houge.domain.msg.UserMsgDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import reactor.core.publisher.Mono;
import top.yein.chaos.biz.StacklessBizCodeException;

/** @author KK (kzou227@qq.com) */
public class MsgServiceImpl implements MsgService {

  private static final Logger log = LogManager.getLogger();
  private final UserMsgDao userMsgDao;
  private final GroupMsgDao groupMsgDao;

  public MsgServiceImpl(UserMsgDao userMsgDao, GroupMsgDao groupMsgDao) {
    this.userMsgDao = userMsgDao;
    this.groupMsgDao = groupMsgDao;
  }

  @Override
  public Mono<Void> insert(UserMsg msg) {
    return userMsgDao
        .insert(msg)
        .doOnNext(
            n -> {
              if (n != 1) {
                log.error("用户消息保存失败 {}", msg);
                throw new StacklessBizCodeException(BizCodes.C3400, "用户消息保存失败");
              }
            })
        .then();
  }

  @Override
  public Mono<Void> insert(GroupMsg msg) {
    return groupMsgDao
        .insert(msg)
        .doOnNext(
            n -> {
              if (n != 1) {
                log.error("群组消息保存失败 {}", msg);
                throw new StacklessBizCodeException(BizCodes.C3400, "群组消息保存失败");
              }
            })
        .then();
  }
}
