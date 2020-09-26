<%--
  Created by IntelliJ IDEA.
  User: lyl
  Date: 2020/9/27
  Time: 0:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <a href="account/findAll">test find all</a>

    <hr>

    <form action="account/save" method="post">
        name: <input type="text" name="name"><br>
        money: <input type="text" name="money"><br>
        <input type="submit" value="save">
    </form>

</body>
</html>
