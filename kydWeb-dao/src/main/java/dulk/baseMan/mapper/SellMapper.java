package dulk.baseMan.mapper;

//import dulk.baseMan.service.config.DataSource;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


//@Repository
@Mapper
public interface SellMapper{
    List<Map<String,String>> store(String dir,String city);

    List<Map<String,String>> findProvince();

    List<Map<String, String>> findCity(int provId);

    List<Map<String, String>> findCountry(int cityId);

    List<Map<String, String>> findServiceBranch(String area,String city );

    List<Map<String, String>> findStoreShop(int sdisId);

    List<Map<String, String>> findStoreUser(int sid);

}
