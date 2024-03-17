package com.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;
import org.springframework.lang.Nullable;
import org.springframework.util.NumberUtils;

/**
 * 用于将字符串转换为数字类型
 */
public class StringToNumberConverterFactory implements ConverterFactory<String, Number> {
    @Override
    public <T extends Number> Converter<String, T> getConverter(Class<T> targetType) {
        if (targetType.equals(Integer.class)) {
            return new StringToNumberConverterFactory.StringToNumber<>(targetType);
        }
        return null;
    }

    private static final class StringToNumber<T extends Number> implements Converter<String, T> {
        private final Class<T> targetType;

        public StringToNumber(Class<T> targetType) {
            this.targetType = targetType;
        }

        @Override
        @Nullable
        public T convert(String source) {
            return NumberUtils.parseNumber(source, this.targetType);
        }
    }
}
