package cool.houge.infra.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import cool.houge.domain.repository.group.GroupQueryRepository;
import cool.houge.domain.repository.group.GroupRepository;
import cool.houge.domain.repository.jwt.JwtSecretRepository;
import cool.houge.domain.repository.message.MessageQueryRepository;
import cool.houge.domain.repository.message.MessageRepository;
import cool.houge.domain.repository.user.UserQueryRepository;
import cool.houge.domain.repository.user.UserRepository;
import cool.houge.infra.repository.group.JooqGroupRepository;
import cool.houge.infra.repository.jwt.JooqJwtSecretRepository;
import cool.houge.infra.repository.message.JooqMessageRepository;
import cool.houge.infra.repository.system.JooqServerInstanceRepository;
import cool.houge.infra.repository.user.JooqUserRepository;
import cool.houge.infra.system.identifier.ServerInstanceRepository;

/** @author KK (kzou227@qq.com) */
public class JooqModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(ServerInstanceRepository.class)
        .to(JooqServerInstanceRepository.class)
        .in(Scopes.SINGLETON);
    bind(JwtSecretRepository.class).to(JooqJwtSecretRepository.class).in(Scopes.SINGLETON);

    bind(UserRepository.class).to(JooqUserRepository.class);
    bind(UserQueryRepository.class).to(JooqUserRepository.class);
    bind(JooqUserRepository.class).in(Scopes.SINGLETON);

    bind(GroupRepository.class).to(JooqGroupRepository.class);
    bind(GroupQueryRepository.class).to(JooqGroupRepository.class);
    bind(JooqGroupRepository.class).in(Scopes.SINGLETON);

    bind(MessageRepository.class).to(JooqMessageRepository.class);
    bind(MessageQueryRepository.class).to(JooqMessageRepository.class);
    bind(JooqMessageRepository.class).in(Scopes.SINGLETON);
  }
}
