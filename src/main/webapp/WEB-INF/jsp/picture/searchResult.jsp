<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 17343
  Date: 2019/3/23
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>搜索结果</title>
</head>
<body>
    <c:forEach items="${tag}" var="tag">
        <img src="${tag}"/>
        <hr/>
    </c:forEach>


</body>
</html>
