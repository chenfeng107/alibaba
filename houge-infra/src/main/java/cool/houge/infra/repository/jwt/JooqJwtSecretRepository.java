/*
 * Copyright 2019-2021 the original author or authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cool.houge.infra.repository.jwt;

import cool.houge.domain.model.JwtSecret;
import cool.houge.domain.repository.jwt.JwtSecretRepository;
import lombok.extern.log4j.Log4j2;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * JWT 密钥存储 - PostgreSQL.
 *
 * @author KK (kzou227@qq.com)
 */
@Log4j2
public class JooqJwtSecretRepository implements JwtSecretRepository {

  @Override
  public Mono<Void> insert(JwtSecret entity) {
    return null;
  }

  @Override
  public Mono<Void> delete(String id) {
    return null;
  }

  @Override
  public Mono<JwtSecret> findById(String id) {
    return null;
  }

  @Override
  public Flux<JwtSecret> findAll() {
    return null;
  }
}
