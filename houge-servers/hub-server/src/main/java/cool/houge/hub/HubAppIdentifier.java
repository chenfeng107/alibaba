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
package cool.houge.hub;

import cool.houge.domain.system.AppInstDao;
import cool.houge.infra.system.identifier.AbstractAppIdentifier;
import javax.inject.Inject;
import lombok.extern.log4j.Log4j2;

/**
 * 应用程序标识符接口.
 *
 * @author KK (kzou227@qq.com)
 */
@Log4j2
public class HubAppIdentifier extends AbstractAppIdentifier {

  /**
   * 构造函数.
   *
   * @param appInstDao 应用实例数据访问对象
   */
  @Inject
  public HubAppIdentifier(AppInstDao appInstDao) {
    super(appInstDao);
  }

  @Override
  public String appName() {
    return "houge-hub";
  }
}
