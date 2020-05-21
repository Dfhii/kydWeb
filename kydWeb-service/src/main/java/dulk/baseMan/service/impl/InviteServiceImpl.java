package dulk.baseMan.service.impl;

import dulk.baseMan.mapper.InviteMapper;
import dulk.baseMan.service.InviteService;
import dulk.baseMan.service.config.DataSourceContextHolder;
import dulk.baseMan.service.config.DataSourceTypeAnno;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class InviteServiceImpl implements InviteService {

    @Resource
    InviteMapper inviteMapper;


    @Override
    @DataSourceTypeAnno(DataSourceContextHolder.DataSourceEnum.slave2)
    public Map<String, String> findInviteById(int id) {
        return inviteMapper.findInviteById(id);
    }

    @Override
    @DataSourceTypeAnno(DataSourceContextHolder.DataSourceEnum.slave2)
    public List<Map<String,String>> iteBySchool(int hireType){
            return inviteMapper.iteBySchool(hireType);
    }
}
