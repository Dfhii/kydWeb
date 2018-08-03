package dulk.baseMan.service;

import dulk.baseMan.BaseTest;
import dulk.baseMan.pojo.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

/**
 * User: Dulk
 * Date: 2018/8/2
 * Time: 15:46
 */
public class UserServiceImplTest extends BaseTest {

    User temp;

    @Autowired
    private UserService userService;

    @Before
    public void setUp() throws Exception {
        temp = new User();
        temp.setUsername("zhangsan");
        temp.setPassword("123");
        temp.setSalt("salt");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testCreateUser() {
        User user = userService.createUser(temp);
        assertNotNull(user.getId());
    }

    @Test
    public void testFindUserById() {
        User user = userService.createUser(temp);
        userService.correlateAllRoles(user.getId());
        User srcUser = userService.findUserById(user.getId());
        assertEquals(user.getId(), srcUser.getId());
        assertNotNull(srcUser.getRoles());
        assertNotEquals(0, srcUser.getRoles().size());
    }

    @Test
    public void testCorrelateAllRoles() {
        User user = userService.createUser(temp);
        userService.correlateAllRoles(user.getId());
    }

    @Test
    public void deleteUserById() {
        userService.deleteUserById(18L);
    }


}