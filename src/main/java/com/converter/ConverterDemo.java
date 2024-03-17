package com.converter;

import org.springframework.core.convert.support.DefaultConversionService;

import java.time.LocalDate;

/**
 * Converter是用于实现类型转换的一个关键组件，用于将一种类型转换为另一种类型。
 */
public class ConverterDemo {

    public static void main(String[] args) {
        // 创建默认转换服务
        DefaultConversionService service = new DefaultConversionService();

        // 添加自定义的转换器
        service.addConverter(new StringToLocalDateConverter());
        service.addConverter(new StringToBooleanConverter());

        // 检查是否可以将字符串转换为LocalDate
        if (service.canConvert(String.class, LocalDate.class)) {
            LocalDate localDate = service.convert("2020-01-01", LocalDate.class);
            System.out.println("LocalDate = " + localDate);
        }

        // 检查是否可以将字符串yes转换为boolean
        if (service.canConvert(String.class, Boolean.class)) {
            Boolean aBoolean = service.convert("yes", Boolean.class);
            System.out.println("yes = " + aBoolean);
        }

        // 检查是否可以将字符串no转换为boolean
        if (service.canConvert(String.class, Boolean.class)) {
            Boolean aBoolean = service.convert("no", Boolean.class);
            System.out.println("no = " + aBoolean);
        }
    }
}
