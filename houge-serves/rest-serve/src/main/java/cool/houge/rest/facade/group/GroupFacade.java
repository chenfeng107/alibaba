package cool.houge.rest.facade.group;

import cool.houge.grpc.CreateGroupRequest;
import cool.houge.grpc.ReactorGroupGrpc.ReactorGroupStub;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.inject.Inject;
import reactor.core.publisher.Mono;

/** @author KK (kzou227@qq.com) */
public class GroupFacade {

  private final ReactorGroupStub groupStub;

  public @Inject GroupFacade(ReactorGroupStub groupStub) {
    this.groupStub = groupStub;
  }

  /**
   * @param input
   * @return
   */
  public Mono<GroupOutput> create(GroupInput input) {
    var builder = CreateGroupRequest.newBuilder();
    if (input.getOriginGid() != null) {
      builder.setOriginGid(input.getOriginGid());
    }
    if (input.getMemberUids() != null) {
      var memberUids =
          input.getMemberUids().stream()
              .filter(Objects::nonNull)
              .distinct()
              .collect(Collectors.toList());
      builder.addAllMemberUids(memberUids);
    }

    return groupStub
        .create(builder.build())
        .map(
            resp -> {
              return new GroupOutput().setGid(resp.getGid());
            });
  }
}
