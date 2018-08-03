package dulk.baseMan.service;

import dulk.baseMan.pojo.User;
import org.apache.ibatis.annotations.Param;


/**
 * User: Dulk
 * Date: 2018/8/2
 * Time: 15:19
 */
public interface UserService {

    User createUser(User user);

    User findUserById(Long userId);

    void correlateAllRoles(Long userId);

    void deleteUserById(Long userId);

    User findByUsernameAndPassword(String username, String password);
}
