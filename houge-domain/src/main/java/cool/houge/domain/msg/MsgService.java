package cool.houge.domain.msg;

import cool.houge.domain.model.GroupMsg;
import cool.houge.domain.model.UserMsg;
import reactor.core.publisher.Mono;

/**
 * 消息服务.
 *
 * @author KK (kzou227@qq.com)
 */
public interface MsgService {

  /**
   * @param msg
   * @return
   */
  Mono<Void> insert(UserMsg msg);

  /**
   * @param msg
   * @return
   */
  Mono<Void> insert(GroupMsg msg);
}
