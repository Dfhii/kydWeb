package dulk.baseMan.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
@Mapper
public interface AntiMapper {
    String findProduct(String serial);
}
