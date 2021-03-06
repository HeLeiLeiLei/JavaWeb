package com.hl.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class ImageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //生成验证码

        //如何让浏览器每三秒刷新一次
        resp.setHeader("refresh","3");

        //在内存中创建一个图片
        BufferedImage image = new BufferedImage(80,20,BufferedImage.TYPE_INT_RGB);
        //得到图片
        Graphics2D graphics = (Graphics2D) image.getGraphics();//笔
        //设置图片的背景颜色
        graphics.setColor(Color.white);
        graphics.fillRect(0,0,80,20);
        //给图片写数据
        graphics.setColor(Color.BLUE);
        graphics.setFont(new Font(null,Font.ITALIC,20));
        graphics.drawString(makeNum(),0,20);

        //告诉浏览器整个请求用图片的方式打开
        resp.setContentType("image/png");

        //告诉浏览器不要缓存 因为网站自己存在缓存
        resp.setDateHeader("expires",-1);
        resp.setHeader( "Cache-Control" , "no-Cache" );
        resp.setHeader("Pragma","no-Cache");

        //把图片写给浏览器
        ImageIO.write(image,"png",resp.getOutputStream());
    }

    //生成随机数
    private String makeNum(){
        Random random = new Random();
        String num = random.nextInt(999999)+"";
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<6-num.length();i++){
            sb.append(0);
        }
        num=sb.toString()+num;
        return num;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
