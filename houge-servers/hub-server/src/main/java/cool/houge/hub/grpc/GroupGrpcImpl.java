package cool.houge.hub.grpc;

import cool.houge.domain.group.GroupService;
import cool.houge.domain.model.Group;
import cool.houge.grpc.CreateGroupRequest;
import cool.houge.grpc.CreateGroupResponse;
import cool.houge.grpc.ReactorGroupGrpc;
import javax.inject.Inject;
import reactor.core.publisher.Mono;

/** @author KK (kzou227@qq.com) */
public class GroupGrpcImpl extends ReactorGroupGrpc.GroupImplBase {

  private final GroupService groupService;

  public @Inject GroupGrpcImpl(GroupService groupService) {
    this.groupService = groupService;
  }

  @Override
  public Mono<CreateGroupResponse> create(Mono<CreateGroupRequest> request) {
    return request
        .flatMap(
            req -> {
              var group = new Group().setMemberUids(req.getMemberUidsList());
              if (!req.getOriginGid().isEmpty()) {
                group.setOriginGid(req.getOriginGid());
              }
              return groupService.create(group);
            })
        .map(
            gid -> {
              return CreateGroupResponse.newBuilder().setGid(gid).build();
            })
        .onErrorMap(ErrorMaps::map);
  }
}
