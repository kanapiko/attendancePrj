package attendance.application.web;

import attendance.application.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    private PasswordEncoder passwordEncoder;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String getLogin(Model model) {
        return "admin/login";
    }

    @RequestMapping(value = "/users")
    public String getUsers() {
        return "admin/users";
    }

}
