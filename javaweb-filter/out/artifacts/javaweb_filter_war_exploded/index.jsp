<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1><span style="color: cornflowerblue">当前在线人数:<%=this.getServletConfig().getServletContext().getAttribute("OnlineCount")%>人</span></h1>
  </body>
</html>
