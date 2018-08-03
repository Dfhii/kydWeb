package dulk.baseMan.dao;

import dulk.baseMan.pojo.Role;
import dulk.baseMan.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
@Mapper
public interface UserDao {

    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    void uncorrelateAllRole(Long userId);

    void correalteRoles(@Param("userId") Long userId, @Param("roles") Set<Role> roles);

    User findByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}