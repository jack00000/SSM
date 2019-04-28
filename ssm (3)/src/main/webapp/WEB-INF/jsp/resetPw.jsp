<%@page import="org.aspectj.weaver.ast.Var"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <script src="http://how2j.cn/study/js/jquery/2.0.0/jquery.min.js"></script>
<link href="http://how2j.cn/study/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
<script src="http://how2j.cn/study/js/bootstrap/3.3.6/bootstrap.min.js"></script>
<!-- jsp定义全局变量 -->
<%!String name = "张小白";%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Pshare Admin-登录页面</title>

    <!-- Bootstrap -->
    <link href="./assets/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="http://pq1rtdg74.bkt.clouddn.com/common.css">
    <link rel="stylesheet" href="http://pq1rtdg74.bkt.clouddn.com/main.css">

    <style>
        html, body {
            height: 100%;
        }
        body {
            background-color: #f0f2f4;
        }
        .sign-in-wrapper {
            padding-top: 80px;
        }
        .sign-in-wrapper .sign-in-inner {
            width: 370px;
            margin-left: auto;
            margin-right: auto;
        }
        .sign-in-wrapper .form-sign-in .form-control {
            height: 40px;
            line-height: 40px;
        }
    </style>
</head>
<body>

    <div class="sign-in-wrapper">
        <div class="sign-in-inner">
            <div class="text-center">
                <h3><a href="#">Pshare Admin</a>-重置密码</h3>
                <h4 class="text-left" style="border-left: 5px solid #4ec3ff">&nbsp;&nbsp;邮箱</h4>
            </div>
            <form class="form-sign-in" method="post" action="sendmail">
                <div class="form-group">
                    <input name="qqyx" type="text" class="form-control" placeholder="账号">
                </div>
                <button class="btn btn-lg btn-primary btn-block" type="submit">发送</button>
                <div class="separator-30"></div>
             
            </form>
        </div><!-- ./sign-in-inner -->
    </div>
</body>
</html>