package org.smart4j.framework.helper;

import org.smart4j.framework.annotation.Aspect;
import org.smart4j.framework.annotation.Controller;
import org.smart4j.framework.annotation.Service;
import org.smart4j.framework.util.ClassUtil;

import java.lang.annotation.Annotation;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName ClassHelper
 * @Description 类操作助手类
 * @Author Lambert
 * @Date 4/12/2020 12:20 AM
 * @Version 1.0
 **/


public final class ClassHelper
{
    //定义类集合(用于存放所加载的类)
    private static final Set<Class<?>> CLASS_SET;

    static
    {
        String basePackage = ConfigHelper.getAppBasePackage();
        CLASS_SET = ClassUtil.getClassSet(basePackage);
    }

    /**
     * 获取应用包名下的所有类
     */
    public static Set<Class<?>> getClassSet()
    {
        return CLASS_SET;
    }

    /**
     *  获取应用包名下所有 Service 类
     */
    public static Set<Class<?>> getServiceClassSet()
    {
       return getClassSetByAnnotation(Service.class);
    }

    /**
     *  获取应用包下所有 Controller 类
     */
    public static Set<Class<?>> getControllerClassSet()
    {
        return getClassSetByAnnotation(Controller.class);
    }

    /**
     *  获取应用包下所有 Aspect 类
     */
    public static Set<Class<?>> getAspectClassSet()
    {
        return getClassSetByAnnotation(Aspect.class);
    }

    /**
     *  获取应用包下所有 Bean 类
     */
    public static Set<Class<?>> getBeanClassSet()
    {
        Set<Class<?>> beanClassSet = new HashSet<>();
        beanClassSet.addAll(getServiceClassSet());
        beanClassSet.addAll(getControllerClassSet());
        return beanClassSet;
    }

    /**
     *  获取应用包名下某父类(或接口)的所有子类(或实现类)
     */
    public static Set<Class<?>> getClassSetBySuper(Class<?> superClass)
    {
        Set<Class<?>> classSet = new HashSet<>();
        for(Class<?> cls : CLASS_SET)
        {
            if(superClass.isAssignableFrom(cls) && !superClass.equals(cls))
            {
                classSet.add(cls);
            }
        }
        return classSet;
    }



    public static Set<Class<?>> getClassSetByAnnotation(Class<? extends Annotation> annotationClass)
    {
        Set<Class<?>> classSet = new HashSet<>();
        for(Class<?> cls : CLASS_SET)
        {
            if(cls.isAnnotationPresent(annotationClass))
            {
                classSet.add(cls);
            }
        }
        return classSet;
    }
}
