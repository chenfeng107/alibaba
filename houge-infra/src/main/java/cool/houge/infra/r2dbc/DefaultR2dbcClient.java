package cool.houge.infra.r2dbc;

import io.r2dbc.spi.Connection;
import io.r2dbc.spi.ConnectionFactory;
import java.util.Objects;
import java.util.function.Function;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;

/**
 * 默认实现.
 *
 * @author KK (kzou227@qq.com)
 */
public class DefaultR2dbcClient implements R2dbcClient {

  private final ConnectionFactory connectionFactory;

  /**
   * 使用 R2DBC 创建连接工厂构建实例.
   *
   * @param connectionFactory R2DBC 创建连接工厂
   */
  public DefaultR2dbcClient(ConnectionFactory connectionFactory) {
    Objects.requireNonNull(connectionFactory, "[connectionFactory]不能为 NULL");
    this.connectionFactory = connectionFactory;
  }

  @Override
  public ConnectionFactory getConnectionFactory() {
    return connectionFactory;
  }

  //  @Override
  //  public Mono<ExecuteSpec> sql(String sql) {
  //    return Mono.usingWhen(
  //        ConnectionFactoryUtils.getConnection(connectionFactory),
  //        conn -> {
  //          try {
  //            return Mono.just(new DefaultExecuteSpec(conn, sql));
  //          } catch (R2dbcException e) {
  //            return Mono.error(e);
  //          }
  //        },
  //        Connection::close);
  //  }

  @Override
  public <R> Flux<R> use(Function<SqlSpec, Publisher<R>> function) {
    return Flux.usingWhen(
        ConnectionFactoryUtils.getConnection(connectionFactory),
        conn -> {
          var spec =
              new SqlSpec() {

                @Override
                public ExecuteSpec sql(String sql) {
                  return new DefaultExecuteSpec(conn, sql);
                }
              };
          return Flux.from(function.apply(spec));
        },
        Connection::close);
  }
}
