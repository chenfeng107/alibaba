package cool.houge.infra.service;

import cool.houge.domain.Paging;
import cool.houge.domain.model.Msg;
import cool.houge.domain.msg.MsgDao;
import cool.houge.domain.msg.MsgQuery;
import cool.houge.domain.msg.MsgService;
import java.util.HashSet;
import java.util.Set;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/** @author KK (kzou227@qq.com) */
public class MsgServiceImpl implements MsgService {

  private final MsgDao msgDao;

  public MsgServiceImpl(MsgDao msgDao) {
    this.msgDao = msgDao;
  }

  @Override
  public Mono<Void> insert(Msg msg) {
    var uids = new HashSet<Integer>();
    uids.add(msg.getSender().getId());
    if (msg.getReceiver() != null) {
      uids.add(msg.getReceiver().getId());
    }
    return msgDao.insert(msg, uids);
  }

  @Override
  public Mono<Void> readMessages(int uid, Set<String> messageIds) {
    return null;
  }

  @Override
  public Flux<Msg> queryByUser(MsgQuery q, Paging paging) {
    return null;
  }
}
