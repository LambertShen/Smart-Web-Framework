package org.smart4j.framework.bean;

import org.smart4j.framework.util.CastUtil;

import java.util.Map;

/**
 * @ClassName Param
 * @Description 请求参数对象
 * @Author Lambert
 * @Date 4/14/2020 9:26 AM
 * @Version 1.0
 **/
public class Param
{
    private Map<String, Object> paramMap;

    public Param(Map<String, Object> paramMap)
    {
        this.paramMap = paramMap;
    }

    /**
     * 根据参数名获取 long 型参数值
     */
    public long getLong(String name)
    {
        return CastUtil.castLong(paramMap.get(name));
    }

    /**
     *  获取所有字段信息
     */
    public Map<String, Object> getMap()
    {
        return paramMap;
    }
}
