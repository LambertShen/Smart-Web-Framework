package org.smart4j.framework.proxy;

/**
 * @InterfaceName Proxy
 * @Description 代理接口
 * @Author Lambert
 * @Date 4/14/2020 5:27 PM
 * @Version 1.0
 **/
public interface Proxy
{
    /**
     *  执行链式编程
     */
    Object doProxy(ProxyChain proxyChain) throws Throwable;
}
