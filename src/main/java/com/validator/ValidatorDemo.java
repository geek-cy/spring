package com.validator;

import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.FieldError;

/**
 * 标准化验证Java对象，集成到控制器流程中自动验证模型对象
 */
public class ValidatorDemo {

    public static void main(String[] args) {
        Person person = new Person();
        person.setName(null);
        person.setAge(130);

        // 创建一个BeanPropertyBindingResult对象,用来存储和追踪验证过程中到错误
        BeanPropertyBindingResult result = new BeanPropertyBindingResult(person, "persion");
        // 创建一个自定义验证器实例
        PersonValidator validator = new PersonValidator();
        if (validator.supports(person.getClass())) {
            validator.validate(person, result);
        }
        if (result.hasErrors()) {
            for (FieldError error : result.getFieldErrors()) {
                System.out.println(error.getField() + ":" + error.getDefaultMessage());
            }
        }
    }
}
