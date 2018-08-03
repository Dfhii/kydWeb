package dulk.baseMan.service;

import dulk.baseMan.pojo.Permission;

import java.util.Set;

/**
 * PermissionService.
 *
 * @author Dulk
 * @version 20180803
 * @date 2018/8/3
 */
public interface PermissionService {
    Set<Permission> findByRoleId(Long roleId);
}
