package org.smart4j.framework.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName JsonUtil
 * @Description JSON 工具类，用于JSON与POJO之间的转换，基于Jackson实现
 * @Author Lambert
 * @Date 4/14/2020 10:20 AM
 * @Version 1.0
 **/
public class JsonUtil
{
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonUtil.class);

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    /**
     *  将 POJO 转换为 JSON
     */
    public static <T> String toJson(T obj)
    {
        String json = null;
        try
        {
            json = OBJECT_MAPPER.writeValueAsString(obj);
        }
        catch (Exception e)
        {
            LOGGER.error("convert POJO to JSON failure", e);
        }
        return json;
    }

    /**
     *  将 JSON 转换为 POJO
     */
    public static <T> T fromJson(String json, Class<T> type)
    {
        T pojo = null;
        try
        {
            pojo = OBJECT_MAPPER.readValue(json, type);
        }
        catch (Exception e)
        {
            LOGGER.error("convert JSON to POJO failure", e);
            throw new RuntimeException(e);
        }
        return pojo;
    }
}
