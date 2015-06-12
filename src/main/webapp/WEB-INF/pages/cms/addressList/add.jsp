<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
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
<center><br/><br/><br/>
<form id="addressListForm" method="post" enctype="multipart/form-data">
<table>
	<tr>
		<td>姓名:</td>
		<td><input id="name" name="name" type="text"></td>
	</tr>
	<tr>
		<td>电话:</td>
		<td><input id="mobile" name="mobile" type="text"></td>
	</tr>
	<tr>
		<td>所属部门:</td>
		<td>
			<select id="deptOpn" name="deptOpn" size="1">
				<c:forEach items="${deptList }" var="deptList">
					<option value ="${deptList.id }">${deptList.department }</option>
				</c:forEach>
			</select>
		</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td><a id="submit" href="${contextPath }/addresslist/add" class="myButton">确定</a>&nbsp;&nbsp;</td>
		<td>&nbsp;&nbsp;<a id="cancel" href="${contextPath }/addresslist/index/page/1" class="myButton">取消</a></td>
	</tr>
</table>
</form>
<br/><br/><br/></center>
<script type="text/javascript">
$(function(){
	$("#submit").click(function(){
		$('#dept').val($("#deptOpn").val());
		
		var url = "${contextPath }/addresslist/add/submit";
		$("#addressListForm").attr("action", url);
		$("#addressListForm").submit();
	});
});
</script>

