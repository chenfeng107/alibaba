package cool.houge.rest.facade.token;

import cool.houge.grpc.CreateTokenRequest;
import cool.houge.grpc.ReactorTokenGrpc.ReactorTokenStub;
import cool.houge.grpc.VerifyTokenRequest;
import cool.houge.grpc.VerifyTokenResponse;
import javax.inject.Inject;
import reactor.core.publisher.Mono;

/** @author KK (kzou227@qq.com) */
public class TokenFacade {

  private final ReactorTokenStub tokenStub;

  public @Inject TokenFacade(ReactorTokenStub tokenStub) {
    this.tokenStub = tokenStub;
  }

  /**
   * @param token
   * @return
   */
  public Mono<Integer> verify(String token) {
    var req = VerifyTokenRequest.newBuilder().setToken(token).build();
    return tokenStub.verify(req).map(VerifyTokenResponse::getUid);
  }

  /**
   * @param input
   * @return
   */
  public Mono<TokenOutput> create(TokenInput input) {
    var req = CreateTokenRequest.newBuilder().setUid(input.getUid()).build();
    return tokenStub.create(req).map(resp -> new TokenOutput().setToken(resp.getToken()));
  }
}
