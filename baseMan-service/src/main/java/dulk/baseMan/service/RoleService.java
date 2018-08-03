package dulk.baseMan.service;

import dulk.baseMan.pojo.Role;

import java.util.Set;

/**
 * RoleService.
 *
 * @author Dulk
 * @version 20180803
 * @date 2018/8/3
 */
public interface RoleService {

    Role createRole(Role role);

    Set<Role> findAllRoles();

    Set<Role> findRolesByUserId(Long userId);

}

