package org.smart4j.framework;

import org.smart4j.framework.helper.*;
import org.smart4j.framework.util.ClassUtil;

/**
 * @ClassName HelperLoader
 * @Description 加载相应的 Helper 类
 * @Author Lambert
 * @Date 4/12/2020 11:45 AM
 * @Version 1.0
 **/
public class HelperLoader
{
    public static void init()
    {
        Class<?>[] classList = {
                ClassHelper.class,
                BeanHelper.class,
                IocHelper.class,
                ControllerHelper.class,
                AopHelper.class
        };

        for(Class<?> cls : classList)
        {
            ClassUtil.loadClass(cls.getName(), true);
        }
    }
}
