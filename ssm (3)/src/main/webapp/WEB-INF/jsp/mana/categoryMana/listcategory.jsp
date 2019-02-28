<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <script src="http://how2j.cn/study/js/jquery/2.0.0/jquery.min.js"></script>
<link href="http://how2j.cn/study/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
<script src="http://how2j.cn/study/js/bootstrap/3.3.6/bootstrap.min.js"></script>
<%@include file="../../../jsp/nav.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<div style="width:500px;margin:0px auto;text-align:center">
	<table class="table">
	    <thead>
					<tr>
						<th>
							id
						</th>
						<th>
							name
						</th>
						<th>
							edit
						</th>
						<th>
							delete
						</th>
					</tr>
				</thead>
	    <c:forEach items="${cs}" var="c" varStatus="st">
	      <c:choose>
		   <c:when test="${c.id==1}">  
		    <tr class="info">
	            <td>${c.id}</td>
	            <td>${c.name}</td>
	            <td><a href="editCategory?id=${c.id}">编辑</a></td>
	            <td><a href="deleteCategory?id=${c.id}">删除</a></td>
	        </tr>     
		   </c:when>
		   <c:otherwise> 
		  
		   </c:otherwise>
		 </c:choose>
	      
	        
	    
	        
	    </c:forEach>
	</table>
	<div style="text-align:center">
		<a href="?start=0">首  页</a>
		<a href="?start=${page.start-page.count}">上一页</a>
		<a href="?start=${page.start+page.count}">下一页</a>
		<a href="?start=${page.last}">末  页</a>
	</div>
	<div style="text-align:center;margin-top:40px">
		
		<form method="post" action="addCategory">
			分类名称： <input name="name" value="" type="text"> <br><br>
			<input type="submit" value="增加分类">
		</form>

	</div>	
 </div>
  