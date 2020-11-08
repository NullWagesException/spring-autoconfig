package priv.zhengfa;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import priv.zhengfa.config.SpringConfig;
import priv.zhengfa.pojo.User;

/**
 * @Author: nullWagesException
 * @Date: 2020-11-08 11:06
 * @Description:
 */
public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfig.class);

        User bean = context.getBean(User.class);
        System.out.println(bean);

    }

}
