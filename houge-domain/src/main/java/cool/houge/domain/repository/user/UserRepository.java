package cool.houge.domain.repository.user;

import cool.houge.domain.model.User;
import reactor.core.publisher.Mono;

/**
 * 数据仓库.
 *
 * @author KK (kzou227@qq.com)
 */
public interface UserRepository {

  /**
   * @param model
   * @return
   */
  Mono<Long> insert(User model);
}
