package cool.houge.infra.r2dbc;

import cool.houge.infra.r2dbc.R2dbcClient.ExecuteSpec;
import io.r2dbc.spi.ColumnMetadata;
import io.r2dbc.spi.Connection;
import io.r2dbc.spi.Row;
import io.r2dbc.spi.Statement;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 默认实现.
 *
 * @author KK (kzou227@qq.com)
 */
class DefaultExecuteSpec implements ExecuteSpec {

  final Connection connection;
  final String sql;
  final Statement statement;

  DefaultExecuteSpec(Connection connection, String sql) {
    this.connection = connection;
    this.sql = sql;
    this.statement = connection.createStatement(sql);
  }

  @Override
  public ExecuteSpec bind(String identifier, Object value) {
    Objects.requireNonNull(value, "[value]不能为 [wNULL");
    statement.bind(identifier, value);
    return this;
  }

  @Override
  public ExecuteSpec bind(String identifier, Object value, Class<?> type) {
    Objects.requireNonNull(type, "[type]不能为 NULL");
    if (value == null) {
      statement.bindNull(identifier, type);
    } else {
      statement.bind(identifier, value);
    }
    return this;
  }

  @Override
  public ExecuteSpec returnGeneratedValues(String... columns) {
    statement.returnGeneratedValues(columns);
    return this;
  }

  @Override
  public <R> Publisher<R> fetch(Function<Row, R> mappingFunction) {
    return Flux.defer(statement::execute)
        .flatMap(rs -> rs.map((row, rowMetadata) -> mappingFunction.apply(row)));
  }

  @Override
  public Publisher<Map<String, Object>> fetch() {
    return this.fetch(
        (row) -> {
          var map = new LinkedHashMap<String, Object>();
          for (ColumnMetadata columnMeta : row.getMetadata().getColumnMetadatas()) {
            map.put(columnMeta.getName(), row.get(columnMeta.getName()));
          }
          return map;
        });
  }

  @Override
  public Mono<Integer> rowsUpdated() {
    return Mono.from(statement.execute()).flatMap(rs -> Mono.from(rs.getRowsUpdated()));
  }

  @Override
  public String toString() {
    return "DefaultExecuteSpec{" + "connection=" + connection + ", sql='" + sql + '\'' + '}';
  }
}
