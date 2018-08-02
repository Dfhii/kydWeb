package dulk.baseMan.service;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * PermService.
 *
 * @author Dulk
 * @version 20180731
 * @date 2018/7/31
 */
@Service
public class PermService {

    public Set<String> getPermsByUserId(Long uid) {
        Set<String> perms = new HashSet<>();
        //js
        perms.add("html:edit");
        //c++
        perms.add("hardware:debug");
        //java
        perms.add("mvn:install");
        perms.add("mvn:clean");
        perms.add("mvn:test");
        return perms;
    }

}
