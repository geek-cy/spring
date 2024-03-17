package com.converter;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.util.ReflectionUtils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

/**
 * 用于类型转换，允许转换操作在多个源目标类型和目标类型之间进行;
 * 可利用TypeDescriptor访问和处理注解的上下文信息
 * Convert接口仅简单的一对一转换
 */
public class GenericConverterDemo {

    public static void main(String[] args) {
        // 创建默认转换服务
        DefaultConversionService service = new DefaultConversionService();
        // 添加转换器
        service.addConverter(new AnnotatedStringToDateConverter());

        // 定义源类型和目标类型
        TypeDescriptor sourceType1 = TypeDescriptor.valueOf(String.class);
        TypeDescriptor date1 = new TypeDescriptor(Objects.requireNonNull(
                ReflectionUtils.findField(MyBean.class, "date")));
        // 转换
        Date date = (Date) service.convert("2023-12-5", sourceType1, date1);

        // 另一组
        TypeDescriptor sourceType2 = TypeDescriptor.valueOf(String.class);
        TypeDescriptor date2 = new TypeDescriptor(Objects.requireNonNull(
                ReflectionUtils.findField(MyBean.class, "dateTime")));
        // 转换
        Date dateTime = (Date) service.convert("2023-12-5", sourceType2, date2);

        MyBean myBean = new MyBean();
        myBean.setDate(date);
        myBean.setDateTime(dateTime);

        System.out.println(myBean);
    }
}

// 用于将字符串转换为Date
class AnnotatedStringToDateConverter implements GenericConverter {

    @Override
    public Set<ConvertiblePair> getConvertibleTypes() {
        // 定义可转换的类型对: 从String到Date
        return Collections.singleton(new ConvertiblePair(String.class, Date.class));
    }

    @Override
    public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
        if (source == null) {
            return null;
        }

        // 将源对象转换为字符串
        String dateString = (String) source;
        // 获取目标类型（Date类型字段）上的DateFormat注解
        DateFormat dateFormat = targetType.getAnnotation(DateFormat.class);
        if (dateFormat == null) {
            throw new IllegalArgumentException("Target type must be annotated with @DateFormat");
        }

        // 根据注解中提供的日期格式创建 SimpleDateFormat
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat.value());
        // 使用SimpleDateFormat将字符串转换为Date
        try {
            return simpleDateFormat.parse(dateString);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface DateFormat {
    String value();
}

@Data
class MyBean {
    @DateFormat("yyyy-MM-dd")
    private Date date;

    @DateFormat("yyyy-MM-dd")
    private Date dateTime;
}
