<%--
  Created by IntelliJ IDEA.
  User: XueJianWen
  Date: 2019/3/22
  Time: 10:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <meta contentType="application/x-www-form-urlencoded">
    <script src="plugin/js/jquery-3.1.1.min.js" type="text/javascript"></script>
    <!-- bootstrap main js -->
    <script type="text/javascript" src="plugin/js/bootstrap.min.js"></script>
    <!-- fileinput main js -->
    <script type="text/javascript" src="plugin/js/fileinput.min.js"></script>
    <!-- chn language js -->
    <script type="text/javascript" src="plugin/js/zh.js"></script>
    <!-- bootstrap theme -->
    <link rel="stylesheet" type="text/css" href="plugin/css/bootstrap.min.css">
    <!-- fileinput theme -->
    <link rel="stylesheet" type="text/css" href="plugin/css/fileinput.min.css">
    <title>文件上传</title>
</head>
<body>
<h1>文字识别<!--<p th:text="'我是文本输出'"></p>--></h1>
<form enctype="multipart/form-data" id="ocr-form" action="/ocr" method="post">
    <div class="col-sm-4">
        <div class="form-group">
            <input type="file" name="file" id="file1" class="file">
        </div>
    </div>
    <div class="col-sm-4">
        <h2>解析结果：</h2>
        <span id="res"></span>
    </div>
</form>
<script>
    $("#file1").fileinput({
        uploadUrl: '/ocr', //你必须在这里设置一个有效的URL，否则你会得到一个错误
        uploadAsync: true, //AJAX设置同步，异步的上传方式 （同步）
        allowedFileExtensions: ['jpg', 'png', 'gif'],//文件类型
        showUpload: true, //是否显示上传按钮
        //browseClass: "btn btn-primary", //按钮样式
        showRemove : true, //显示移除按钮
        dropZoneEnabled: true,//是否显示拖拽区域
        overwriteInitial: false,
        //maxFileSize:0,//单位为kb，如果为0表示不限制文件大小
        maxFilesNum: 10,
        maxFileCount: 4, //表示允许同时上传的最大文件个数
        minFileCount: 0,	//最少文件
        validateInitialCount:false//异步上传返回结果处理

    }).on('fileuploaded', function(event, data, previewId, index) {
        // alert(JSON.stringify(data));
        var res_arr = data.response.words_result;
        for(var key in res_arr){
            console.log(res_arr[key].words);
            $('#res').append(res_arr[key].words + "<br/>");
        }
        // console.log(JSON.stringify(data));
    });
</script>
</body>
</html>

