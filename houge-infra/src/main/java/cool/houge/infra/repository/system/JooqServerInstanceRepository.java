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

import static cool.houge.infra.db.Tables.SERVER_INSTANCE;

import cool.houge.domain.model.AppInst;
import cool.houge.infra.db.tables.records.ServerInstanceRecord;
import cool.houge.infra.system.identifier.ServerInstanceRepository;
import javax.inject.Inject;
import org.jooq.DSLContext;
import org.jooq.impl.DSL;
import reactor.core.publisher.Mono;

/**
 * 服务实例数据访问仓库.
 *
 * @author KK (kzou227@qq.com)
 */
public class JooqServerInstanceRepository implements ServerInstanceRepository {

  private final DSLContext dsl;

  @Inject
  public JooqServerInstanceRepository(DSLContext dsl) {
    this.dsl = dsl;
  }

  @Override
  public Mono<Void> insert(AppInst model) {
    var record =
        new ServerInstanceRecord()
            .setId(model.getId())
            .setAppName(model.getAppName())
            .setHostName(model.getHostName())
            .setHostAddress(model.getHostAddress())
            .setOsName(model.getOsName())
            .setOsVersion(model.getOsVersion())
            .setOsArch(model.getOsArch())
            .setOsUser(model.getOsUser())
            .setJavaVmName(model.getJavaVmName())
            .setJavaVmVersion(model.getJavaVmVersion())
            .setJavaVmVendor(model.getJavaVmVendor())
            .setWorkDir(model.getWorkDir())
            .setPid(model.getPid());
    return Mono.from(dsl.insertInto(SERVER_INSTANCE).set(record)).then();
  }

  @Override
  public Mono<Void> delete(int id) {
    return Mono.from(dsl.delete(SERVER_INSTANCE).where(SERVER_INSTANCE.ID.eq(id))).then();
  }

  @Override
  public Mono<Void> updateCheckTime(int id) {
    return Mono.from(
            dsl.update(SERVER_INSTANCE)
                .set(SERVER_INSTANCE.CHECK_TIME, DSL.currentLocalDateTime())
                .where(SERVER_INSTANCE.ID.eq(id)))
        .then();
  }

  @Override
  public Mono<AppInst> findById(int id) {
    return Mono.from(dsl.selectFrom(SERVER_INSTANCE).where(SERVER_INSTANCE.ID.eq(id)))
        .map(ServerInstanceMapper.INSTANCE::map);
  }
}
