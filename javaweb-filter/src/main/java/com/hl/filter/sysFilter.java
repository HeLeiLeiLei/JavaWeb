package com.hl.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class sysFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest rqe, ServletResponse reps, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) rqe;
        HttpServletResponse response = (HttpServletResponse) reps;
        if(request.getSession().getAttribute("USER_SESSION") == null){
            response.sendRedirect(request.getContextPath()+"/sys/error.jsp");
        }
        filterChain.doFilter(rqe,reps);
    }

    public void destroy() {

    }
}
