package com.property;

import org.springframework.core.env.StandardEnvironment;

public class EnvironmentDemo {

    public static void main(String[] args) {
        // 设置系统属性模拟Spring配置文件功能
        System.setProperty("spring.profiles.deafult", "dev");
        System.setProperty("spring.profiles.active", "test");

        // 创建StandardEnvironment实例用于访问属性和配置文件信息
        StandardEnvironment environment = new StandardEnvironment();
        // 使用getProperty方法获取系统属性
        String version = environment.getProperty("java.version");
        System.out.println("java.version" + version);
        // 获取当前激活的配置文件
        String[] activeProfiles = environment.getActiveProfiles();
        System.out.println("activeProfiles:" + String.join(",", activeProfiles));
        // 获取默认配置文件
        String[] defaultProfiles = environment.getDefaultProfiles();
        System.out.println("defaultProfiles:" + String.join(",", defaultProfiles));
        // 检查是否激活了指定的配置文件
        boolean isDevProfileActive = environment.acceptsProfiles("test");
        System.out.println("isDevProfileActive:" + isDevProfileActive);
    }
}
