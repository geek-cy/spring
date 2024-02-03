package com.property;

import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySourcesPropertyResolver;

import java.util.HashMap;
import java.util.Map;

/**
 * 提供灵活的配置属性解析，从多种源读取并转换属性值，支持类型转换，支持占位符解析。
 */
public class ConfigurablePropertyResolverDemo {

    public static void main(String[] args) {
        // 创建属性源
        Map<String, Object> properties = new HashMap<>();
        properties.put("key1", "value1");
        properties.put("key2", "value2 + ${key1}");
        MapPropertySource propertySource = new MapPropertySource("myPropertySource", properties);
        MutablePropertySources propertySources = new MutablePropertySources();
        propertySources.addLast(propertySource);
        // 创建ConfigurablePropertyResolver，并设置和获取转换服务
        PropertySourcesPropertyResolver propertyResolver = new PropertySourcesPropertyResolver(propertySources);
        DefaultConversionService conversionService = new DefaultConversionService();
        propertyResolver.setConversionService(conversionService);
        // 设置占位符前后缀
        propertyResolver.setPlaceholderPrefix("${");
        propertyResolver.setPlaceholderSuffix("}");
        // 设置默认值分隔符
        propertyResolver.setValueSeparator(":");
        // 设置未解析占位符的处理方式,遇到无法解析时不会抛出异常
        propertyResolver.setIgnoreUnresolvableNestedPlaceholders(true);
        // 设置必须存在的属性
        propertyResolver.setRequiredProperties("key1", "key2");
        propertyResolver.validateRequiredProperties();
        // 读取属性
        String key1 = propertyResolver.getProperty("key1");
        String key2 = propertyResolver.getProperty("key2", String.class, "version");
        System.out.println("key2:" + key1 + "+" + key2);
    }
}
