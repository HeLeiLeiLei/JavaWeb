<%--
  Created by IntelliJ IDEA.
  User: 65181
  Date: 2021/9/12
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> </title>
</head>
<body>
<!--通过pageContext取出我们保存的值-->
<%
    String name1 = (String) pageContext.findAttribute("name1");
    String name2= (String) pageContext.findAttribute("name2");
    String name3= (String) pageContext.findAttribute("name3");
    String name4= (String) pageContext.findAttribute("name4");
    String name5= (String) pageContext.findAttribute("name5");

    String hello1= (String) pageContext.findAttribute("hello1");
%>

<!--通过EL表达式 来输出-->
<h1>取出的值为</h1>
<h3>${name1}</h3>
<h3>${name2}</h3>
<h3>${name3}</h3>
<h3>${name4}</h3>
<h3><%=name5%></h3>
<h3>bb${hello1}</h3>
</body>
</html>