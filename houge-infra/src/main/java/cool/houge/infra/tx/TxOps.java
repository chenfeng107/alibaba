package cool.houge.infra.tx;

import io.r2dbc.spi.Connection;
import io.r2dbc.spi.ConnectionFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.context.Context;

/** @author KK (kzou227@qq.com) */
public class TxOps {

  private final ConnectionFactory connectionFactory;

  /** @param connectionFactory */
  public TxOps(ConnectionFactory connectionFactory) {
    this.connectionFactory = connectionFactory;
  }

  /**
   * @param p
   * @param <T>
   * @return
   */
  public <T> Mono<T> tx(Mono<T> p) {
    return Mono.usingWhen(
        connectionFactory.create(),
        conn -> {
          // 事务管理
          return Mono.usingWhen(
                  Mono.just(conn),
                  connection -> p,
                  Connection::commitTransaction,
                  (connection, err) -> Mono.empty(),
                  Connection::rollbackTransaction)
              .onErrorResume(t -> Mono.from(conn.rollbackTransaction()).then(Mono.error(t)))
              .contextWrite(Context.of(Connection.class, conn));
        },
        Connection::close);
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
          return Flux.usingWhen(
                  Mono.just(conn),
                  connection -> p,
                  Connection::commitTransaction,
                  (connection, err) -> Mono.empty(),
                  Connection::rollbackTransaction)
              .onErrorResume(t -> Mono.from(conn.rollbackTransaction()).then(Mono.error(t)))
              .contextWrite(Context.of(Connection.class, conn));
        },
        Connection::close);
  }
}
