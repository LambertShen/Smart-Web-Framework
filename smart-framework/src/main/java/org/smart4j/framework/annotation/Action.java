package org.smart4j.framework.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @AnnotationName Action
 * @Description Action 方法注解
 * @Author Lambert
 * @Date 4/12/2020 12:14 AM
 * @Version 1.0
 **/

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Action
{
    /**
     *  请求类型与路径
     */
    String value();
}
