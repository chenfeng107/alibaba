package cool.houge.domain.shared;

import cool.houge.domain.model.JwtSecret;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/** @author KK (kzou227@qq.com) */
public interface JwtSecretDao {

  /**
   * @param m
   * @return
   */
  Mono<Integer> insert(JwtSecret m);

  /**
   * @param id
   * @return
   */
  Mono<Integer> delete(String id);

  /**
   * @param id
   * @return
   */
  Mono<JwtSecret> findById(String id);

  /** @return */
  Flux<JwtSecret> findAll();
}
