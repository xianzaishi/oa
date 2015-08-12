<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>新增用户</title>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<script language="javascript" type="text/javascript" src="${contextPath}/script/jquery-1.7.2.min.js"></script> 
<style type="text/css">
<!--
body {
font-family: Arial, Helvetica, sans-serif;
font-size:12px;
color:#666666;
background:#fff;
text-align:center;
}
* {
margin:0;
padding:0;
}
a {
color:#1E7ACE;
text-decoration:none;
}
a:hover {
color:#000;
text-decoration:underline;
}
h3 {
font-size:14px;
font-weight:bold;
}
pre,p {
color:#1E7ACE;
margin:4px;
}
input, select,textarea {
padding:1px;
margin:2px;
font-size:11px;
}
.buttom{
padding:1px 10px;
font-size:12px;
border:1px #1E7ACE solid;
background:#D0F0FF;
}
#formwrapper {
width:450px;
margin:15px auto;
padding:20px;
text-align:left;
border:1px solid #A4CDF2;
}
fieldset {
padding:10px;
margin-top:5px;
border:1px solid #A4CDF2;
background:#fff;
}
fieldset legend {
color:#1E7ACE;
font-weight:bold;
padding:3px 20px 3px 20px;
border:1px solid #A4CDF2;
background:#fff;
}
fieldset label {
float:left;
width:120px;
text-align:right;
padding:4px;
margin:1px;
}
fieldset div {
clear:left;
margin-bottom:2px;
}
.enter{ text-align:center;}
.clear {
clear:both;
}
-->
</style>
</head>
<body>
<div id="formwrapper">
<br/>
<form:form id="userForm" commandName="user" method="post">
<fieldset>
<legend>新增用户</legend>
<div>
<label for="Name">用户名</label>
<form:input type="text" id="Name" path="userName" size="20" maxlength="30" />
<c:out value="<font color='red'>${tip }</font>" default="*(最多30个字符)" escapeXml="boolean"/><br/>
</div>
<div>
<label for="realName">姓名</label>
<form:input type="text" id="realName" path="realName" size="20" maxlength="30" />
*(最多30个字符)<br/>
</div>
<div>
<label for="password">密码</label>
<form:input type="password" id="password" path="password" size="20" maxlength="15" />
*(最多15个字符)<br/>
</div>
<div>
<label for="confirm_password">密码验证</label>
<input type="password" name="confirm_password" id="confirm_password" size="20" maxlength="15" />
*<br/>
</div>
<div>
<label for="dept">部门</label>
<form:hidden id="dept" path="dept"/>
<select id="deptOpn" size="1">
	<c:forEach items="${deptList }" var="deptList">
		<option value ="${deptList.id }">${deptList.department }</option>
	</c:forEach>
</select>
*<br/>
</div>
<div class="enter">
<a id="submitForm" href="javascript:void(0)" class="buttom">提交</a>
<a href="javascript:void(0)" class="buttom">重置</a>
</div>
<p><strong>* 在提交您的注册信息时, 我们认为您已经同意了我们的服务条款.<br/>
* 这些条款可能在未经您同意的时候进行修改.</strong></p>
</fieldset>
</form:form>
</div>
<script language="javascript">
$(function(){
	$('#submitForm').click(function(){
		var url = "${contextPath}/add/user";
		
		$('#dept').val($("#deptOpn").val());
		
		if($('#Name').val() == ''){
			alert("请正确填写用户名");
			return false;
		}else if($('#realName').val() == ''){
			alert("请正确填写姓名");
			return false;
		}else if($('#password').val() == ''){
			alert("请正确填写密码");
			return false;
		}else if($('#confirm_password').val() == '' || ($('#confirm_password').val() != $('#password').val())){
			alert("请正确填写密码验证");
			return false;
		}else{
			$('#userForm').attr('action', url);
			$('#userForm').submit();
		}
	});
});
</script>
</body>
</html>