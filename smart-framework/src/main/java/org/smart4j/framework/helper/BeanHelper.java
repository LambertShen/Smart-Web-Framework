package org.smart4j.framework.helper;

import org.smart4j.framework.util.ReflectionUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName BeanHelper
 * @Description Bean 助手类
 * @Author Lambert
 * @Date 4/12/2020 12:48 AM
 * @Version 1.0
 **/
public class BeanHelper
{
    /**
     *  定义 Bean 映射 (用于存放Bean类与 Bean 实例的映射关系)
     */
    private static final Map<Class<?>, Object> BEAN_MAP = new HashMap<>();

    static
    {
        Set<Class<?>> beanClassSet = ClassHelper.getBeanClassSet();
        for(Class<?> beanClass : beanClassSet)
        {
            Object obj = ReflectionUtil.newInstance(beanClass);
            BEAN_MAP.put(beanClass, obj);
        }
    }

    /**
     *  获取 Bean 映射
     */
    public static Map<Class<?>, Object> getBeanMap()
    {
        return BEAN_MAP;
    }

    /**
     *  获取 Bean 实例
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(Class<T> cls)
    {
        if(!BEAN_MAP.containsKey(cls))
        {
            throw new RuntimeException("can not get bean by class: " + cls);
        }
        return (T)BEAN_MAP.get(cls);
    }
}
