package cool.houge.infra.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import cool.houge.domain.msg.MsgService;
import cool.houge.domain.system.TokenService;
import cool.houge.domain.user.UserService;
import cool.houge.infra.service.TokenServiceImpl;
import cool.houge.infra.service.tx.TxMsgServiceImpl;
import cool.houge.infra.service.tx.TxUserServiceImpl;

/**
 * Guice模块.
 *
 * @author KK (kzou227@qq.com)
 */
public class ServiceModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(TokenService.class).to(TokenServiceImpl.class).in(Scopes.SINGLETON);
    bind(MsgService.class).to(TxMsgServiceImpl.class).in(Scopes.SINGLETON);
    bind(UserService.class).to(TxUserServiceImpl.class).in(Scopes.SINGLETON);
  }
}
