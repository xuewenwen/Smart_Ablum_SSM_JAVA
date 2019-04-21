<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>


<!-- Mirrored from admindesigns.com/demos/absolute/1.1/admin_forms-validation.html by HTTrack Website Copier/3.x [XR&CO'2014], Thu, 06 Aug 2015 02:56:15 GMT -->

<head>
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <title>橘猫相册主页</title>
    <meta name="keywords" content="HTML5 Bootstrap 3 Admin Template UI Theme" />
    <meta name="description" content="AbsoluteAdmin - A Responsive HTML5 Admin UI Framework">
    <meta name="author" content="AbsoluteAdmin">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!-- Theme CSS -->
    <link rel="stylesheet" type="text/css" href="/assets/skin/default_skin/css/theme.css">

    <!-- Admin Forms CSS -->
    <link rel="stylesheet" type="text/css" href="/assets/admin-tools/admin-forms/css/admin-forms.css">

    <!-- Favicon -->
    <link rel="shortcut icon" href="/assets/img/favicon.ico">


    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
    <link href="../css/fileinput.css" media="all" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" crossorigin="anonymous">
    <link href="../themes/explorer-fas/theme.css" media="all" rel="stylesheet" type="text/css" />

    <script src="/js/jquery.min.js"></script>
</head>

<body class="admin-validation-page" data-spy="scroll" data-target="#nav-spy" data-offset="200">

<!-- Start: Main -->
<div id="main">

    <!-- Start: Header -->
    <header class="navbar navbar-fixed-top navbar-shadow" style="text-align: center">
        <div class="navbar-branding">
            <a class="navbar-brand" href="dashboard.html">
                <b>橘猫相册</b>SmartArt
            </a>
            <span id="toggle_sidemenu_l" class="ad ad-lines"></span>
        </div>
        <div style="display: inline-block;
      height: 60px;
      line-height: 60px;">
            <input type="text" class="form-control" style="height: 30px;width:auto;display: inline-block;">
            <button class="btn btn-primary" type="button"
                    style="height: 30px; line-height: 30px; padding: 0 12px;">搜索!</button>
            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal_2"
                    data-target=".bs-example-modal-sm" style="height: 30px; line-height: 30px; padding: 0 12px;">创建相册</button>

            <!-- 创建相册 Modal -->
            <script>

                $(".modal-backdrop").remove();

            </script>

            <div class="modal fade" id="myModal_2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                <div class="modal-backdrop" role="document">
                    <div class="modal-dialog" style="width:500px;height: 20%;">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                        aria-hidden="true">&times;</span></button>
                                <h4 class="modal-title" id="exampleModalLabel">相册创建</h4>
                            </div>
                            <div class="modal-body">
                                <form>
                                    <div>
                                        <label for="recipient-name" class="control-label" style="">相册名:</label>
                                        <input type="text" class="form-control" id="recipient-name" placeholder="相册名">
                                    </div>
                                    <div class="form-group">
                                        <label for="message-text" class="control-label">相册描述：</label>
                                        <textarea class="form-control" id="message-text" style="height: 100px"
                                                  placeholder="描述....."></textarea>
                                    </div>

                                    <div>
                                        <label for="message-text" class="control-label">相册封面：</label>

                                        <form id="uploadForm" enctype="multipart/form-data">
                                            <input type="file" name="file_data" id="file_data" <%--class="inputfile"--%> <%--style="width:100%;height:40px"--%> multiple/>
                                        </form>

                                    </div>
                                </form>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                                <button type="button" class="btn btn-primary" id="asure">确定</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>
        <ul class="nav navbar-nav navbar-right">
            <li class="dropdown menu-merge">
                <a href="#" class="dropdown-toggle fw600 p15" data-toggle="dropdown">
                    <img src="assets/img/avatars/5.jpg" alt="avatar" class="mw30 br64">
                    <span class="hidden-xs pl15"> 薛剑文 </span>
                    <span class="caret caret-tp hidden-xs"></span>
                </a>
                <ul class="dropdown-menu list-group dropdown-persist w250" role="menu">
                    <li class="list-group-item">
                        <a href="#" class="animated animated-short fadeInUp">
                            <span class="fa fa-user"></span> 个人信息
                            <span class="label label-warning"></span>
                        </a>
                    </li>
                    <li class="list-group-item">
                        <a href="#" class="animated animated-short fadeInUp">
                            <span class="fa fa-gear"></span> 设置密码 </a>
                    </li>
                    <li class="dropdown-footer">
                        <a href="#" class="">
                            <span class="fa fa-power-off pr5"></span> 退出 </a>
                    </li>
                </ul>
            </li>
        </ul>
    </header>
    <!-- End: Header -->

    <!-- Start: Sidebar -->
    <aside id="sidebar_left" class="nano nano-light affix">

        <!-- Start: Sidebar Left Content -->
        <div class="sidebar-left-content nano-content">

            <!-- Start: Sidebar Header -->
            <header class="sidebar-header">

                <!-- Sidebar Widget - Author -->
                <div class="sidebar-widget author-widget">
                    <div class="media">
                        <a class="media-left" href="#">
                            <img src="assets/img/avatars/3.jpg" class="img-responsive">
                        </a>
                        <div class="media-body">
                            <div class="media-author">薛剑文</div>
                            <div class="media-links">
                                <a href="pages_login.html">退出</a>
                            </div>
                        </div>
                    </div>
                </div>


                <!-- Sidebar Widget - Search (hidden) -->
                <div class="sidebar-widget search-widget hidden">
                    <div class="input-group">
              <span class="input-group-addon">
                <i class="fa fa-search"></i>
              </span>
                        <input type="text" id="sidebar-search" class="form-control" placeholder="Search...">
                    </div>
                </div>

            </header>
            <!-- End: Sidebar Header -->

            <!-- Start: Sidebar Menu -->
            <ul class="nav sidebar-menu">
                <li class="sidebar-label pt20">我的面板</li>
                <li>
                    <a href="#">
                        <span class="glyphicon glyphicon-book"></span>
                        <span class="sidebar-title">全部相片</span>
                        <span class="sidebar-title-tray">
                <span class="label label-xs bg-primary">New</span>
              </span>
                    </a>
                </li>
                <li class="active">
                    <a href="#">
                        <span class="glyphicon glyphicon-home"></span>
                        <span class="sidebar-title">我的相册</span>
                    </a>
                </li>
                <li>
                    <a href="/recycle/recycle">
                        <span class="fa fa-calendar"></span>
                        <span class="sidebar-title">回收站</span>
                    </a>
                </li>

                <!-- End: Sidebar Menu -->

                <!-- Start: Sidebar Collapse Button -->
                <div class="sidebar-toggle-mini">
                    <a href="#">
                        <span class="fa fa-sign-out"></span>
                    </a>


                </div>
                <!-- End: Sidebar Collapse Button -->

                <!-- End: Sidebar Left Content -->
            </ul>
        </div>
    </aside>

    <!-- Start: Content-Wrapper -->
    <section id="content_wrapper">