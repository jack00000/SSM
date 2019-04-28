<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Pshare Admin-首页</title>

    <!-- Bootstrap -->
    <link href="http://pq1rtdg74.bkt.clouddn.com/bootstrap.css" rel="stylesheet">
    
    <link rel="stylesheet" href="http://pq1rtdg74.bkt.clouddn.com/daterangepicker.css">
    <link rel="stylesheet" href="http://pq1rtdg74.bkt.clouddn.com/font-awesome.min.css">
    <link rel="stylesheet" href="http://pq1rtdg74.bkt.clouddn.com/common.css">
    <link rel="stylesheet" href="http://pq1rtdg74.bkt.clouddn.com/main.css">
    <link rel="stylesheet" href="http://pqh1rik4s.bkt.clouddn.com/fontawesome-webfont.woff2">
    <link rel="stylesheet" href="http://pqh1rik4s.bkt.clouddn.com/fontawesome-webfont.ttf">
    <link rel="stylesheet" href="http://pqh1rik4s.bkt.clouddn.com/fontawesome-webfont.woff">
        <link rel="stylesheet" href="http://pqh1rik4s.bkt.clouddn.com/font-awesome.min%20-%20%E5%89%AF%E6%9C%AC.css">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <span class="navbar-sidebar-toggle" data-toggle="tooltip" data-placement="right" title="菜单栏收缩或展开"><i class="fa fa-bars" aria-hidden="true"></i></span>
            <a class="navbar-brand" href="#">Pshare Admin</a>
        </div>

        <div class="navbar-end">
            <div class="nav-notifications">
                <div class="btn-group">
                    <button type="button" class="btn btn-noti" data-toggle="dropdown">
                        <i class="fa fa-envelope fa-lg"></i>
                        <span class="badge badge-terques">5</span>
                    </button>
                    <ul class="dropdown-menu dropdown-menu-right" role="menu">
                        <li><a href="#">Action</a></li>
                        <li><a href="#">Another action</a></li>
                        <li><a href="#">Something else here</a></li>
                        <li class="divider"></li>
                        <li><a href="#">Separated link</a></li>
                    </ul>
                </div>
                <div class="btn-group">
                    <button type="button" class="btn btn-noti" data-toggle="dropdown">
                        <i class="fa fa-bell fa-lg"></i>
                        <span class="badge badge-yellow">3</span>
                    </button>
                    <ul class="dropdown-menu dropdown-menu-right" role="menu">
                        <li><a href="#">Action</a></li>
                        <li><a href="#">Another action</a></li>
                        <li><a href="#">Something else here</a></li>
                        <li class="divider"></li>
                        <li><a href="#">Separated link</a></li>
                    </ul>
                </div>
                <div class="btn-group">
                    <button type="button" class="btn btn-noti" data-toggle="dropdown">
                        <i class="fa fa-comments fa-lg"></i>
                        <span class="badge badge-red">2</span>
                    </button>
                    <ul class="dropdown-menu dropdown-menu-right" role="menu">
                        <li><a href="#">Action</a></li>
                        <li><a href="#">Another action</a></li>
                        <li><a href="#">Something else here</a></li>
                        <li class="divider"></li>
                        <li><a href="#">Separated link</a></li>
                    </ul>
                </div>
            </div>

            <div class="dropdown">
                <button class="btn btn-default dropdown-toggle" type="button" id="navbar-dropdownmenu" data-toggle="dropdown">
                    <img src="http://pq1rtdg74.bkt.clouddn.com/avatar-mini.jpg" alt="Admin">
                    管理员${user2.name}
                    <span class="caret"></span>
                </button>
                <ul class="dropdown-menu dropdown-menu-right" role="menu" aria-labelledby="navbar-dropdownmenu">
                    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">设置</a></li>
                    <li role="presentation"><a role="menuitem" tabindex="-1" href="login.html">退出登录</a></li>
                </ul>
            </div>
        </div>
    </div>
</nav>
<div class="wrapper">
    <aside class="sidebar-menu">
        <div class="separator-50"></div>

        <ul class="menu-list">
            <li class="menu-item actived">
                <a><i class="backendIndex" aria-hidden="true"></i>首页</a>
            </li>
            <li class="separator-20"></li>
            <li class="menu-item">
                <a href="javascript:void(0)"><i class="fa fa-cube" aria-hidden="true"></i>文章管理</a>
                <ul class="sub-menu-list">
                    <li class="sub-menu-item"><a href="paperReview">文章一览</a></li>
                    <li class="sub-menu-item"><a href="animate.html">文章删除</a></li>
                </ul>
            </li>
            <li class="menu-item">
                <a href="javascript:void(0)"><i class="fa fa-key" aria-hidden="true"></i>用户管理</a>
                <ul class="sub-menu-list">
                    <li class="sub-menu-item"><a href="userReview">用户一览</a></li>
                    <li class="sub-menu-item"><a href="plugin.html">用户删除</a></li>
                    <li class="sub-menu-item"><a href="plugin.html">管理员新增</a></li>
                </ul>
            </li>
          
          

            <li class="separator-30"></li>

            <li class="menu-item">
                <a href="login.html"><i class="fa fa-sign-out" aria-hidden="true"></i>安全退出</a>
            </li>

        </ul>
    </aside>

    <div class="main-container">
        <div id="container" style="width: 100%; height: 100%; margin: 0 auto"></div>
    </div>
    <footer class="main-footer">
        <p>知识付费共享blog后台管理模块 邮箱:1558185399@qq.com</p>
    </footer>
</div>

<div class="scroll-to-top"><i class="fa fa-chevron-up fa-lg"></i></div>

<script src="http://pq1rtdg74.bkt.clouddn.com/jquery-3.1.1.min.js"></script>
<script src="http://pq1rtdg74.bkt.clouddn.com/bootstrap.min.js"></script>
<script src="http://pq1rtdg74.bkt.clouddn.com/moment.min.js"></script>
<script src="http://pq1rtdg74.bkt.clouddn.com/daterangepicker.js"></script>
<script src="http://pq1rtdg74.bkt.clouddn.com/main.js"></script>
<script src="http://pqh1rik4s.bkt.clouddn.com/jquery.min.js"></script>
<script src="http://pqh1rik4s.bkt.clouddn.com/highcharts.js"></script>
<script src="http://pqh1rik4s.bkt.clouddn.com/highcharts-more.js"></script>
<script language="JavaScript">
$(document).ready(function() {  
   var chart = {
      type: 'bubble',
      zoomType: 'xy'
   };
   var title = {
      text: 'Highcharts Bubbles'   
   };   
   var series= [{
            data: [[97, 36, 79], [94, 74, 60], [68, 76, 58], [64, 87, 56], [68, 27, 73], [74, 99, 42], [7, 93, 87], [51, 69, 40], [38, 23, 33], [57, 86, 31]]
        }, {
            data: [[25, 10, 87], [2, 75, 59], [11, 54, 8], [86, 55, 93], [5, 3, 58], [90, 63, 44], [91, 33, 17], [97, 3, 56], [15, 67, 48], [54, 25, 81]]
        }, {
            data: [[47, 47, 21], [20, 12, 4], [6, 76, 91], [38, 30, 60], [57, 98, 64], [61, 17, 80], [83, 60, 13], [67, 78, 75], [64, 12, 10], [30, 77, 82]]
      }
   ];     
      
   var json = {};   
   json.chart = chart; 
   json.title = title;     
   json.series = series;   
   $('#container').highcharts(json);
  
});
</script>
</body>
</html>