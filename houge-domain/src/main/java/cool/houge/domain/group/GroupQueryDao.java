package cool.houge.domain.group;

import cool.houge.Nil;
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
  Mono<Group> findById(int id);

  /**
   * 查询指定群成员的用户 ID 列表.
   *
   * @param uid 群 ID
   * @return 成员用户 ID
   */
  Flux<Long> findUidByGid(int uid);

  /**
   * 查询指定用户已经关联的群组 IDs.
   *
   * @param uid 用户 ID
   * @return 群组 IDs
   */
  Flux<Long> findGidByUid(int uid);

  /**
   * 使用群组 ID 查询用户是否存在.
   *
   * @param gid 群组 ID
   * @return Nil.mono()/Mono.empty()
   */
  Mono<Nil> existsById(int gid);
}
