package cool.houge.infra.service;

import cool.houge.domain.Paging;
import cool.houge.domain.model.UserMsg;
import cool.houge.domain.msg.UserMsgDao;
import cool.houge.domain.msg.MsgQuery;
import cool.houge.domain.msg.MsgService;
import java.util.HashSet;
import java.util.Set;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/** @author KK (kzou227@qq.com) */
public class MsgServiceImpl implements MsgService {

  private final UserMsgDao userMsgDao;

  public MsgServiceImpl(UserMsgDao userMsgDao) {
    this.userMsgDao = userMsgDao;
  }

  @Override
  public Mono<Void> insert(UserMsg msg) {
    var uids = new HashSet<Integer>();
    uids.add(msg.getSend().getId());
    if (msg.getRec() != null) {
      uids.add(msg.getRec().getId());
    }
    //    return msgDao.insert(msg, uids);
    return null;
  }

  @Override
  public Mono<Void> readMessages(int uid, Set<String> messageIds) {
    return null;
  }

  @Override
  public Flux<UserMsg> queryByUser(MsgQuery q, Paging paging) {
    return null;
  }
}
