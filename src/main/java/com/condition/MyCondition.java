package com.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.stereotype.Component;

public class MyCondition implements Condition {

    private final String className;

    public MyCondition(String className) {
        this.className = className;
    }
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return metadata.getAnnotations().isPresent(Component.class.getName());
    }
}
