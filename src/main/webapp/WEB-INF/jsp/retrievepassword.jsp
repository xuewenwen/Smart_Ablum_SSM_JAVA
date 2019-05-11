<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<!-- Mirrored from admindesigns.com/demos/absolute/1.1/pages_login.html by HTTrack Website Copier/3.x [XR&CO'2014], Thu, 06 Aug 2015 02:55:38 GMT -->

<head>
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <title>欢迎使用橘猫智能相册</title>
    <meta name="keywords" content="HTML5 Bootstrap 3 Admin Template UI Theme" />
    <meta name="description" content="AbsoluteAdmin - A Responsive HTML5 Admin UI Framework">
    <meta name="author" content="AbsoluteAdmin">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- Theme CSS -->
    <link rel="stylesheet" type="text/css" href="assets/skin/default_skin/css/theme.css">

    <!-- Admin Forms CSS -->
    <link rel="stylesheet" type="text/css" href="assets/admin-tools/admin-forms/css/admin-forms.css">

    <!-- Favicon -->
    <link rel="shortcut icon" href="assets/img/favicon.ico">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
    <script src="/js/jquery.min.js"></script>
</head>

<body class="external-page external-alt sb-l-c sb-r-c">


<!-- Start: Main -->
<div id="main" class="animated fadeIn">

    <!-- Start: Content-Wrapper -->
    <section id="content_wrapper">

        <!-- Begin: Content -->
        <section id="content">

            <div class="admin-form theme-info mw500" id="login">

                <!-- Login Logo -->
                <div class="content-header">
                    <h1> 忘记密码</h1>
                </div>
                <!-- Login Panel/Form -->
                <div class="panel mt30 mb25">

                    <form method="post" action="list.html" id="contact">
                        <div class="panel-body bg-light p25 pb15">


                            <!-- Email Input -->
                            <div class="section">
                                <label for="email" class="field-label text-muted fs18 mb10">邮箱</label>
                                <label for="email" class="field prepend-icon">
                                    <input type="email" name="email" id="email" class="gui-input" placeholder="请输入邮箱..." style="width: 80%">
                                    <button type="button" class="btn btn-primary" id="clickToSend" >点击发送</button>
                                    <label for="email" class="field-icon">
                                        <i class="fa fa-lock"></i>
                                    </label>
                                </label>
                            </div>


                            <!-- captcha Input -->
                            <div class="section">
                                <label for="captcha" class="field-label text-muted fs18 mb10">验证码</label>
                                <label for="captcha" class="field prepend-icon">
                                    <input type="captcha" name="captcha" id="captcha" class="gui-input" placeholder="请输入验证码...">
                                    <label for="captcha" class="field-icon">
                                        <i class="fa fa-lock"></i>
                                    </label>
                                </label>
                            </div>

                            <div>
                                <button type="button" class="btn btn-primary btn-lg btn-block" data-toggle="modal"
                                        data-target="#Modal" id="clickToCheck">点击验证</button>
                                <script>
                                    $(function () {
                                            var GenerateCode;
                                            $("#clickToSend").on("click", function () {
                                                var userMail=$("#email").val();
                                                if (userMail==null||userMail=="") {
                                                    alert("邮箱不能为空");
                                                }else {
                                                $.ajax({
                                                    type: "POST",
                                                    url: "/SendCheckCode",
                                                    dataType: "json",
                                                    data: {
                                                        "userEmail": userMail
                                                    },
                                                    success:function (code) {
                                                        GenerateCode=code;
                                                        if (code==2){ //等于2说明账号不存在，无法找回
                                                            alert("邮箱未注册");
                                                            this.location.href="/Login"
                                                        }else
                                                        {
                                                            alert("验证码发送成功噜 *´∀`)")
                                                        }
                                                    }
                                                })
                                                }
                                            })

                                            $("#clickToCheck").on("click",function (){
                                                var userEmail=$("#email").val();
                                                var userPassword=$("#password").val();
                                                var inputCheckCode=$("#captcha").val();//用户输入的验证码
                                                if (inputCheckCode==GenerateCode){

                                                    $("#updatePasswordConfirm").on("click",function () {
                                                        var pass=$("#password").val();
                                                        var repeat=$("#password_1").val();
                                                        if (pass==repeat){
                                                        $.ajax({
                                                            url:"/updatePassword",
                                                            type:"get",
                                                            data:{
                                                                "userEmail":userEmail,
                                                                "userPassword":userPassword
                                                            },
                                                            async:false,
                                                            success:function () {
                                                                alert("更新密码成功！(*^▽^*)")
                                                                window.location.href="login.jsp";}
                                                        })}
                                                        else {
                                                            alert("两次密码输入不一致")
                                                        }
                                                    })
                                                }
                                                else {
                                                    $('#Modal').modal("hide");
                                                    alert("验证码输入有误，请重新验证");
                                                }
                                            });
                                        }
                                    )
                                </script>

                                <div class="modal fade" id="Modal" tabindex="-1" role="dialog" aria-labelledby="ModalLabel">
                                    <div class="modal-dialog" role="document">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                                        aria-hidden="true">&times;</span></button>

                                                <!-- Password Input -->
                                                <div class="section">
                                                    <label for="password" class="field-label text-muted fs18 mb10">密码</label>
                                                    <label for="password" class="field prepend-icon">
                                                        <input type="password" name="password" id="password" class="gui-input"
                                                               placeholder="请输入密码...">
                                                        <label for="password" class="field-icon">
                                                            <i class="fa fa-lock"></i>
                                                        </label>
                                                    </label>
                                                </div>

                                                <!-- Password forget -->
                                                <div class="section">
                                                    <label for="password" class="field-label text-muted fs18 mb10">确认密码</label>
                                                    <label for="password" class="field prepend-icon">
                                                        <input type="password" name="password" id="password_1" class="gui-input"
                                                               placeholder="请再次输入密码...">
                                                        <label for="password" class="field-icon">
                                                            <i class="fa fa-lock"></i>
                                                        </label>
                                                    </label>
                                                    <div class="modal-footer" style="background-color: white">
                                                        <button type="button" class="btn btn-primary" style="margin-top:3%" id="updatePasswordConfirm">确认修改</button>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </section>
        <!-- End: Content -->

    </section>
    <!-- End: Content-Wrapper -->

</div>
<!-- End: Main -->


<!-- BEGIN: PAGE SCRIPTS -->

<!-- jQuery -->
<script src="vendor/jquery/jquery-1.11.1.min.js"></script>
<script src="vendor/jquery/jquery_ui/jquery-ui.min.js"></script>

<!-- Theme Javascript -->
<script src="assets/js/utility/utility.js"></script>
<script src="assets/js/demo/demo.js"></script>
<script src="assets/js/main.js"></script>

<!-- END: PAGE SCRIPTS -->

</body>


<!-- Mirrored from admindesigns.com/demos/absolute/1.1/pages_login.html by HTTrack Website Copier/3.x [XR&CO'2014], Thu, 06 Aug 2015 02:55:42 GMT -->

</html>