package cool.houge.domain.group;

import cool.houge.domain.model.Group;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/** @author KK (kzou227@qq.com) */
public interface GroupQueryDao {

  /**
   * 查询指定群信息.
   *
   * @param id 群 ID
   * @return 群信息
   */
  Mono<Group> queryById(int id);

  /**
   * 查询指定群成员的用户 ID 列表.
   *
   * @param gid 群 ID
   * @return 成员用户 ID
   */
  Flux<Integer> queryUidByGid(int gid);

  /**
   * 查询指定用户已经关联的群组 IDs.
   *
   * @param uid 用户 ID
   * @return 群组 IDs
   */
  Flux<Integer> queryGidByUid(int uid);
}
