package cool.houge.domain.group;

import cool.houge.domain.model.Group;
import reactor.core.publisher.Mono;

/** @author KK (kzou227@qq.com) */
public interface GroupDao {

  /**
   * @param m
   * @return
   */
  Mono<Integer> insert(Group m);

  /**
   * @param gid
   * @param uid
   * @return
   */
  Mono<Integer> joinMember(int gid, int uid);

  /**
   * @param gid
   * @param uid
   * @return
   */
  Mono<Integer> removeMember(int gid, int uid);
}
