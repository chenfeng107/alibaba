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
package cool.houge.rest.interceptor;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.UnaryOperator;
import org.reactivestreams.Publisher;
import reactor.netty.http.server.HttpServerRequest;
import reactor.netty.http.server.HttpServerResponse;

/**
 * 拦截器.
 *
 * @author KK (kzou227@qq.com)
 */
public class Interceptors {

  /** 认证拦截器. */
  private final UnaryOperator<BiFunction<HttpServerRequest, HttpServerResponse, Publisher<Void>>>
      tokenFn;
  /** 服务认证拦截器. */
  private final UnaryOperator<BiFunction<HttpServerRequest, HttpServerResponse, Publisher<Void>>>
      akskFn;

  /**
   * 使用拦截回调函数创建实例.
   *
   * @param tokenFn 认证拦截函数
   * @param akskFn 服务认证拦截器
   */
  public Interceptors(
      UnaryOperator<BiFunction<HttpServerRequest, HttpServerResponse, Publisher<Void>>> tokenFn,
      UnaryOperator<BiFunction<HttpServerRequest, HttpServerResponse, Publisher<Void>>> akskFn) {
    Objects.requireNonNull(tokenFn, "[tokenFn]不能为null");
    Objects.requireNonNull(akskFn, "[akskFn]不能为null");
    this.tokenFn = tokenFn;
    this.akskFn = akskFn;
  }

  /**
   * 认证拦截器.
   *
   * @param next 执行成功后的下一个函数
   * @return 认证拦截器
   */
  public BiFunction<HttpServerRequest, HttpServerResponse, Publisher<Void>> token(
      BiFunction<HttpServerRequest, HttpServerResponse, Publisher<Void>> next) {
    return tokenFn.apply(next);
  }

  /**
   * 返回服务认证拦截器.
   *
   * @param next 执行成功后的下一个函数
   * @return 服务认证拦截器
   */
  public BiFunction<HttpServerRequest, HttpServerResponse, Publisher<Void>> aksk(
      BiFunction<HttpServerRequest, HttpServerResponse, Publisher<Void>> next) {
    return akskFn.apply(next);
  }
}
