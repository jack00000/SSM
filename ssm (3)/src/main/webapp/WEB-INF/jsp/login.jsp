<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <script src="http://how2j.cn/study/js/jquery/2.0.0/jquery.min.js"></script>
<link href="http://how2j.cn/study/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
<script src="http://how2j.cn/study/js/bootstrap/3.3.6/bootstrap.min.js"></script>
 
 

 
<div class="container">
	<div class="row clearfix">
		<div class="col-md-8 column">
		</div>
		<div class="col-md-4 column">
			<form role="form" action="login2Backend" method="POST">
			<div class="form-group">
					 <label for="exampleInputUserNmae">User Name</label><input type="name" class="form-control" id="exampleInputName" name="name" />
				</div>
				<div class="form-group">
					 <label for="exampleInputEmail1">Email address</label><input type="email" class="form-control" id="exampleInputEmail1" name="email"/>
				</div>
				<div class="form-group">
					 <label for="exampleInputPassword1">Password</label><input type="password" class="form-control" id="exampleInputPassword1" name="password" />
				</div>
				 <button type="submit" class="btn btn-default">Submit</button>
			</form>
		</div>
	</div>
</div>