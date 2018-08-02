package dulk.baseMan.web.controller;

import dulk.baseMan.common.utils.StringUtils;
import dulk.baseMan.pojo.Girl;
import dulk.baseMan.service.DemoService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * dulk.baseMan.web.controller.demoController.
 *
 * @author Dulk
 * @version 20180730
 * @date 2018/7/30
 */
@RestController
public class DemoController {

    @Autowired
    private DemoService demoService;

    @RequestMapping("/hello")
    public String hello(String name) {
        name = StringUtils.isBlank(name) ? "World" : name;
        return String.format("Hello, %s", name);
    }

    @RequestMapping("/findGirl")
    public Girl findGirl(Integer id) {
        return demoService.findById(id);
    }

    @RequestMapping("/user/signUp")
    public String signUp() {
        return "sign up";
    }

    @RequestMapping("/user/login")
    public String login() {

        UsernamePasswordToken token = new UsernamePasswordToken("zhangsan", "123456");
        try {
            SecurityUtils.getSubject().login(token);
        } catch (AuthenticationException e) {
            return e.getMessage();
        }


        return "success";
    }

    @RequestMapping("/page/index")
    public String index() {
        return "index";
    }

}
