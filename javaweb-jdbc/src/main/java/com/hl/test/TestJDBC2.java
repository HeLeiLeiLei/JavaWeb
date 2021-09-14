package com.hl.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class TestJDBC2 {
    public static void main(String[] args) throws Exception {
        //配置信息
        //useUnicode=true&characterEncoding=utf-8 解决中文乱码
        String url="jdbc:mysql://localhost:3306/jdbc?useUnicode=true&characterEncoding=utf-8";
        String username="root";
        String password="123456";

        //1 加载驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2 链接数据库
        Connection connection = DriverManager.getConnection(url, username, password);
        //3 编写sql
        String sql="insert into people(id,name,age,address) values(?,?,?,?)";
        //4 预编译
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,4);//给第一个占位符设置值为4
        preparedStatement.setString(2,"哈哈");//给第二个占位符设置值为哈哈
        preparedStatement.setInt(3,20);//给第三个占位符设置值为20
        preparedStatement.setString(4,"成都市温江区西财学府阳光");//给第四个占位符设置值为成都市温江区西财学府阳光
        //5 执行sq
        int i = preparedStatement.executeUpdate();
        if(i>0){
            System.out.println("执行成功");
        }
        //6 关闭链接 释放资源
        preparedStatement.close();
        connection.close();
    }
}
