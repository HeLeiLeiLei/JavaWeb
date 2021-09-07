package com.hl.servlet;

import com.sun.corba.se.spi.protocol.RequestDispatcherDefault;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ServletDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context=this.getServletContext();
        //设置返回类型编码格式
        //resp.setContentType("text/html");
        //resp.setCharacterEncoding("utf-8");

        //RequestDispatcher rd=context.getRequestDispatcher("/ServletDemo");
        //rd.forward(req,resp);

        context.getRequestDispatcher("/ServletDemo").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}