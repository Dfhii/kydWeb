package dulk.baseMan.web.controller;

import dulk.baseMan.pojo.Agent;
import dulk.baseMan.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/agent")
public class AgentController {
    @Autowired
    AgentService agentService;

    @RequestMapping(value = "/addAgent",method = RequestMethod.POST )
    @ResponseBody
    public int addAgent(@RequestBody  Agent agent){
        int result=0;
         try{

             result=agentService.addAgent(agent);
         }catch (Exception e){
             e.printStackTrace();
         }
        return  result;
    }
}
