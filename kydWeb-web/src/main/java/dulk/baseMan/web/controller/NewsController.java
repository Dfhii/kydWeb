package dulk.baseMan.web.controller;

import com.alibaba.fastjson.JSONObject;
import dulk.baseMan.service.NewsService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/news")
public class NewsController {
    @Resource
    NewsService newsService;

    @RequestMapping("/findTitle")
    @ResponseBody
    public String findTitle(){

        String str="";
        try {
            List<Map<String, String>> result =   newsService.findNewsTitle();
            str = JSONObject.toJSONStringWithDateFormat(result,"yyyy-MM-dd");

        }catch(Exception e){
            str="";
            e.printStackTrace();
        }
        return str;
    }


    @RequestMapping("/findTitleByHome")
    @ResponseBody
    public String findTitleByHome(){

        String str="";
        try {
            List<Map<String, String>> result =   newsService.findTitleByHome();
            str = JSONObject.toJSONStringWithDateFormat(result,"yyyy-MM-dd");
        }catch(Exception e){
            str="";
            e.printStackTrace();
        }
        return str;
    }

    @RequestMapping("/findContents")
    public ModelAndView findContents(@RequestParam("id") String id){
        String str="";
        ModelAndView modelAndView=new ModelAndView();
        try {
            Map<String,String> map=newsService.findNewsContents(Integer.parseInt(id));
            modelAndView.addObject("Contents",map.get("Contents"));
            modelAndView.addObject("Title",map.get("Title"));
            modelAndView.setViewName("news");

        }catch(Exception e){
            e.printStackTrace();
        }
        return modelAndView;

    }
}
