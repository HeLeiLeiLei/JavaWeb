package com.hl.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class CookieDemonServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置中文乱码问题
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        
        //创建一个往浏览器写的对象 
        PrintWriter out = resp.getWriter();

        //获取cookice
        Cookie[] cookies = req.getCookies();
        if(cookies != null){
            out.write("你上一次访问的时间是:");
            for (int i = 0; i < cookies.length; i++) {
                if(cookies[i].getName().equals("lastLoginTime")){
                    long lastLoginTime = Long.parseLong(cookies[i].getValue());
                    Date date = new Date(lastLoginTime);
                    out.write(date.toLocaleString());
                }
            }
        }else{
            out.write("你是第一次进入本站");
        }

        //System.currentTimeMillis() 获取当前系统时间  +"" 是转化为字符串
        Cookie cookie = new Cookie("lastLoginTime", System.currentTimeMillis()+"");
        //设置cookie的保存时间  24*60*60 就表示一天 有效期就为一天
        cookie.setMaxAge(24*60*60);
        //把记录到的会话 返回给用户端
        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
