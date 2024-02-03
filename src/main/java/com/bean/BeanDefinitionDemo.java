package com.bean;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.ScannedGenericBeanDefinition;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.SimpleMetadataReaderFactory;

import java.io.IOException;

/**
 * BeanDefinition主要是定义和配置Bean的属性和行为，以便Spring容器可以根据这些信息动态创建、初始化、管理Bean实例
 */
public class BeanDefinitionDemo {
    public static void main(String[] args) throws IOException {
        // 创建bean工厂
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 注册BeanDefinition
        beanFactory.registerBeanDefinition("myBean", createBeanDefinition());
        // 获取Mybean
        Mybean myBean = beanFactory.getBean("myBean", Mybean.class);
        System.out.println(myBean);
        beanFactory.destroySingleton("myBean");
    }

    private static BeanDefinition createBeanDefinition() throws IOException {
        SimpleMetadataReaderFactory metadataReaderFactory = new SimpleMetadataReaderFactory();
        MetadataReader metadataReader = metadataReaderFactory.getMetadataReader(Mybean.class.getName());
        // 用于表示扫描到的bean定义
        ScannedGenericBeanDefinition beanDefinition = new ScannedGenericBeanDefinition(metadataReader);
        beanDefinition.setScope("singleton");
        beanDefinition.setLazyInit(true);
        beanDefinition.setPrimary(true);// 设置为主要自动装配候选bean
        beanDefinition.setAbstract(false);
        beanDefinition.setInitMethodName("init");// 设置初始化方法的名称
        beanDefinition.setDestroyMethodName("destroy");// 设置销毁方法的名称
        beanDefinition.setAutowireCandidate(true);// 设置为自动装配候选bean
        beanDefinition.setRole(BeanDefinition.ROLE_APPLICATION);
        beanDefinition.setDescription("This is a custom bean definition");
        beanDefinition.setResourceDescription(Mybean.class.getName());// 出现错误时显示上下文
        beanDefinition.getPropertyValues().add("name", "lex");
        beanDefinition.getPropertyValues().add("age", "26");
        return beanDefinition;
    }
}
