package cool.houge.rest.controller.msg;

import am.ik.yavi.builder.ValidatorBuilder;
import am.ik.yavi.core.ConstraintViolationsException;
import am.ik.yavi.core.Validator;
import cool.houge.protos.MsgContentType;
import cool.houge.protos.MsgKind;
import cool.houge.rest.facade.msg.MsgFacade;
import cool.houge.rest.facade.msg.SendMsgInput;
import cool.houge.rest.interceptor.Interceptors;
import cool.houge.rest.web.AbstractRestSupport;
import cool.houge.rest.web.RoutingService;
import java.util.List;
import javax.inject.Inject;
import reactor.core.publisher.Mono;
import reactor.netty.http.server.HttpServerRequest;
import reactor.netty.http.server.HttpServerResponse;
import reactor.netty.http.server.HttpServerRoutes;

/**
 * 消息控制器.
 *
 * @author KK (kzou227@qq.com)
 */
public class MsgController extends AbstractRestSupport implements RoutingService {

  private final Validator<SendMsgInput> sendMsgValidator =
      ValidatorBuilder.<SendMsgInput>of()
          .constraint(
              SendMsgInput::getKind,
              "kind",
              c -> c.oneOf(List.of(MsgKind.USER_VALUE, MsgKind.GROUP_VALUE)))
          .constraint(SendMsgInput::getTo, "to", c -> c.positive())
          .constraint(
              SendMsgInput::getContent,
              "content",
              c -> c.notNull().notEmpty().lessThanOrEqual(2048))
          .constraint(
              SendMsgInput::getContentType,
              "content_type",
              c -> c.oneOf(List.of(MsgContentType.TEXT_VALUE)))
          .constraint(SendMsgInput::getExtra, "extra", c -> c.lessThanOrEqual(2048))
          .build();

  private final MsgFacade msgFacade;

  public @Inject MsgController(MsgFacade msgFacade) {
    this.msgFacade = msgFacade;
  }

  @Override
  public void update(HttpServerRoutes routes, Interceptors interceptors) {
    routes.post("/msgs/ids", interceptors.token(this::fetchIds));
    routes.post("/msgs/send", interceptors.token(this::send));
  }

  /**
   * @param request
   * @param response
   * @return
   */
  Mono<Void> fetchIds(HttpServerRequest request, HttpServerResponse response) {
    var count = queryInt(request, "count", 50);
    return msgFacade.fetchMsgIds(count).flatMap(ids -> json(response, ids));
  }

  /**
   * @param request
   * @param response
   * @return
   */
  Mono<Void> send(HttpServerRequest request, HttpServerResponse response) {
    var ac = super.authContext(request);
    return json(request, SendMsgInput.class)
        .doOnNext(
            input -> {
              // 参数校验
              sendMsgValidator.validate(input).throwIfInvalid(ConstraintViolationsException::new);
            })
        .flatMap(input -> msgFacade.send(ac, input))
        .flatMap(o -> json(response, o));
  }
}
