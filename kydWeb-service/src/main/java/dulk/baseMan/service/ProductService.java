package dulk.baseMan.service;

import java.util.List;
import java.util.Map;

public interface ProductService {

     List<Map<String,String>> findProductHome();

     List<Map<String,String>> findProductDetailsImg(int productId);

     List<Map<String,String>> findProduct(int SeriesId);

     List<Map<String,String>> findProductMenu();
}
