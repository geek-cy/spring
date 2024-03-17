package com.converter;

import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.support.DefaultConversionService;

/**
 * ConversionService，提供了两种核心功能
 * 1、检查是否可以在特定的源类型和目标类型之间进行转换
 * 2、执行实际的转换操作
 */
public class ConversionService {

    public static void main(String[] args) {
        DefaultConversionService conversionService = new DefaultConversionService();

        // 使用canConvert检查转换是否可能
        if (conversionService.canConvert(Integer.class, String.class)) {
            System.out.println("Can convert from Integer to String");

            // 执行转换操作，将Integer转换为String
            String converted = conversionService.convert(666, String.class);
            System.out.println("Converted: " + converted);
        }

        // 使用TypeDescriptor检查转换是否可能
        if (conversionService.canConvert(TypeDescriptor.valueOf(Integer.class), TypeDescriptor.valueOf(String.class))) {
            System.out.println("Can convert from Integer to String");

            // 执行转换操作，将Integer转换为String
            Object convertedWithTypeDescriptor = conversionService.convert(888, TypeDescriptor.valueOf(Integer.class), TypeDescriptor.valueOf(String.class));

            System.out.println("Converted: " + convertedWithTypeDescriptor);
        }
    }
}
