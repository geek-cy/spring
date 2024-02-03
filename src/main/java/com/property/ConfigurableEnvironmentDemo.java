package com.property;

import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.StandardEnvironment;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 用于灵活管理和访问应用程序的配置环境，提供了统一接口来处理来自不同来源的配置数据
 * 并且允许在运行时动态添加、移除或修改属性源
 */
public class ConfigurableEnvironmentDemo {

    public static void main(String[] args) {
        StandardEnvironment environment = new StandardEnvironment();
        // 设置配置文件
        environment.setActiveProfiles("dev");
        System.out.println("Active Profiles:" + Arrays.toString(environment.getActiveProfiles()));

        // 添加配置文件
        environment.addActiveProfile("test");
        System.out.println("Active Profiles:" + Arrays.toString(environment.getActiveProfiles()));

        // 设置默认配置文件
        environment.setDefaultProfiles("default");
        System.out.println("Active Profiles:" + Arrays.toString(environment.getDefaultProfiles()));

        // 设置系统属性
        Map<String, Object> systemProperties = environment.getSystemProperties();
        System.out.println("System Properties:" + systemProperties);

        // 获取系统环境变量
        Map<String, Object> systemEnvironment = environment.getSystemEnvironment();
        System.out.println("System Environment:" + systemEnvironment);

        // 合并环境变量
        Map<String, Object> properties = new HashMap<>();
        properties.put("key1", "value1");
        properties.put("key2", "value2");
        StandardEnvironment standardEnvironment = new StandardEnvironment();
        standardEnvironment.getPropertySources().addFirst(new MapPropertySource("myEnvironment", properties));
        environment.merge(standardEnvironment);

        // 获取可变属性源
        MutablePropertySources propertySources = environment.getPropertySources();
        System.out.println("Property Sources:" + propertySources);
    }
}
