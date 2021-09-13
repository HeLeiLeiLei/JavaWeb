package com.hl.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println(req.getParameter("username"));
        String username = req.getParameter("username");

        if(username.equals("admin")){
            req.getSession().setAttribute("USER_SESSION",req.getSession().getId());
            //System.out.println(this.getServletContext().getContextPath()+"/sys/succes.jsp");
            //System.out.println(req.getContextPath()+"/sys/succes.jsp");
            resp.sendRedirect(req.getContextPath()+"/sys/succes.jsp");
        }else{
            resp.sendRedirect(req.getContextPath()+"/sys/error.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
