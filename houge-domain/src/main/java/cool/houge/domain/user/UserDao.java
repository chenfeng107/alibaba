package cool.houge.domain.user;

import cool.houge.domain.model.User;
import reactor.core.publisher.Mono;

/** @author KK (kzou227@qq.com) */
public interface UserDao {

  /**
   * @param m
   * @return
   */
  Mono<Integer> insert(User m);
}
