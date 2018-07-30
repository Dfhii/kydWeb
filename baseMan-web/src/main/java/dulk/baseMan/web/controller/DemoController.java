package dulk.baseMan.web.controller;

import dulk.baseMan.common.utils.StringUtils;
import dulk.baseMan.pojo.Girl;
import dulk.baseMan.service.DemoService;
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

}
