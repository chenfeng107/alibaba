package cool.houge.domain.group;

import cool.houge.domain.entity.Group;
import reactor.core.publisher.Mono;

/** @author KK (kzou227@qq.com) */
public interface GroupRepository {

  /**
   * 保存群组信息.
   *
   * @param entity 群实体
   * @return 群组 ID
   */
  Mono<Long> insert(Group entity);

  /**
   * 删除群组.
   *
   * @param gid 群组 ID
   * @return RS
   */
  Mono<Void> delete(long gid);

  /**
   * 在指定的群中将指定用户设置为群成员.
   *
   * @param gid 群组 ID
   * @param uid 用户 ID
   * @return RS
   */
  Mono<Void> joinMember(long gid, long uid);

  /**
   * 将指定的群组中的指定用户移除.
   *
   * @param gid 群组 ID
   * @param uid 用户 ID
   * @return RS
   */
  Mono<Void> removeMember(long gid, long uid);
}
