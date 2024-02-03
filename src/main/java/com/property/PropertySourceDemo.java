package com.property;

import org.springframework.core.env.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.core.io.support.ResourcePropertySource;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * PropertySource:
 * 专门用于封装不同来源的配置数据，如文件、环境变量、系统属性等。
 * 它为这些配置源提供了一个统一的接口，使得可以以一致的方式访问各种不同类型的配置数据
 */
public class PropertySourceDemo {

    public static void main(String[] args) throws IOException {
        // 从properties加载属性
        Properties source = PropertiesLoaderUtils.loadProperties(new ClassPathResource("jdbc.properties"));
        PropertiesPropertySource properties = new PropertiesPropertySource("properties", source);
        // 从Resource加载属性
        ClassPathResource resource = new ClassPathResource("jdbc.properties");
        ResourcePropertySource propertySource = new ResourcePropertySource("resource", resource);
        // 从Map加载属性
        Map<String, Object> map = new HashMap<>();
        map.put("name", "mengmeng");
        map.put("age", "18");
        MapPropertySource mapPropertySource = new MapPropertySource("map", map);
        // 访问系统环境变量
        Map mapEnv = System.getenv();
        SystemEnvironmentPropertySource environmentPropertySource = new SystemEnvironmentPropertySource("env", mapEnv);
        // 解析命令行参数
        String[] myArgs = {"--appName=MyApplication", "--port=8080"};
        SimpleCommandLinePropertySource commandLinePropertySource = new SimpleCommandLinePropertySource(myArgs);
        // 组合多个Property实例
        CompositePropertySource compositePropertySource = new CompositePropertySource("composite");
        compositePropertySource.addPropertySource(properties);
        compositePropertySource.addPropertySource(propertySource);
        compositePropertySource.addPropertySource(mapPropertySource);
        compositePropertySource.addPropertySource(environmentPropertySource);
        compositePropertySource.addPropertySource(commandLinePropertySource);
        for (PropertySource propertySource1 : compositePropertySource.getPropertySources()) {
            System.out.println(propertySource1.getName() + ":" + propertySource1.getSource());
        }

    }
}
