package org.smart4j.framework.util;

import org.apache.commons.lang3.StringUtils;

/**
 * @ClassName CastUtil
 * @Description TODO
 * @Author Lambert
 * @Date 4/14/2020 9:28 AM
 * @Version 1.0
 **/
public class CastUtil
{
    public static String castString(Object obj)
    {
        return CastUtil.castString(obj, "");
    }

    public static String castString(Object obj, String defaultValue)
    {
        return obj != null ? String.valueOf(obj) : defaultValue;
    }

    public static double castDouble(Object obj)
    {
        return CastUtil.castDouble(obj, 0);
    }

    public static double castDouble(Object obj, double defaultValue)
    {
        double doubleValue = defaultValue;
        if(obj != null)
        {
            String strValue = castString(obj);
            if(StringUtils.isNotEmpty(strValue))
            {
                try
                {
                    doubleValue = Double.parseDouble(strValue);
                }
                catch (NumberFormatException e)
                {
                    doubleValue = defaultValue;
                }
            }
        }
        return doubleValue;
    }

    public static long castLong(Object obj)
    {
        return castLong(obj, 0L);
    }

    public static long castLong(Object obj, long defalutValue)
    {
        long longValue = defalutValue;
        if(obj != null)
        {
            String strValue = castString(obj);
            try
            {
                longValue = Long.parseLong(strValue);
            }
            catch (NumberFormatException e)
            {
                longValue = defalutValue;
            }
        }
        return longValue;
    }

    public static int castInt(Object obj)
    {
        return castInt(obj, 0);
    }

    public static int castInt(Object obj, int defalutValue)
    {
        int longValue = defalutValue;
        if(obj != null)
        {
            String strValue = castString(obj);
            try
            {
                longValue = Integer.parseInt(strValue);
            }
            catch (NumberFormatException e)
            {
                longValue = defalutValue;
            }
        }
        return longValue;
    }

    public static boolean castBoolean(Object obj)
    {
        return castBoolean(obj, false);
    }

    public static boolean castBoolean(Object obj, boolean defalutValue)
    {
        boolean longValue = defalutValue;
        if(obj != null)
        {
            String strValue = castString(obj);
            try
            {
                longValue = Boolean.parseBoolean(strValue);
            }
            catch (NumberFormatException e)
            {
                longValue = defalutValue;
            }
        }
        return longValue;
    }
}

