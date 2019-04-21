<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
