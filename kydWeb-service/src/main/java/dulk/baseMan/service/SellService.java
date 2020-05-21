package dulk.baseMan.service;

import dulk.baseMan.service.config.DataSourceContextHolder;
import dulk.baseMan.service.config.DataSourceTypeAnno;

import java.util.List;
import java.util.Map;

public interface SellService {
 
    List<Map<String,String>> findListMap(String district,String city);


    List<Map<String, String>> findProvince();

    List<Map<String, String>>  findCity(int cityId);

    List<Map<String, String>> findCountry(int cityId);

     List<Map<String, String>> findServiceBranch(String district,String city);

    List<Map<String,String>> findStoreShop(int sdisId);

    List<Map<String, String>> findStoreUser(int sid);

}
