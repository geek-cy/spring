package com.bean;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;

/**
 * PropertiesBeanDefinition从属性文件中加载Bean的配置信息，通常是键值对
 */
public class PropertiesBeanDefinitionReaderDemo {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        new PropertiesBeanDefinitionReader(beanFactory).loadBeanDefinitions("myBean.properties");
        System.out.println("myBean = " + beanFactory.getBean("myBean"));
    }
}
