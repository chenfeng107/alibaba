package cool.houge.infra.dao;

import io.r2dbc.spi.Connection;
import java.util.function.Function;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/** @author KK (kzou227@qq.com) */
class ConnectionHelper {

  /** @return */
  static Mono<Connection> connection() {
    return Mono.deferContextual(
        context -> {
          var conn = context.get(Connection.class);
          return Mono.just(conn);
        });
  }

  /**
   * @param func
   * @param <R>
   * @return
   */
  static <R> Mono<R> connectionMono(Function<Connection, Publisher<R>> func) {
    return connection().flatMap(conn -> Mono.from(func.apply(conn)));
  }

  /**
   * @param func
   * @param <R>
   * @return
   */
  static <R> Flux<R> connectionFlux(Function<Connection, Publisher<R>> func) {
    return connection().flatMapMany(conn -> Flux.from(func.apply(conn)));
  }
}
