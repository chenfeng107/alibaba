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

import static cool.houge.infra.db.Tables.JWT_SECRET;

import cool.houge.domain.model.JwtSecret;
import cool.houge.domain.repository.jwt.JwtSecretRepository;
import javax.inject.Inject;
import org.jooq.DSLContext;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * JWT 密钥存储 - PostgreSQL.
 *
 * @author KK (kzou227@qq.com)
 */
public class JooqJwtSecretRepository implements JwtSecretRepository {

  private final DSLContext dsl;

  @Inject
  public JooqJwtSecretRepository(DSLContext dsl) {
    this.dsl = dsl;
  }

  @Override
  public Mono<Void> insert(JwtSecret model) {
    return Mono.from(
        dsl.insertInto(JWT_SECRET).set(JwtSecretMapper.INSTANCE.map(model))
      )
      .then();
  }

  @Override
  public Mono<Void> delete(String id) {
    return Mono.from(
        dsl.delete(JWT_SECRET).where(JWT_SECRET.ID.eq(id))
      )
      .then();
  }

  @Override
  public Mono<JwtSecret> findById(String id) {
    return Mono.from(
        dsl.selectFrom(JWT_SECRET).where(JWT_SECRET.ID.eq(id))
      )
      .map(JwtSecretMapper.INSTANCE::map);
  }

  @Override
  public Flux<JwtSecret> findAll() {
    return Flux.from(
        dsl.selectFrom(JWT_SECRET)
      )
      .map(JwtSecretMapper.INSTANCE::map);
  }
}
