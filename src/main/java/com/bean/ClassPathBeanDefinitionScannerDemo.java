package com.bean;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;

/**
 * ClassPathBeanDefinitionScanner在类路径上扫描指定包及其子包中的类
 */
public class ClassPathBeanDefinitionScannerDemo {

    public static void main(String[] args) {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(factory);
        scanner.scan("com.bean");
        System.out.println(factory.getBean(Mybean.class));
    }
}
