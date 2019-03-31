<%--
  Created by IntelliJ IDEA.
  User: ROCKEY
  Date: 2019/3/16
  Time: 21:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Insert Photo</title>
    <meta http-equiv="Content-Type" content="multipart/form-data; charset=utf-8" />
    <%--<script src="/js/jquery/jquery-3.3.1.min.js"></script>--%>
    <script src="/js/jquery-3.1.1.min.js"></script>
</head>
<body>
<div>
        <p>名称：<input type="text" id="pictureName"></p>
        <p>相册名：<input type="text" id="AlbumId"></p>
        <p>描述<input type="text" id="pictureDescription"></p>
        <p>状态：<input type="text" id="pictureStatus"></p>

    <%--<p><form id="uploadForm" enctype="multipart/form-data">文件：<input id="file" type="file" name="file"></form></p>--%>

    <%--<form id="uploadForm" enctype="multipart/form-data">
    <input id="file" multiple="multiple" type="file" datatype="file">
    </form>--%>

    <form method="post" <%--action="/multipleSave"--%> enctype="multipart/form-data" id="uploadForm">
        <input name="file" type="file" datatype="file" id="file" multiple><br>
    </form>


    <p>  <input type="button" value="确认上传" id="btnUpload"></p>
        <p><input type="button" value="确认信息" id="btnSave"></p>
</div>
<script>
    $(function () {
        $("#btnSave").on("click", function () {
            if ($("#btnSave").hasClass("Saving")) {
                return;
            }

            $("#btnSave").addClass("Saving");
            $("#btnSave").val("Saving");

            var pictureName=$("#pictureName").val();
            if (pictureName.trim()=="") {
                alert("picture name is empty!");
                return;
            }

            var AlbumId=$("#AlbumId").val();
            if (AlbumId.trim()=="") {
                alert("User is empty!");
                return;
            }

            var pictureDescription=$("#pictureDescription").val();
            var pictureStatus=$("#pictureStatus").val();
           // alert(pictureDescription);



            $.ajax({
                type:"POST",
                url:"/picture/doInsert",
               dataType:"json",
              //  cache:false,
             //   processData:false,//取消格式化数据
              //  contentType:false,
                data:{
                    "pictureName":pictureName,
                    "AlbumId":AlbumId,
                    "pictureDescription":pictureDescription,
                    "pictureStatus":pictureStatus
               //    "formdata":formdata
                },
                success:function (result) {
                    $("#btnSave").removeClass("Saving");
                    $("#btnSave").val("Save");

                    if (result.code == 0) {
                        window.location.href = "/picture/"+result.pictureId;
                    } else {
                        alert(result.msg);
                    }
                },
                error:function () {
                    $("#btnSave").removeClass("Saving");
                    $("#btnSave").val("Save");
                    alert("失败!");
                }
            })
        })


        $("#btnUpload").on("click", function (){
           // var formdata=new FormData($('#file'));
           var formdata=new FormData($('#uploadForm')[0]);//可传送二进制文件，即上传文件
            //new FormData的参数是一个DOM对象，而非jQuery对象
            alert(formdata);
            $.ajax({
                type:"POST",


                url:"/multipleSave",
              // url:"/testuploadimg",


               dataType:"json",
             //  cache:false,
                processData:false,//取消格式化数据
                contentType:false,
               // async: false,
                data:formdata,
                success:function (result) {
                 //   $("#btnSave").removeClass("Saving");
                   // $("#btnSave").val("Save");

                    if (result.code == 0) {
                        alert(result.msg);
                    } else {
                        alert("上传失败");
                    }
                },
                error:function () {
                   // $("#btnSave").removeClass("Saving");
                  //  $("#btnSave").val("Save");
                    alert(data.status+"::"+data.info);
                }
            })


        })

    })
</script>
</body>
</html>
