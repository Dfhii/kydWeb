package dulk.baseMan.service;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * RoleService.
 *
 * @author Dulk
 * @version 20180731
 * @date 2018/7/31
 */
@Service
public class RoleService {

    //test 模拟
    public Set<String> getRolesByUserId(Long id) {
        Set<String> roles = new HashSet<>();
        roles.add("js");
        roles.add("java");
        roles.add("c++");
        return roles;
    }

}
