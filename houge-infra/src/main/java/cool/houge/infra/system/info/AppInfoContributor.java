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
package cool.houge.infra.system.info;

import com.google.common.collect.ImmutableMap;
import cool.houge.infra.system.identifier.AppIdentifier;
import cool.houge.infra.system.info.Info.Builder;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Map;
import javax.inject.Inject;
import reactor.core.publisher.Mono;

/**
 * 应用信息贡献者实现类.
 *
 * @author KK (kzou227@qq.com)
 */
public class AppInfoContributor implements InfoContributor {

  private final AppIdentifier appIdentifier;

  /**
   * 使用应用标识构造对象.
   *
   * @param appIdentifier 应用标识对象.
   */
  @Inject
  public AppInfoContributor(AppIdentifier appIdentifier) {
    this.appIdentifier = appIdentifier;
  }

  @Override
  public Mono<Void> contribute(Builder builder) {
    return Mono.fromRunnable(() -> builder.withDetail("app", info0()));
  }

  private Map<String, Object> info0() {
    var processInfo = ProcessHandle.current().info();
    var startTime =
        processInfo
            .startInstant()
            .map(instant -> ZonedDateTime.ofInstant(instant, ZoneId.systemDefault()));
    return ImmutableMap.<String, Object>builder()
        .put("name", appIdentifier.appName())
        .put("version", appIdentifier.version())
        .put("fid", appIdentifier.fid())
        .put("work_dir", System.getProperty("user.dir"))
        .put("command", processInfo.command())
        .put("command_line", processInfo.commandLine())
        .put("start_time", startTime)
        .build();
  }
}
