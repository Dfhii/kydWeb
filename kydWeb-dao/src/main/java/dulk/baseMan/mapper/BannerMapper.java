package dulk.baseMan.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface BannerMapper {

    public List<Map<String, String>> findBannerUrl();

}
