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
package cool.houge.service.impl;

import cool.houge.Nil;
import cool.houge.service.dto.CreateGroupDTO;
import cool.houge.service.vo.CreateGroupVO;
import cool.houge.service.vo.JoinGroupVO;
import cool.houge.storage.GroupDao;
import cool.houge.storage.entity.Group;
import cool.houge.storage.query.GroupQueryDao;
import javax.inject.Inject;
import org.roaringbitmap.longlong.Roaring64NavigableMap;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import top.yein.chaos.biz.BizCode;
import top.yein.chaos.biz.StacklessBizCodeException;
import cool.houge.service.GroupService;

/**
 * 群组服务实现.
 *
 * @author KK (kzou227@qq.com)
 */
public class GroupServiceImpl implements GroupService {

  private final GroupDao groupDao;
  private final GroupQueryDao groupQueryDao;

  /** 已存在的群组 ID 位图. */
  private Roaring64NavigableMap existingGidBits = Roaring64NavigableMap.bitmapOf();

  /**
   * 使用群组数据接口、群组数据查询接口构造对象.
   *
   * @param groupDao 群组数据接口
   * @param groupQueryDao 群组数据查询接口
   */
  @Inject
  public GroupServiceImpl(GroupDao groupDao, GroupQueryDao groupQueryDao) {
    this.groupDao = groupDao;
    this.groupQueryDao = groupQueryDao;
  }

  @Override
  public Mono<CreateGroupDTO> createGroup(CreateGroupVO vo) {
    var entity =
        Group.builder()
            .id(vo.getId())
            .creatorId(vo.getCreatorId())
            .ownerId(vo.getCreatorId())
            .memberSize(1)
            .build();
    return groupDao
        .insert(entity)
        .doOnSuccess(id -> this.updateGidBits(id, true))
        .map(id -> CreateGroupDTO.builder().id(id).build());
  }

  @Override
  public Mono<Void> deleteGroup(long gid) {
    return groupDao.delete(gid).doOnSuccess(unused -> updateGidBits(gid, false));
  }

  @Override
  public Mono<Nil> existsById(long gid) {
    if (existingGidBits.contains(gid)) {
      return Nil.mono();
    }

    return groupQueryDao.existsById(gid).doOnNext(unused -> updateGidBits(gid, true));
  }

  @Override
  public Mono<Void> joinMember(long gid, JoinGroupVO vo) {
    return existsById(gid)
        .switchIfEmpty(
            Mono.error(() -> new StacklessBizCodeException(BizCode.C404, "不存在的群组[" + gid + "]")))
        .flatMap(unused -> groupDao.joinMember(gid, vo.getUid()));
  }

  @Override
  public Mono<Void> removeMember(long gid, JoinGroupVO vo) {
    return existsById(gid)
        .switchIfEmpty(
            Mono.error(() -> new StacklessBizCodeException(BizCode.C404, "不存在的群组[" + gid + "]")))
        .flatMap(unused -> groupDao.removeMember(gid, vo.getUid()));
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
