package dulk.baseMan.service.impl;

import dulk.baseMan.dao.RoleDao;
import dulk.baseMan.dao.UserDao;
import dulk.baseMan.pojo.Role;
import dulk.baseMan.pojo.User;
import dulk.baseMan.service.RoleService;
import dulk.baseMan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * UserServiceImpl.
 *
 * @author Dulk
 * @version 20180802
 * @date 2018/8/2
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private RoleService roleService;

    @Override
    public User createUser(User user) {
        userDao.insert(user);
        return user;
    }

    @Override
    public User findUserById(Long userId) {
        User user = userDao.selectByPrimaryKey(userId);
        user.setRoles(roleDao.findByUserId(userId));
        return user;
    }

    @Override
    public void correlateAllRoles(Long userId) {
        Set<Role> roles = roleDao.findAll();
        userDao.correalteRoles(userId, roles);
    }

    @Override
    @Transactional
    public void deleteUserById(Long userId) {
        userDao.uncorrelateAllRole(userId);
        userDao.deleteByPrimaryKey(userId);
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        User user = userDao.findByUsernameAndPassword(username, password);
        user.setRoles(roleService.findRolesByUserId(user.getId()));
        return user;
    }

}
