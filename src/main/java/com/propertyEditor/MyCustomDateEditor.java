package com.propertyEditor;

import java.beans.PropertyEditorSupport;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 继承自PropertyEditorSupport的自定义属性编辑器，用于将时间格式的字符串转换为Date对象，或将Date对象格式化为该字符串格式
 */
public class MyCustomDateEditor extends PropertyEditorSupport {

    private final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-DD");

    @Override
    public String getAsText() {
        Date value = (Date) getValue();
        return (value != null ? dateFormat.format(value) : "");
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        try {
            setValue(this.dateFormat.parse(text));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
