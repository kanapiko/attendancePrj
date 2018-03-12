package attendance.application.security;

import attendance.application.emuns.AuthCd;
import attendance.application.emuns.Flag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AdminAuthenticationProvider extends DaoAuthenticationProvider {
    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {

        super.additionalAuthenticationChecks(userDetails, authentication);

        AdminUser adminUser = (AdminUser) userDetails;

        // 管理ユーザでない、もしくは削除済み場合は認証失敗
        if(!adminUser.getUser().authCd.equals(AuthCd.ADMIN.getCode())
                || adminUser.getUser().delFlg.equals(Flag.ON.getVal())) {
            throw new UsernameNotFoundException("user not found");
        }
    }

    @Autowired
    public void setUserDetailsService(UserDetailsService userDetailsService) {
        super.setUserDetailsService(userDetailsService);
    }

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        super.setPasswordEncoder(passwordEncoder);
    }
}
