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
package cool.houge.infra.repository.system;

import cool.houge.domain.model.ServerInstance;
import cool.houge.infra.system.identifier.ServerInstanceRepository;
import reactor.core.publisher.Mono;

/**
 * 服务实例数据访问仓库.
 *
 * @author KK (kzou227@qq.com)
 */
public class JooqServerInstanceRepository implements ServerInstanceRepository {

  @Override
  public Mono<Void> insert(ServerInstance entity) {
    return null;
  }

  @Override
  public Mono<Void> delete(int id) {
    return null;
  }

  @Override
  public Mono<Void> update(ServerInstance entity) {
    return null;
  }

  @Override
  public Mono<Void> updateCheckTime(int id) {
    return null;
  }

  @Override
  public Mono<ServerInstance> findById(int id) {
    return null;
  }
}
