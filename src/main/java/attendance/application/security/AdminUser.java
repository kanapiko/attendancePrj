package attendance.application.security;

import attendance.application.entity.MUser;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

/**
 * ログイン管理ユーザ
 */
public class AdminUser extends User {
  private MUser mUser;

  public AdminUser(MUser mUser) {
      super(mUser.userId.toString(), mUser.password, AuthorityUtils.createAuthorityList("ROLE_ADMIN"));
      this.mUser = mUser;
  }

  public MUser getUser() {
      return this.mUser;
  }
}
