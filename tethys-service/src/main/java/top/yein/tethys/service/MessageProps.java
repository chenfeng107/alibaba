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
package top.yein.tethys.service;

import java.time.Duration;
import lombok.Builder;
import lombok.Value;

/**
 * 消息配置.
 *
 * @author KK (kzou227@qq.com)
 */
@Value
@Builder
public class MessageProps {

  /** 消息可拉取的最早时间限制. */
  private Duration pullBeginTimeLimit;
}
