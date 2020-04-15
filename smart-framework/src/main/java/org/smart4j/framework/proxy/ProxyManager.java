package org.smart4j.framework.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.List;

/**
 * @ClassName ProxyManager
 * @Description 代理管理器
 * @Author Lambert
 * @Date 4/15/2020 9:54 AM
 * @Version 1.0
 **/
public class ProxyManager
{
    @SuppressWarnings("unchecked")
    public static <T> T createProxy(final Class<?> targetClass, final List<Proxy> proxyList)
    {
        return (T) Enhancer.create(targetClass, new MethodInterceptor()
        {
            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable
            {
                return new ProxyChain(targetClass, obj, method, proxy, args, proxyList);
            }
        });
    }
}
