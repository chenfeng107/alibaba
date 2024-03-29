package cool.houge.hub.grpc;

import cool.houge.domain.system.TokenService;
import cool.houge.grpc.CreateTokenRequest;
import cool.houge.grpc.CreateTokenResponse;
import cool.houge.grpc.ReactorTokenGrpc;
import cool.houge.grpc.VerifyTokenRequest;
import cool.houge.grpc.VerifyTokenResponse;
import javax.inject.Inject;
import reactor.core.publisher.Mono;

/** @author KK (kzou227@qq.com) */
public class TokenGrpcImpl extends ReactorTokenGrpc.TokenImplBase {

  private final TokenService tokenService;

  public @Inject TokenGrpcImpl(TokenService tokenService) {
    this.tokenService = tokenService;
  }

  @Override
  public Mono<CreateTokenResponse> create(Mono<CreateTokenRequest> request) {
    return request
        .flatMap(req -> tokenService.generateToken(req.getUid()))
        .map(token -> CreateTokenResponse.newBuilder().setToken(token).build())
        .onErrorMap(ErrorMaps::map);
  }

  @Override
  public Mono<VerifyTokenResponse> verify(Mono<VerifyTokenRequest> request) {
    return request
        .flatMap(
            req -> {
              // 校验令牌的有效性
              return tokenService.verify(req.getToken());
            })
        .map(
            info -> {
              // 响应
              return VerifyTokenResponse.newBuilder().setUid(info.getUid()).build();
            })
        .onErrorMap(ErrorMaps::map);
  }
}
