package cool.houge.domain.user;

import cool.houge.domain.model.User;
import reactor.core.publisher.Mono;

/**
 * 用户数据访问接口.
 *
 * @author KK (kzou227@qq.com)
 */
public interface UserDao {

  /**
   * 保存用户信息.
   *
   * @param m 用户实体
   * @return 用户 ID
   */
  Mono<Integer> insert(User m);
}
