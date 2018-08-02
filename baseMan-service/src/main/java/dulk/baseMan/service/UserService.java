package dulk.baseMan.service;

import dulk.baseMan.pojo.User;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Random;

/**
 * UserService.
 *
 * @author Dulk
 * @version 20180731
 * @date 2018/7/31
 */
@Service
public class UserService {

    public User findUserByName(String username) {
        //模拟
        User user = new User();
        user.setUsername(username);
        user.setNick(username + "NICK");
        user.setPwd("J/ms7qTJtqmysekuY8/v1TAS+VKqXdH5sB7ulXZOWho=");
        user.setSalt("wxKYXuTPST5SG0jMQzVPsg==");
        user.setUid(new Random().nextLong());
        user.setCreated(new Date());
        return user;
    }

}
