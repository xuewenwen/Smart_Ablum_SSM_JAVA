<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 17343
  Date: 2019/3/30
  Time: 13:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>相册首页</title>
</head>
<body>
<c:forEach items="${album}" var="album">
    <img src="${album.albumCover}">
    <label >${album.albumName}</label>
    <br/>
</c:forEach>


</body>
</html>
