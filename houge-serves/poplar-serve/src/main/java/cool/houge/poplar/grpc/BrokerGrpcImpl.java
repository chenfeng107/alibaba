package cool.houge.poplar.grpc;

import cool.houge.grpc.AttachBrokerRequest;
import cool.houge.grpc.AttachBrokerResponse;
import cool.houge.grpc.ReactorBrokerGrpc;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/** @author KK (kzou227@qq.com) */
public class BrokerGrpcImpl extends ReactorBrokerGrpc.BrokerImplBase {

  @Override
  public Flux<AttachBrokerResponse> attach(Mono<AttachBrokerRequest> request) {
    return super.attach(request);
  }
}
