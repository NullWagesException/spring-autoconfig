package priv.zhengfa.registrar;

import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.io.UrlResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.core.io.support.SpringFactoriesLoader;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.lang.Nullable;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import priv.zhengfa.annotation.EnableAutoConfig;
import priv.zhengfa.config.EasyFactoriesLoader;

import java.io.IOException;
import java.net.URL;
import java.util.*;

/**
 * @Author: nullWagesException
 * @Date: 2020-11-08 11:10
 * @Description:
 */
public class EnableAutoConfigRegistrar implements DeferredImportSelector, BeanClassLoaderAware {

    private ClassLoader beanClassLoader;


    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        beanClassLoader = classLoader;
    }

    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        String factoryClassName = EnableAutoConfig.class.getName();
        List<String> list = loadSpringFactories(beanClassLoader).getOrDefault(factoryClassName, Collections.emptyList());
        return list.toArray(new String[0]);
    }

    private static Map<String, List<String>> loadSpringFactories(@Nullable ClassLoader classLoader) {
        MultiValueMap<String, String> result;
        try {
            Enumeration<URL> urls = (classLoader != null ?
                    classLoader.getResources(EasyFactoriesLoader.FACTORIES_RESOURCE_LOCATION) :
                    ClassLoader.getSystemResources(EasyFactoriesLoader.FACTORIES_RESOURCE_LOCATION));
            result = new LinkedMultiValueMap<>();
            while (urls.hasMoreElements()) {
                URL url = urls.nextElement();
                UrlResource resource = new UrlResource(url);
                Properties properties = PropertiesLoaderUtils.loadProperties(resource);
                for (Map.Entry<?, ?> entry : properties.entrySet()) {
                    List<String> factoryClassNames = Arrays.asList(
                            StringUtils.commaDelimitedListToStringArray((String) entry.getValue()));
                    result.addAll((String) entry.getKey(), factoryClassNames);
                }
            }
            return result;
        }
        catch (IOException ex) {
            throw new IllegalArgumentException("Unable to load factories from location [" +
                    EasyFactoriesLoader.FACTORIES_RESOURCE_LOCATION + "]", ex);
        }
    }

}
