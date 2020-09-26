<%--
  Created by IntelliJ IDEA.
  User: lyl
  Date: 2020/9/27
  Time: 0:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>list</h1>
<c:forEach items="${list}" var="account">
    ${account.name}
    ${account.money}
</c:forEach>
</body>
</html>
