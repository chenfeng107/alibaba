package cool.houge.rest.controller.user;

import cool.houge.grpc.CreateUserRequest;
import cool.houge.grpc.ReactorUserGrpc.ReactorUserStub;
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

  private final ReactorUserStub userStub;

  public @Inject UserController(ReactorUserStub userStub) {
    this.userStub = userStub;
  }

  @Override
  public void update(HttpServerRoutes routes, Interceptors interceptors) {
    routes.post("/s/users", this::create);
  }

  Mono<Void> create(HttpServerRequest request, HttpServerResponse response) {
    return json(request, UserForm.class)
        .flatMap(
            form -> {
              var builder = CreateUserRequest.newBuilder();
              if (form.getOriginUid() != null) {
                builder.setOriginUid(form.getOriginUid());
              }
              return userStub.create(builder.build());
            })
        .flatMap(o -> json(response, o));
  }
}
