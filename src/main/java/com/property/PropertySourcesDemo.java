package com.property;

import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;

import java.util.HashMap;
import java.util.Map;

/**
 * MutablePropertySources 提供了一个可修改的属性源集合
 * 允许添加、替换和删除属性源，是处理动态环境属性时的首选
 */
public class PropertySourcesDemo {

    public static void main(String[] args) {
        // 创建MutablePropertySources对象
        MutablePropertySources propertySources = new MutablePropertySources();
        // 创建两个MapPropertySource对象
        Map<String, Object> map1 = new HashMap<>();
        map1.put("key1", "value1");
        MapPropertySource mapPropertySource1 = new MapPropertySource("map1", map1);

        Map<String, Object> map2 = new HashMap<>();
        map2.put("key2", "value2");
        MapPropertySource mapPropertySource2 = new MapPropertySource("map2", map2);

        // 添加属性源到开头
        propertySources.addFirst(mapPropertySource1);
        // 添加属性源到末尾
        propertySources.addLast(mapPropertySource2);

        // 打印属性源
        for (PropertySource propertySource : propertySources) {
            System.out.println(propertySource.getName() + ":" + propertySource.getSource());
        }
        System.out.println("--------------------------");

        // 替换属性源
        Map<String, Object> map3 = new HashMap<>();
        map3.put("app.name", "Spring");
        map3.put("app.version", "5.0");
        MapPropertySource mapPropertySource3 = new MapPropertySource("map3", map3);
        propertySources.replace("map1", mapPropertySource3);
        for (PropertySource propertySource : propertySources) {
            System.out.println(propertySource.getName() + ":" + propertySource.getSource());
        }
        // 检查是否包含属性源
        System.out.println(propertySources.contains("map2"));
        // 移除属性源
        propertySources.remove("map2");
        System.out.println("--------------------------");
        for (PropertySource propertySource : propertySources) {
            System.out.println(propertySource.getName() + ":" + propertySource.getSource());
        }
    }
}
