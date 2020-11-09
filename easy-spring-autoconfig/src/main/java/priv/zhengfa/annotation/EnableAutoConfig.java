package priv.zhengfa.annotation;

import org.springframework.context.annotation.Import;
import priv.zhengfa.registrar.EnableAutoConfigRegistrar;

import java.lang.annotation.*;

/**
 * @Author: nullWagesException
 * @Date: 2020-11-08 11:14
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import(value = {EnableAutoConfigRegistrar.class})
public @interface EnableAutoConfig {
}
