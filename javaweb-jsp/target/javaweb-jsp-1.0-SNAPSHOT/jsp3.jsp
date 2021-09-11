<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jsp3</title>
</head>
<body>
<%--    @include 标签会将三个页面和二为一--%>
    <%@include file="common/header.jsp" %>
    <h1>网页主体</h1>
<%--    <%--%>
<%--        int i=10;--%>
<%--    %>--%>
    <%@include file="common/footer.jsp" %>

    <!--jsp标签-->
    <%--jsp:include标签还是三个页面--%>
    <jsp:include page="/common/header.jsp"/>
    <h1>网页主体</h1>
<%--    <%--%>
<%--        int i=10;--%>
<%--    %>--%>
    <jsp:include page="/common/footer.jsp"/>

</body>
</html>
