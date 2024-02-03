package com.bean;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Lazy
@Scope("prototype")
@Component
public class Mybean {

    private String name;

    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void init(){
        System.out.println("init Mybean");
    }

    public void destroy() {
        System.out.println("destroy Mybean");
    }

    @Override
    public String toString() {
        return "Mybean{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
