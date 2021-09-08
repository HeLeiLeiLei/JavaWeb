package com.hl.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

public class FileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //实现文件下载
        //1 获取下载文件的路径
        //String realPath = this.getServletContext().getRealPath("/何雷.png");
        String realPath = "E:\\webfa\\servletresp\\target\\classes\\何雷.PNG";
        //
        System.out.println("文件的路径是:"+realPath);//文件的路径是:E:\apache-tomcat-9.0.22\webapps\servletresp\何雷.png
        //2 下载文件名子是啥？
        String fileName=realPath.substring(realPath.lastIndexOf("\\")+1);
        //3 设置想办法让浏览器能够支持下载我们需要的东西
        resp.setHeader("Content-Disposition", "attachment;filename="+ URLEncoder.encode(fileName,"utf-8"));
        //4 获取下载文件的输入流
        FileInputStream fileInputStream = new FileInputStream(realPath);
        //5 创建缓冲区
        int len=0;
        byte[] buffer=new byte[1024];
        //6 获取OutputStream对象
        ServletOutputStream outputStream = resp.getOutputStream();
        //7 将FileOutputStream写入buffer缓冲区
        //8 使用OutputStream将缓冲区中的数据输出到客户端
        while ((len=fileInputStream.read(buffer))>0){
            outputStream.write(buffer,0,len);
        }
        //9 关闭流
        fileInputStream.close();
        outputStream.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
