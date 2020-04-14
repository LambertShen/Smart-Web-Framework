package org.smart4j.framework.bean;

/**
 * @ClassName Data
 * @Description 返回数据对象
 * @Author Lambert
 * @Date 4/14/2020 9:38 AM
 * @Version 1.0
 **/
public class Data
{
    private Object model;

    public Data(Object model)
    {
        this.model = model;
    }

    public Object getModel()
    {
        return model;
    }
}
