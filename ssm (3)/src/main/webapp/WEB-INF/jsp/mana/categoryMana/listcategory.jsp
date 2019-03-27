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
 
 <div class="widget purple">
                         <div class="widget-title">
                             <h4><i class="icon-reorder"></i> Editable Table</h4>
                            <span class="tools">
                                <a href="javascript:;" class="icon-chevron-down"></a>
                                <a href="javascript:;" class="icon-remove"></a>
                            </span>
                         </div>
                         <div class="widget-body">
                             <div>
                                 <div class="clearfix">
                                     <div class="btn-group">
                                         <button id="editable-sample_new" class="btn green">
                                             Add New <i class="icon-plus"></i>
                                         </button>
                                     </div>
                                     <div class="btn-group pull-right">
                                         <button class="btn dropdown-toggle" data-toggle="dropdown">Tools <i class="icon-angle-down"></i>
                                         </button>
                                         <ul class="dropdown-menu pull-right">
                                             <li><a href="#">Print</a></li>
                                             <li><a href="#">Save as PDF</a></li>
                                             <li><a href="#">Export to Excel</a></li>
                                         </ul>
                                     </div>
                                 </div>
                                 <div class="space15"></div>
                                 <div id="editable-sample_wrapper" class="dataTables_wrapper form-inline" role="grid"><div class="row-fluid"><div class="span6"><div id="editable-sample_length" class="dataTables_length"><label><select size="1" name="editable-sample_length" aria-controls="editable-sample" class="xsmall"><option value="5" selected="selected">5</option><option value="15">15</option><option value="20">20</option><option value="-1">All</option></select> records per page</label></div></div><div class="span6"><div class="dataTables_filter" id="editable-sample_filter"><label>Search: <input type="text" aria-controls="editable-sample" class="medium"></label></div></div></div><table class="table table-striped table-hover table-bordered dataTable" id="editable-sample" aria-describedby="editable-sample_info">
                                     <thead>
                                     <tr role="row"><th class="sorting_disabled" role="columnheader" rowspan="1" colspan="1" aria-label="Username" style="width: 177px;">Username</th><th class="sorting" role="columnheader" tabindex="0" aria-controls="editable-sample" rowspan="1" colspan="1" aria-label="Full Name: activate to sort column ascending" style="width: 264px;">Full Name</th><th class="sorting" role="columnheader" tabindex="0" aria-controls="editable-sample" rowspan="1" colspan="1" aria-label="Points: activate to sort column ascending" style="width: 118px;">Points</th><th class="sorting" role="columnheader" tabindex="0" aria-controls="editable-sample" rowspan="1" colspan="1" aria-label="Notes: activate to sort column ascending" style="width: 168px;">Notes</th><th class="sorting" role="columnheader" tabindex="0" aria-controls="editable-sample" rowspan="1" colspan="1" aria-label="Edit: activate to sort column ascending" style="width: 82px;">Edit</th><th class="sorting" role="columnheader" tabindex="0" aria-controls="editable-sample" rowspan="1" colspan="1" aria-label="Delete: activate to sort column ascending" style="width: 117px;">Delete</th></tr>
                                     </thead>
                                     
                                 <tbody role="alert" aria-live="polite" aria-relevant="all"><tr class="odd">
                                         <td class="  sorting_1">Admin</td>
                                         <td class=" "> Admin lab</td>
                                         <td class=" ">462</td>
                                         <td class="center ">new user</td>
                                         <td class=" "><a class="edit" href="javascript:;">Edit</a></td>
                                         <td class=" "><a class="delete" href="javascript:;">Delete</a></td>
                                     </tr><tr class="even">
                                         <td class="  sorting_1">Admin</td>
                                         <td class=" "> Admin lab</td>
                                         <td class=" ">462</td>
                                         <td class="center ">new user</td>
                                         <td class=" "><a class="edit" href="javascript:;">Edit</a></td>
                                         <td class=" "><a class="delete" href="javascript:;">Delete</a></td>
                                     </tr><tr class="odd">
                                         <td class="  sorting_1">Dulal</td>
                                         <td class=" ">Jonathan Smith</td>
                                         <td class=" ">434</td>
                                         <td class="center ">new user</td>
                                         <td class=" "><a class="edit" href="javascript:;">Edit</a></td>
                                         <td class=" "><a class="delete" href="javascript:;">Delete</a></td>
                                     </tr><tr class="even">
                                         <td class="  sorting_1">Dulal</td>
                                         <td class=" ">Jonathan Smith</td>
                                         <td class=" ">434</td>
                                         <td class="center ">new user</td>
                                         <td class=" "><a class="edit" href="javascript:;">Edit</a></td>
                                         <td class=" "><a class="delete" href="javascript:;">Delete</a></td>
                                     </tr><tr class="odd">
                                         <td class="  sorting_1">Jhon Doe</td>
                                         <td class=" ">Jhon Doe </td>
                                         <td class=" ">1234</td>
                                         <td class="center ">super user</td>
                                         <td class=" "><a class="edit" href="javascript:;">Edit</a></td>
                                         <td class=" "><a class="delete" href="javascript:;">Delete</a></td>
                                     </tr></tbody></table><div class="row-fluid"><div class="span6"><div class="dataTables_info" id="editable-sample_info">Showing 1 to 5 of 12 entries</div></div><div class="span6"><div class="dataTables_paginate paging_bootstrap pagination"><ul><li class="prev disabled"><a href="#">← Prev</a></li><li class="active"><a href="#">1</a></li><li><a href="#">2</a></li><li><a href="#">3</a></li><li class="next"><a href="#">Next → </a></li></ul></div></div></div></div>
                             </div>
                         </div>
                     </div>
  