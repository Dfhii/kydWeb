package dulk.baseMan.dao;

import dulk.baseMan.pojo.Girl;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * DemoDao.
 *
 * @author Dulk
 * @version 20180730
 * @date 2018/7/30
 */
@Repository
@Mapper
public interface DemoDao {

    Girl findById(Integer id);

    int insertGirl(Girl girl);

    int updateGirl(Girl girl);

    int deleteGirl(Integer id);


}
