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
  Mono<User> queryById(int id);

  /**
   * 判断指定用户是否存在.
   *
   * <p>如果用户存在则返回一个 {@code Mono<Null>} 实例可用 {@code Mono} 操作符进行消费, 反之则返回 {@code Mono.empty()}.
   *
   * @param uid 用户 ID
   * @return RS
   */
  Mono<Nil> exists(int uid);
}
