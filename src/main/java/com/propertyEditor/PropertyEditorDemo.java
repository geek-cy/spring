package com.propertyEditor;

import org.springframework.beans.BeanWrapperImpl;

import java.util.Date;

/**
 * PropertyEditor主要用于处理Java Bean属性的转换和编辑。spring3.0后推荐使用ConversionService作为主要的类型转换机制
 * 这个接口允许将属性值从一种格式转换为另一种（如从字符串到对象），并提供自定义编辑功能
 */
public class PropertyEditorDemo {

    public static void main(String[] args) {
        // 创建一个 BeanWrapperImpl实例，用于操作MyBean类
        BeanWrapperImpl beanWrapper = new BeanWrapperImpl(MyBean.class);

        // 注册自定义属性编辑器
        beanWrapper.overrideDefaultEditor(Date.class, new MyCustomDateEditor());

        // 设置Mybean类中名为"date"的属性值，使用字符串"2023-12-5"
        // 使用注册的将字符串转换为Date对象
        beanWrapper.setPropertyValue("date", "2023-12-5");

        System.out.println(beanWrapper.getWrappedInstance());
    }
}
