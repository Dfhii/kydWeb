package dulk.baseMan.web.config;


import dulk.baseMan.pojo.Agent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogConfig {
    private static final Logger LOG = LoggerFactory.getLogger(LogConfig.class);

    @Bean
    public Agent logMethod() {
        LOG.info("==========Agent log==========");
        return new Agent();
    }
}