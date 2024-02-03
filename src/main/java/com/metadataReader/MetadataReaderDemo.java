package com.metadataReader;

import com.itherima.dao.impl.NoteDaoImpl;
import lombok.Lombok;
import lombok.Setter;
import org.springframework.core.annotation.MergedAnnotations;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.SimpleMetadataReaderFactory;

import javax.annotation.Resource;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.Map;
import java.util.Set;

/**
 * 允许应用程序获取有关类的元数据信息（注解信息、超类信息、资源信息）
 * 直接读取字节码，比反射更高效
 */
public class MetadataReaderDemo {
    public static void main(String[] args) throws IOException {
        // MetadataReaderFactory用于创建MetadataReader对象的工厂,负责处理类资源，将其包装城MetadataReader对象
        SimpleMetadataReaderFactory readerFactory = new SimpleMetadataReaderFactory();
        MetadataReader metadataReader = readerFactory.getMetadataReader("com.itherima.dao.impl.NoteDaoImpl");

        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        System.out.println(classMetadata.getClassName());

        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        System.out.println(annotationMetadata.getClass());
        // 获取底层类上的所有注解类型的完全限定类名
        System.out.println(annotationMetadata.getAnnotationTypes());
        MergedAnnotations annotations = annotationMetadata.getAnnotations();
        boolean present = annotations.isPresent(Target.class.getName());
        System.out.println("present" + present);

        // 检查类是否被Setter注解修饰
        // 确定给定类型的注解是否在底层类上
        boolean isAnnotated = annotationMetadata.hasAnnotation(Resource.class.getName());
        System.out.println(isAnnotated);

        // 确定底层类是否具有其本身带有给定类型的元注解的注解
        boolean isMetaAnnotated = annotationMetadata.hasMetaAnnotation(Retention.class.getName());
        System.out.println("isMetaAnnotated " + isMetaAnnotated);

        // 获取类上的注解属性
        Map<String, Object> annotationAttributes = annotationMetadata.getAnnotationAttributes(Resource.class.getName());
        System.out.println(annotationAttributes.get("value"));

        // 反射获取
        AnnotationMetadata introspect = AnnotationMetadata.introspect(NoteDaoImpl.class);
        System.out.println(introspect.getClass());
        Set<String> annotationTypes = introspect.getAnnotationTypes();
        System.out.println(annotationTypes);
        boolean hasAnnotation = introspect.hasAnnotation(Resource.class.getName());
        System.out.println(hasAnnotation);
    }
}
