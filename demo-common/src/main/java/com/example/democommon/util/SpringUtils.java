package com.example.democommon.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.Map;

/**
 * Created by yebinxing on 2021/3/29.
 * https://github.com/starkerry
 */
@Component
public class SpringUtils implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (SpringUtils.applicationContext == null) {
            SpringUtils.applicationContext = applicationContext;
        }
    }

    public static <T> T getBean(Class<T> beanClass) {
        return applicationContext.getBean(beanClass);
    }

    @SuppressWarnings("unchecked")
    public static <T> T getBean(String beanName) {
        return (T)applicationContext.getBean(beanName);
    }

    public static Map<String, Object> getBeansWithAnnotation(
            Class<? extends Annotation> annotationType) {
        return applicationContext.getBeansWithAnnotation(annotationType);
    }


    /**
     * @param clazz register class
     * @param serviceName register name
     * @param propertyValueMap register property
     */
    public static <T> T addBean(Class<T> clazz,
                                String serviceName,
                                String initMethodName,
                                String destroyMethodName,
                                Map<String, Object> propertyValueMap,
                                Map<String, String> propertyReferenceMap){
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(clazz);
        if(propertyValueMap!=null){
            for(Map.Entry<String, Object> item : propertyValueMap.entrySet()) {
                beanDefinitionBuilder.addPropertyValue(item.getKey(), item.getValue());
            }
        }

        if(propertyReferenceMap != null) {
            for(Map.Entry<String, String> item : propertyReferenceMap.entrySet()) {
                beanDefinitionBuilder.addPropertyReference(item.getKey(), item.getValue());
            }
        }

        AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getRawBeanDefinition();
        if(StringUtils.isNotBlank(initMethodName)) {
            beanDefinition.setInitMethodName(initMethodName);
        }
        if(StringUtils.isNotBlank(destroyMethodName)) {
            beanDefinition.setDestroyMethodName(destroyMethodName);
        }
        return (T)registerBean(serviceName, beanDefinition);
    }

    /**
     * register bean to spring
     * @param beanName
     * @param beanDefinition
     */
    private static Object registerBean(String beanName, BeanDefinition beanDefinition) {
        ConfigurableApplicationContext configurableApplicationContext = (ConfigurableApplicationContext) applicationContext;
        DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) configurableApplicationContext
                .getBeanFactory();
        beanFactory.registerBeanDefinition(beanName, beanDefinition);
        return applicationContext.getBean(beanName);
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static boolean isActiveProfileTest() {
        return isActiveProfileDev() || isActiveProfileUat();
    }

    public static boolean isActiveProfileDev() {
        String[] aps = applicationContext.getEnvironment().getActiveProfiles();
        if(aps != null) {
            return Arrays.stream(aps).anyMatch(ap -> "dev".equals(ap));
        }
        return false;
    }

    public static boolean isActiveProfileUat() {
        String[] aps = applicationContext.getEnvironment().getActiveProfiles();
        if(aps != null) {
            return Arrays.stream(aps).anyMatch(ap -> "uat".equals(ap));
        }
        return false;
    }
}
