package com.bean;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;

import java.util.Arrays;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

/**
 * BeanDefinitionRegistry用于管理和注册Bean定义
 * 将Bean元数据信息添加容器
 */
public class BeanDefinitionRegistryDemo {

    public static void main(String[] args) {
        DefaultListableBeanFactory listableBeanFactory = new DefaultListableBeanFactory();
        // 创建一个Bean定义
        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(Mybean.class);
        // 将Bean定义注册到容器
        listableBeanFactory.registerBeanDefinition("myBean", beanDefinition);
        // 获取Bean
        BeanDefinition beanDefinition2 = listableBeanFactory.getBeanDefinition("myBean");
        System.out.println("原来的BeanDefinition:" + beanDefinition);
        System.out.println("获取到的BeanDefinition:" + beanDefinition2);
        boolean myBean = listableBeanFactory.containsBeanDefinition("myBean");
        System.out.println("Bean定义是否包含" + myBean);
        // 获取所有Bean定义的名称
        String[] beanNames = listableBeanFactory.getBeanDefinitionNames();
        System.out.println("Bean定义的名称：" + Arrays.toString(beanNames));
        // 获取Bean定义的数量
        int beanDefinitionCount = listableBeanFactory.getBeanDefinitionCount();
        System.out.println("bean定义的数量" + beanDefinitionCount);
        // 检查Bean是否已经被使用
        boolean isUsed = listableBeanFactory.isBeanNameInUse("myBean");
        System.out.println("Bean是否已经被使用：" + isUsed);
        // 移除Bean
        listableBeanFactory.removeBeanDefinition("myBean");
    }
}
