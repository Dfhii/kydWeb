package dulk.baseMan.web.controller;

import com.alibaba.fastjson.JSONObject;
import dulk.baseMan.service.BannerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/banner")
public class BannerController {

    @Resource
    BannerService bannerService;

    @RequestMapping("/findBannerHome")
    @ResponseBody
    public String findBannerHome(){
        String str="";
        try{
           List<Map<String,String>> bannerList= bannerService.findBannerUrl();
            str= JSONObject.toJSONString(bannerList);
        }catch (Exception e){
            e.printStackTrace();
        }
        return str;
    }
}
