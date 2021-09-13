package com.hl.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

// 统计网站 在线人数 : 统计session
public class OnlineCountListener implements HttpSessionListener {
    //创建session监听器 监视你的一举一动
    //一旦创建session就会出发这个事件
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        ServletContext sc = httpSessionEvent.getSession().getServletContext();
        System.out.println(httpSessionEvent.getSession().getId());
        Integer onlineCount = (Integer) sc.getAttribute("OnlineCount");
        if(onlineCount == null){
            onlineCount=new Integer(1);
        }else{
            int count=onlineCount.intValue();
            onlineCount=new Integer(count+1);
        }
        sc.setAttribute("OnlineCount",onlineCount);
    }

    //销毁session监听器
    //一旦销毁就会出发这个事件
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        ServletContext sc = httpSessionEvent.getSession().getServletContext();
        httpSessionEvent.getSession().invalidate();//销毁session
        System.out.println("一个session销毁了");
        Integer onlineCount = (Integer) sc.getAttribute("OnlineCount");
        if(onlineCount == null){
            onlineCount=new Integer(0);
        }else{
            int count=onlineCount.intValue();
            onlineCount=new Integer(count-1);
        }
        sc.setAttribute("OnlineCount",onlineCount);
    }
}
