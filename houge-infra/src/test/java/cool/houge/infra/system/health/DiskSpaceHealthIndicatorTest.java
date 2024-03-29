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
package cool.houge.infra.system.health;

import java.io.File;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

/**
 * {@link DiskSpaceHealthIndicator} 单元测试.
 *
 * @author KK (kzou227@qq.com)
 */
class DiskSpaceHealthIndicatorTest {

  @Test
  void health() {
    var path = new File("").getAbsoluteFile();
    var indicator = new DiskSpaceHealthIndicator(path, 1);
    var p = indicator.health();
    StepVerifier.create(p)
        .expectNextMatches(health -> health.getStatus() == HealthStatus.UP)
        .expectComplete()
        .verify();
  }

  @Test
  void healthDown() {
    var path = new File("").getAbsoluteFile();
    var indicator = new DiskSpaceHealthIndicator(path, path.getTotalSpace());
    var p = indicator.health();
    StepVerifier.create(p)
        .expectNextMatches(health -> health.getStatus() == HealthStatus.DOWN)
        .expectComplete()
        .verify();
  }
}
