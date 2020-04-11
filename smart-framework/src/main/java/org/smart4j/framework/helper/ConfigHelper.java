package org.smart4j.framework.helper;

import org.smart4j.framework.ConfigConstant;
import org.smart4j.framework.util.PropsUtil;

import java.util.Properties;

/**
 * @ClassName ConfigHelper
 * @Description 属性文件助手类
 * @Author Lambert
 * @Date 4/11/2020 9:11 PM
 * @Version 1.0
 **/
public final class ConfigHelper
{
    private static final Properties CONFIG_PROPS = PropsUtil.loadProps(ConfigConstant.CONFIG_FILE);

    /**
     *  获取 JDBC 驱动
     */
    public static String getJdbcDriver()
    {
        return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_DRIVER);
    }

    /**
     *  获取 JDBC URL
     */
    public static String getJdbcUrl()
    {
        return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_URL);
    }

    /**
     *  获取 JDBC 用户名
     */
    public static String getJdbcUserName()
    {
        return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_USERNAME);
    }

    /**
     *  获取 JDBC 密码
     */
    public static String getJdbcPassword()
    {
        return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_PASSWORD);
    }

    /**
     *  获取应用基础包名
     */
    public static String getAppBasePackage()
    {
        return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.APP_BASE_PACKAGE);
    }

    /**
     *  获取应用 JSP 路径
     */
    public static String getAppJspPath()
    {
        return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.APP_JSP_PATH, "/WEB-INF/view/");
    }

    /**
     *  获取应用静态路径资源
     */
    public static String getAppAssetPath()
    {
        return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.APP_ASSET_PATH, "/asset/");
    }
}
