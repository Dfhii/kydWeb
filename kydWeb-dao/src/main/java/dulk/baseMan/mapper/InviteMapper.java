package dulk.baseMan.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface InviteMapper {

    Map<String,String> findInviteById(int id);

    List<Map<String,String>> iteBySchool(int hireType);

 }
