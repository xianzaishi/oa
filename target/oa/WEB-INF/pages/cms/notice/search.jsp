<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<style type="text/css">
table.altrowstable {
	font-family: verdana,arial,sans-serif;
	font-size:11px;
	color:#333333;
	border-width: 1px;
	border-color: #a9c6c9;
	border-collapse: collapse;
}
table.altrowstable th {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #a9c6c9;
}
table.altrowstable td {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #a9c6c9;
}
.oddrowcolor{
	background-color:#d4e3e5;
}
.evenrowcolor{
	background-color:#c3dde0;
}
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

<table width="960px" align="center" border="0">
	<tr>
		<td>
			<form id="searchForm" method="post" action="">
				<input id="searchKeyword" type="text" size="50"/>&nbsp;<a id="search" href="javascript:void(0)" class="myButton">搜索</a>
			</form>
		</td>
		<td align="right">
			<a href="${contextPath }/cms/notice/add" class="myButton">发布</a>&nbsp;
			<a id="editNotice" href="javascript:void(0)" class="myButton">编辑</a>&nbsp;
			<a id="deleteNotice" href="javascript:void(0)" class="myButton">删除</a>
		</td>
	</tr>
</table>

<table class="altrowstable" id="alternatecolor" width="960px" align="center">
<tr>
	<th><input id="checkAll" type="checkbox" /><th>通知</th><th>发布时间</th><th>发布人</th>
</tr>
<c:forEach items="${noticeList }" var="noticeList" varStatus="idx">
<tr>
	<td><input id="${noticeList.id }" name="checkbox" type="checkbox" /></td>
	<td width="600px"><div id="${noticeList.id }" name="preview"><c:out value="${noticeList.title }"/></div></td>
	<td width="180px"><fmt:formatDate  value="${noticeList.createDate }" pattern="yyyy.MM.dd HH:mm:ss" /></td>
	<td width="180px"><c:out value="${noticeList.creator }"/></td>
</tr>
</c:forEach>
</table>
<br/>
<center>
	<font style="font-size: 9pt"> 
		<a id="toFirstPage" href="javascript:void(0)">首页&nbsp;&nbsp;</a>
		<a id="toPrePage" href="javascript:void(0)">上一页&nbsp;&nbsp;</a>
		<a id="toNextPage" href="javascript:void(0)">下一页&nbsp;&nbsp;</a>
		<a id="toEndPage" href="javascript:void(0)">尾页&nbsp;&nbsp;</a>
		<input id="goToPageText" type="text" style="width:30px; height:12px;"/><a id="goToPage" href="javascript:void(0)">GO</a>
		共<a id="total"></a>条&nbsp;&nbsp;&nbsp;第<a id="nowPage"></a>页&nbsp;&nbsp;&nbsp;共<a id="totalPage"></a>页&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
	</font>
</center>
<script type="text/javascript">
function altRows(id){
	if(document.getElementsByTagName){  
		
		var table = document.getElementById(id);  
		var rows = table.getElementsByTagName("tr"); 
		 
		for(i = 0; i < rows.length; i++){          
			if(i % 2 == 0){
				rows[i].className = "evenrowcolor";
			}else{
				rows[i].className = "oddrowcolor";
			}      
		}
	}
}

window.onload=function(){
	altRows('alternatecolor');
}
$(function(){
	//------------------------分页 开始--------------------------------
	var count = ${count };	//总数
	var page = ${page };	//当前页码
	var pageCount = 1;	//总页码数
	var maxPerPage = 20;	//每页最多内容条数
	$('#total').html(count);
	$('#nowPage').html(page);
	$('#toFirstPage').attr("href", 1);
	
	//上一页
	if(page == 1){
		$('#toPrePage').attr("href", 1);
	}else{
		$('#toPrePage').attr("href", page - 1);
	}
	
	if(count%maxPerPage == 0){
		pageCount = count/maxPerPage;
	}else{
		pageCount = parseInt(count/maxPerPage + 1);
	}
	$('#totalPage').html(pageCount);
	$('#toEndPage').attr("href", pageCount);
	
	//下一页
	if(page == pageCount){
		$('#toNextPage').attr("href", pageCount);
	}else{
		$('#toNextPage').attr("href", page + 1);
	}
	
	//goToPage
	$('#goToPage').click(function(){
		var toPage = $('#goToPageText').val();
		if(toPage <= pageCount){
			$('#goToPage').attr("href", toPage);
		}else{
			$('#goToPage').attr("href", pageCount);
		}
	});
	//------------------------分页 结束--------------------------------
	
	//全选
	$('#checkAll').click(function(){
		if($('#checkAll').attr("checked") != "checked"){
			$("[name='checkbox']").removeAttr("checked");
		}else{
			$("[name='checkbox']").attr("checked", "true");
		}
	});
	
	//删除
	$('#deleteNotice').click(function(){
		var check = $("input:checked");
		var ids = -1;
		check.each(function(i){
			if($(this).attr("id") != "checkAll"){
				if(ids != -1){
					ids = ids + ','+$(this).attr("id");
				}else{
					ids = $(this).attr("id");
				}
			}
		});
		if(ids == -1){
			alert("请选择要删除的通知！");
			return 0;
		}
		var url = "${contextPath }/cms/notice/delete/ids/" + ids;
		window.location.href = url;
	});
	
	//编辑
	$('#editNotice').click(function(){
		var id = $("input:checked").attr("id");
		
		if(id == "checkAll"){
			alert("只能单选一个通知进行编辑操作！");
			return 0;
		}else if(id == "" || id == undefined){
			alert("请选择要编辑的通知！");
			return 0;
		}
		var url = "${contextPath }/cms/notice/edit/id/" + id;
		window.location.href = url;
	});
	
	//预览
	$("[name='preview']").click(function(){
		var id = this.id;
		var url = "${contextPath }/cms/notice/preview/id/" + id;
		window.open (url, 'newwindow', 'location=no, width=800, height=500, scrollbars=yes, menubar=no');
	});
	
	//搜索
	$('#search').click(function(){
		var keyword = $('#searchKeyword').val();
		var url = "${contextPath }/cms/content/search/keyword/" + keyword + "/page/1";
		
		if(keyword.replace(/(^\s*)|(\s*$)/g, "") == ""){
			alert("请输入搜索内容！");
			return 0;
		}
		
		$('#searchForm').attr("action", url);
		$('#searchForm').submit();
	});
});
</script>

