package cool.houge.infra.tx;

import io.r2dbc.spi.Connection;
import io.r2dbc.spi.ConnectionFactory;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.context.Context;

/** @author KK (kzou227@qq.com) */
public class TxOps {

  private final ConnectionFactory connectionFactory;
  private final boolean rollbackOnly;

  /**
   * @param connectionFactory
   * @param rollbackOnly
   */
  public TxOps(ConnectionFactory connectionFactory, boolean rollbackOnly) {
    this.connectionFactory = connectionFactory;
    this.rollbackOnly = rollbackOnly;
  }

  /**
   * @param p
   * @param <T>
   * @return
   */
  public <T> Mono<T> tx(Mono<T> p) {
    return tx(Flux.from(p)).singleOrEmpty();
  }

  /**
   * @param p
   * @param <T>
   * @return
   */
  public <T> Flux<T> tx(Flux<T> p) {
    return Flux.usingWhen(
        connectionFactory.create(),
        conn -> {
          // 事务管理
          return Flux.from(conn.beginTransaction())
              .thenMany(p)
              .concatWith(
                  (Publisher<? extends T>)
                      (rollbackOnly ? conn.rollbackTransaction() : conn.commitTransaction()))
              .onErrorResume(t -> Mono.from(conn.rollbackTransaction()).then(Mono.error(t)))
              .contextWrite(Context.of(Connection.class, conn));
        },
        Connection::close);
  }
}
