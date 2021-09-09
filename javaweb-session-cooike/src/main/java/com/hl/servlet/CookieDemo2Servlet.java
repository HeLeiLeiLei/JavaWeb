package com.hl.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CookieDemo2Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //System.currentTimeMillis() 获取当前系统时间  +"" 是转化为字符串
        Cookie cookie = new Cookie("lastLoginTime", System.currentTimeMillis()+"");
        //设置cookie的保存时间  有效期设置为0
        cookie.setMaxAge(0);
        //把记录到的会话 返回给用户端
        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

