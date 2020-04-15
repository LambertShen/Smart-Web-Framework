package org.smart4j.framework.annotation;

import java.lang.annotation.*;

/**
 * @AnnotationName Aspect
 * @Description 切面注解
 * @Author Lambert
 * @Date 4/14/2020 5:25 PM
 * @Version 1.0
 **/

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Aspect
{
    Class<? extends Annotation> value();
}
