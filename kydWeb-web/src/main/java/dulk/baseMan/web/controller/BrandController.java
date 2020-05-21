package dulk.baseMan.web.controller;

import com.alibaba.fastjson.JSONObject;
import dulk.baseMan.service.BrandService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("brand")
public class BrandController {
    @Resource
    BrandService brandService;
    
    @RequestMapping("/findCoures")
    @ResponseBody
    public String findCoures(){
        String str="";
        try{
            List<Map<String,String>> bannerList= brandService.findCoures();
            str= JSONObject.toJSONString(bannerList);
        }catch (Exception e){
            e.printStackTrace();
        }
        return str;
    }

    @RequestMapping("/findVideo")
    @ResponseBody
    public String findVideo(){
        String str="";
        try{
            List<Map<String,String>> bannerList= brandService.findVideo();
            str= JSONObject.toJSONString(bannerList);
        }catch (Exception e){
            e.printStackTrace();
        }
        return str;
    }
}
