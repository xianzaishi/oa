<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<div style="float: right; height: auto; min-height: 200px; margin-left: 20px; margin-top: 10px;">
	<input id="seachUserName" type="text" /><a id="seachUser" href="javascript:void(0)" class="myButton2"><font color="#2e6e9e">搜索</font></a>
	<table id="infoList"></table>
	<div id="pager1"></div>
	<br/>
<div id="addUser" style="float: right;"><a href="javascript:void(0)" class="myButton2"><font color="#2e6e9e">添加</font></a>&nbsp;&nbsp;&nbsp;&nbsp;</div>
</div>


<script type="text/javascript">
var clickedId;

//编辑人员
function Modify(id) {
	window.location.href = "${contextPath }/user/edit/" + id;
}

//删除人员
function Delete(id) {
	var url = "${contextPath }/user/delete/" + id;
	var del = confirm("确定要删除？");
	
	if(del == true){
		$.ajax({
			url : url,
			timeout : 5000,
			success:function(data) {
				$("#infoList").jqGrid().hideCol("somecol").trigger("reloadGrid");
			},
			error : function(response) {
				alert("error");
			}
		});
	}
}

//用户授权
function Authorize(id){
	var url = "${contextPath }/authorize/user/id/" + id;
	window.open (url, 'newwindow', 'location=no, width=400, height=400, scrollbars=yes, menubar=no');
}

$(function(){
	var url = "${contextPath }/user/get";
	
	$("#infoList").jqGrid({
	    url:url,
	    datatype:'json',
	    mtype:'GET',
	    colNames:['编号','用户名','姓名','部门','操作'],
	    colModel:[
	        {name:'id',index:'id',width:55},
	        {name:'userName',index:'userName',width:200},
	        {name:'realName',index:'realName',width:200},
	        {name:'dept',index:'dept',width:80},
	        {name:'Modify',index:'Id',width:110,align:"center",sortable:false}
	    ],
	    //autowidth:true,
	    jsonReader:{
	        page:"page",
	        total:"total",
	        repeatitems:false
	    },
	    pager:jQuery('#pager1'),
	    rowNum:20,
	    rowList:[20,40,80,100],
	    sortname:'id',
	    sortorder:'desc',
	    viewrecords:true,
	    caption:'',
	    height:'460px',
	    gridComplete:function(){  //在此事件中循环为每一行添加修改和删除链接
            var ids=jQuery("#infoList").jqGrid('getDataIDs');
            for(var i=0; i<ids.length; i++){
                var id=ids[i];   
                modify = "<a href='javascript:void(0)' style='color:#f60' onclick='Modify(" + id + ");'>编辑</a>&nbsp;<a href='javascript:void(0)' style='color:#f60' onclick='Delete(" + id + ");' >删除</a>&nbsp;<a href='javascript:void(0)' style='color:#f60' onclick='Authorize(" + id + ");'>授权</a>";  //这里的onclick就是调用了上面的javascript函数 Modify(id)
                jQuery("#infoList").jqGrid('setRowData', ids[i], { Modify: modify });
            }
        }
	}).navGrid("#pager1",{edit:false,add:false,del:false,search:false});
	
});

$(function(){
	//添加人员
	$("#addUser").click(function(){
		window.location.href = "${contextPath }/user/add"; 
	});
	
	//搜索人员
	$("#seachUser").click(function(){
		var user = $("#seachUserName").val();
		var url = "${contextPath }/search/user/" + user;
		window.location.href = url;
	});
});
</script>
