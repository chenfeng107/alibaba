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
package cool.houge.pivot.handler;

import com.google.common.base.CharMatcher;
import cool.houge.domain.BizCodes;
import cool.houge.domain.repository.group.GroupQueryRepository;
import cool.houge.domain.service.message.MessageStorageService;
import cool.houge.infra.id.MessageIdGenerator;
import cool.houge.pivot.agent.PacketSender;
import cool.houge.pivot.packet.MessagePacketBase;
import cool.houge.util.YeinGid;
import javax.inject.Inject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import reactor.core.publisher.Mono;
import top.yein.chaos.biz.StacklessBizCodeException;

/**
 * 群组消息处理器.
 *
 * @author KK (kzou227@qq.com)
 */
public class GroupMessageHandler implements PacketHandler<MessagePacketBase> {

  private static final Logger log = LogManager.getLogger();

  private final MessageIdGenerator messageIdGenerator;
  private final MessageStorageService messageStorageService;
  private final PacketSender packetSender;
  private final GroupQueryRepository groupQueryRepository;

  /**
   * @param messageIdGenerator
   * @param messageStorageService
   * @param packetSender
   * @param groupQueryRepository
   */
  @Inject
  public GroupMessageHandler(
      MessageIdGenerator messageIdGenerator,
      MessageStorageService messageStorageService,
      PacketSender packetSender,
      GroupQueryRepository groupQueryRepository) {
    this.messageIdGenerator = messageIdGenerator;
    this.messageStorageService = messageStorageService;
    this.packetSender = packetSender;
    this.groupQueryRepository = groupQueryRepository;
  }

  @Override
  public Mono<Void> handle(MessagePacketBase packet) {
    if (packet.getMessageId() == null) {
      // 自动填充消息 ID
      packet.setMessageId(messageIdGenerator.nextId());
      log.debug("自动填充群聊消息 ID, packet={}", packet);
    }
    // 校验 message_id
    if (packet.getMessageId().length() != YeinGid.YEIN_GID_LENGTH) {
      throw new StacklessBizCodeException(BizCodes.C3600, "[message_id]不能为空且必须是一个长度为 15 的字符串");
    }
    if (CharMatcher.whitespace().matchesAnyOf(packet.getMessageId())) {
      throw new StacklessBizCodeException(BizCodes.C3600, "[message_id]不能包含空白字符");
    }
    var gid = packet.getTo();
    return Mono.empty();

    // FIXME
    //    return groupQueryDao
    //        .existsById(gid)
    //        .switchIfEmpty(
    //            Mono.error(
    //                () ->
    //                    new StacklessBizCodeException(
    //                        BizCodes.C3630, Strings.lenientFormat("群组不存在[gid=%s]", gid))))
    //        .doOnNext(uids -> packetSender.sendToGroup(List.of(gid), packet))
    //        .flatMapMany(unused -> groupQueryDao.queryUidByGid(gid))
    //        .collectList()
    //        .filter(uids -> !uids.isEmpty())
    //        .flatMap(
    //            uids -> {
    //              // 存储消息
    //              var entity = MessagePacketHelper.toMessageEntity(packet);
    //              return messageStorageService.store(entity, uids);
    //            })
    //        .then();
  }
}
