<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<div class="navitagorDiv">
	<nav class="navbar navbar-default" role="navigation">
				<div class="navbar-header">
					 <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button> <a class="navbar-brand" href="backendIndex">Pshare</a>
				</div>
				
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li class="active">
							 <a href="categoryMana">Category management</a>
						</li>
						<li>
							 <a href="paperMana">Paper management</a>
						</li>
						<li>
							 <a href="reviewMana">Review management</a>
						</li>
						<li>
							 <a href="paymentMana">Payment management</a>
						</li>
						<li>
							 <a href="userMana">User management</a>
						</li>
						
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<li>
							 <a href="#">当前用户:${user2.name}</a>
						</li>
					</ul>
				
			</nav>
</div>
<style>
body
{
	background-image:url('https://api.xygeng.cn/bing/1366.php'); 
}
.center {
    margin: auto;
    width: 60%;
    border: 3px solid #73AD21;
    padding: 10px;
}
</style> 

<script>
$(document).ready(function(){

		$.ajax({url:"demo_test.txt",success:function(result){
			$("#div1").html(result);
		}});
});
</script>
 