package cool.houge.poplar.grpc;

import cool.houge.domain.BizCodes;
import cool.houge.protos.ErrorInfo;
import io.grpc.Metadata;
import io.grpc.Metadata.Key;
import io.grpc.Status;
import io.grpc.StatusException;
import io.r2dbc.spi.R2dbcBadGrammarException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import top.yein.chaos.biz.BizCodeException;

/** @author KK (kzou227@qq.com) */
final class ErrorMaps {

  private static final Logger log = LogManager.getLogger();
  private static final Key<byte[]> ERROR_INFO_KEY =
      Key.of("error-info-bin", Metadata.BINARY_BYTE_MARSHALLER);

  static Throwable map(Throwable t) {
    if (t instanceof StatusException) {
      return t;
    }

    if (t instanceof BizCodeException) {
      var ex = (BizCodeException) t;
      var code = ex.getBizCode();
      var status = Status.fromCodeValue(code.getGrpcStatus());

      var data = new Metadata();
      var builder =
          ErrorInfo.newBuilder()
              .setCode(code.getCode())
              .setHttpStatus(code.getHttpStatus())
              .setMessage(code.getMessage());

      data.put(ERROR_INFO_KEY, builder.build().toByteArray());
      return status.asRuntimeException(data);
    }

    // r2dbc 异常处理
    if (t instanceof R2dbcBadGrammarException) {
      log.error("SQL语法错误", t);

      var code = BizCodes.C0;
      var status = Status.INTERNAL;

      var data = new Metadata();
      var builder =
          ErrorInfo.newBuilder()
              .setCode(code.getCode())
              .setHttpStatus(code.getHttpStatus())
              .setMessage("[R2DBC]SQL语法错误");

      data.put(ERROR_INFO_KEY, builder.build().toByteArray());
      return status.asRuntimeException(data);
    }

    log.error("gRPC出现未处理的异常信息", t);
    return Status.fromThrowable(t).asRuntimeException();
  }
}
