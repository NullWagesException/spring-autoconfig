package priv.zhengfa.registrar;

import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.io.support.SpringFactoriesLoader;
import org.springframework.core.type.AnnotationMetadata;
import priv.zhengfa.annotation.EnableAutoConfig;

import java.util.List;

/**
 * @Author: nullWagesException
 * @Date: 2020-11-08 11:10
 * @Description:
 */
public class EnableAutoConfigRegistrar implements ImportBeanDefinitionRegistrar, BeanClassLoaderAware {

    private ClassLoader beanClassLoader;


    public void setBeanClassLoader(ClassLoader classLoader) {
        beanClassLoader = classLoader;
        System.out.println(classLoader);
    }

    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        List<EnableAutoConfig> factories = SpringFactoriesLoader.loadFactories(EnableAutoConfig.class, beanClassLoader);
        System.out.println(factories);
    }
}
