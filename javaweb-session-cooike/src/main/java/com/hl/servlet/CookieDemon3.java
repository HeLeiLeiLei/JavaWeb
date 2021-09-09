package com.hl.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;

public class CookieDemon3 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //设置中文乱码问题
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        //才创建外浏览器
        PrintWriter out = resp.getWriter();
        //获取cookice
        Cookie[] cookies = req.getCookies();
        if(cookies != null){
            out.write("你上一次访问:");
            for (int i = 0; i < cookies.length; i++) {
                if(cookies[i].getName().equals("name")){
                    //out.write(cookies[i].getValue());
                    out.write(URLDecoder.decode(cookies[i].getValue(),"utf-8"));
                }
            }
        }else{
            out.write("你是第一次进入本站");
        }
        //Cookie cookie=new Cookie("name", "何雷");
        Cookie cookie=new Cookie("name", URLEncoder.encode("何雷","utf-8"));
        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}