package org.smart4j.framework.util;

import org.apache.commons.lang3.StringUtils;

/**
 * @ClassName StringUtil
 * @Description String 操作助手类
 * @Author Lambert
 * @Date 4/12/2020 1:06 AM
 * @Version 1.0
 **/
public final class StringUtil
{
    public static boolean isEmpty(String str)
    {
        return StringUtils.isEmpty(str) && StringUtils.isBlank(str);
    }

    public static boolean isNotEmpty(String str)
    {
        return StringUtils.isNotEmpty(str) && StringUtils.isNotBlank(str);
    }
}
