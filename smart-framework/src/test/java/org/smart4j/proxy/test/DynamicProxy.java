package org.smart4j.proxy.test;

import org.omg.CORBA.portable.InvokeHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName DynamicProxy
 * @Description TODO
 * @Author Lambert
 * @Date 4/14/2020 1:16 PM
 * @Version 1.0
 **/
public class DynamicProxy implements InvocationHandler
{

    private Object target;

    public DynamicProxy(Object target)
    {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
    {
        before();
        Object result = method.invoke(target, args);
        after();
        return result;
    }

    @SuppressWarnings("unchecked")
    public <T> T getProxy()
    {
        T result = null;
        result = (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
        return result;
    }

    private void before()
    {
        System.out.println("before....");
    }

    private void after()
    {
        System.out.println("after....");
    }
}
