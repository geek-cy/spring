package com.condition;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.SimpleMetadataReaderFactory;

import java.io.IOException;

public class ConditionDemo {

    public static void main(String[] args) throws IOException {
        // 创建资源解析器，用于获取匹配指定模式的资源
        PathMatchingResourcePatternResolver patternResolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = patternResolver.getResources("classpath*:com/condition/*.class");
        // 创建工厂读取元数据信息
        SimpleMetadataReaderFactory factory = new SimpleMetadataReaderFactory();
        MyCondition condition = new MyCondition("com.condition.MyCondition");
        for (Resource resource : resources) {
            MetadataReader metadataReader = factory.getMetadataReader(resource);
            boolean matches = condition.matches(null, metadataReader.getAnnotationMetadata());
            System.out.println(matches);
        }
    }
}
