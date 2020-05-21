package dulk.baseMan.service.impl;

import dulk.baseMan.mapper.ProductMapper;
import dulk.baseMan.service.ProductService;
import dulk.baseMan.service.config.DataSourceContextHolder;
import dulk.baseMan.service.config.DataSourceTypeAnno;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceimpl  implements ProductService {

    @Resource
    ProductMapper productMapper;


    @Override
    @DataSourceTypeAnno(DataSourceContextHolder.DataSourceEnum.slave2)
    public List<Map<String, String>> findProductHome() {
        return productMapper.findProductHome();
    }

    @Override
    @DataSourceTypeAnno(DataSourceContextHolder.DataSourceEnum.slave2)
    public List<Map<String, String>> findProductDetailsImg(int productId) {
        return productMapper.findProductDetailsImg(productId);
    }

    @Override
    @DataSourceTypeAnno(DataSourceContextHolder.DataSourceEnum.slave2)
    public List<Map<String, String>> findProduct(int SeriesId) {
        return productMapper.findProduct(SeriesId);
    }

    @Override
    @DataSourceTypeAnno(DataSourceContextHolder.DataSourceEnum.slave2)
    public List<Map<String, String>> findProductMenu() {
        return productMapper.findProductMenu();
    }
}
