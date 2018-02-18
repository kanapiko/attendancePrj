package attendance.application.web;

import attendance.application.entity.MUser;
import attendance.application.service.UserService;
import attendance.application.web.form.AdminLoginForm;
import attendance.application.web.session.LoginUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Optional;

/**
 * 管理画面コントローラ
 */
@Controller
@RequestMapping(value="/admin")
public class AdminController {

    private final static Logger logger = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private LoginUser loginUser;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLogin(@ModelAttribute(name = "loginForm") AdminLoginForm loginForm, Model model) {
        return "admin/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String postLogin(@ModelAttribute(name = "loginForm") @Valid AdminLoginForm loginForm,
                        BindingResult result,
                        RedirectAttributes redirectAttributes,
                        Model model) {
        if (result.hasErrors()) {
            return "admin/login";
        }

        logger.info("encoded password: {}", passwordEncoder.encode(loginForm.password));

        Optional<MUser> muser = userService.adminLogin(loginForm.userId, loginForm.password);
        if (muser.isPresent()) {
            loginUser.setUser(muser.get());
            return "redirect:/admin/users";
        } else {
            model.addAttribute("loginFailedErrorMsg", "ログインIDまたはパスワードが正しくありません。");
            return "admin/login";
        }
    }

    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/admin/login";
    }
}
