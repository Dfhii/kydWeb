package dulk.baseMan.service.impl;

import dulk.baseMan.dao.RoleDao;
import dulk.baseMan.pojo.Role;
import dulk.baseMan.service.PermissionService;
import dulk.baseMan.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * RoleServiceImpl.
 *
 * @author Dulk
 * @version 20180803
 * @date 2018/8/3
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private PermissionService permissionService;

    @Override
    public Role createRole(Role role) {
        roleDao.insert(role);
        return role;
    }

    @Override
    public Set<Role> findAllRoles() {
        return roleDao.findAll();
    }

    @Override
    public Set<Role> findRolesByUserId(Long userId) {
        Set<Role> roles = roleDao.findByUserId(userId);
        for (Role role : roles) {
            role.setPermissions(permissionService.findByRoleId(role.getId()));
        }
        return roles;
    }
}
