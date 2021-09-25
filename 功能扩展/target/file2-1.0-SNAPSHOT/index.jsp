<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<!---->
<!---->
<!--文件上传必须通过表单
    get方法 上传文件的限制大小
    post方法 上传文件没有大小
-->
<form action="${pageContext.request.contextPath}/update.do" method="post" enctype="multipart/form-data">
    上传用户: <input type="text" name="username"><br/>
    <p><input type="file" name="file1"></p>
    <p><input type="file" name="file2"><br/></p>
    <p><input type="submit">  |  <input type="reset"></p>

</form>
</body>
</html>