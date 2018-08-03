package dulk.baseMan.service.impl;

import dulk.baseMan.dao.PermissionDao;
import dulk.baseMan.pojo.Permission;
import dulk.baseMan.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * PermissionServiceImpl.
 *
 * @author Dulk
 * @version 20180803
 * @date 2018/8/3
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionDao permissionDao;

    @Override
    public Set<Permission> findByRoleId(Long roleId) {
        return permissionDao.findByRoleId(roleId);
    }
}
