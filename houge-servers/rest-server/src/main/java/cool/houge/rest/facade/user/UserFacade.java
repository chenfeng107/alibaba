package cool.houge.rest.facade.user;

import cool.houge.grpc.CreateUserRequest;
import cool.houge.grpc.ReactorUserGrpc.ReactorUserStub;
import javax.inject.Inject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import reactor.core.publisher.Mono;

/** @author KK (kzou227@qq.com) */
public class UserFacade {

  private static final Logger log = LogManager.getLogger();

  private final ReactorUserStub userStub;

  public @Inject UserFacade(ReactorUserStub userStub) {
    this.userStub = userStub;
  }

  /**
   * @param input
   * @return
   */
  public Mono<UserOutput> create(UserInput input) {
    var builder = CreateUserRequest.newBuilder();
    if (input.getOriginUid() != null) {
      builder.setOriginUid(input.getOriginUid());
    }

    return userStub
        .create(builder.build())
        .map(
            resp -> {
              //
              return new UserOutput().setUid(resp.getUid());
            });
  }
}
