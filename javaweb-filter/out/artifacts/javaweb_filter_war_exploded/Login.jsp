<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>登录</h1>
<form action="${pageContext.request.contextPath}/servlet/login" method="post">
    <input type="text" name="username"><br>
    <input type="submit">
</form>
<br>
</body>
</html>
