package attendance.application.web.session;

import attendance.application.entity.MUser;

/**
 * ログインユーザ
 */
public class LoginUser {
    private MUser user;

    public boolean isLoggedIn() {
        return user != null;
    }

    public MUser getUser() {
        return user;
    }

    public void setUser(MUser user) {
        this.user = user;
    }
}
