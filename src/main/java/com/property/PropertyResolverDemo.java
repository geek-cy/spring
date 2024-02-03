package com.property;

import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertyResolver;
import org.springframework.core.env.PropertySourcesPropertyResolver;

import java.util.HashMap;
import java.util.Map;

/**
 * 专注于提供一套灵活且强大的机制来处理应用程序配置属性。
 * 它定义了一系列方法，用于访问和操纵来自各种源的属性
 */
public class PropertyResolverDemo {

    public static void main(String[] args) {
        // 创建属性源
        Map<String, Object> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "key1=${key1} + key2=${key2}");
        MapPropertySource mapPropertySource = new MapPropertySource("map", map);
        MutablePropertySources propertySources = new MutablePropertySources();
        propertySources.addLast(mapPropertySource);
        PropertySourcesPropertyResolver propertyResolver = new PropertySourcesPropertyResolver(propertySources);
        // 获取属性
        String key1 = propertyResolver.getProperty("key1");
        String key2 = propertyResolver.getProperty("key2");
        System.out.println("获取属性：key1:" + key1 + ",key2:" + key2);
        // 检查属性是否存在
        boolean containsKey1 = propertyResolver.containsProperty("key1");
        boolean containsKey2 = propertyResolver.containsProperty("key2");
        System.out.println("属性是否存在:key1:" + containsKey1 + ",key2:" + containsKey2);
        // 带默认值带属性获取
        String key3 = propertyResolver.getProperty("key3", "default");
        System.out.println("key3:" + key3);
        // 获取必需属性
        String requiredProperty = propertyResolver.getRequiredProperty("key1");
        System.out.println("requiredProperty:" + requiredProperty);
        // 解析占位符
        String placeholders = propertyResolver.resolvePlaceholders(map.get("key3").toString());
        System.out.println("解析占位符：" + placeholders + "'");
        // 解析必需的占位符
        String requiredPlaceholders = propertyResolver.resolveRequiredPlaceholders("key:${key1}");
        System.out.println("解析必需的占位符:" + requiredPlaceholders);
    }
}
