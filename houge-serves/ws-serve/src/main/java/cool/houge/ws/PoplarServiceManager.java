package cool.houge.ws;

import com.google.common.base.Strings;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigException;
import cool.houge.grpc.AttachBrokerRequest;
import cool.houge.grpc.ReactorBrokerGrpc;
import cool.houge.grpc.ReactorBrokerGrpc.ReactorBrokerStub;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import java.security.SecureRandom;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;
import javax.inject.Inject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import reactor.core.publisher.Flux;

/** @author KK (kzou227@qq.com) */
public class PoplarServiceManager {

  private static final Logger log = LogManager.getLogger();
  /** 跳过重复错误日志的限制. */
  private static final int SKIP_REPEAT_ERROR_LOG_LIMIT = 16;

  private final AtomicBoolean STARTED = new AtomicBoolean();
  private final String name;
  private final String streamGrpcTargets;
  private final List<Worker> workers = new CopyOnWriteArrayList<>();

  private final BrokerMsgHandler msgHandler;

  /**
   * @param config
   * @param msgHandler
   */
  public @Inject PoplarServiceManager(Config config, BrokerMsgHandler msgHandler) {
    this.msgHandler = msgHandler;
    this.name = this.genName();
    this.streamGrpcTargets = config.getString("ws.poplar.stream-grpc-targets");
  }

  /** */
  public void start() {
    if (!STARTED.compareAndSet(false, true)) {
      throw new IllegalStateException("不能重复启动");
    }
    if (Strings.isNullOrEmpty(streamGrpcTargets)) {
      throw new ConfigException.BadValue("ws.poplar.stream-grpc-targets", "不能为空");
    }

    var targetList = List.of(streamGrpcTargets).stream().distinct().collect(Collectors.toList());
    log.info("ws.poplar.stream-grpc-targets={}", targetList);

    for (String target : targetList) {
      workers.add(new Worker(target));
      log.info("初始化Agent通道完成 target={}", target);
    }

    this.runWorkers();
    // 保持健康运行
    this.keepWorkers();
  }

  /** */
  public void stop() {
    for (Worker worker : workers) {
      worker.channel.shutdownNow();
    }
  }

  void keepWorkers() {
    Flux.interval(Duration.ofSeconds(10))
        .doOnNext(
            n -> {
              this.runWorkers();
            })
        .subscribe();
  }

  void runWorkers() {
    for (Worker worker : workers) {
      if (!worker.isRunning()) {
        try {
          worker.run();
        } catch (Exception e) {
          log.error("运行Worker异常 target={} channel={}", worker.target, worker.channel, e);
        }
      }
    }
  }

  class Worker {
    final String target;
    final ManagedChannel channel;
    final ReactorBrokerStub brokerStub;
    AtomicBoolean running = new AtomicBoolean();

    Worker(String target) {
      this.target = target;
      this.channel = newChannel(target);
      this.brokerStub = ReactorBrokerGrpc.newReactorStub(this.channel);
    }

    void run() {
      this.running.set(true);
      var req = AttachBrokerRequest.newBuilder().setName(name).build();
      this.brokerStub
          .attach(req)
          .retry(3)
          .doOnTerminate(
              () -> {
                log.info("Poplar 消息监听终止 target={}", target);
                running.set(false);
              })
          .subscribe(
              resp -> {
                // 分发消息
                if (resp.hasMsg()) {
                  msgHandler.run(resp.getMsg());
                }

                System.out.println("响应数据");
                System.out.println(resp);
              },
              e -> {
                if (!channel.isShutdown()) {
                  log.error("Poplar 消息监听出现异常 target={}", target, e);
                }
              });
    }

    boolean isRunning() {
      return !channel.isShutdown() && running.get();
    }
  }

  ManagedChannel newChannel(String target) {
    return ManagedChannelBuilder.forTarget(target)
        .disableServiceConfigLookUp()
        .usePlaintext()
        .disableRetry()
        .build();
  }

  String genName() {
    var pid = ProcessHandle.current().pid();
    var ran = (short) new SecureRandom().nextInt(Short.MAX_VALUE);
    return Strings.lenientFormat("houge-ws-%s.%s", pid, ran);
  }
}
