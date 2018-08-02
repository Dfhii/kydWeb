package dulk.baseMan.web.config;

import dulk.baseMan.web.realm.CustomRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.spring.web.config.ShiroFilterChainDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ShiroConfig.
 *
 * @author Dulk
 * @version 20180731
 * @date 2018/7/31
 */
@Configuration
public class ShiroConfig {

    @Bean
    public Realm realm() {
        return new CustomRealm();
    }

    @Bean
    public ShiroFilterChainDefinition shiroFilterChainDefinition() {
        DefaultShiroFilterChainDefinition chain = new DefaultShiroFilterChainDefinition();

        chain.addPathDefinition("/user/signUp", "anon");
        chain.addPathDefinition("/user/login", "anon");
        chain.addPathDefinition("/page/index", "authc");
        return chain;
    }

}
