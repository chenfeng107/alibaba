package cool.houge.domain.user;

import cool.houge.Nil;
import cool.houge.domain.model.User;
import reactor.core.publisher.Mono;

/** @author KK (kzou227@qq.com) */
public interface UserQueryDao {

  /**
   * 使用用户 ID 查询用户信息.
   *
   * @param id 用户 ID
   * @return 用户信息
   */
  Mono<User> findById(int id);

  /**
   * 使用用户 ID 查询用户是否存在.
   *
   * @param id 用户 ID
   * @return true/false
   */
  Mono<Nil> existsById(int id);
}
