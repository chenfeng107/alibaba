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

import cool.houge.rest.auth.AuthContext;
import cool.houge.rest.facade.token.TokenFacade;
import cool.houge.rest.web.AbstractRestSupport;
import java.util.function.BiFunction;
import javax.inject.Inject;
import lombok.extern.log4j.Log4j2;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.netty.http.server.HttpServerRequest;
import reactor.netty.http.server.HttpServerResponse;
import top.yein.chaos.biz.BizCode;
import top.yein.chaos.biz.BizCodeException;

/**
 * 用户认证拦截器.
 *
 * @author KK (kzou227@qq.com)
 */
@Log4j2
public class TokenInterceptor extends AbstractRestSupport {

  private static final String ACCESS_TOKEN_QUERY_NAME = "access_token";

  private final TokenFacade tokenFacade;

  /**
   * 构造函数.
   *
   * @param tokenFacade
   */
  public @Inject TokenInterceptor(TokenFacade tokenFacade) {
    this.tokenFacade = tokenFacade;
  }

  /**
   * 请求认证.
   *
   * @param next 认证成功后执行的处理函数
   * @return RS
   */
  public BiFunction<HttpServerRequest, HttpServerResponse, Publisher<Void>> handle(
      BiFunction<? super HttpServerRequest, ? super HttpServerResponse, ? extends Publisher<Void>>
          next) {
    return (request, response) ->
        Flux.defer(
            () -> {
              var token = queryParam(request, ACCESS_TOKEN_QUERY_NAME);
              if (token == null || token.isEmpty()) {
                throw new BizCodeException(BizCode.C401, "缺少 access_token");
              }

              return tokenFacade
                  .verify(token)
                  .flatMapMany(
                      uid -> {
                        var ac =
                            new AuthContext() {
                              @Override
                              public int uid() {
                                return uid;
                              }

                              @Override
                              public String token() {
                                return token;
                              }
                            };

                        // 设置用户认证上下文
                        this.setAuthContext(request, ac);
                        return next.apply(request, response);
                      });
            });
  }

  void setAuthContext(HttpServerRequest request, AuthContext ac) {
    request.withConnection(conn -> conn.channel().attr(AUTH_CONTEXT_ATTR).set(ac));
  }
}
