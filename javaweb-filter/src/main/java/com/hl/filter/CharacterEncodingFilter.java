package com.hl.filter;

import javax.servlet.*;
import java.io.IOException;

public class CharacterEncodingFilter implements Filter {
    //初始话 web服务器启动的时候 过滤器就初始话了 随时等待过滤对象出现
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.print("CharacterEncodingFilter 已经初始化了");
    }

    //Chain 链
    /*
    * 1 过滤中的所有代码,在过滤特定请求的时候都会执行
    * 2 必须要让过滤器继续同行
    * filterChain.doFilter(servletRequest,servletResponse);
    * */
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setCharacterEncoding("utf-8");
        servletResponse.setContentType("text/html,charset=UTF-8");

        System.out.print("CharacterEncodingFilter 执行前.....");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.print("CharacterEncodingFilter 执行后.....");

    }

    //销毁
    public void destroy() {
        System.out.print("CharacterEncodingFilter 已经销毁了");
    }
}
