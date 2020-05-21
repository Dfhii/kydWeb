package dulk.baseMan.web.controller;


import com.alibaba.fastjson.JSONObject;
import dulk.baseMan.service.SellService;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("sell")
public class SellController {
    @Resource
    SellService sellService;

    @RequestMapping("/Store")
    @ResponseBody
    public String store(@RequestParam(value = "dir") String dir,@RequestParam(value = "city") String city){
        String str="";
        try {
            List<Map<String, String>> result = sellService.findListMap(dir,city);
             str = JSONObject.toJSONString(result);
           
        }catch(Exception e){

            e.printStackTrace();
        }
        return str;
    }

    @RequestMapping("/province")
    @ResponseBody
    public String province(){
        String str="";
        try {
            List<Map<String, String>> result = sellService.findProvince();
            str = JSONObject.toJSONString(result);
        }catch(Exception e){

            e.printStackTrace();
        }
        return str;
    }

    @RequestMapping("/country")
    @ResponseBody
    public String country(@RequestParam(value = "cityId") String cityId){
        String str="";
        try {
            List<Map<String, String>> result = sellService.findCountry(Integer.parseInt(cityId));
            str = JSONObject.toJSONString(result);
        }catch(Exception e){

            e.printStackTrace();
        }
        return str;
    }

    @RequestMapping("/city")
    @ResponseBody
    public String city(@RequestParam(value = "provId") String provId){
        String str="";
        try {
            List<Map<String, String>> result = sellService.findCity(Integer.parseInt(provId));
            str = JSONObject.toJSONString(result);
        }catch(Exception e){

            e.printStackTrace();
        }
        return str;
    }

    @RequestMapping("/branch")
    @ResponseBody
    public String branch(@RequestParam(value = "dir") String dir,@RequestParam(value = "city") String city){
        String str="";
        try {
            if(dir.equals("null")){
                dir=null;
            }
            List<Map<String, String>> result = sellService.findServiceBranch(dir,city);
            str = JSONObject.toJSONString(result);
        }catch(Exception e){
            e.printStackTrace();
        }
        return str;
    }

    @RequestMapping(value = "/shop")
    @ResponseBody
    public String shop(int sdisId){
        String str="";
        try{
            List<Map<String, String>> result=sellService.findStoreShop(sdisId);
            str = JSONObject.toJSONString(result);
        }catch (Exception e){
            e.printStackTrace();
        }

        return str;
    }


    @RequestMapping(value = "/storeUser")
    @ResponseBody
    public String storeUser(int sid){
        String str="";
        try{
            List<Map<String, String>> result=sellService.findStoreUser(sid);
            str = JSONObject.toJSONString(result);
        }catch (Exception e){
            e.printStackTrace();
        }
        return str;
    }
}
