package cool.houge.rest.controller.token;

import cool.houge.grpc.CreateTokenRequest;
import cool.houge.grpc.ReactorTokenGrpc.ReactorTokenStub;
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

  private final ReactorTokenStub tokenStub;

  public @Inject TokenController(ReactorTokenStub tokenStub) {
    this.tokenStub = tokenStub;
  }

  @Override
  public void update(HttpServerRoutes routes, Interceptors interceptors) {
    routes.post("/s/token", this::create);
  }

  Mono<Void> create(HttpServerRequest request, HttpServerResponse response) {
    return json(request, TokenForm.class)
        .flatMap(
            form -> {
              var builder = CreateTokenRequest.newBuilder().setUid(form.getUid());
              return tokenStub.create(builder.build());
            })
        .flatMap(o -> json(response, o));
  }
}
