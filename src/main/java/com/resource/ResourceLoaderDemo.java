package com.resource;

import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

/**
 * 提供了一个标准化的方法来加载资源，不论资源是存放在类路径、文件系统、网络URL还是其他位置
 * 可以确定资源的类型，并为其创建相应的 Resource 实例
 */
public class ResourceLoaderDemo {

    public static void main(String[] args) throws IOException {
        DefaultResourceLoader defaultResourceLoader = new DefaultResourceLoader();
        Resource resource = defaultResourceLoader.getResource("applicationContext.xml");
        String description = resource.getDescription();
        System.out.println(description);
        if (resource.exists()) {
            try (InputStream is = resource.getInputStream()) {
                byte[] bytes = new byte[is.available()];
                is.read(bytes);
                System.out.println(new String(bytes));
            }
        }
        Resource fileResource = defaultResourceLoader.getResource("file:///Users/geek_cy/IdeaProjects/spring/spring/src/main/resources/applicationContext.xml");
        String filename = fileResource.getFilename();
        System.out.println(filename);

        Resource urlResource = defaultResourceLoader.getResource("https://dist.apache.org/repos/dist/test/test.txt");
        System.out.println(urlResource.contentLength());
    }
}
