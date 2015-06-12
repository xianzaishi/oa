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
<center><br/>
<form:form id="addContentForm" commandName="notice" method="POST">
<table>
	<tr>
		<td>标题：</td>
		<td>&nbsp;<form:input id="title" path="title" style="width:700px;"/><font size="2" color="red">&nbsp;*</font>
		</td>
	</tr>
	<tr>
		<td>内容：</td>
		<td><form:textarea id="noticeText" path="content" style="width:500px; height:200px;"></form:textarea><font style="float:right;" size="2" color="red">&nbsp;*</font></td>
	</tr>
</table>
</form:form>
<div style="text-align:center">
	<a class="myButton" id="addContentButton" href="javascript:void(0)">确定</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<a class="myButton" id="canle" href="javascript:void(0)">取消</a>
</div>
</center>

<!-- ckeditor 图片上传 -->
<center>
<div id="ckeditor-upload-images" class="flow-div flow-menu" style="display:none;">
	<div style="float:right; position:absolute; width:260px; height:100px; top:190px; left:265px; right:18px; border:2px solid #03c; background-color:#F2F2F2;">
		<form id="ckeditor-fileUploadForm" ENCTYPE="multipart/form-data" action="${contextPath }/cms/content/fileUpload" method="post">
			上传图片：<input type="file" value="上传" id="ckeditor-file" name="ckeditor-file"/><br/>
			<input type="radio" id="image-size" name="image-size" value="original" checked/>原始大小
			<input type="radio" id="image-size" name="image-size" value="small" />缩放<br/>
			<input id="ckeditor-uploadFileButton" type="button" value="上传" />
			<input id="ckeditor-uploadFileButton-cancel" type="button" value="取消" />
		</form>
	</div>
	<div style="clear:both;"></div>
</div>
<center>
<script type="text/javascript">

//ckeditor图片上传
function ckeditorImageUpload(){
	$('#ckeditor-upload-images').show();
}

$(function(){
	var ckeditor = CKEDITOR.replace( 'noticeText' );
	
	//添加
	$("#addContentButton").click(function(){
		async = true;
		// 表单验证
		if($.trim($("#title").val()) == ""){
			alert("标题不能为空");
			return 0;
		}else if(ckeditor.getData() == ""){
			alert("内容不能为空");
			return 0;
		}
		var url = "${contextPath }/cms/notice/add/submit";
		$("#addContentForm").attr("action", url);
		$("#addContentForm").submit();
	});
	
	//ckeditor图片上传
	$("#ckeditor-uploadFileButton").click(function(){
		var url = "${contextPath }/cms/content/uploadImageUrl/-1";
		var id;
		var imageUrl;
		//ajax文件上传
		$.ajaxFileUpload({
			url:url,//服务器端程序
			secureuri:false,
			fileElementId:'ckeditor-file',//input框的ID
			dataType: 'json',//返回数据类型
			success: function (data, status){//上传成功
				var size = $('input[name=image-size]:checked').val();
				var originalData = ckeditor.getData();
				id = data.id;
				imageUrl = "${contextPath }" + data.url;
				
				if(size == "original"){
					ckeditor.setData(originalData + "<div align='center'><img src='" + imageUrl + "' /></div>");
				}else if(size == "small"){
					ckeditor.setData(originalData + "<div align='center'><img src='" + imageUrl + "' style='width: 220px; height: 220px;' /></div>");
				}
				
				$('#ckeditor-upload-images').hide();
			},
			error: function (data, status, e){
				alert(e);
			}
		});
	});
	
	$('#ckeditor-uploadFileButton-cancel').click(function(){
		$('#ckeditor-upload-images').hide();
	});
});
</script>
