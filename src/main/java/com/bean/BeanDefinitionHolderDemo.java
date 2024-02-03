package com.bean;

import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * BeanDefinitionHolder用于持有一个BeanDefinition，用于管理和操作
 */
public class BeanDefinitionHolderDemo {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(Mybean.class);
        String beanName = "myBean";
        String[] aliases = {"myBeanA", "myBeanB"};
        // 创建一个BeanDefinitionHolder，将BeanDefinition与名称关联起来
        BeanDefinitionHolder beanDefinitionHolder = new BeanDefinitionHolder(beanDefinition, beanName, aliases);
        // 注册BeanDefinitionHolder
        BeanDefinitionReaderUtils.registerBeanDefinition(beanDefinitionHolder, beanFactory);
        System.out.println(beanFactory.getBean("myBean"));
        System.out.println(beanFactory.getBean("myBeanA"));
        System.out.println(beanFactory.getBean("myBeanB"));
        System.out.println(beanDefinitionHolder.matchesName("myBeanC"));
    }
}
