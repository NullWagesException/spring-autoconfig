package priv.zhengfa.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
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
@MapperScan("priv.zhengfa.mapper")
public class SpringConfig {

    @Bean
    public User user() {
        return new User();
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUsername("xxx");
        dataSource.setPassword("xxx");
        dataSource.setUrl("jdbc:mysql://xxx/springtrans");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        return dataSource;
    }

}
