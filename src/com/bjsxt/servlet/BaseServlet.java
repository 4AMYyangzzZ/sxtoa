package com.bjsxt.servlet;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {
    private Logger logger= Logger.getLogger(BaseServlet.class);
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //2.使用反射
        try {
            Method method = this.getClass().getDeclaredMethod(request.getParameter("method"),HttpServletRequest.class,HttpServletResponse.class);
            method.invoke(this,request,response);
        } catch (NoSuchMethodException e) {
            logger.fatal(e.getMessage());
        } catch (IllegalAccessException e) {
            logger.fatal(e.getMessage());
        } catch (InvocationTargetException e) {
            //logger.fatal(e.getMessage());
            e.printStackTrace();

        }
    }
}
