package cool.houge.domain.msg;

import cool.houge.domain.model.Msg;
import reactor.core.publisher.Mono;

/** @author KK (kzou227@qq.com) */
public interface MsgDao {

  /**
   * @param msg
   * @return
   */
  Mono<Void> insert(Msg msg);
}
