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
package cool.houge.service;

import cool.houge.Nil;
import lombok.Builder;
import lombok.Value;
import reactor.core.publisher.Mono;

/**
 * 群组服务接口.
 *
 * @author KK (kzou227@qq.com)
 */
public interface GroupService {

  /**
   * 创建群组.
   *
   * @param vo VO
   * @return 群组 ID
   */
  Mono<CreateResult> create(Create vo);

  /**
   * 删除群组.
   *
   * @param gid 群组 ID
   * @return RS
   */
  Mono<Void> delete(long gid);

  /**
   * 判断指定的群组是否存在.
   *
   * <p>如果用户存在则返回一个 {@code Mono<Nil>} 实例可用 {@code Mono} 操作符进行消费, 反之则返回 {@code Mono.empty()}.
   *
   * @param gid 群组 ID
   * @return Nil.mono()/Mono.empty()
   */
  Mono<Nil> existsById(long gid);

  /**
   * 将指定的用户与群组建立关系.
   *
   * @param p VO
   * @return RS
   */
  Mono<Void> joinMember(JoinMember p);

  /**
   * 将指定的用户与群组解除关系.
   *
   * @param p VO
   * @return RS
   */
  Mono<Void> deleteMember(JoinMember p);

  /** 创建群组对象. */
  @Value
  @Builder
  class Create {

    /** 群组 ID. */
    private Long gid;
    /** 创建者用户 ID. */
    private long creatorId;
    /** 群组名称. */
    private String name;
  }

  /** 创建群组返回对象. */
  @Value
  @Builder
  class CreateResult {

    /** 群组 ID. */
    private Long gid;
  }

  /** 加入群组请求参数对象. */
  @Value
  @Builder
  class JoinMember {

    /** 群组ID. */
    private long gid;
    /** 用户ID. */
    private long uid;
  }
}
