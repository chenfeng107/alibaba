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
package cool.houge.domain;

import top.yein.chaos.biz.BizCode;

/**
 * 业务错误码定义.
 *
 * @author KK (kzou227@qq.com)
 */
public enum BizCodes implements BizCode {

  // ---------------------------------------------------------------------//
  // 3000 - 3020 >> 用户相关的错误码
  // ---------------------------------------------------------------------//
  C3000(409, 6, "用户已存在"),

  // ---------------------------------------------------------------------//
  // 3300 - 3350 >> 会话 TOKEN 相关的错误码
  // ---------------------------------------------------------------------//
  C3300(400, 3, "非法的访问令牌"),
  C3301(400, 3, "已过期的访问令牌"),
  C3309(400, 3, "服务端未发现指定的 JWT KeyID"),

  // ---------------------------------------------------------------------//
  // 3400 - 3420 >> 消息相关错误码
  // ---------------------------------------------------------------------//
  C3400(500, 13, "消息保存失败"),
  ;

  private final int code;
  private final int httpStatus;
  private final int grpcStatus;
  private final String message;

  BizCodes(String message) {
    this(500, 2, message);
  }

  BizCodes(int httpStatus, int grpcStatus, String message) {
    this.grpcStatus = grpcStatus;
    this.code = Integer.parseInt(this.name().substring(1));
    this.httpStatus = httpStatus;
    this.message = message;
  }

  @Override
  public int getCode() {
    return code;
  }

  @Override
  public int getHttpStatus() {
    return httpStatus;
  }

  @Override
  public int getGrpcStatus() {
    return grpcStatus;
  }

  @Override
  public String getMessage() {
    return message;
  }
}
