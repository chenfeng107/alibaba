package cool.houge.rest.auth;

/** @author KK (kzou227@qq.com) */
public interface AuthContext {

  /** @return */
  int uid();

  /** @return */
  String token();
}
