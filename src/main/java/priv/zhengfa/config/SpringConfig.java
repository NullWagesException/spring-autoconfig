package priv.zhengfa.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import priv.zhengfa.annotation.EnableAutoConfig;
import priv.zhengfa.pojo.User;

import javax.sql.DataSource;

/**
 * @Author: nullWagesException
 * @Date: 2020-11-08 11:06
 * @Description:
 */
@Configuration
@EnableAutoConfig
public class SpringConfig {

    @Bean
    public User user() {
        return new User();
    }

    @Bean
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUsername("root");
        dataSource.setPassword("xxx");
        dataSource.setUrl("jdbc:mysql://xxx/springtrans");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        return dataSource;
    }

}
