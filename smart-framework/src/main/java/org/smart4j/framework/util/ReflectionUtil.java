package org.smart4j.framework.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @ClassName ReflectionUtil
 * @Description 反射工具类
 * @Author Lambert
 * @Date 4/12/2020 12:33 AM
 * @Version 1.0
 **/
public final class ReflectionUtil
{
    private static final Logger LOGGER = LoggerFactory.getLogger(ReflectionUtil.class);

    /**
     *  创建实例
     */
    public static Object newInstance(Class<?> cls)
    {
        Object instance = null;
        try
        {
            instance = cls.newInstance();
        }
        catch (Exception e)
        {
            LOGGER.error("new instance failure", e);
            throw new RuntimeException(e);
        }
        return instance;
    }

    /**
     *  调用方法
     */
    public static Object invokeMethod(Object obj, Method method, Object... args)
    {
        Object result = null;
        try
        {
            method.setAccessible(true);
            result = method.invoke(obj, args);
        }
        catch (Exception e)
        {
            LOGGER.error("invoke method failure", e);
            throw new RuntimeException(e);
        }
        return result;
    }

    /**
     *  设置成员变量的值
     */
    public static void setField(Object obj, Field field, Object value)
    {
        try
        {
            field.setAccessible(true);
            field.set(obj, value);
        }
        catch (Exception e)
        {
            LOGGER.error("set field failure", e);
            throw new RuntimeException(e);
        }
    }
}
