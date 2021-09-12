<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<!--定义一个变量 core 值为85-->
<c:set var="score" value="85"/>
    <c:choose>
        <c:when test="${score>=90}">
            你的成绩为优秀
        </c:when>
        <c:when test="${score>=80}">
            你的成绩为中等
        </c:when>
        <c:when test="${score>=60}">
            你的成绩为合格
        </c:when>
        <c:when test="${score<60}">
            你的成绩为不及格
        </c:when>
    </c:choose>

</body>
</html>
