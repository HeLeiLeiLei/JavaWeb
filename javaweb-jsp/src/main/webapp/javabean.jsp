<%@ page import="com.hl.pojo.People" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<%--%>
<%--    People peopel = new People();--%>
<%--%>--%>
<!--jsp语法-->
<jsp:useBean id="people" class="com.hl.pojo.People" scope="page"/>
<jsp:setProperty name="people" property="id" value="1"/>
<jsp:setProperty name="people" property="name" value="何雷"/>
<jsp:setProperty name="people" property="age" value="18"/>
<jsp:setProperty name="people" property="address" value="西南交通大学"/>

<%--<%=people.getName()%>--%>
ID:<jsp:getProperty name="people" property="id"/>
名字:<jsp:getProperty name="people" property="name"/>
年龄:<jsp:getProperty name="people" property="age"/>
地址:<jsp:getProperty name="people" property="address"/>

</body>
</html>
