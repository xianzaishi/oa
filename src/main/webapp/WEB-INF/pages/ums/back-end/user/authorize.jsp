<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>角色授权</title>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<link rel="stylesheet" type="text/css" href="${contextPath}/css/myButton.css" />
<script language="javascript" type="text/javascript" src="${contextPath}/script/jquery-1.7.2.min.js"></script> 
</head>
<body><br/><br/>
<div style="text-align: left; margin-left: 100px; margin-right: 100px;">
	<c:forEach items="${roleList }" var="roleList" varStatus="idx">
		<input id="${roleList.id }" type="checkbox" name="role" value="${roleList.id }"/><c:out value="${roleList.modelName }"/><br/>
	</c:forEach>
</div>
<br/>
<div style="text-align:center">
	<a class="myButton" id="submit" href="javascript:void(0)">确定</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</div>
<script language="javascript">
$(function(){
	var roleIds = ${roleIds };
	var count = roleIds.length;
	for(i=0; i<count; i++){
		$("#" + roleIds[i]).attr("checked", true);
	}
	$("#submit").click(function(){
		async = true;
		var userId = ${userId };
		var checkedBox = $("input[name='role']:checked");
		count = $("input[name='role']:checked").length;
		roleIds = "";
		for(i=0; i<count; i++){
			roleIds += $("input[name='role']:checked")[i].value + ",";
		}
		var url = "${contextPath}/authorize/user/id/" + userId + "/role/id/" + roleIds;
		window.location.href = url;
	});
});
</script>
</body>
</html>