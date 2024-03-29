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
package cool.houge.infra.id;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;
import cool.houge.infra.system.identifier.AppIdentifier;

/**
 * {@link YeinGidMsgIdGenerator} 单元测试.
 *
 * @author KK (kzou227@qq.com)
 */
class YeinGidUserMsgIdGeneratorTest {

  @Test
  void nextId() {
    var applicationIdentifier = mock(AppIdentifier.class);
    when(applicationIdentifier.fid()).thenReturn(0);

    var messageIdGenerator = new YeinGidMsgIdGenerator(applicationIdentifier);
    assertThat(messageIdGenerator.nextId()).isNotBlank();
  }

  @Test
  void nextIds() {
    var applicationIdentifier = mock(AppIdentifier.class);
    when(applicationIdentifier.fid()).thenReturn(0);

    var messageIdGenerator = new YeinGidMsgIdGenerator(applicationIdentifier);
    var limitRequest = 9;
    var p1 = messageIdGenerator.nextIds().limitRequest(limitRequest);
    StepVerifier.create(p1).expectNextCount(limitRequest).verifyComplete();

    var p2 = messageIdGenerator.nextIds();
    StepVerifier.create(p2).expectNextCount(MsgIdGenerator.REQUEST_IDS_LIMIT).verifyComplete();
  }
}
