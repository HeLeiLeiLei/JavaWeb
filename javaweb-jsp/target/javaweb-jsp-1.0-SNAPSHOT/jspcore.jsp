<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>if test</title>
</head>
<body>
<form action="jspcore.jsp" method="get">
    名字:<input type="text" name="username"><br>
    密码:<input type="password" name="password"><br>
    <input type="submit" value="登录">
</form>

<!--判断是否为管理员-->
<%--<%--%>
<%--    if(request.getParameter("username").equals("admin")){--%>
<%--        System.out.print("管理员欢迎你");--%>
<%--    }--%>
<%--%>--%>
<!--判断是否为管理员-->

<c:if test="${param.username == 'admin'}" var="isadmin">
    <c:out value="管理员欢迎你"/>
</c:if>

<c:out value="${isadmin}"/>

</body>
</html>
