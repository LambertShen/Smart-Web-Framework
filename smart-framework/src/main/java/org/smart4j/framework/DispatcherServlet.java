package org.smart4j.framework;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.smart4j.framework.bean.Data;
import org.smart4j.framework.bean.Handler;
import org.smart4j.framework.bean.Param;
import org.smart4j.framework.bean.View;
import org.smart4j.framework.helper.BeanHelper;
import org.smart4j.framework.helper.ConfigHelper;
import org.smart4j.framework.helper.ControllerHelper;
import org.smart4j.framework.util.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName DispatcherServlet
 * @Description 请求转发器
 * @Author Lambert
 * @Date 4/14/2020 9:40 AM
 * @Version 1.0
 **/

@WebServlet(urlPatterns = "/*", loadOnStartup = 0)
public class DispatcherServlet extends HttpServlet
{
    @Override
    public void init(ServletConfig servletConfig) throws ServletException
    {
        // 初始化相关的 Helper 类
        HelperLoader.init();
        //获取 ServletContext 对象(用于注册 Servlet)
        ServletContext servletContext = servletConfig.getServletContext();
        // 注册处理 JSP 的 Servlet
        ServletRegistration jspServlet = servletContext.getServletRegistration("jsp");
        jspServlet.addMapping(ConfigHelper.getAppJspPath() + "*");
        //注册处理静态资源的默认 Servlet
        ServletRegistration defaultServlet = servletContext.getServletRegistration("defalut");
        defaultServlet.addMapping(ConfigHelper.getAppAssetPath() + "*");
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        // 获取请求方法与请求路径
        String requestMethod = request.getMethod().toLowerCase();
        String requestPath = request.getPathInfo();
        // 获取 Action 处理器
        Handler handler = ControllerHelper.getHandler(requestMethod, requestPath);
        if(handler != null)
        {
            Class<?> controllerClass = handler.getControllerClass();
            Object controllerBean = BeanHelper.getBean(controllerClass);
            //创建请求参数对象
            HashMap<String, Object> paramMap = new HashMap<>();
            Enumeration<String> paramNames = request.getParameterNames();
            while(paramNames.hasMoreElements())
            {
                String paramName = paramNames.nextElement();
                String paramValue = request.getParameter(paramName);
                paramMap.put(paramName, paramValue);
            }
            String streamStr = StreamUtil.getString(request.getInputStream());
            String body = CodecUtil.decodeURL(streamStr);
            if(StringUtil.isNotEmpty(body))
            {
                String[] params = StringUtils.split(body, "&");
                if(ArrayUtils.isNotEmpty(params))
                {
                    for(String param : params)
                    {
                        String[] array = StringUtils.split(param, "=");
                        if(ArrayUtils.isNotEmpty(array) && array.length == 2)
                        {
                            String paramName = array[0];
                            String paramValue = array[1];
                            paramMap.put(paramName, paramValue);
                        }
                    }
                }
            }

            Param param = new Param(paramMap);
            //调用 Action 方法
            Method actionMethod = handler.getActionMethod();
            Object result = ReflectionUtil.invokeMethod(controllerBean, actionMethod, param);
            //调用 Action 方法返回值
            if(result instanceof View)
            {
                //返回 JSP 页面
                View view = (View)request;
                String path = view.getPath();
                if(StringUtil.isNotEmpty(path))
                {
                    if(path.startsWith("/"))
                    {
                        response.sendRedirect(request.getContextPath() + path);
                    }
                    else
                    {
                        Map<String, Object> model = view.getModel();
                        for(Map.Entry<String, Object> entry : model.entrySet())
                        {
                            request.setAttribute(entry.getKey(), entry.getValue());
                        }
                        request.getRequestDispatcher(ConfigHelper.getAppJspPath() + path).forward(request, response);
                    }
                }
            }
            else if(result instanceof Data)
            {
                //返回 JSON 数据
                Data data = (Data)result;
                Object model = data.getModel();
                if(model != null)
                {
                    response.setContentType("application/json");
                    response.setCharacterEncoding("UTF-8");
                    PrintWriter writer = response.getWriter();
                    String json = JsonUtil.toJson(model);
                    writer.write(json);
                    writer.flush();
                    writer.close();
                }
            }
        }
    }
}
