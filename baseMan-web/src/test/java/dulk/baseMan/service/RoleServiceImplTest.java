package dulk.baseMan.service;

import dulk.baseMan.BaseTest;
import dulk.baseMan.pojo.Role;
import org.junit.After;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

/**
 * RoleServiceImplTest.
 *
 * @author Dulk
 * @version 20180803
 * @date 2018/8/3
 */
public class RoleServiceImplTest extends BaseTest {

    @Autowired
    private RoleService roleService;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testCreateRole() {
        Role role = new Role();
        role.setRole("admin");
        role.setDescription("管理员");
        role.setAvailable(true);
        roleService.createRole(role);
        assertNotNull(role.getId());
    }

    @Test
    public void testFindAllRoles() {
        Set<Role> roles = roleService.findAllRoles();
        assertNotNull(roles);
        assertNotEquals(0, roles.size());
    }

    @Test
    public void testFindRolesByUserId() {
        Set<Role> roles = roleService.findRolesByUserId(16L);
        assertNotNull(roles);
        assertNotEquals(0, roles.size());
    }


}
