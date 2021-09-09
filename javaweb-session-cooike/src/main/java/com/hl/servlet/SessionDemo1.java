package com.hl.servlet;

import com.hl.pojo.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SessionDemo1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决乱码问题
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html,charset=utf-8");
        //得到session
        HttpSession session=req.getSession();
        //给Session中存东西
        session.setAttribute("name",new Person("何雷",18));
        //获取Session的IDS
        String sessionID = session.getId();
        //判断Session是不是新创建
        if(session.isNew()){
            resp.getWriter().write("Session创建成功 ID："+sessionID);
        }else {
            resp.getWriter().write("Session已经存在 ID: "+sessionID);
        }



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
