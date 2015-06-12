<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<style type="text/css">
h1,h2,h3,h4,h5,h6,p,ul,li,dl,dt,dd{padding:0;margin:0;font-size:9pt;}
li{list-style:none;}img{border:none;}em{font-style:normal;}
a{color:#555;text-decoration:none;outline:none;blr:this.onFocus=this.blur();}
a:hover{color:#000;text-decoration:underline;}
.clear{height:0;overflow:hidden;clear:both;}
h4{font-size:14px;height:27px;line-height:27px;padding-left:10px;border-bottom:#ddd 1px solid;}
.news{width:440px;border:#ddd 1px solid;}
.news ul{padding:5px 10px;}
.news ul li{height:24px;line-height:24px;overflow:hidden;}
</style>
<br/>
<table width="960px" border="0" cellpadding="0" cellspacing="0" bgcolor="white" align="center">
<tr><td>
<div class="news" style="float: left; margin-top: 20px; margin-bottom: 20px; margin-left: 20px;">
	<h4>公告通知</h4>
	<ul>
		<c:forEach items="${noticeList }" var="noticeList">
			<li>·<a title="<c:out value='${noticeList.title }' />" href="${contextPath }/cms/notice/preview/id/${noticeList.id}" target=_blank><c:out value="${noticeList.title }" /></a></li>
		</c:forEach>
	</ul>
</div>
<div class="news" style="float: right; margin-top: 20px; margin-bottom: 20px; margin-right: 20px;">
	<h4>单位文件</h4>
	<ul>
		<c:forEach items="${myFileList }" var="myFileList">
			<li>·<a title="<c:out value='${myFileList.fileName }' />" href="javascript:void(0)" onClick="clickDownload(${myFileList.id });"><c:out value="${myFileList.fileName }" /></a></li>
		</c:forEach>
	</ul>
</div>
</td></tr></table>
<script type="text/javascript">
function clickDownload(id){
	var url = "${contextPath }/cms/official/dept/file/download/id/" + id;
	window.open (url, 'newwindow', 'location=no, width=600, height=270, scrollbars=yes, menubar=no');
}
</script>