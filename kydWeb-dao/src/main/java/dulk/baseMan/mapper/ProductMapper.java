package dulk.baseMan.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ProductMapper {

     List<Map<String,String>> findProductHome();

     List<Map<String,String>> findProductDetailsImg(int productId);

     List<Map<String,String>> findProduct(int SeriesId);

     List<Map<String,String>> findProductMenu();
}
