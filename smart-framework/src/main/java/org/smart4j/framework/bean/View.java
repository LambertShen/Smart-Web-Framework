package org.smart4j.framework.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName View
 * @Description 返回视图对象
 * @Author Lambert
 * @Date 4/14/2020 9:35 AM
 * @Version 1.0
 **/
public class View
{
    private String path;

    private Map<String, Object> model;

    public View(String path)
    {
        this.path = path;
        model = new HashMap<>();
    }

    public View addModel(String key, Object value)
    {
        model.put(key, value);
        return this;
    }

    public Map<String, Object> getModel()
    {
        return model;
    }

    public String getPath()
    {
        return path;
    }
}
