package cool.houge.poplar.grpc;

import cool.houge.grpc.AttachBrokerRequest;
import cool.houge.grpc.AttachBrokerResponse;
import cool.houge.grpc.ReactorBrokerGrpc;
import cool.houge.poplar.broker.BrokerManager;
import javax.inject.Inject;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/** @author KK (kzou227@qq.com) */
public class BrokerGrpcImpl extends ReactorBrokerGrpc.BrokerImplBase {

  private final BrokerManager brokerManager;

  public @Inject BrokerGrpcImpl(BrokerManager brokerManager) {
    this.brokerManager = brokerManager;
  }

  @Override
  public Flux<AttachBrokerResponse> attach(Mono<AttachBrokerRequest> request) {
    return request.flatMapMany(req -> brokerManager.attach(req)).onErrorMap(ErrorMaps::map);
  }
}
