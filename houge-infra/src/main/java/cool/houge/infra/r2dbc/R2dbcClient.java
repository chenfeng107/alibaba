package cool.houge.infra.r2dbc;

import io.r2dbc.spi.ConnectionFactory;
import io.r2dbc.spi.Row;
import java.util.Map;
import java.util.function.Function;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * <a href="https://r2dbc.io/">R2DBC</a> 响应式客户端接口规范定义.
 *
 * @author KK (kzou227@qq.com)
 */
public interface R2dbcClient {

  /**
   * 返回 R2DBC 连接工厂对象.
   *
   * @return R2DBC 连接工厂对象.
   */
  ConnectionFactory getConnectionFactory();

  /**
   * 返回执行规范并绑定指定的 SQL.
   *
   * @param sql 需执行的 SQL
   * @return 执行的规范对象
   */
  //  Mono<ExecuteSpec> sql(String sql);

  /**
   * @param function
   * @param <R>
   * @return
   */
  <R> Flux<R> use(Function<SqlSpec, Publisher<R>> function);

  /** */
  interface SqlSpec {

    /**
     * @param sql
     * @return
     */
    ExecuteSpec sql(String sql);
  }

  /** 用于指定 SQL 的执行规范. */
  interface ExecuteSpec {

    /**
     * 使用索引绑定 SQL 参数值.
     *
     * @param identifier 索引
     * @param value 参数值且不能为 NULL
     * @return self
     */
    ExecuteSpec bind(String identifier, Object value);

    /**
     * 使用索引绑定 SQL 参数值.
     *
     * <p>如果参数值为 NULL 则绑定数据类型的默认 NULL 值.
     *
     * @param identifier 索引
     * @param value 参数值
     * @param type 参数类型
     * @return self
     */
    ExecuteSpec bind(String identifier, Object value, Class<?> type);

    /**
     * 执行指定 SQL 并返回数据库自动生成的值.
     *
     * @param columns 返回列的名称
     * @return self
     */
    ExecuteSpec returnGeneratedValues(String... columns);

    /**
     * 返回获取数据规范并绑定数据结果映射函数.
     *
     * @param <R> 映射的数据类型
     * @param mappingFunction 数据映射函数
     * @return 获取数据规范
     */
    <R> Publisher<R> fetch(Function<Row, R> mappingFunction);

    /**
     * 返回获取数据规范并将数据映射为 {@code Map} 类型.
     *
     * @return 获取数据规范
     */
    Publisher<Map<String, Object>> fetch();

    /**
     * 返回更新数据库受影响的行数.
     *
     * @return 受影响的行数
     */
    Mono<Integer> rowsUpdated();
  }

  /** 批量执行规范. */
  interface BatchExecuteSpec {

    /**
     * 返回更新数据库受影响的行数.
     *
     * @return 受影响的行数
     */
    Mono<Integer> rowsUpdated();
  }
}
