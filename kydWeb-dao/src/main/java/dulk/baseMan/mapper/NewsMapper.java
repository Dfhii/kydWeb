package dulk.baseMan.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface NewsMapper {
    List<Map<String,String>> findNewsTitle();

    HashMap<String,String> findNewsContents(int id);

    List<Map<String,String>> findTitleByHome();
}
