<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>操作成功</title>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<script language="javascript" type="text/javascript" src="${contextPath}/script/jquery-1.7.2.min.js"></script> 
</head>
<body>
<span id="s"></span>
<script language="javascript">
var time = 5; //时间,秒 

function Redirect(){ 
window.location = "${contextPath}/user/management"; 
} 
var i = 0; 
function dis(){ 
document.all.s.innerHTML = "操作成功" + (time - i) + "秒钟后返回上一页面......</br>页面如果没有自动跳转，请点击<a href='${contextPath}/user/management'>返回上一页面</a>"; 
i++; 
} 
timer=setInterval('dis()', 1000);//显示时间 
timer=setTimeout('Redirect()',time * 1000); //跳转 
</script>
</body>
</html>