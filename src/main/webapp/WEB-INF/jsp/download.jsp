<%--
  Created by IntelliJ IDEA.
  User: 28074
  Date: 2019/4/20
  Time: 17:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>a</title>
    <%--<script type="text/javascript">
        // 直接通过ajax请求文件数据
        // jquery下载文件时不能触发浏览器弹出保存文件对话框！
        // 可以在javascript中访问下载的文件数据
        function downloadFilebyAjax() {
            console.log("ajaxDownloadDirectly");
            var url = "/picture/insert";
            $.ajax({
                url: url,
                type: 'post',
                data: {'fileName': "testAjaxDownload.txt"},
                success: function (data, status, xhr) {
                    console.log("Download file DONE!");
                    console.log(data); // ajax方式请求的数据只能存放在javascipt内存空间，可以通过javascript访问，但是无法保存到硬盘
                    console.log(status);
                    console.log(xhr);
                    console.log("=====================");
                }
            });
        }

        // 模拟表单提交同步方式下载文件
        // 能够弹出保存文件对话框
        function downloadFileByForm() {
            console.log("ajaxDownloadSynchronized");
            var url = "http://localhost:8080/ajaxDownloadServlet.do";
            var fileName = "testAjaxDownload.txt";
            var form = $("<form></form>").attr("action", url).attr("method", "post");
            form.append($("<input></input>").attr("type", "hidden").attr("name", "fileName").attr("value", fileName));
            form.appendTo('body').submit().remove();
        }
    </script>--%>
</head>
<body>
<%--<a href="&lt;%&ndash;<%=request.getContextPath()%>/ajaxDownloadServlet.do?fileName=testAjaxDownload.txt&ndash;%&gt;/down">同步下载文件</a><br/>
<a href="#" onclick="downloadFilebyAjax()">ajax下载文件</a> <br/>
<a href="#" onclick="downloadFileByForm()">模拟表单提交下载文件</a>--%>
<a href="/downloaded">下载</a>
</body>
</html>
