package cool.houge.infra.service;

import cool.houge.Nil;
import cool.houge.domain.model.User;
import cool.houge.domain.user.UserDao;
import cool.houge.domain.user.UserQueryDao;
import cool.houge.domain.user.UserService;
import reactor.core.publisher.Mono;

/** @author KK (kzou227@qq.com) */
public class UserServiceImpl implements UserService {

  private final UserDao userDao;
  private final UserQueryDao userQueryDao;

  public UserServiceImpl(UserDao userDao, UserQueryDao userQueryDao) {
    this.userDao = userDao;
    this.userQueryDao = userQueryDao;
  }

  @Override
  public Mono<Integer> create(User user) {
    return userDao.insert(user);
  }

  @Override
  public Mono<Nil> exists(int uid) {
    return userQueryDao.exists(uid);
  }
}
