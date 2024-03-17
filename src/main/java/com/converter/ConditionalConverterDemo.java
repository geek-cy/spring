package com.converter;

import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.ConditionalConverter;
import org.springframework.core.convert.converter.Converter;

/**
 * 主要为Converter提供一个条件检查的功能，在转换前能够根据特定条件判断是否应该转换
 */
public class ConditionalConverterDemo {

    public static void main(String[] args) {
        StringToIntegerConditionalConverter converter = new StringToIntegerConditionalConverter();
        TypeDescriptor sourceType = TypeDescriptor.valueOf(String.class);
        TypeDescriptor targetType = TypeDescriptor.valueOf(Integer.class);

        if (converter.matches(sourceType, targetType)) {
            Integer result = converter.convert("8");
            System.out.println("Converted result:" + result);
        } else {
            System.out.println("Conversion not supported");
        }
    }

}
class StringToIntegerConditionalConverter implements Converter<String, Integer>, ConditionalConverter {

    @Override
    public boolean matches(TypeDescriptor sourceType, TypeDescriptor targetType) {
        return String.class.equals(sourceType.getType()) && Integer.class.equals(targetType.getType());
    }

    @Override
    public Integer convert(String source) {
        if (source == null || source.isEmpty()) {
            return null;
        }
        return Integer.parseInt(source);
    }
}