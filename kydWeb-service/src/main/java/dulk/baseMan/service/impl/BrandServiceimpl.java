package dulk.baseMan.service.impl;

import dulk.baseMan.mapper.BrandMapper;
import dulk.baseMan.service.BrandService;
import dulk.baseMan.service.config.DataSourceContextHolder;
import dulk.baseMan.service.config.DataSourceTypeAnno;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class BrandServiceimpl implements BrandService {
    @Resource
    BrandMapper brandMapper;

    @Override
    @DataSourceTypeAnno(DataSourceContextHolder.DataSourceEnum.slave2)
    public List<Map<String, String>> findCoures() {
        return brandMapper.findCourse();
    }

    @Override
    @DataSourceTypeAnno(DataSourceContextHolder.DataSourceEnum.slave2)
    public List<Map<String, String>> findVideo() {
        return brandMapper.findVideo();
    }


}
