package dulk.baseMan.service.impl;

import dulk.baseMan.mapper.BannerMapper;
import dulk.baseMan.service.BannerService;
import dulk.baseMan.service.config.DataSourceContextHolder;
import dulk.baseMan.service.config.DataSourceTypeAnno;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class BannerServiceimpl implements BannerService {

    @Resource
    BannerMapper bannerMapper;

    @Override
    @DataSourceTypeAnno(DataSourceContextHolder.DataSourceEnum.slave2)
    public List<Map<String, String>> findBannerUrl() {
        return bannerMapper.findBannerUrl();
    }
}
