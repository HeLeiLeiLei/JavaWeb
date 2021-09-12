<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    ArrayList<String> arrayList=new ArrayList();
    arrayList.add(0,"哈哈");
    arrayList.add(1,"呵呵");
    arrayList.add(2,"火花");
    arrayList.add(3,"小何");
    arrayList.add(4,"小站");
    arrayList.add(5,"小型");
    request.setAttribute("list",arrayList);
%>

<!--
   var 每一次遍历出来的对象
   items 遍历的对象
   begin 集合第一个元素
   end 集合的last元素
   step 步长
-->
<c:forEach var="arrayList" items="${list}">
    <c:out value="${arrayList}"/><br>
</c:forEach>

<hr>

<c:forEach begin="0" end="6" step="3" items="${list}" var="arrlist">
    <c:out value="${arrlist}"/>
    <c:out value="------------"/>
</c:forEach>

</body>
</html>
