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
package cool.houge.infra.service.message;

import cool.houge.domain.constants.MessageReadStatus;
import cool.houge.domain.Paging;
import cool.houge.domain.model.Message;
import cool.houge.domain.repository.message.MessageQueryRepository;
import cool.houge.domain.repository.message.MessageRepository;
import cool.houge.domain.repository.message.UserMessageQuery;
import cool.houge.domain.service.message.MessageProps;
import cool.houge.domain.service.message.MessageService;
import java.time.LocalDateTime;
import java.util.List;
import javax.inject.Inject;
import lombok.extern.log4j.Log4j2;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 消息服务实现.
 *
 * @author KK (kzou227@qq.com)
 */
@Log4j2
public class MessageServiceImpl implements MessageService {

  private final MessageProps messageProps;
  private final MessageRepository messageRepository;
  private final MessageQueryRepository messageQueryRepository;

  /**
   * 可以被 IoC 容器使用的构造函数.
   *
   * @param messageProps 消息配置
   * @param messageRepository 消息数据接口
   * @param messageQueryRepository 消息查询数据接口
   */
  @Inject
  public MessageServiceImpl(
      MessageProps messageProps,
      MessageRepository messageRepository,
      MessageQueryRepository messageQueryRepository) {
    this.messageProps = messageProps;
    this.messageRepository = messageRepository;
    this.messageQueryRepository = messageQueryRepository;
  }

  @Override
  public Mono<Void> readMessages(long uid, List<String> messageIds) {
    return messageRepository.updateUnreadStatus(uid, messageIds, MessageReadStatus.READ.getCode());
  }

  @Override
  public Flux<Message> queryByUser(UserMessageQuery q, Paging paging) {
    var beginTimeLimit = LocalDateTime.now().minus(messageProps.getPullBeginTimeLimit());
    if (q.getBeginTime() == null || beginTimeLimit.isAfter(q.getBeginTime())) {
      q.setBeginTime(beginTimeLimit);
    }
    return messageQueryRepository.queryByUser(q, paging);
  }
}
