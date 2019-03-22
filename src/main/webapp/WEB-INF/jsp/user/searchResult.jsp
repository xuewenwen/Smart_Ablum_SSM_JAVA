<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 17343
  Date: 2019/3/21
  Time: 15:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
    <title>Title</title>
</head>
<body>
<form name="userList" >
    <table border="1" align="center" class="table table-striped">
        <tr>
            <td>ID</td>
            <td>用户名</td>
            <td>邮箱</td>
            <td>存储的照片数</td>
            <td>使用空间</td>
            <td>最后登录时间</td>
            <td>用户状态</td>
        </tr>
        <tr align="center">
            <%--<td>${user.USER_ID}</td>--%>
            <td><c:out value="${user.user_id}"></c:out></td>
            <td><c:out value="${user.user_name}"></c:out></td>
            <td><c:out value="${user.user_email}"></c:out></td>
            <td><c:out value="${user.count}"></c:out></td>
            <td><c:out value="${user.user_size}"></c:out></td>
            <td><c:out value="${user.user_last_login_time}"></c:out></td>
                <td>
                    <c:if test="${user.user_status==0}">
                        <button type="button" class="btn btn-warning">未激活</button>
                    </c:if>
                    <c:if test="${user.user_status==1}">
                        <button type="button" class="btn btn-danger">封禁</button>
                    </c:if>
                    <c:if test="${user.user_status==2}">
                        <button type="button" class="btn btn-success">解封</button>
                    </c:if>
                </td>
        </tr>
    </table>
</form>

</body>
</html>
