package cool.houge.infra.r2dbc;

import io.r2dbc.spi.Connection;
import io.r2dbc.spi.ConnectionFactory;
import reactor.core.publisher.Mono;

/**
 * R2DBC {@link io.r2dbc.spi.ConnectionFactory} 工具类.
 *
 * @author KK (kzou227@qq.com)
 */
public final class ConnectionFactoryUtils {

  private ConnectionFactoryUtils() {}

  /**
   * 获取 {@link Connection}.
   *
   * <p>优先从 {@link reactor.util.context.Context} 获取连接返回, 如果上下文不存在 {@link Connection} 则通过 {@link
   * ConnectionFactory#create()} 返回连接.
   *
   * @param connectionFactory R2DBC 连接工厂
   * @return {@link Connection}
   */
  public static Mono<Connection> getConnection(ConnectionFactory connectionFactory) {
    return Mono.deferContextual(
        context -> {
          if (context.hasKey(Connection.class)) {
            return Mono.just(context.get(Connection.class));
          }
          return Mono.from(connectionFactory.create());
        });
  }

  /**
   * 判断 {@link reactor.util.context.Context} 是否存在 {@link Connection}.
   *
   * @return 存在则返回 {@code true} 反之返回 {@code false}
   */
  public static Mono<Boolean> hasContextConnection() {
    return Mono.deferContextual(contextView -> Mono.just(contextView.hasKey(Connection.class)));
  }
}
