/*
 * Copyright 2019-2020 the original author or authors
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
package cool.houge.rest.resource;

import cool.houge.rest.auth.AuthContext;
import java.security.SecureRandom;

/**
 * 测试专用的 AuthContext.
 *
 * @author KK (kzou227@qq.com)
 */
public class TestAuthContext implements AuthContext {

  final int uid = new SecureRandom().nextInt();

  @Override
  public int uid() {
    return uid;
  }

  @Override
  public String token() {
    return Long.toHexString(uid);
  }
}
