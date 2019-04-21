<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>登陆 欢迎使用橘猫！</title>
    <link rel="stylesheet" href="css/style.css">
    <link href="css/popup-box.css" rel="stylesheet" type="text/css" media="all"/>
    <!--<link href='//fonts.googleapis.com/css?family=Open+Sans:400,300italic,300,400italic,600,600italic,700,700italic,800,800italic' rel='stylesheet' type='text/css'>
     <link href='//fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
-->

    <script src="/js/jquery.min.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="keywords"
          content="Sign In And Sign Up Forms  Widget Responsive, Login Form Web Template, Flat Pricing Tables, Flat Drop-Downs, Sign-Up Web Templates, Flat Web Templates, Login Sign-up Responsive Web Template, Smartphone Compatible Web Template, Free Web Designs for Nokia, Samsung, LG, Sony Ericsson, Motorola Web Design"/>
    <script type="application/x-javascript"> addEventListener("load", function () {
        setTimeout(hideURLbar, 0);
    }, false);

    function hideURLbar() {
        window.scrollTo(0, 1);
    } </script>

    <script src = "../js/jquery.min.js" ></script>
    <!--script type="text/javascript" src="js/jquery.validate.js"></script-->
    <script src="../js/jquery.magnific-popup.js" type="text/javascript"></script>
    <script type="text/javascript" src="../js/modernizr.custom.53451.js"></script>
    <script>
        $(document).ready(function () {
            $('.popup-with-zoom-anim').magnificPopup({
                type: 'inline',
                fixedContentPos: false,
                fixedBgPos: true,
                overflowY: 'auto',
                closeBtnInside: true,
                preloader: false,
                midClick: true,
                removalDelay: 300,
                mainClass: 'my-mfp-zoom-in'
            });

        });
    </script>

</head>
<body>
<h1>欢迎使用橘猫相册</h1>
<div class="w3layouts" >
    <div class="signin-agile">
        <h2>登录
        </h2>
        <form action="login" method="post" id="loginForm" >
            <input type="text" name="userEmail" class="name" placeholder="用户名/邮箱" required="">
            <input type="password" name="userpassword" class="password" placeholder="密码" required="">
            <ul>
                <li>
                    <input type="checkbox" id="brand1" value="">
                    <label for="brand1"><span></span>记住密码</label>
                </li>
            </ul>
            <a href="/retrievepassword">忘记密码?</a><br>
            <div class="clear"></div>
            <input type="submit" value="登录">
        </form>
    </div>

    <div class="signup-agileinfo">
        <h3>为什么要使用橘猫相册？</h3>
        <p>智能云相册应用中十分广泛，我们公司的这一款智能相册，表单外观比较华丽，赶紧点击下一步按钮即可跳转到下一步填写注册信息。从而在表单切换时拥有弹性的动画，是一款很不错的相册系统哦。</p>
        <div class="more">
            <a class="book popup-with-zoom-anim button-isi zoomIn animated" data-wow-delay=".5s" href="#small-dialog">免费注册</a>
        </div>
    </div>
    <div class="clear"></div>
</div>
<div class="footer-w3l">
    <p class="agileinfo">代码敲不队</p>
</div>
<div class="pop-up">

    <div id="small-dialog" class="mfp-hide book-form">
        <h3>注册橘猫智能相册 </h3>
        <form action="#" method="post" id="RegForm">
            <%--required里面放对象，对象里封装方法--%>
            <input type="text" id ="Name" name="Name" placeholder="请输入用户名" required=""/>
            <input type="text" name="Email" class="email" id="email" placeholder="请输入邮件" required=""/>
            <input type="password" id="Password" name="Password" class="password" placeholder="请输入密码" required=""/>
            <input type="password" id="Repeated" name="Password" class="password" placeholder="请重复密码" required=""/>
            <input type="text" name="checkCode" id="checkCode" placeholder="在此输入接收到的验证码" required=""/>
            <input id="sendCheckCode" type="button" class="layui-btn layui-btn-normal"  value="点击获取验证码">
            <input id="reg" type="button" value="立即注册">
        </form>
        <script>
            $(function () {
                var GenerateCode;
                $("#sendCheckCode").on("click", function () {


                    var userName=$("#Name").val();
                    var userMail=$("#email").val();

                    var userPassword=$("#Password").val();

                    var userRepeat=$("#Repeated").val();
                    if (userPassword!=userRepeat) {
                        alert("两次输入密码不一致");
                    }

                    $.ajax({
                            type: "POST",
                            url: "/Register",
                            dataType: "json",
                            data: {
                                "userName": userName,
                                "userPassword": userPassword,
                                "userEmail": userMail
                            },
                        success:function (code) {
                                GenerateCode=code;
                                    if (code==2){ //等于2说明账号已经存在了
                                     alert("这个邮箱注册过啦，想找回账号请点击找回密码哦(#^.^#)");
                                    }else
                                        {
                                            alert("验证码发送成功噜 *´∀`)")
                                        }
                            }

                    })
                })
                $("#reg").on("click",function (){
                        var userName=$("#Name").val();
                        var inputCheckCode=$("#checkCode").val();//用户输入的验证码
                        if (inputCheckCode==GenerateCode){
                            $.ajax({
                                url:"/activate",
                                type:"get",
                                data:{
                                    "userName":userName
                                },
                                async:false,
                                success:function () {
                                    alert("注册成功啦")
                                    window.location.href="login.jsp";}
                            })
                        }
                    });
            }
            )
                   </script>
    </div>
</div>
<!-- jQuery -->
<script src="vendor/jquery/jquery-1.11.1.min.js"></script>
<script src="vendor/jquery/jquery_ui/jquery-ui.min.js"></script>

<!-- jQuery Validate Plugin-->
<script src="assets/admin-tools/admin-forms/js/jquery.validate.min.js"></script>

<!-- jQuery Validate Addon -->
<script src="assets/admin-tools/admin-forms/js/additional-methods.min.js"></script>

<!-- AdminForms JS -->
<script src="assets/admin-tools/admin-forms/js/jquery-ui-datepicker.min.js"></script>

<!-- Theme Javascript -->
<script src="assets/js/utility/utility.js"></script>
<script src="assets/js/demo/demo.js"></script>
<script src="assets/js/main.js"></script>
<!-- END: PAGE SCRIPTS -->
<script type="text/javascript" src="js/pages.js"></script>
<script type="text/javascript" src="js/items.js"></script>
<!-- END: PAGE SCRIPTS -->
<script src="../js/plugins/piexif.js" type="text/javascript"></script>
<script src="../js/plugins/sortable.js" type="text/javascript"></script>
<script src="../js/fileinput.js" type="text/javascript"></script>
<script src="../js/locales/fr.js" type="text/javascript"></script>
<script src="../js/locales/es.js" type="text/javascript"></script>
<script src="../themes/fas/theme.js" type="text/javascript"></script>
<script src="../themes/explorer-fas/theme.js" type="text/javascript"></script>
</body>
</html>
