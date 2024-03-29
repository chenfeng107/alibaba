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
package cool.houge.rest.web;

import java.nio.file.Path;
import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import javax.annotation.Nullable;
import lombok.extern.log4j.Log4j2;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.netty.http.server.HttpRouteHandlerMetadata;
import reactor.netty.http.server.HttpServerRequest;
import reactor.netty.http.server.HttpServerResponse;
import reactor.netty.http.server.HttpServerRoutes;

/**
 * {@link HttpServerRoutes} 包装器.
 *
 * @author KK (kzou227@qq.com)
 */
@Log4j2
public class HttpServerRoutesWrapper implements HttpServerRoutes {

  private final HttpServerRoutes delegate;
  private final HttpExceptionHandler httpExceptionHandler;

  /**
   * 构造函数.
   *
   * @param delegate 被包装的路由对象
   */
  public HttpServerRoutesWrapper(HttpServerRoutes delegate) {
    this(delegate, new HttpExceptionHandler());
  }

  /**
   * 使用 routes、异常处理器构造对象.
   *
   * @param delegate HTTP routes
   * @param httpExceptionHandler 异常处理器
   */
  public HttpServerRoutesWrapper(
      HttpServerRoutes delegate, HttpExceptionHandler httpExceptionHandler) {
    this.delegate = delegate;
    this.httpExceptionHandler = httpExceptionHandler;
  }

  @Override
  public HttpServerRoutes directory(
      String uri,
      Path directory,
      @Nullable Function<HttpServerResponse, HttpServerResponse> interceptor) {
    return delegate.directory(uri, directory, interceptor);
  }

  @Override
  public HttpServerRoutes removeIf(Predicate<? super HttpRouteHandlerMetadata> condition) {
    return delegate.removeIf(condition);
  }

  @Override
  public HttpServerRoutes route(
      Predicate<? super HttpServerRequest> condition,
      BiFunction<? super HttpServerRequest, ? super HttpServerResponse, ? extends Publisher<Void>>
          handler) {
    return delegate.route(condition, handler);
  }

  @Override
  public HttpServerRoutes comparator(Comparator<HttpRouteHandlerMetadata> comparator) {
    return delegate.comparator(comparator);
  }

  @Override
  public HttpServerRoutes noComparator() {
    return delegate.noComparator();
  }

  @Override
  public Publisher<Void> apply(HttpServerRequest request, HttpServerResponse response) {
    return Flux.defer(() -> delegate.apply(request, response))
        .onErrorResume(t -> httpExceptionHandler.apply(request, response, t));
  }
}
