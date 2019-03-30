<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 17343
  Date: 2019/3/24
  Time: 13:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>回收站预览</title>
    <script src="/js/jquery.min.js"></script>
    <script>
        function fun() {
            var obj = document.getElementsByName("picture");
            var check_val = [];
            for(var k in obj){
                if(obj[k].checked)
                    check_val.push(obj[k].value);
            }
            var str = check_val.join(",");
            $.ajax({
                type:"POST",
                url:"/recycle/remove",
                contentType:false,
                dataType:"text",
                data:str,
                success: function(data){
                    list();
                    console.log(data);
                },
                error:function () {
                    alert("错误");
                }
            });
        }
    </script>
    <script>
        function fun1() {
            var obj = document.getElementsByName("picture");
            var check_val = [];
            for(var k in obj){
                if(obj[k].checked)
                    check_val.push(obj[k].value);
            }
            var str = check_val.join(",");
            $.ajax({
                type:"POST",
                url:"/recycle/removePicture",
                contentType:false,
                dataType:"text",
                data:str,
                success: function(data){
                    list();
                    console.log(data);
                },
                error:function () {
                    alert("错误");
                }
            });
        }
    </script>
</head>
<body>
<div id="list">
正在加载
</div>


<input type="button" value="移回到原来相册" onclick="fun()">
<script>
    function list() {
        $.ajax({
            type:"GET",
            url:"/recycle/list",
            success: function(html){
                $("#list").html(html);
            },
            error:function () {
                $("#list").html("加载失败，请刷新重试！");
            }
        });
    }
    $(function() {
        list();
    })
</script>
<input type="button" value="彻底删除" onclick="fun1()">
</body>
</html>
