package cool.houge.poplar.broker;

import cool.houge.grpc.AttachBrokerRequest;
import cool.houge.grpc.AttachBrokerResponse;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import javax.inject.Inject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

/** @author KK (kzou227@qq.com) */
public class BrokerManager {

  private static final Logger log = LogManager.getLogger();
  private final ConcurrentMap<String, Sinks.Many<AttachBrokerResponse>> brokers;

  public @Inject BrokerManager() {
    this.brokers = new ConcurrentHashMap<>();
  }

  /**
   * @param req
   * @return
   */
  public Flux<AttachBrokerResponse> attach(AttachBrokerRequest req) {
    var name = req.getName();
    var sink =
        this.brokers.compute(
            name,
            (unused, oldSink) -> {
              if (oldSink != null) {
                var rs = oldSink.tryEmitComplete();
                log.warn("出现相同的Broker名称 name={} rs={}", unused, rs);
              }
              return Sinks.many().unicast().onBackpressureError();
            });

    return sink.asFlux()
        .doOnCancel(() -> this.removeBroker(name))
        .doOnTerminate(() -> this.removeBroker(name));
  }

  /** @return */
  public Flux<Sinks.Many<AttachBrokerResponse>> all() {
    return Flux.fromIterable(brokers.values());
  }

  void removeBroker(String name) {
    var sink = brokers.remove(name);
    log.info("已删除Broker name={} {}", name, sink);
  }
}
