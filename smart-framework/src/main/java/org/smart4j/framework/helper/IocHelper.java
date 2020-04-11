package org.smart4j.framework.helper;

import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.smart4j.framework.annotation.Inject;
import org.smart4j.framework.util.ReflectionUtil;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map;

/**
 * @ClassName IocHelper
 * @Description 依赖注入助手类
 * @Author Lambert
 * @Date 4/12/2020 1:11 AM
 * @Version 1.0
 **/
public final class IocHelper
{
    static
    {
        //获取所有的 Bean 类与 Bean实例之间的映射关系
        Map<Class<?>, Object> beanMap = BeanHelper.getBeanMap();
        if(MapUtils.isNotEmpty(beanMap))
        {
            for(Map.Entry<Class<?>, Object> beanEntry : beanMap.entrySet())
            {
                //从 BeanMap 中获取 Bean 类与 Bean 实例
                Class<?> beanClass = beanEntry.getKey();
                Object beanInstance = beanEntry.getValue();
                //获取 Bean 类定义的所有成员变量
                Field[] beanFields = beanClass.getDeclaredFields();
                if(ArrayUtils.isNotEmpty(beanFields))
                {
                    for(Field beanField : beanFields)
                    {
                        //判断当前 Bean Field 是否带有 Inject 注解
                        if(beanField.isAnnotationPresent(Inject.class))
                        {
                            //在 Bean Map 中获取 Bean Field 对应的实例
                            Class<?> beanFieldClass = beanField.getType();
                            Object beanFieldInstance = beanMap.get(beanFieldClass);
                            if(beanFieldInstance != null)
                            {
                                ReflectionUtil.setField(beanInstance, beanField, beanFieldInstance);
                            }
                        }
                    }
                }
            }
        }
    }
}
