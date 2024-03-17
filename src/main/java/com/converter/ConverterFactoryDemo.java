package com.converter;

import org.springframework.core.convert.support.DefaultConversionService;

/**
 * 用于实现类型转换的工厂，能够根据不同的目标类型动态创建相应的Converter实例，可以为一系列相关转换任务只定义一个ConverterFactory
 */
public class ConverterFactoryDemo {

    public static void main(String[] args) {
        DefaultConversionService conversionService = new DefaultConversionService();

        // 向转换服务中添加一个字符串到数字的转换器工厂
        conversionService.addConverterFactory(new StringToNumberConverterFactory());

        // 使用转换服务将字符串转换为Integer类型
        Integer num = conversionService.convert("8", Integer.class);
        System.out.println(num);
    }
}
