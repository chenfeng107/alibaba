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
package cool.houge.infra.service.group;

import cool.houge.Nil;
import cool.houge.domain.repository.group.GroupQueryRepository;
import cool.houge.domain.repository.group.GroupRepository;
import cool.houge.domain.service.group.CreateGroupInput;
import cool.houge.domain.service.group.CreateGroupResult;
import cool.houge.domain.service.group.GroupService;
import cool.houge.domain.service.group.JoinMemberInput;
import javax.inject.Inject;
import org.roaringbitmap.longlong.Roaring64NavigableMap;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import top.yein.chaos.biz.BizCode;
import top.yein.chaos.biz.StacklessBizCodeException;

/**
 * 群组服务实现.
 *
 * @author KK (kzou227@qq.com)
 */
public class GroupServiceImpl implements GroupService {

  private final GroupRepository groupRepository;
  private final GroupQueryRepository groupQueryRepository;

  /** 已存在的群组 ID 位图. */
  private Roaring64NavigableMap existingGidBits = Roaring64NavigableMap.bitmapOf();

  /**
   * 使用群组数据接口、群组数据查询接口构造对象.
   *
   * @param groupRepository 群组数据接口
   * @param groupQueryRepository 群组数据查询接口
   */
  @Inject
  public GroupServiceImpl(
      GroupRepository groupRepository, GroupQueryRepository groupQueryRepository) {
    this.groupRepository = groupRepository;
    this.groupQueryRepository = groupQueryRepository;
  }

  @Override
  public Mono<CreateGroupResult> create(CreateGroupInput in) {
    return Mono.empty();
    //    var entity =
    //        new Group()
    //            .setId(in.getGid())
    //            // FIXME
    //            //            .creatorId(in.getCreatorId())
    //            //            .ownerId(in.getCreatorId())
    //            .setMemberSize(1);
    //    return groupRepository
    //        .insert(entity)
    //        .doOnSuccess(id -> this.updateGidBits(id, true))
    //        .map(id -> CreateGroupResult.builder().gid(id).build());
  }

  @Override
  public Mono<Void> delete(long gid) {
    return groupRepository.delete(gid).doOnSuccess(unused -> updateGidBits(gid, false));
  }

  @Override
  public Mono<Nil> existsById(long gid) {
    if (existingGidBits.contains(gid)) {
      return Nil.mono();
    }

    return groupQueryRepository.existsById(gid).doOnNext(unused -> updateGidBits(gid, true));
  }

  @Override
  public Mono<Void> joinMember(JoinMemberInput p) {
    return existsById(p.getGid())
        .switchIfEmpty(
            Mono.error(
                () -> new StacklessBizCodeException(BizCode.C404, "不存在的群组[" + p.getGid() + "]")))
        .flatMap(unused -> groupRepository.joinMember(p.getGid(), p.getUid()));
  }

  @Override
  public Mono<Void> deleteMember(JoinMemberInput p) {
    return existsById(p.getGid())
        .switchIfEmpty(
            Mono.error(
                () -> new StacklessBizCodeException(BizCode.C404, "不存在的群组[" + p.getGid() + "]")))
        .flatMap(unused -> groupRepository.removeMember(p.getGid(), p.getUid()));
  }

  private void updateGidBits(long gid, boolean v) {
    // existingGidBits 是非线程安全的对象
    // 将对 existingGidBits 所有的更新操作放置在同一个线程中避免额外的 Lock
    Mono.fromRunnable(
            () -> {
              if (v) {
                existingGidBits.addLong(gid);
              } else {
                existingGidBits.removeLong(gid);
              }
            })
        .subscribeOn(Schedulers.single())
        .subscribe();
  }
}
