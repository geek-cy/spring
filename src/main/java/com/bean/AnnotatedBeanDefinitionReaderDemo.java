package com.bean;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;

/**
 * AnnotatedBeanDefinitionReader用于读取和解析带有注解的Bean定义的类
 */
public class AnnotatedBeanDefinitionReaderDemo {

    public static void main(String[] args) {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        AnnotatedBeanDefinitionReader annotatedBeanDefinitionReader = new AnnotatedBeanDefinitionReader(factory);
        annotatedBeanDefinitionReader.registerBean(Mybean.class);
        BeanDefinition beanDefinition = factory.getBeanDefinition("mybean");
        System.out.println(beanDefinition.getScope());
    }
}
