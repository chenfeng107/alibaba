/*
 * Copyright 2019-2021 the original author or authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cool.houge.ws.pivot;

import com.google.common.base.Strings;
import com.typesafe.config.ConfigException;
import cool.houge.grpc.broker.BrokerGrpc;
import cool.houge.grpc.broker.BrokerGrpc.BrokerStub;
import cool.houge.grpc.broker.BrokerPb;
import cool.houge.grpc.broker.BrokerPb.AttachRequest;
import cool.houge.ws.PivotStreamServiceConfig;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Status;
import io.grpc.Status.Code;
import io.grpc.StatusException;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.ClientCallStreamObserver;
import io.grpc.stub.ClientResponseObserver;
import java.security.SecureRandom;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.LockSupport;
import java.util.stream.Collectors;
import javax.inject.Inject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 消息监控管理器.
 *
 * @author KK (kzou227@qq.com)
 */
public class PivotStreamServiceManager {

  private static final Logger log = LogManager.getLogger();
  /** 跳过重复错误日志的限制. */
  private static final int SKIP_REPEAT_ERROR_LOG_LIMIT = 16;

  private final String name;
  private final PivotStreamServiceConfig pivotStreamServiceConfig;
  private final PacketProcessor packetProcessor;
  private final CommandProcessor commandProcessor;
  private final AtomicBoolean STARTED = new AtomicBoolean();
  private final AtomicBoolean RUN = new AtomicBoolean(true);
  private final List<ManagedChannel> channels = new CopyOnWriteArrayList<>();

  /**
   * 使用配置及处理器构造对象.
   *
   * @param pivotStreamServiceConfig 配置对象
   * @param packetProcessor Packet处理器
   * @param commandProcessor Command处理器
   */
  @Inject
  public PivotStreamServiceManager(
      PivotStreamServiceConfig pivotStreamServiceConfig,
      PacketProcessor packetProcessor,
      CommandProcessor commandProcessor) {
    var pid = ProcessHandle.current().pid();
    var ran = (short) new SecureRandom().nextInt(Short.MAX_VALUE);
    this.name = Strings.lenientFormat("tethys-ws-%s.%s", pid, ran);
    this.pivotStreamServiceConfig = pivotStreamServiceConfig;
    this.packetProcessor = packetProcessor;
    this.commandProcessor = commandProcessor;
  }

  /** 启动监控管理器. */
  public void start() {
    if (!STARTED.compareAndSet(false, true)) {
      throw new IllegalStateException("已启动的 WatchManager");
    }

    if (Strings.isNullOrEmpty(pivotStreamServiceConfig.getMultiGrpcTarget())) {
      throw new ConfigException.BadValue("agent-service.multi-grpc-target", "不能为空");
    }
    var targets = pivotStreamServiceConfig.getMultiGrpcTarget().split(",");
    if (targets.length <= 0) {
      throw new ConfigException.BadValue("agent-service.multi-grpc-target", "至少需要配置一个 agent 服务");
    }
    var targetList = List.of(targets).stream().distinct().collect(Collectors.toList());
    log.info("agent-service.multi-grpc-target 列表 {}", targetList);

    for (String target : targetList) {
      var channel =
          ManagedChannelBuilder.forTarget(target)
              .disableServiceConfigLookUp()
              .usePlaintext()
              .disableRetry()
              .build();
      channels.add(channel);
      log.info("初始化Agent通道完成 target={}", target, channel);

      new Helper(target, channel).run();
    }
  }

  /** 停止监控管理器. */
  public void stop() {
    if (!RUN.compareAndSet(true, false)) {
      throw new IllegalStateException("已停止的 AgentServiceManager");
    }

    for (ManagedChannel channel : channels) {
      channel.shutdownNow();
    }
  }

  class Helper {

    private final String target;
    private final ManagedChannel channel;
    private final BrokerStub brokerStub;
    private final AtomicInteger retryCount;
    private final AtomicReference<Status.Code> lastStatusCodeRef;

    Helper(String target, ManagedChannel channel) {
      this.target = target;
      this.channel = channel;
      this.brokerStub = BrokerGrpc.newStub(channel);
      this.retryCount = new AtomicInteger();
      this.lastStatusCodeRef = new AtomicReference<>();
    }

    void run() {
      var request = BrokerPb.AttachRequest.newBuilder().setId(name).build();
      if (retryCount.get() > 0) {
        log.info("请求连接Agent name={} target={} retryCount={}", name, target, retryCount.get());
      } else {
        log.info("请求连接Agent name={} target={}", name, target);
      }

      this.brokerStub.attach(request, response());
    }

    private ClientResponseObserver<BrokerPb.AttachRequest, BrokerPb.AttachResponse> response() {
      return new ClientResponseObserver<>() {

        ClientCallStreamObserver<AttachRequest> requestStream;

        @Override
        public void beforeStart(ClientCallStreamObserver<BrokerPb.AttachRequest> requestStream) {
          this.requestStream = requestStream;
        }

        @Override
        public void onNext(BrokerPb.AttachResponse response) {
          if (retryCount.get() > 0) {
            retryCount.set(0);
            lastStatusCodeRef.set(Code.OK);
          }

          if (response.hasPacketMixin()) {
            packetProcessor.process(response.getPacketMixin());
          } else if (response.hasCommand()) {
            commandProcessor.process(response.getCommand());
          } else {
            log.error("不支持的响应 channel={} response={}", channel, response);
          }
        }

        @Override
        public void onError(Throwable t) {
          requestStream.cancel("request-error", t);

          Status status = null;
          if (t instanceof StatusRuntimeException) {
            status = ((StatusRuntimeException) t).getStatus();
          } else if (t instanceof StatusException) {
            status = ((StatusException) t).getStatus();
          }

          if (status != null) {
            // 如果最新的响应状态码与上次的一致，则根据错误次数判断是否需要打印日志，减少重复的错误日志打印
            if (status.getCode() != Helper.this.lastStatusCodeRef.get()
                || retryCount.getAndIncrement() == 0) {
              log.error("Agent响应错误 target={} status_code={}", target, status.getCode());
            }
            Helper.this.lastStatusCodeRef.set(status.getCode());
          } else {
            log.error("Agent响应预期之外的错误 channel={}", channel, t);
          }

          // 最长等待的时长
          var waitSecs = Math.min(retryCount.get() * 10, 60);
          LockSupport.parkNanos(TimeUnit.SECONDS.toNanos(waitSecs));

          // 重试
          run();
          retryCount.compareAndSet(SKIP_REPEAT_ERROR_LOG_LIMIT, 0);
        }

        @Override
        public void onCompleted() {
          log.info("完成 target={}", target);
        }
      };
    }
  }
}