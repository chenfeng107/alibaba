package cool.houge.rest.controller;

import cool.houge.rest.facade.token.TokenFacade;
import cool.houge.rest.facade.token.TokenInput;
import cool.houge.rest.interceptor.Interceptors;
import cool.houge.rest.web.AbstractRestSupport;
import cool.houge.rest.web.RoutingService;
import javax.inject.Inject;
import reactor.core.publisher.Mono;
import reactor.netty.http.server.HttpServerRequest;
import reactor.netty.http.server.HttpServerResponse;
import reactor.netty.http.server.HttpServerRoutes;

/** @author KK (kzou227@qq.com) */
public class TokenController extends AbstractRestSupport implements RoutingService {

  private final TokenFacade tokenFacade;

  public @Inject TokenController(TokenFacade tokenFacade) {
    this.tokenFacade = tokenFacade;
  }

  @Override
  public void update(HttpServerRoutes routes, Interceptors interceptors) {
    routes.post("/s/token", this::create);
  }

  Mono<Void> create(HttpServerRequest request, HttpServerResponse response) {
    return json(request, TokenInput.class)
        .flatMap(input -> tokenFacade.create(input))
        .flatMap(o -> json(response, o));
  }
}
