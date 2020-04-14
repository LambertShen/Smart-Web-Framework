package org.smart4j.framework.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @ClassName CodecUtil
 * @Description 编码与解码操作工具类
 * @Author Lambert
 * @Date 4/14/2020 10:15 AM
 * @Version 1.0
 **/
public class CodecUtil
{
    private static final Logger LOGGER = LoggerFactory.getLogger(CodecUtil.class);

    /**
     *  将 URL 编码
     */
    public static String encodeURL(String source)
    {
        String target = null;
        try
        {
            target = URLEncoder.encode(source, "UTF-8");
        }
        catch (Exception e)
        {
            LOGGER.error("encode url failure", e);
            throw new RuntimeException(e);
        }
        return target;
    }

    /**
     *  将 URL 解码
     */
    public static String decodeURL(String source)
    {
        String target = null;
        try
        {
            target = URLDecoder.decode(source, "UTF-8");
        }
        catch (Exception e)
        {
            LOGGER.error("decode url failure", e);
            throw new RuntimeException(e);
        }
        return target;
    }
}
