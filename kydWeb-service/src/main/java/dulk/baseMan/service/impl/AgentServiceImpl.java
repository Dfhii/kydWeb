package dulk.baseMan.service.impl;

import dulk.baseMan.mapper.AgentMapper;
import dulk.baseMan.pojo.Agent;
import dulk.baseMan.service.AgentService;
import dulk.baseMan.service.config.DataSourceContextHolder;
import dulk.baseMan.service.config.DataSourceTypeAnno;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AgentServiceImpl implements AgentService {
    @Resource
    AgentMapper agentMapper;

    @Override
    @DataSourceTypeAnno(DataSourceContextHolder.DataSourceEnum.slave2)
    public int addAgent(Agent agent){
        return agentMapper.addAgent(agent);
    }
}
