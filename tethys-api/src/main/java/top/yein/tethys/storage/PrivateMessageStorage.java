package top.yein.tethys.storage;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import top.yein.tethys.entity.PrivateMessage;

/**
 * 私聊消息存储.
 *
 * @author KK (kzou227@qq.com)
 */
public interface PrivateMessageStorage {

  /**
   * 存储私聊消息.
   *
   * @param entity 数据实体
   * @return RS
   */
  Mono<Void> store(PrivateMessage entity);

  /**
   * 将消息设置为已读.
   *
   * @param uid 用户 ID
   * @param messageId 消息 ID
   * @return RS
   */
  Mono<Void> readPrivateMessage(int uid, int messageId);

  /**
   * 查询用户私人聊天消息.
   *
   * @param uid 用户 ID
   * @param limit 返回最大记录数
   * @return 私人消息
   */
  Flux<PrivateMessage> findByUid(int uid, int limit);
}