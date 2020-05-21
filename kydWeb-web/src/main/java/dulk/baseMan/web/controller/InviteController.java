package dulk.baseMan.web.controller;

import com.alibaba.fastjson.JSONObject;
import dulk.baseMan.service.InviteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("/join")
public class InviteController {
    @Resource
    InviteService inviteService;


    @RequestMapping("/iteById")
    @ResponseBody
    public String iteById(@RequestParam("id")int id){
        String str="";
        try{
           str=JSONObject.toJSONString(inviteService.findInviteById(id));
        }catch (Exception e){
            e.printStackTrace();
        }

        return str;
    }

    @RequestMapping("/iteBySchool")
    @ResponseBody
    public String iteBySchool(@RequestParam("hireType")int hireType){
        String str="";
        try{

            str=JSONObject.toJSONStringWithDateFormat(inviteService.iteBySchool(hireType),"yyyy-MM-dd");
        }catch (Exception e){
            e.printStackTrace();
        }

        return str;
    }
}
