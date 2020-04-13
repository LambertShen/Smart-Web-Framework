package org.smart4j.framework.bean;

import java.lang.reflect.Method;

/**
 * @ClassName Handler
 * @Description 封装Action信息
 * @Author Lambert
 * @Date 4/12/2020 11:31 AM
 * @Version 1.0
 **/
public class Handler
{
    private Class<?> controllerClass;
    private Method actionMethod;

    public Handler(Class<?> controllerClass, Method actionMethod)
    {
        this.controllerClass = controllerClass;
        this.actionMethod = actionMethod;
    }

    public Class<?> getControllerClass()
    {
        return controllerClass;
    }

    public Method getActionMethod()
    {
        return actionMethod;
    }
}
