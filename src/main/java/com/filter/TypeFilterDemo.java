package com.filter;

import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.SimpleMetadataReaderFactory;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.core.type.filter.TypeFilter;

import javax.annotation.Resource;
import java.io.IOException;

public class TypeFilterDemo {

    public static void main(String[] args) throws IOException {
        // 创建路径匹配器
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        // 创建元数据工厂
        SimpleMetadataReaderFactory factory = new SimpleMetadataReaderFactory();
        // 创建注解类型过滤器
        TypeFilter annotationTypeFilter = new AnnotationTypeFilter(Resource.class);
        // 获取所有指定路径的类文件
        org.springframework.core.io.Resource[] resources = resolver.getResources("classpath*:com/itherima/dao/impl/*.class");
        for (org.springframework.core.io.Resource resource : resources) {
            // 创建MetadataReader对象
            MetadataReader metadataReader = factory.getMetadataReader(resource);
            boolean match = annotationTypeFilter.match(metadataReader, factory);
            System.out.println("文件名：" + resource.getFilename() + " 是否匹配：" + match);
        }
    }
}
