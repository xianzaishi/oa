<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<script language="javascript" type="text/javascript" src="${contextPath}/script/jquery-1.7.2.min.js" ></script>
</head>
<body>
	<div style="text-align:center"><h3><c:out value="${myFile.fileName }"/></h3></div>
	<div style="margin: 20px 100px;"><a href="${myFile.path }">下载</a></div>
</body>
</html>
