package dulk.baseMan.mapper;

import dulk.baseMan.pojo.Agent;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AgentMapper {
    int addAgent(Agent agent);
}
