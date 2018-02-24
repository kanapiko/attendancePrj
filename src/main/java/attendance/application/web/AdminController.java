package attendance.application.web;

import attendance.application.service.OrgService;
import attendance.application.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

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
    private OrgService orgService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        return "admin/login";
    }

    @RequestMapping(value = "/login-error", method = RequestMethod.GET)
    public String loginError(Model model) {
        model.addAttribute("loginFailedErrorMsg", "ユーザIDまたはパスワードが正しくありません。");
        return "admin/login";
    }

    /**
     * ユーザ・組織管理画面表示
     * @return
     */
    @RequestMapping(value = "/user-org")
    public String getUserOrg() {
        return "admin/user-org";
    }

    /**
     * 組織検索
     *
     * @return
     */
    @RequestMapping(value = "/find-orgs", method = RequestMethod.GET)
    public
    @ResponseBody
    Map<String, Object> findOrgs() {

        Map<String, Object> res = new HashMap<>();

        res.put("results", orgService.findOrgs());

        return res;
    }

    /**
     * ユーザ検索
     *
     * @return
     */
    @RequestMapping(value = "/find-users", method = RequestMethod.GET)
    public
    @ResponseBody
    Map<String, Object> findUsers(@RequestParam(required = false) String orgCd) {

        Map<String, Object> res = new HashMap<>();

        res.put("results", userService.findUsers(orgCd));

        return res;
    }
}
