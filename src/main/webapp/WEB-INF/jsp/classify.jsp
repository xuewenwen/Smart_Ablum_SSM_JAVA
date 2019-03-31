<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<script src="/js/ajaxupload.js"></script>
</head>
<body>
	<div align="center">
		<h1>AI图像识别</h1>
		<hr>
		<form name="upform" action="/classify/animal" id="myForm" enctype="multipart/form-data" method="post">
		<br>
			<input type="file" name="animalfile" id="urls2" />
			
			<img src="" width='100px' height='100px' id="aurl" />
			<br>
			<br>
			<input type="button" name="anom" id="anom" value="识别"/>
		</form>
		<hr>
		<div id="tip"></div>
	</div>
</body>
<script type="text/javascript" src="/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="/js/jquery.form.js"></script>
<script type="text/javascript">  
$("#urls2").change(function(e){
	var filteList = e.target.files||e.dataTransfer.files;
	var length = filteList.length;
	for(var i=0;i<length;i++){
		//得到流 回显数据
		var img = window.webkitURL.createObjectURL(filteList[i]);
		//图片过滤i
		if(filteList[i].type.indexOf("image")!=-1){
			var fileName = filteList[i].name;
			var fileSize = filteList[i].size;
			
			$("#aurl").attr("src",img); 
		}
	}
}); 


$("#anom").click(function(){
    $("#myForm").ajaxSubmit({ 
        dataType: 'html', 
        beforeSend: function() { //开始上传 
        	
        }, 
        uploadProgress: function(event, position, total, percentComplete) { 
            /* alert(percentComplete) */
        }, 
        success: function(data) { //成功 
        	$("#tip").html(data);
        }, 
        error:function(xhr){ //上传失败 
            alert(xhr.responseText); //返回失败信息 
        } 
    }); 
});
</script>
</html>
