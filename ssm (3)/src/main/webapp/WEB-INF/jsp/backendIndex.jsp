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
                    管理员
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
                <a href="index.html"><i class="fa fa-home" aria-hidden="true"></i>首页</a>
            </li>
            <li class="separator-20"></li>
            <li class="menu-item">
                <a href="javascript:void(0)"><i class="fa fa-cube" aria-hidden="true"></i>UI 控件</a>
                <ul class="sub-menu-list">
                    <li class="sub-menu-item"><a href="widget.html">小部件</a></li>
                    <li class="sub-menu-item"><a href="animate.html">动画</a></li>
                </ul>
            </li>
            <li class="menu-item">
                <a href="javascript:void(0)"><i class="fa fa-key" aria-hidden="true"></i>插件应用</a>
                <ul class="sub-menu-list">
                    <li class="sub-menu-item"><a href="jq-plugin.html">jQuery插件</a></li>
                    <li class="sub-menu-item"><a href="plugin.html">我的插件</a></li>
                </ul>
            </li>
            <li class="menu-item">
                <a href="javascript:void(0)"><i class="fa fa-book" aria-hidden="true"></i>其他页面</a>
                <ul class="sub-menu-list">
                    <li class="sub-menu-item"><a href="inbox.html">收件箱</a></li>
                    <li class="sub-menu-item"><a href="table.html">表格</a></li>
                </ul>
            </li>
            <li class="menu-item">
                <a href="javascript:void(0)"><i class="fa fa-tag" aria-hidden="true"></i>更多页面 <span class="badge">4</span></a>
                <ul class="sub-menu-list">
                    <li class="sub-menu-item"><a href="blank.html">空白页面</a></li>
                    <li class="sub-menu-item"><a href="login.html">登录页面</a></li>
                    <li class="sub-menu-item"><a href="jump.html">跳转页面</a></li>
                    <li class="sub-menu-item"><a href="404.html">404页面</a></li>
                </ul>
            </li>
            <li class="menu-item">
                <a href="javascript:void(0)"><i class="fa fa-list" aria-hidden="true"></i>一级菜单</a>
                <ul class="sub-menu-list">
                    <li class="sub-menu-item"><a href="#">二级菜单-1</a></li>
                    <li class="sub-menu-item"><a href="#">二级菜单-2</a></li>
                </ul>
            </li>

            <li class="separator-30"></li>

            <li class="menu-item">
                <a href="login.html"><i class="fa fa-sign-out" aria-hidden="true"></i>安全退出</a>
            </li>

        </ul>
    </aside>

    <div class="main-container">
        <div class="padding">
            <ol class="breadcrumb">
                <li class="active">首页</li>
            </ol>
            <div class="box">
                <div class="heading">
                    <h3 class="title">提醒<a href="inbox.html" class="link-right">更多>></a></h3>
                </div>

                <div class="box-inner">
                    <div class="container">
						<div class="row clearfix">
							<div class="col-md-6 column">
							   
							</div>
							<div class="col-md-6 column">
							</div>
						</div>
						<div class="row clearfix">
							<div class="col-md-6 column">
							</div>
							<div class="col-md-6 column">
							</div>
						</div>
                    </div>
                </div>
            </div>
        </div>
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
</body>
</html>
	