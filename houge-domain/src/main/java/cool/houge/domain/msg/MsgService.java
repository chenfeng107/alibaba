package cool.houge.domain.msg;

import cool.houge.domain.Paging;
import cool.houge.domain.model.UserMsg;
import java.util.Set;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/** @author KK (kzou227@qq.com) */
public interface MsgService {

  /**
   *
   * @param msg
   * @return
   */
  Mono<Void> insert(UserMsg msg);

  /**
   * 将指定用户的消息批量设置为已读状态.
   *
   * @param uid 用户 ID
   * @param messageIds 消息 IDs
   * @return RS
   */
  Mono<Void> readMessages(int uid, Set<String> messageIds);

  /**
   * 分页查询符合用户指定条件的消息.
   *
   * @param q 指定的查询条件
   * @param paging 分页
   * @return
   */
  Flux<UserMsg> queryByUser(MsgQuery q, Paging paging);
}
