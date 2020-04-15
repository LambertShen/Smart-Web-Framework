package org.smart4j.proxy.test;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @ClassName CGLibProxy
 * @Description TODO
 * @Author Lambert
 * @Date 4/14/2020 4:13 PM
 * @Version 1.0
 **/
public class CGLibProxy implements MethodInterceptor
{

    public <T> T getProxy(Class<T> cls)
    {
        return (T) Enhancer.create(cls, this);
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable
    {
        before();
        Object result = proxy.invokeSuper(obj, args);
        after();
        return null;
    }

    public void before()
    {
        System.out.println("before");
    }

    public void after()
    {
        System.out.println("after");
    }
}
