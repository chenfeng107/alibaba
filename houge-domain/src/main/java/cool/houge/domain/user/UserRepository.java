package cool.houge.domain.user;

import cool.houge.domain.entity.User;
import reactor.core.publisher.Mono;

/**
 * 数据仓库.
 *
 * @author KK (kzou227@qq.com)
 */
public interface UserRepository {

  /**
   * @param entity
   * @return
   */
  Mono<Void> insert(User entity);
}
