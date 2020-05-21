package dulk.baseMan.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface BrandMapper {

    List<Map<String,String>> findCourse();

    List<Map<String,String>> findVideo();
}
