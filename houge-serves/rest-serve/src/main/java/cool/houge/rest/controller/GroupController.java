package cool.houge.rest.controller;

import cool.houge.rest.facade.group.GroupFacade;
import cool.houge.rest.facade.group.GroupInput;
import cool.houge.rest.interceptor.Interceptors;
import cool.houge.rest.web.AbstractRestSupport;
import cool.houge.rest.web.RoutingService;
import javax.inject.Inject;
import reactor.core.publisher.Mono;
import reactor.netty.http.server.HttpServerRequest;
import reactor.netty.http.server.HttpServerResponse;
import reactor.netty.http.server.HttpServerRoutes;

/** @author KK (kzou227@qq.com) */
public class GroupController extends AbstractRestSupport implements RoutingService {

  private final GroupFacade groupFacade;

  public @Inject GroupController(GroupFacade groupFacade) {
    this.groupFacade = groupFacade;
  }

  @Override
  public void update(HttpServerRoutes routes, Interceptors interceptors) {
    routes.post("/s/groups", this::create);
  }

  Mono<Void> create(HttpServerRequest request, HttpServerResponse response) {
    return json(request, GroupInput.class)
        .flatMap(input -> groupFacade.create(input))
        .flatMap(o -> json(response, o));
  }
}
