package com.resource;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.IOException;

/**
 * 获取与给定类路径下的一个文件相关的所有资源
 */
public class PathMatchingResourcePatternResolverDemo {

    public static void main(String[] args) throws IOException {
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = resolver.getResources("classpath*:*.xml");
        for (Resource resource : resources) {
            System.out.println(resource.getFilename());
        }
    }
}
