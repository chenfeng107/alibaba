package cool.houge.rest.controller.msg;

import cool.houge.rest.interceptor.Interceptors;
import cool.houge.rest.web.AbstractRestSupport;
import cool.houge.rest.web.RoutingService;
import reactor.core.publisher.Mono;
import reactor.netty.http.server.HttpServerRequest;
import reactor.netty.http.server.HttpServerResponse;
import reactor.netty.http.server.HttpServerRoutes;

/**
 * 消息控制器.
 *
 * @author KK (kzou227@qq.com)
 */
public class MsgController extends AbstractRestSupport implements RoutingService {

  @Override
  public void update(HttpServerRoutes routes, Interceptors interceptors) {
    routes.post("/messages/ids", interceptors.token(this::genIds));
    routes.post("/messages/send", interceptors.token(this::send));
  }

  Mono<Void> genIds(HttpServerRequest request, HttpServerResponse response) {
    return Mono.empty();
  }

  Mono<Void> send(HttpServerRequest request, HttpServerResponse response) {
    return Mono.empty();
  }
}
