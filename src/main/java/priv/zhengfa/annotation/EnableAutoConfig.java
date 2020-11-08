package priv.zhengfa.annotation;

import org.springframework.context.annotation.Import;
import priv.zhengfa.registrar.EnableAutoConfigRegistrar;

import java.lang.annotation.*;

/**
 * @Author: nullWagesException
 * @Date: 2020-11-08 11:14
 * @Description:
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(value = {EnableAutoConfigRegistrar.class})
public @interface EnableAutoConfig {
}
