package com.hl.test;

import java.sql.*;

public class TestJDBC {
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
        //Statement 是不安全的
        // 向数据库发送sql的对象Statement:CRUD
        Statement statement = connection.createStatement();
        //4 编写sql
        String sql="SELECT * FROM people";
        //增删改都使用executeUpdate即可
//        String sql="delte from people where id=4";
//        int i = statement.executeUpdate(sql);
        //5 执行sql 返回一个结果集 只要这一个方法executeQuery 才有结果集
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()){
            System.out.println("id"+resultSet.getObject("id"));
            System.out.println("name"+resultSet.getObject("name"));
            System.out.println("age"+resultSet.getObject("age"));
            System.out.println("address"+resultSet.getObject("address"));
        }


        //6 关闭链接 释放资源(一定要做到) 先开后关
        resultSet.close();
        statement.close();
        connection.close();
    }
}
