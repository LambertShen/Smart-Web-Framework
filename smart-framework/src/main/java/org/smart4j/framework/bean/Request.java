package org.smart4j.framework.bean;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @ClassName Request
 * @Description 封装请求方法
 * @Author Lambert
 * @Date 4/12/2020 11:14 AM
 * @Version 1.0
 **/
public class Request
{
    private String requestMethod;
    private String requestPath;

    public Request(String requestMethod, String requestPath)
    {
        this.requestMethod = requestMethod;
        this.requestPath = requestPath;
    }

    public String getRequestMethod()
    {
        return requestMethod;
    }

    public String getRequestPath()
    {
        return requestPath;
    }

    @Override
    public int hashCode()
    {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object obj)
    {
        return EqualsBuilder.reflectionEquals(this, obj);
    }
}
