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
package cool.houge.ws.pivot.command;

import cool.houge.grpc.broker.BrokerPb;
import reactor.core.publisher.Mono;

/**
 * 命令处理器接口.
 *
 * @author KK (kzou227@qq.com)
 */
public interface CommandHandler {

  /**
   * 命令处理函数.
   *
   * @param command 命令
   */
  Mono<Void> handle(BrokerPb.Command command);
}