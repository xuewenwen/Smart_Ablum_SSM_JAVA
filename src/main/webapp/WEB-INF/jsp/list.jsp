﻿﻿<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        <input type="text" class="form-control" style="height: 30px;width:auto;display: inline-block;" id="tagName">
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
        <input class="btn btn-primary" type="button"
          style="height: 30px; line-height: 30px; padding: 0 12px;" value="搜索!" onclick="judgment()"></input>
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
                    <label for="albumDescription" class="control-label">相册封面：</label>
                  <form id="uploadForm" enctype="multipart/form-data">
                    <input type="file" name="file_data" id="file_data" <%--class="inputfile"--%> datatype="file"/>
                    <div>
                      <label for="albumName" class="control-label" style="">相册名:</label>
                      <input type="text" class="form-control" id="albumName" placeholder="相册名">
                    </div>
                    <div class="form-group">
                      <label for="albumDescription" class="control-label">相册描述：</label>
                      <textarea class="form-control" id="albumDescription" style="height: 100px"
                                placeholder="描述....."></textarea>
                    </div>

                    <div>


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
                <img src="assets/img/avatars/0.png" class="img-responsive">
              </a>
              <div class="media-body">
                <div class="media-author">${name}</div>
                <div class="media-links">
                  <a href="/exit">退出</a>
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
            <a href="/showAll">
              <span class="glyphicon glyphicon-book"></span>
              <span class="sidebar-title">全部相片</span>
            </a>
          </li>
          <li>
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
          <li>
            <a href="/retrievepassword" class="animated animated-short fadeInUp">
              <span class="fa fa-gear"></span>
              <span class="sidebar-title">密码修改</span>
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
        <div class="progress">
          <div class="progress-bar" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 0.0; min-width: 2em;">
            0.0
          </div>
        </div>
      </div>
    </aside>

    <!-- Start: Content-Wrapper -->
    <section id="content_wrapper">

      <!-- Begin: Content -->
      <section id="content" class="table-layout animated fadeIn">

        <!-- begin: .tray-center -->
        <div class="tray tray-center">

          <!-- Begin: Content Header -->
          <div class="content-header">
            <h2> 我的相册</h2>
            <p class="lead"></p>
          </div>
          <!-- message listing panel -->
          <div class="admin-form theme-primary mw1000 center-block" style="padding-bottom: 175px;">

            <div class="panel  heading-border">

              <!-- message toolbar header -->
              <div class="panel-menu">
                <div class="row">
                </div>
              </div>
              <!--  hide-->
              <!-- Modal -->
              <div class="modal fade bs-example-modal-lg" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                <div class="modal-dialog  modal-lg" role="document">
                  <div class="modal-content">
                    <div class="modal-header">
                      <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                          aria-hidden="true">&times;</span></button>
                      <h4 class="modal-title" id="myModalLabel">上传图片</h4>
                    </div>
                    <div class="modal-body">
                      <form enctype="multipart/form-data">
                        <br>
                        <div class="file-loading">
                          <input id="file-0a" class="file" type="file" multiple data-min-file-count="1"
                            data-theme="fas" style="width:unset;">
                        </div>
                        <br>
                  
                        <button type="reset" class="btn btn-primaryy">重置</button>
                      </form>
                    </div>
                    <div class="modal-footer">
                      <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                      <button type="button" class="btn btn-primary">保存上传</button>
                    </div>
                  </div>
                </div>
              </div>
              <!-- message listings table -->

              <script>
                function list() {
                  $.ajax({
                    type:"GET",
                    url:"/albumList",
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
              <div class="panel-body pn">
                <div id="list">
                  正在加载...
                </div>
              <!-- end: .admin-form -->
            </div>

            <!-- end: .tray-center -->
            </div>
          </div>
        </div>
      </section>
      <!-- End: Content -->

    </section>
    <!-- End: Content-Wrapper -->

  </div>
  <!-- End: Main -->

  <!-- BEGIN: PAGE SCRIPTS -->

  <style>
    /* demo page styles */
    body {
      min-height: 2300px;
    }

    .content-header b,
    .admin-form .panel.heading-border:before,
    .admin-form .panel .heading-border:before {
      transition: all 0.7s ease;
    }

    /* responsive demo styles */
    @media (max-width: 800px) {
      .admin-form .panel-body {
        padding: 18px 12px;
      }
    }
  </style>

  <style>
    .ui-datepicker select.ui-datepicker-month,
    .ui-datepicker select.ui-datepicker-year {
      width: 48%;
      margin-top: 0;
      margin-bottom: 0;

      line-height: 25px;
      text-indent: 3px;

      color: #888;
      border-color: #DDD;
      background-color: #FDFDFD;

      -webkit-appearance: none;
      /*Optionally disable dropdown arrow*/
    }
  </style>

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
  <script>
   
    $("#file-0a").fileinput({
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
        maxFileCount: 5, //表示允许同时上传的最大文件个数
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


    $(function () {
      $("#asure").on("click", function (){

        if ($("#asure").hasClass("Saving")) {
          return;
        }


        // var formdata=new FormData($('#file'));
        var formdata=new FormData($('#uploadForm')[0]);//可传送二进制文件，即上传文件
        var albumName = $("#albumName").val();
        var albumDescription = $("#albumDescription").val();

        formdata.append("albumName",albumName);
        formdata.append("albumDescription",albumDescription);

        $.ajax({

          type:"POST",
          url:"/uploadCover",
          dataType:"json",
          processData:false,//取消格式化数据
          contentType:false,
          //  cache:false,
          // async: false,
          data:formdata,
          success:function (result) {
            //   $("#btnSave").removeClass("Saving");
            // $("#btnSave").val("Save");

            if (result.code == 0) {
              alert(result.msg);
              this.refresh();
            } else {
              alert(result.msg);
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