<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<link rel="stylesheet" type="text/css" href="${contextPath}/css/ajaxfileupload.css" />
<link rel="stylesheet" type="text/css" href="${contextPath}/css/jquery-ui-1.8.21.custom.css" />
<script language="javascript" type="text/javascript" src="${contextPath}/script/jquery-1.7.2.min.js" ></script>
<script language="javascript" type="text/javascript" src="${contextPath}/script/ckeditor/ckeditor.js" ></script> 
<script language="javascript" type="text/javascript" src="${contextPath}/script/ajaxfileupload.js" ></script> 
<script language="javascript" type="text/javascript" src="${contextPath}/script/lhgdialog/lhgcore.lhgdialog.min.js" ></script>
<style>
.myButton {
	-moz-box-shadow:inset 0px 1px 0px 0px #d4e3e5;
	-webkit-box-shadow:inset 0px 1px 0px 0px #d4e3e5;
	box-shadow:inset 0px 1px 0px 0px #d4e3e5;
	background:-webkit-gradient(linear, left top, left bottom, color-stop(0.05, #d4e3e5), color-stop(1, #d4e3e5));
	background:-moz-linear-gradient(top, #d4e3e5 5%, #d4e3e5 100%);
	background:-webkit-linear-gradient(top, #d4e3e5 5%, #d4e3e5 100%);
	background:-o-linear-gradient(top, #d4e3e5 5%, #d4e3e5 100%);
	background:-ms-linear-gradient(top, #d4e3e5 5%, #d4e3e5 100%);
	background:linear-gradient(to bottom, #d4e3e5 5%, #d4e3e5 100%);
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#d4e3e5', endColorstr='#d4e3e5',GradientType=0);
	background-color:#d4e3e5;
	border:1px solid #d4e3e5;
	display:inline-block;
	cursor:pointer;
	color:#000000;
	font-family:arial;
	font-size:13px;
	font-weight:bold;
	padding:6px 12px;
	text-decoration:none;
}
.myButton:hover {
	background:-webkit-gradient(linear, left top, left bottom, color-stop(0.05, #d4e3e5), color-stop(1, #d4e3e5));
	background:-moz-linear-gradient(top, #d4e3e5 5%, #d4e3e5 100%);
	background:-webkit-linear-gradient(top, #d4e3e5 5%, #d4e3e5 100%);
	background:-o-linear-gradient(top, #d4e3e5 5%, #d4e3e5 100%);
	background:-ms-linear-gradient(top, #d4e3e5 5%, #d4e3e5 100%);
	background:linear-gradient(to bottom, #d4e3e5 5%, #d4e3e5 100%);
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#d4e3e5', endColorstr='#d4e3e5',GradientType=0);
	background-color:#d4e3e5;
}
.myButton:active {
	position:relative;
	top:1px;
}
</style>
<center><br/><br/><br/><br/><br/>
<form:form id="addDeptFolderForm" commandName="deptFolder" method="POST" accept-charset="UTF-8">
<table>
	<tr>
		<td>名称：</td>
		<td>&nbsp;<form:input id="name" path="name" style="width:700px;"/><font size="2" color="red">&nbsp;*</font>
		</td>
	</tr>
</table>
</form:form>
<br/><br/>
<div style="text-align:center">
	<a class="myButton" id="addDeptFolderButton" href="javascript:void(0)">确定</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a class="myButton" id="canle" href="javascript:void(0)">取消</a>
</div>
</center>

<script type="text/javascript">
$(function(){
	//添加
	$("#addDeptFolderButton").click(function(){
		async = true;
		// 表单验证
		if($.trim($("#name").val()) == ""){
			alert("名称不能为空");
			return 0;
		}
		var url = "${contextPath }/cms/official/dept/add/submit";
		$("#addDeptFolderForm").attr("action", url);
		$("#addDeptFolderForm").submit();
	});
});
</script>
