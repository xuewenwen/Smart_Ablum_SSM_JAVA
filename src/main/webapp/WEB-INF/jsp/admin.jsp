<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/3/23
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html style="overflow: hidden;">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <meta name="keywords" content="">
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <!-- Bootstrap Core CSS -->
    <link href="../ts/bootstrap.min.css" rel="stylesheet" type="text/css">
    <!-- Custom CSS -->
    <link href="../ts/style.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="../ts/morris.css" type="text/css">
    <!-- Graph CSS -->
    <link href="../ts/font-awesome.css" rel="stylesheet">
    <!-- jQuery -->
    <script src="../ts/jquery-2.1.4.min.js.下载"></script>
    <!-- //jQuery -->
    <link href="../ts/css" rel="stylesheet" type="text/css">
    <link href="../ts/css(1)" rel="stylesheet" type="text/css">
    <!-- lined-icons -->
    <link rel="stylesheet" href="../ts/icon-font.min.css" type="text/css">
    <!-- //lined-icons -->
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

    <style type="text/css">
        .div-td{width: 100%;font-size: 18px}
        .div-td table td{line-height: 70px }
        .div-td tr:nth-child(even){background: rgb(228, 228, 227);}
    </style>
</head>

<body>
<div class="sidebar-menu">
    <header class="logo1">
        <a href="" class="sidebar-icon"> <span class="fa fa-bars"></span> </a>
    </header>
    <h1>橘猫智能相册</h1>
    <div style="border-top:1px ridge rgba(219, 215, 215, 0.253)"></div>
    <div class="menu">
        <ul id="menu">
            <li id="menu-academico"><a href=""><i class="fa fa-list-ul" aria-hidden="true"></i><span> 用户管理</span> <span class="fa fa-angle-right" style="float:right"></span><div class="clearfix"></div></a>
                <ul id="menu-academico-sub">
                    <li id="menu-academico-avaliacoes"><a href="">用户信息统计</a></li>
                    <li id="menu-academico-avaliacoes"><a href="">用户信息统计</a></li>
                    <li id="menu-academico-avaliacoes"><a href="">用户信息统计</a></li>
                </ul>
            </li>
            </ul>
    </div>
</div>
<form class="form-inline">
    <div class="form-group" style="height:40px;width:250px;margin-left:235px;margin-top:58px;">
        <input type="text" class="form-control" id="exampleInputEmail3" placeholder="用户ID">
    </div>
    <button type="submit" class="btn btn-default" style="height:35px;width:100px;margin-left:-60px;margin-top:55px;">搜索</button>
</form>

<div class="div-td">
    <table  width="88%" border="1" align="right" style="text-align:center;vertical-align:middle;">
        <tr>
            <td> ID</td>
            <td> 用户</td>
            <td> 邮箱</td>
            <td> 存储的照片数</td>
            <td> 使用空间</td>
            <td> 最后登录时间</td>
            <td> 用户状态</td>
        </tr>
    </table>
</div>
</body>
</html>
