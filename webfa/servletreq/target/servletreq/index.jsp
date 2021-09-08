<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <form action="${pageContext.request.contextPath}/login" method="post">
        名字:<input type="text" name="username"><br>
        密码:<input type="password" name="password"><br>
        爱好:
        <input type="checkbox" name="hobbys" value="游戏"/>游戏
        <input type="checkbox" name="hobbys" value="皮皮虾"/>皮皮虾
        <input type="checkbox" name="hobbys" value="打羽毛球"/>打羽毛球
        <input type="checkbox" name="hobbys" value="喝水"/>喝水
        <br>
        <input type="submit">
    </form>
</div>
</body>
</html>
