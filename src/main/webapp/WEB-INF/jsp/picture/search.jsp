<%--
  Created by IntelliJ IDEA.
  User: 17343
  Date: 2019/3/21
  Time: 20:41
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
    <script>
        function judgment() {
            var a=document.getElementById("tagName").value;
            //var i = parseInt(a)
            if(a!=null && a!="" ){
                window.location.href = "/picture/search/"+a;
                //alert(a);
            }
            else {
                alert("输入异常");
            }
            // alert(a);
        }
    </script>
</head>
<body>
<form class="form-horizontal">
    <div class="form-group">
        <label for="tagName" class="col-sm-2 control-label">搜索（根据tag）</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="tagName" placeholder="text">
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
            <input type="button" class="btn btn-default" onclick="judgment()" value="确定">
        </div>
    </div>
</form>

</body>
</html>
