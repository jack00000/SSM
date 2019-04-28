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

<script language="JavaScript">
$(document).ready(function() {  
   var chart = {
      type: 'spline',
      animation: Highcharts.svg, // don't animate in IE < IE 10.
      marginRight: 10,
      events: {
         load: function () {
            // set up the updating of the chart each second
            var series = this.series[0];
            setInterval(function () {
               var x = (new Date()).getTime(), // current time
               y = Math.random();
               series.addPoint([x, y], true, true);
            }, 1000);
         }
      }
   };
   var title = {
      text: 'Live random data'   
   };   
   var xAxis = {
      type: 'datetime',
      tickPixelInterval: 150
   };
   var yAxis = {
      title: {
         text: 'Value'
      },
      plotLines: [{
         value: 0,
         width: 1,
         color: '#808080'
      }]
   };
   var tooltip = {
      formatter: function () {
      return '<b>' + this.series.name + '</b><br/>' +
         Highcharts.dateFormat('%Y-%m-%d %H:%M:%S', this.x) + '<br/>' +
         Highcharts.numberFormat(this.y, 2);
      }
   };
   var plotOptions = {
      area: {
         pointStart: 1940,
         marker: {
            enabled: false,
            symbol: 'circle',
            radius: 2,
            states: {
               hover: {
                 enabled: true
               }
            }
         }
      }
   };
   var legend = {
      enabled: false
   };
   var exporting = {
      enabled: false
   };
   var series= [{
      name: 'Random data',
      data: (function () {
         // generate an array of random data
         var data = [],time = (new Date()).getTime(),i;
         for (i = -19; i <= 0; i += 1) {
            data.push({
               x: time + i * 1000,
               y: Math.random()
            });
         }
         return data;
      }())    
   }];     
      
   var json = {};   
   json.chart = chart; 
   json.title = title;     
   json.tooltip = tooltip;
   json.xAxis = xAxis;
   json.yAxis = yAxis; 
   json.legend = legend;  
   json.exporting = exporting;   
   json.series = series;
   json.plotOptions = plotOptions;
   
   
   Highcharts.setOptions({
      global: {
         useUTC: false
      }
   });
   $('#container').highcharts(json);
  
});
</script>

</body>
</html>