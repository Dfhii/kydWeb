package dulk.baseMan.web.controller;


import com.alibaba.fastjson.JSONObject;
import dulk.baseMan.mapper.ProductMapper;
import dulk.baseMan.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/product")
public class ProductController  {

    @Resource
    ProductService productService;

    @RequestMapping("/findProductHome")
    @ResponseBody
    public String findProductHome(){
        String  str="";
        try{
            str= JSONObject.toJSONString(productService.findProductHome());
        }catch (Exception e){
            e.printStackTrace();
        }
        return str;
    }

    @RequestMapping("/findProductDetailsImg")
    @ResponseBody
    public String findProductDetailsImg(int productId){
        String  str="";
        try{
            str= JSONObject.toJSONString(productService.findProductDetailsImg(productId));
        }catch (Exception e){
            e.printStackTrace();
        }
        return str;
    }

    @RequestMapping("/findProduct")
    @ResponseBody
    public String findProduct(int SeriesId) {
        String  str="";
        try{
            str= JSONObject.toJSONString(productService.findProduct(SeriesId));
        }catch (Exception e){
            e.printStackTrace();
        }
        return str;
    }

    @RequestMapping("/findProductMenu")
    @ResponseBody
    public String findProductMenu() {
        String  str="";
        try{
            str= JSONObject.toJSONString(productService.findProductMenu());
        }catch (Exception e){
            e.printStackTrace();
        }
        return str;
    }
}
