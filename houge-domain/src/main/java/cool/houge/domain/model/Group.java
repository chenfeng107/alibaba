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
package cool.houge.domain.model;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 群组信息.
 *
 * @author KK (kzou227@qq.com)
 */
@Data
@Accessors(chain = true)
public class Group {

  /** 群组 ID. */
  private Integer id;
  /** 源群组ID. */
  private String originGid;
  /** 群组的用户ID. */
  private List<Integer> memberUids;
  /** 数据版本. */
  private Integer ver;
  /** 创建时间. */
  private LocalDateTime createTime;
  /** 更新时间. */
  private LocalDateTime updateTime;
}
