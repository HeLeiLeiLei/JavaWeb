<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<%--JSP表达式
作用:用来将程序的输出，输出到客户端
<%= 变量名或表达式%>

--%>
<%=new java.util.Date()%>
<hr>
<%--JSP脚本片段--%>
<%
    int sum=0;
    for (int i = 1; i <=5 ; i++) {
        sum+=i;
    }
    out.print("<h1>"+sum+"</h1>");
%>
<hr>
<%
    int x=10;
    out.print(x);
%>
<p>这里是jsp</p>
<%
    out.print("<h1>"+x+"</h1>");
%>
<hr>
<%
    for (int i = 0; i < 5; i++) {
        out.println("<h1> 何雷"+i+"</h1>");
%>
<%
    }
%>

<%!
    static {
        System.out.print("Lading Servlet");
    }
    public void test(){
        System.out.print("进入到这个方法了");
    }
%>
















</body>
</html>
