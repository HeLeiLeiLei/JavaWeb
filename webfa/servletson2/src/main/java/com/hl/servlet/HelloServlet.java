package com.hl.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        this.getInitParameterNames()//获取初始话参数
//        this.getServletConfig()//获取servlet的配置
//        this.getServletContext();//获取servlet上下问
        ServletContext context=this.getServletContext();
        String userName="何雷雷雷";

        //将一个数据保存在了servletContext中,名字为username 值为userName
        context.setAttribute("username",userName);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
