package org.smart4j.proxy.test;

/**
 * @ClassName TestApplication
 * @Description TODO
 * @Author Lambert
 * @Date 4/14/2020 1:15 PM
 * @Version 1.0
 **/
public class TestApplication
{
    public static void main(String[] args)
    {
        DynamicProxy dynamicProxy = new DynamicProxy(new PersonImpl());
        Person  proxy = dynamicProxy.getProxy();
        proxy.say();
    }
}
