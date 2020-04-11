package org.smart4j.framework.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @ClassName PropsUtil
 * @Description TODO
 * @Author Lambert
 * @Date 4/11/2020 9:13 PM
 * @Version 1.0
 **/
public final class PropsUtil
{
    private static final Logger LOGGER = LoggerFactory.getLogger(PropsUtil.class);

    public static Properties loadProps(String fileName)
    {
        Properties props = null;
        InputStream is = null;
        try
        {
            is = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
            if(is == null)
            {
                throw new FileNotFoundException(fileName+"file is not found.");
            }
            props = new Properties();
            props.load(is);
        }
        catch (Exception e)
        {
            LOGGER.error("load properties file failure", e);
        }
        finally
        {
            if(is != null)
            {
                try
                {
                    is.close();
                }
                catch (Exception e)
                {
                    LOGGER.error("close input stream failure", e);
                }
            }
        }
        return props;
    }

    public static String getString(Properties props, String key)
    {
        return getString(props, key, "");
    }

    public static String getString(Properties props, String key, String defaultValue)
    {
        String value = defaultValue;
        if(props.containsKey(key))
        {
            value = props.getProperty(key);
        }
        return value;
    }
}
