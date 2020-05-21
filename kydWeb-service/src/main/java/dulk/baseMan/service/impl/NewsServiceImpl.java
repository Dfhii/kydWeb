package dulk.baseMan.service.impl;

import dulk.baseMan.mapper.NewsMapper;
import dulk.baseMan.service.NewsService;
import dulk.baseMan.service.config.DataSourceContextHolder;
import dulk.baseMan.service.config.DataSourceTypeAnno;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NewsServiceImpl implements NewsService {
    @Resource
    NewsMapper newsMapper;

    @Override
    @DataSourceTypeAnno(DataSourceContextHolder.DataSourceEnum.slave2)
    public List<Map<String, String>> findNewsTitle() {

        return newsMapper.findNewsTitle();
    }

    @Override
    @DataSourceTypeAnno(DataSourceContextHolder.DataSourceEnum.slave2)
    public HashMap<String,String> findNewsContents(int id) {
        return newsMapper.findNewsContents(id);
    }

    @Override
    @DataSourceTypeAnno(DataSourceContextHolder.DataSourceEnum.slave2)
    public List<Map<String, String>> findTitleByHome() {
        return newsMapper.findTitleByHome();
    }
}
