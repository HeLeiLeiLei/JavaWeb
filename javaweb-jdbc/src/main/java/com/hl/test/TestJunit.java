package com.hl.test;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//@Test注解只在方法上有效
public class TestJunit {

    Connection connection=null;
    @Test
    public void Say() throws SQLException {
        //配置信息
        //useUnicode=true&characterEncoding=utf-8 解决中文乱码
        String url="jdbc:mysql://localhost:3306/jdbc?useUnicode=true&characterEncoding=utf-8";
        String username="root";
        String password="123456";
        try {
            //1 加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2 链接数据库
            connection= DriverManager.getConnection(url, username, password);
            //3 通知数据库开启事物,false是开启
            connection.setAutoCommit(false);
            //4 编写sql语句 执行sql
            String sql1="update account set money=money+200 where name='A'";
            connection.prepareStatement(sql1).executeUpdate();

            //制造错误
            //int i=1/0;

            connection.commit();
            System.out.println("执行成功");
        } catch (Exception e) {
            connection.rollback();
            e.printStackTrace();
        }finally {
            connection.close();
        }
    }
}
