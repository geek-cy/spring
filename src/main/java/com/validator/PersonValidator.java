package com.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class PersonValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        // 检查名称是否为空
        ValidationUtils.rejectIfEmpty(errors, "name", "name.empty", "姓名不能为空");
        Person p = (Person) target;
        if (p.getAge() < 0) {
            errors.rejectValue("age", "negative.value", "年龄不能为负数");
        }
        else if (p.getAge() > 120) {
            errors.rejectValue("age", "too.darn.old", "目前年龄最大到上120岁");
        }
    }
}
