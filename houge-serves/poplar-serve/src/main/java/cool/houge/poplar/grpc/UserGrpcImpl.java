package cool.houge.poplar.grpc;

import cool.houge.domain.model.User;
import cool.houge.domain.user.UserService;
import cool.houge.grpc.CreateUserRequest;
import cool.houge.grpc.CreateUserResponse;
import cool.houge.grpc.ReactorUserGrpc;
import javax.inject.Inject;
import reactor.core.publisher.Mono;

/**
 * 用户gRPC服务实现.
 *
 * @author KK (kzou227@qq.com)
 */
public class UserGrpcImpl extends ReactorUserGrpc.UserImplBase {

  private final UserService userService;

  public @Inject UserGrpcImpl(UserService userService) {
    this.userService = userService;
  }

  @Override
  public Mono<CreateUserResponse> create(Mono<CreateUserRequest> request) {
    return request
        .map(req -> new User().setOriginUid(req.getOriginUid()))
        .flatMap(userService::create)
        .map(uid -> CreateUserResponse.newBuilder().setUid(uid).build())
        .onErrorMap(ErrorMaps::map);
  }
}
