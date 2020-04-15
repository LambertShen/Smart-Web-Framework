package org.smart4j.proxy.test2;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @ClassName SampleClass
 * @Description TODO
 * @Author Lambert
 * @Date 4/15/2020 10:01 AM
 * @Version 1.0
 **/
public class SampleClass
{
    public void test()
    {
        System.out.println("hello world");
    }

    public static void main(String[] args)
    {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(SampleClass.class);
        enhancer.setCallback(new MethodInterceptor()
        {
            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable
            {
                System.out.println("before method run...");
                Object result = proxy.invokeSuper(obj, args);
                System.out.println("after method run...");
                return result;
            }
        });
        SampleClass sampleClass = (SampleClass) enhancer.create();
        sampleClass.test();
    }
}
