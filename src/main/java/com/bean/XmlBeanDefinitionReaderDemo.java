package com.bean;

import com.itherima.dao.BookDao;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

/**
 * XmlBeanDefinitionReader用于加载和解析XML格式的Bean定义配置文件
 */
public class XmlBeanDefinitionReaderDemo {
    public static void main(String[] args) {
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        // 加载XML配置文件,并将这些信息注册到容器到Bean工厂
        reader.loadBeanDefinitions(new ClassPathResource("applicationContext.xml"));
        // 获取Bean
        BookDao myBean = factory.getBean("bookDao", BookDao.class);
        System.out.println("myBean = " + myBean);
    }
}
