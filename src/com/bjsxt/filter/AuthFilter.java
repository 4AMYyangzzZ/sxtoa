package com.bjsxt.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String url = request.getRequestURL().toString();
        int i1=url.indexOf("login.jsp");
        int i2=url.indexOf("register.jsp");
        String queryString = request.getQueryString();
        int i3=-1;
        int i4=-1;
        if (queryString!=null){
            i3=queryString.indexOf("method=login");
            i4=queryString.indexOf("method=register");
        }
        if(i1>=0 || i2>=0 || i3>=0 || i4>=0){
            chain.doFilter(request,response);

        }else {
            HttpSession session = request.getSession();
            Object uname = session.getAttribute("uname");
            if (uname==null){
                response.sendRedirect(request.getContextPath()+"/login.jsp");
            }else {
                chain.doFilter(request,response);
            }
        }

    }

    @Override
    public void destroy() {

    }
}
