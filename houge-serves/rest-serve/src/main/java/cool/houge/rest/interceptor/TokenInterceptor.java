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

import cool.houge.grpc.ReactorTokenGrpc.ReactorTokenStub;
import cool.houge.grpc.VerifyTokenRequest;
import cool.houge.rest.auth.AuthContext;
import cool.houge.rest.web.AbstractRestSupport;
import java.util.function.BiFunction;
import javax.inject.Inject;
import lombok.extern.log4j.Log4j2;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.netty.http.server.HttpServerRequest;
import reactor.netty.http.server.HttpServerResponse;
import reactor.util.context.Context;
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

  private final ReactorTokenStub tokenStub;

  /**
   * 构造函数.
   *
   * @param tokenStub
   */
  public @Inject TokenInterceptor(ReactorTokenStub tokenStub) {
    this.tokenStub = tokenStub;
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

              var req = VerifyTokenRequest.newBuilder().setToken(token).build();
              return tokenStub
                  .verify(req)
                  .flatMapMany(
                      resp -> {
                        var uid = resp.getUid();
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

                        return Flux.defer(() -> next.apply(request, response))
                            .contextWrite(Context.of(AUTH_CONTEXT_KEY, ac));
                      });
            });
  }
}
