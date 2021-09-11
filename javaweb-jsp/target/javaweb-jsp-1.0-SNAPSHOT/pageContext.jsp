<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<!--内置对象-->
<%
    request.setAttribute("name1","何雷1");
    pageContext.setAttribute("name2","何雷2");
    session.setAttribute("name3","何雷3");
    application.setAttribute("name4","何雷4");
%>

<!--通过pageContext取出我们保存的值-->
<%
    String name1 = (String) pageContext.findAttribute("name1");
    String name2= (String) pageContext.findAttribute("name2");
    String name3= (String) pageContext.findAttribute("name3");
    String name4= (String) pageContext.findAttribute("name4");
    String name5= (String) pageContext.findAttribute("name5");
%>

<!--通过EL表达式 来输出-->
<h1>取出的值为</h1>
<h3>${name1}</h3>
<h3>${name2}</h3>
<h3>${name3}</h3>
<h3>${name4}</h3>
<h3><%=name5%></h3>
</body>
</html>
