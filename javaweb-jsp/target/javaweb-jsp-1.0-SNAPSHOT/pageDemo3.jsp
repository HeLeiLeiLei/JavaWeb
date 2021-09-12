<%--
  Created by IntelliJ IDEA.
  User: 65181
  Date: 2021/9/12
  Time: 16:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    //pageContext.forward("/index.jsp");// 转发 URl不会发生改变
    response.sendRedirect("index.jsp");//重定向 URL发生改变  这里不用加"/ "
%>
 <%
    pageContext.setAttribute("hello1","hello2",pageContext.SESSION_SCOPE);
    //等价于 session.setAttribute();
 %>

</body>
</html>
