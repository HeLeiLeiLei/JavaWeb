<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>2</h1>
<%
   //String username= (String) request.getP("username");
%>
<%=request.getParameter("username")%>
<%c:out%>
</body>
</html>
