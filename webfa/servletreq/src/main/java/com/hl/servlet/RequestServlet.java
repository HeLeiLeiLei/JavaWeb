package com.hl.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RequestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进入到request里面");

        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String[] hobbys = req.getParameterValues("hobbys");

        System.out.println("=================================");
        System.out.println(username);
        System.out.println(password);
        for(int i=0;i<hobbys.length;i++){
            System.out.println(hobbys[i].toString());
        }
        System.out.println("=================================");
        //请求转发 这里的 / 表示当前项目路径下
        //System.out.println(req.getContextPath()+"/Success.jsp");
        req.getRequestDispatcher("/Success.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
