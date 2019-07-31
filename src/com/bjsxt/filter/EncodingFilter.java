package com.bjsxt.filter;

import javax.servlet.*;
import java.io.IOException;

public class EncodingFilter implements Filter {
    private String encoding=null;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        encoding=filterConfig.getInitParameter("encoding");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //过滤器的处理操作
        request.setCharacterEncoding(encoding);
        //调用下一个过滤器或者目标资源（没有下一个过滤器）
        chain.doFilter(request,response);
        //下一个过滤器或者目标资源响应完成后的后续处理
    }

    @Override
    public void destroy() {

    }
}
