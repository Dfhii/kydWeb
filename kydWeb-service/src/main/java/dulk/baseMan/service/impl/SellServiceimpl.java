package dulk.baseMan.service.impl;

import dulk.baseMan.mapper.SellMapper;
import dulk.baseMan.service.SellService;
import dulk.baseMan.service.config.DataSourceContextHolder;
import dulk.baseMan.service.config.DataSourceTypeAnno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SellServiceimpl implements SellService {
    @Autowired
    SellMapper sellMapper;

    @Override
    public List<Map<String, String>> findListMap(String district,String city) {
        return sellMapper.store(district,city);
    }

    @Override
    public List<Map<String, String>> findProvince( ) {
        return sellMapper.findProvince();
    }

    @Override
    public List<Map<String, String>> findCity(int provId) {
        return sellMapper.findCity(provId);
    }

    @Override
    public List<Map<String, String>> findCountry(int cityId) {
        return sellMapper.findCountry(cityId);
    }

    @DataSourceTypeAnno(DataSourceContextHolder.DataSourceEnum.slave1)
    @Override
    public List<Map<String, String>> findServiceBranch(String district,String city) {
        return sellMapper.findServiceBranch(district,city);
    }

    @Override
    public List<Map<String, String>> findStoreShop(int sdisId) {
        return sellMapper.findStoreShop(sdisId);
    }

    @Override
    public List<Map<String, String>> findStoreUser(int sid) {
        return sellMapper.findStoreUser(sid);
    }
}
