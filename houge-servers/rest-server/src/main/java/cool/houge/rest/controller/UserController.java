package cool.houge.rest.controller;

import cool.houge.rest.facade.user.UserFacade;
import cool.houge.rest.facade.user.UserInput;
import cool.houge.rest.interceptor.Interceptors;
import cool.houge.rest.web.AbstractRestSupport;
import cool.houge.rest.web.RoutingService;
import javax.inject.Inject;
import reactor.core.publisher.Mono;
import reactor.netty.http.server.HttpServerRequest;
import reactor.netty.http.server.HttpServerResponse;
import reactor.netty.http.server.HttpServerRoutes;

/**
 * 消息控制器.
 *
 * @author KK (kzou227@qq.com)
 */
public class UserController extends AbstractRestSupport implements RoutingService {

  private final UserFacade userFacade;

  public @Inject UserController(UserFacade userFacade) {
    this.userFacade = userFacade;
  }

  @Override
  public void update(HttpServerRoutes routes, Interceptors interceptors) {
    routes.post("/s/users", this::create);
  }

  /**
   * @param request
   * @param response
   * @return
   */
  Mono<Void> create(HttpServerRequest request, HttpServerResponse response) {
    return json(request, UserInput.class)
        .flatMap(input -> userFacade.create(input))
        .flatMap(o -> json(response, o));
  }
}
