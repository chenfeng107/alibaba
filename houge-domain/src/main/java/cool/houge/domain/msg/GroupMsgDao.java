package cool.houge.domain.msg;

import cool.houge.domain.model.GroupMsg;
import reactor.core.publisher.Mono;

/** @author KK (kzou227@qq.com) */
public interface GroupMsgDao {

  /**
   * @param msg
   * @return
   */
  Mono<Integer> insert(GroupMsg msg);
}
