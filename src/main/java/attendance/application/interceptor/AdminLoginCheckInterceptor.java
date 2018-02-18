package attendance.application.interceptor;

import attendance.application.web.session.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 管理者ユーザのログインチェックを行う
 */
@Component
public class AdminLoginCheckInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private LoginUser loginUser;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        if (loginUser.isLoggedIn()) {
            return true;
        } else {
            response.sendRedirect(request.getContextPath() + "/admin/login");
            return false;

        }
    }
}
