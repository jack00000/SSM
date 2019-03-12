<%@page import="org.aspectj.weaver.ast.Var"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <script src="http://how2j.cn/study/js/jquery/2.0.0/jquery.min.js"></script>
<link href="http://how2j.cn/study/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
<script src="http://how2j.cn/study/js/bootstrap/3.3.6/bootstrap.min.js"></script>
<!-- jsp定义全局变量 -->
<%!String name = "张小白";%>
<style>
body
{
	background-image:url('https://source.unsplash.com/random'); 
	background-size:100% 100%;
}

</style> 

<script>
$(function(){    
    $.ajax({    
        //请求方式    
        type:"GET",    
        //文件位置    
        url:"https://www.bing.com/HPImageArchive.aspx?format=js&idx=0&n=8&mkt=zh-CN",  
        //返回数据格式为json,也可以是其他格式如    
        dataType: "json",    
        //请求成功后要执行的函数，拼接html    
        success: function(data){    
        	data.images[n].url = data.images[n].url.replace('1920x1080', '1080x1920');
			var url = 'https://www.bing.com' + data.images[n].url;
            $("div").append(str);    
        }    
    });    
});    
$(document).ready(function(){

		$.ajax({url:"https://www.bing.com/HPImageArchive.aspx?format=js&idx=0&n=8&mkt=zh-CN",success:function(data){
			var url = 'https://www.bing.com' + data.images[n].url;debugger;
		}});
});
</script>

  <style>
            /*web background*/
            .container{
                display:table;
                height:100%;
            }

            .row{
                display: table-cell;
                vertical-align: middle;
            }
            /* centered columns styles */
            .row-centered {
                text-align:center;
            }
            .col-centered {
                display:inline-block;
                float:none;
                text-align:left;
                margin-right:-4px;
            }
        </style>
    </head>

    <body>
        <div class="container" >
            <div class="row row-centered">
                <div class="well col-md-6 col-centered">
                    <h2>欢迎登录</h2>
                    <form action="login2Backend" method="post" role="form">
                        <div class="input-group input-group-md">
                            <span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-user" aria-hidden="true"></i></span>
                            <input type="text" class="form-control" id="userid" name="name" placeholder="请输入用户ID"/>
                        </div>
                        <div class="input-group input-group-md">
                            <span class="input-group-addon" id="sizing-addon1"><i class="glyphicon glyphicon-lock"></i></span>
                            <input type="password" class="form-control" id="password" name="password" placeholder="请输入密码"/>
                        </div>
                        <br/>
                        <button type="submit" class="btn btn-success btn-block">登录</button>
                    </form>
                </div>
            </div>
        </div>

 
