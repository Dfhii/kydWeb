package dulk.baseMan.web.controller;

 
 
 
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class DemoController {

//    @Autowired
//    private UserService userService;



    @RequestMapping("/anon/index")
    public String index()
    {
        return "index";
    }

    @RequestMapping("/anon/head")
    public String authc()
    {
        return "authc";
    }



}
