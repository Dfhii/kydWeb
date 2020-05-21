package dulk.baseMan.web.controller;


  
import dulk.baseMan.service.AntiService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
 



@Controller
@RequestMapping("anti")
public class AntiController {
    @Resource
    AntiService antiService;


    @RequestMapping("/product")
    @ResponseBody
    public String product(@RequestParam(value = "serial") String serial) {
        String str = "";
        try {
            str = antiService.findProduct(serial);
        } catch (Exception e) {
            str = "";
            e.printStackTrace();
        }
        return str;
    }


}