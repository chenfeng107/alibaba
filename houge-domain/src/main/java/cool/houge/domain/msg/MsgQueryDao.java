package cool.houge.domain.msg;

import cool.houge.domain.model.UserMsg;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/** @author KK (kzou227@qq.com) */
public interface MsgQueryDao {

  /**
   * 使用消息 ID 查询消息.
   *
   * @param id 消息 ID
   * @return 消息
   */
  Mono<UserMsg> queryById(String id);

  /**
   * 分页查询符合用户指定条件的消息.
   *
   * @param q 指定的查询条件
   * @return
   */
  Flux<UserMsg> queryByUser(MsgQuery q);
}
