package com.resource;

import org.junit.Test;
import org.springframework.core.io.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;

public class ResourceDemo {

    public static void main(String[] args) throws IOException {
        String path = "applicationContext.xml";
        // ClassPathResource用于访问类路径上的资源
        ClassPathResource resource = new ClassPathResource(path);
        // InputStreamSource提供一个输入流，可以多次返回一个新的、未读取的输入流
        try (InputStream is = resource.getInputStream()) {
            // 获取当前可从输入流中读取的字节数，用于检查是否还有剩余的数据可读，仅仅是个估计值
            // 创建一个与可读字节数相同大小作为缓冲区
            byte[] bytes = new byte[is.available()];
            // 将输入流中的字节读取到给定的字节数组中，返回实际读取的字节数
            is.read(bytes);
            System.out.println(new String(bytes));
        }
    }

    @Test
    public void fileSystemResourceTest() throws IOException {
        String path = "/Users/geek_cy/IdeaProjects/spring/spring/src/main/resources/applicationContext.xml";
        // FileSystemResource用于访问文件系统上的资源
        Resource resource = new FileSystemResource(path);
        try (InputStream is = resource.getInputStream()) {
            byte[] bytes = new byte[is.available()];
            is.read(bytes);
            System.out.println(new String(bytes));
        }
    }

    @Test
    public void urlResourceTest() throws IOException {
        // UrlResource用于访问网络上的资源
        Resource resource = new UrlResource("https://dist.apache.org/repos/dist/test/test.txt");
        try (InputStream is = resource.getInputStream()) {
            byte[] bytes = new byte[is.available()];
            is.read(bytes);
            System.out.println(new String(bytes));
        }
    }

    @Test
    public void ByteArrayResourceTest() throws IOException {
        // ByteArrayResource用于访问字节数作为资源
        byte[] data = "hello world".getBytes();
        Resource resource = new ByteArrayResource(data);
        try (InputStream is = resource.getInputStream()) {
            byte[] bytes = new byte[is.available()];
            is.read(bytes);
            System.out.println(new String(bytes));
        }
    }

    @Test
    public void InputSteamResourceTest() throws IOException {
        InputStream isSource = new ByteArrayInputStream("hello world".getBytes());
        // InputStreamResource用于访问输入流作为资源
        Resource resource = new InputStreamResource(isSource);
        try (InputStream is = resource.getInputStream()) {
            byte[] bytes = new byte[is.available()];
            is.read(bytes);
            System.out.println(new String(bytes));
        }
    }
}
