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
package cool.houge.infra.system.identifier;

import cool.houge.domain.model.AppInst;
import reactor.core.publisher.Mono;

/** @author KK (kzou227@qq.com) */
public interface ServerInstanceRepository {

  /**
   * 新增应用服务实例.
   *
   * @param model 实体
   * @return RS
   */
  Mono<Void> insert(AppInst model);

  /**
   * 删除应用服务实例.
   *
   * @param id 应用 ID
   * @return RS
   */
  Mono<Void> delete(int id);

  /**
   * 更新最后检查时间.
   *
   * @param id 应用 ID
   * @return RS
   */
  Mono<Void> updateCheckTime(int id);

  /**
   * 查询应用服务实例.
   *
   * @param id 应用 ID
   * @return 实体
   */
  Mono<AppInst> findById(int id);
}
