/*
 * Copyright 2019-2020 the original author or authors
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

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import cool.houge.infra.system.identifier.AppIdentifier;
import java.security.SecureRandom;
import java.util.Map;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

/**
 * {@link AppInfoContributor} 单元测试.
 *
 * @author KK (kzou227@qq.com)
 */
class AppInfoContributorTest {

  @Test
  void contribute() {
    var appName = UUID.randomUUID().toString();
    var version = UUID.randomUUID().toString();
    var fid = new SecureRandom().nextInt();

    var identifier = mock(AppIdentifier.class);
    when(identifier.appName()).thenReturn(appName);
    when(identifier.version()).thenReturn(version);
    when(identifier.fid()).thenReturn(fid);

    var contributor = new AppInfoContributor(identifier);
    var builder = new Info.Builder();
    StepVerifier.create(contributor.contribute(builder)).expectComplete().verify();

    var details = builder.build().getDetails();
    Map<String, Object> appInfo = (Map<String, Object>) details.get("app");

    assertThat(appInfo)
        .containsEntry("name", appName)
        .containsEntry("version", version)
        .containsEntry("fid", fid)
        .containsKeys("work_dir", "command", "command_line", "start_time");
  }
}
