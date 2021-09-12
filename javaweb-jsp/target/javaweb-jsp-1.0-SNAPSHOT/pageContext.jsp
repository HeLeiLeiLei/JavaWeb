<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<!--内置对象-->
<%
    request.setAttribute("name1","何雷1");//保存的数据在一次请求中有效，请求转发会携带数据
    pageContext.setAttribute("name2","何雷2");//保存的数据在当前页面中有效
    session.setAttribute("name3","何雷3");//保存的数据在一次会话中有效,打开浏览器到关闭浏览器
    application.setAttribute("name4","何雷4");//保存的数据在整个服务器中有效，服务器打开到服务器关闭
%>

<!--通过pageContext取出我们保存的值-->

<%
    //从底层到高层() pageContext->request->session->application
    //jvm 双亲委派机制
    String name1 = (String) pageContext.findAttribute("name1");
    String name2= (String) pageContext.findAttribute("name2");
    String name3= (String) pageContext.findAttribute("name3");
    String name4= (String) pageContext.findAttribute("name4");
    String name5= (String) pageContext.findAttribute("name5");

    pageContext.forward("/pageDemo2.jsp");
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
