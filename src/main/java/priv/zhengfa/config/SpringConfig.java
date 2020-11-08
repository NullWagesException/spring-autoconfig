package priv.zhengfa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import priv.zhengfa.pojo.User;

/**
 * @Author: nullWagesException
 * @Date: 2020-11-08 11:06
 * @Description:
 */
@Configuration
public class SpringConfig {

    @Bean
    public User user() {
        return new User();
    }

}
