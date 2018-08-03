package dulk.baseMan.web.controller;

import dulk.baseMan.pojo.User;
import dulk.baseMan.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * DemoController.
 *
 * @author Dulk
 * @version 20180802
 * @date 2018/8/2
 */
@RestController
public class DemoController {

    @Autowired
    private UserService userService;


    //todo 访问无需认证
    @RequestMapping("/anon/login")
    public String login(User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            return e.getMessage();
        }

        return "login success";
    }

    //todo 访问需要认证
    @RequestMapping("/authc/myIndex")
    public String myIndex() {
        return "myIndex success";
    }

    //todo 访问需要认证，需要授权
    @RequiresPermissions("user:add")
    @RequestMapping("/authc/user/add")
    public String addUser(User user) {
        userService.createUser(user);
        return "addUser success:" + user.getUsername();
    }

    //todo 访问需要认证，需要授权
    @RequiresPermissions("vip:index")
    @RequestMapping("/authc/vip/index")
    public String vipIndex() {
        return "vipIndex success";
    }

    //todo 访问无需授权
    @RequestMapping("/anon/logout")
    public String logout() {
        try {
            SecurityUtils.getSubject().logout();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "logout success";
    }


}
