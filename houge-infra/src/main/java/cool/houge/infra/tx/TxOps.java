package cool.houge.infra.tx;

import io.r2dbc.spi.Batch;
import io.r2dbc.spi.Connection;
import io.r2dbc.spi.ConnectionFactory;
import io.r2dbc.spi.ConnectionMetadata;
import io.r2dbc.spi.IsolationLevel;
import io.r2dbc.spi.Statement;
import io.r2dbc.spi.TransactionDefinition;
import io.r2dbc.spi.ValidationDepth;
import java.time.Duration;
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
              .contextWrite(Context.of(Connection.class, new NoTxConnection(conn)));
        },
        Connection::close);
  }

  private class NoTxConnection implements Connection {

    private final Connection delegate;

    private NoTxConnection(Connection delegate) {
      this.delegate = delegate;
    }

    @Override
    public Publisher<Void> beginTransaction() {
      return Mono.empty();
    }

    @Override
    public Publisher<Void> beginTransaction(TransactionDefinition definition) {
      return Mono.empty();
    }

    @Override
    public Publisher<Void> close() {
      return Mono.empty();
    }

    @Override
    public Publisher<Void> commitTransaction() {
      return Mono.empty();
    }

    @Override
    public Batch createBatch() {
      return this.delegate.createBatch();
    }

    @Override
    public Publisher<Void> createSavepoint(String name) {
      return Mono.empty();
    }

    @Override
    public Statement createStatement(String sql) {
      return this.delegate.createStatement(sql);
    }

    @Override
    public boolean isAutoCommit() {
      return this.delegate.isAutoCommit();
    }

    @Override
    public ConnectionMetadata getMetadata() {
      return this.delegate.getMetadata();
    }

    @Override
    public IsolationLevel getTransactionIsolationLevel() {
      return this.delegate.getTransactionIsolationLevel();
    }

    @Override
    public Publisher<Void> releaseSavepoint(String name) {
      return Mono.empty();
    }

    @Override
    public Publisher<Void> rollbackTransaction() {
      return Mono.empty();
    }

    @Override
    public Publisher<Void> rollbackTransactionToSavepoint(String name) {
      return Mono.empty();
    }

    @Override
    public Publisher<Void> setAutoCommit(boolean autoCommit) {
      return Mono.empty();
    }

    @Override
    public Publisher<Void> setLockWaitTimeout(Duration timeout) {
      return this.delegate.setLockWaitTimeout(timeout);
    }

    @Override
    public Publisher<Void> setStatementTimeout(Duration timeout) {
      return this.delegate.setStatementTimeout(timeout);
    }

    @Override
    public Publisher<Void> setTransactionIsolationLevel(IsolationLevel isolationLevel) {
      return Mono.empty();
    }

    @Override
    public Publisher<Boolean> validate(ValidationDepth depth) {
      return this.delegate.validate(depth);
    }
  }
}
