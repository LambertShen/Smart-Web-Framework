package org.smart4j.framework;

import org.smart4j.framework.helper.BeanHelper;
import org.smart4j.framework.helper.ClassHelper;
import org.smart4j.framework.helper.ControllerHelper;
import org.smart4j.framework.helper.IocHelper;

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
                ControllerHelper.class
        };

    }
}
