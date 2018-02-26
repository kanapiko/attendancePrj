package attendance.application.config;

import attendance.application.security.AdminUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * Spring Security
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    AdminUserDetailService userDetailService;

    @Override
    public void configure(WebSecurity web) throws Exception {
        // セキュリティ設定を無視するリクエスト設定
        // 静的リソース(images、css、javascript)に対するアクセスはセキュリティ設定を無視する
        web.ignoring().antMatchers(
                "/img/**",
                "/css/**",
                "/js/**",
                "/lib/**",
                "/user/**",
                "/api/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 認可の設定
        http.authorizeRequests()
                .antMatchers("/admin/login", "/admin/login-error").permitAll()
                .anyRequest().authenticated()  // 全て認証無しの場合アクセス不許可
                .and()
        // ログイン設定
        .formLogin()
                .loginPage("/admin/login")           // ログインフォームのパス
                .loginProcessingUrl("/admin/login")   // 認証処理のパス
                .defaultSuccessUrl("/admin/user-org")    // 認証成功時の遷移先
                .failureUrl("/admin/login-error")     // 認証失敗時の遷移先
                .usernameParameter("userId").passwordParameter("password")  // ユーザー名、パスワードのパラメータ名
                .and()
        // ログアウト設定
        .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/admin/logout"))       // ログアウト処理のパス
                .logoutSuccessUrl("/admin/login")    // ログアウト完了時の遷移先
                .invalidateHttpSession(true)         // ログアウト時にセッションを破棄
                .permitAll()
                .and()
        .csrf()
                .disable();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
