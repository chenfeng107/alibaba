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
package cool.houge.infra.system.info;

import java.util.Objects;
import java.util.Set;
import javax.inject.Inject;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 信息服务实现类.
 *
 * @author KK (kzou227@qq.com)
 */
public class InfoServiceImpl implements InfoService {

  private final Set<InfoContributor> infoContributors;

  /**
   * 使用信息贡献对象列表构造对象.
   *
   * @param contributors 贡献信息的对象列表
   */
  @Inject
  public InfoServiceImpl(Set<InfoContributor> contributors) {
    Objects.requireNonNull(contributors, "contributors 不能为空");
    this.infoContributors = contributors;
  }

  @Override
  public Mono<Info> info() {
    return Mono.defer(
        () -> {
          var builder = new Info.Builder();
          return Flux.fromIterable(infoContributors)
              .flatMap(infoContributor -> infoContributor.contribute(builder))
              .then(Mono.fromSupplier(builder::build));
        });
  }
}
