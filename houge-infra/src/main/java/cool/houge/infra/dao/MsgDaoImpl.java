package cool.houge.infra.dao;

import cool.houge.domain.model.Msg;
import cool.houge.domain.msg.MsgDao;
import reactor.core.publisher.Mono;

/** @author KK (kzou227@qq.com) */
public class MsgDaoImpl implements MsgDao {

  @Override
  public Mono<Void> insert(Msg msg) {
    return null;
  }
}
