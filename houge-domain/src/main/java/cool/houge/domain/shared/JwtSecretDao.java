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
  Mono<Integer> remove(String id);

  /**
   * @param id
   * @return
   */
  Mono<JwtSecret> get(String id);

  /**
   * 返回所有配置的密钥.
   *
   * @return
   */
  Flux<JwtSecret> getAll();
}
