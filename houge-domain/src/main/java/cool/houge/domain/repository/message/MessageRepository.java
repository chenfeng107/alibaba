package cool.houge.domain.repository.message;

import cool.houge.domain.model.Msg;
import java.util.List;
import reactor.core.publisher.Mono;

public interface MessageRepository {

  /**
   * 保存消息并与用户进行关联.
   *
   * @param entity 消息实体
   * @param uids 关联的用户 IDs
   * @return 受影响行数
   */
  Mono<Void> insert(Msg entity, List<Long> uids);

  /**
   * 批量将用户的消息 {@code unread} 修改为指定状态.
   *
   * @param uid 用户 ID
   * @param messageIds 消息 IDs
   * @param v 状态
   * @return RS
   */
  Mono<Void> updateUnreadStatus(long uid, List<String> messageIds, int v);
}
