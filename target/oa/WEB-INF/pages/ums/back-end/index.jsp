<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<link rel="stylesheet" type="text/css" href="${contextPath}/css/dtree.css" />
<script language="javascript" type="text/javascript" src="${contextPath}/script/dtree.js"></script> 
<div id="a"></div>
<div id="tree" style="float: left; height: 400px; height: auto; min-height: 400px; margin-left: 20px; margin-top: 10px;">
   <div class="dtree">
	  <script type="text/javascript">
	  	var treeName = 'tree';
		var tree = new dTree(treeName,'${contextPath}');
		$.ajax( {
			type:"GET",
			//url : "/eoms/cms/folder.json",
			url : "${contextPath }/cms/index/loadTree" + ".json",
			dataType : "json",
			timeout : 5000,
			async:false,
			success:function(data) {
			    tree.add(0,-1,'频道管理');
			    for(i=0; i<data.length; i++){
			    	tree.add(data[i].id,data[i].parent,data[i].name,data[i].id);
			    }
			},
			error : function(response) {
				alert("error");
				//$.msg.alert("error:"+response);
			}
		});
		document.write(tree);
		for(i=0; i<tree.aNodes.length; ++i){
			$('#s' + treeName + i).bind('click', function(){
				$('#div-head').html('');
				var str = $(this).html();
				$('[name = dtreeFont]').attr('style', '');
				//$(this).html('<font style="color:red" name="dtreeFont">' + str + '</font>');
				$('#div-head').append('内容管理 &gt;&gt; ' + str);
				clickedId = $(this).attr('href');
				$("#infoList").jqGrid("setGridParam", { 
					url: '${contextPath }/cms/content/get/channelId/' + clickedId, //设置表格的url 
					datatype: 'json' //设置数据类型 
				}).hideCol("somecol").trigger("reloadGrid");;
				return false;
			});
		}
	 </script>
	</div>
</div>


<div style="float: right; height: auto; min-height: 200px; margin-left: 20px; margin-top: 10px;">
	<table id="infoList"></table>
	<div id="pager1"></div>
	<br/>
<div id="addChannel" style="float: left;"><a href="javascript:void(0)" class="myButton2"><font color="#2e6e9e">添加频道</font></a>&nbsp;&nbsp;&nbsp;&nbsp;</div>
<div id="editChannel" style="float: left;"><a href="javascript:void(0)" class="myButton2"><font color="#2e6e9e">编辑频道</font></a>&nbsp;&nbsp;&nbsp;&nbsp;</div>
<div id="deleteChannel" style="float: left;"><a href="javascript:void(0)" class="myButton2"><font color="#2e6e9e">删除频道</font></a>&nbsp;&nbsp;&nbsp;&nbsp;</div>
<div id="addContent" style="float: left;"><a href="javascript:void(0)" class="myButton2"><font color="#2e6e9e">添加内容</font></a>&nbsp;&nbsp;&nbsp;&nbsp;</div>
</div>


<script type="text/javascript">
var clickedId;

//编辑文章
function Modify(id) {
	var url = "${contextPath }/cms/content/edit/" + id;
	//window.open (url, 'newwindow', 'height=500, width=600, top=0, left=400, top=0, left=0, toolbar=no, menubar=no, scrollbars=no, resizable=no, location=no, status=no');
	//$("#dialog-confirm").openWidow({id:"abcd",width:800,height:470,title:"编辑内容",url:url});
	$.dialog({
		title: "编辑内容",
		close: function(){location.reload()},
		content: 'url:' + url,
		width: 860,
		height: 560,
		drag: false,
	    resize: false,
		lock: true
	});
}

//删除文章
function Delete(id) {
	var url = "${contextPath }/cms/content/contentId/" + id + "/delete";
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

$(function(){
	var url = "${contextPath }/cms/content/get";
	
	$("#infoList").jqGrid({
	    url:'${contextPath }/cms/content/get',
	    datatype:'json',
	    mtype:'GET',
	    colNames:['编号','标题','创建时间','摘要','操作'],
	    colModel:[
	        {name:'id',index:'id',width:55},
	        {name:'title',index:'title',width:100},
	        {name:'createDate',index:'createDate',width:110,formatter:"date",formatoptions: {srcformat:'u',newformat:'Y-m-d H:i:s'}},
	        {name:'brief',index:'brief',width:100},
	        {name:'Modify',index:'Id',width:80,align:"center",sortable:false}
	    ],
	    //autowidth:true,
	    jsonReader:{
	        page:"page",
	        total:"total",
	        repeatitems:false
	    },
	    pager:jQuery('#pager1'),
	    rowNum:10,
	    rowList:[10,20],
	    sortname:'id',
	    sortorder:'desc',
	    viewrecords:true,
	    caption:'',
	    height:'222px',
	    gridComplete:function(){  //在此事件中循环为每一行添加修改和删除链接
            var ids=jQuery("#infoList").jqGrid('getDataIDs');
            for(var i=0; i<ids.length; i++){
                var id=ids[i];   
                modify = "<a href='#' style='color:#f60' onclick='Modify(" + id + ");'>编辑</a>&nbsp;<a href='#'  style='color:#f60' onclick='Delete(" + id + ");' >删除</a>";  //这里的onclick就是调用了上面的javascript函数 Modify(id)
                jQuery("#infoList").jqGrid('setRowData', ids[i], { Modify: modify });
            }
        }
	}).navGrid("#pager1",{edit:false,add:false,del:false,search:false});
	
});

$(function(){
	//添加频道
	$("#addChannel").click(function(){
		if(''== clickedId || clickedId == undefined){
			alert("请选择上层频道");
		}else{
			var url = "${contextPath}/cms/channel/add/" + clickedId;
			//window.open (url, 'newwindow', 'height=500, width=600, top=0, left=400, top=0, left=0, toolbar=no, menubar=no, scrollbars=no, resizable=no, location=no, status=no'); 
			//$("#dialog-confirm").openWidow({id:"abc",width:440,height:500,title:"測試",url:url});
			$.dialog({
				title: "添加频道",
				close: function(){location.reload()},
				content: 'url:' + url,
				width: 400,
				height: 200,
				drag: false,
			    resize: false,
				lock: true
			});
			
		}
		return false;
	});
	
	//编辑频道
	$("#editChannel").click(function(){
		if(''== clickedId || clickedId == undefined){
			alert("请选择要编辑的频道");
		}else{
			var url = "${contextPath}/cms/channel/edit/" + clickedId;
			//window.open (url, 'newwindow', 'height=500, width=600, top=0, left=400, top=0, left=0, toolbar=no, menubar=no, scrollbars=no, resizable=no, location=no, status=no'); 
			//$("#dialog-confirm").openWidow({id:"abc",width:440,height:500,title:"測試",url:url});
			$.dialog({
				title: "编辑频道",
				close: function(){location.reload()},
				content: 'url:' + url,
				width: 400,
				height: 200,
				drag: false,
			    resize: false,
				lock: true
			});
		}
		return false;
	});
	
	//删除频道
	$("#deleteChannel").click(function(){
		//TODO 检查此频道下是否有文章
		if(''== clickedId || clickedId == undefined){
			alert("请选择要删除的频道");
		}else{
			if(confirm("确定删除此频道?")){
				var url = "${contextPath}/cms/channel/delete/" + clickedId;
				$.ajax( {
					url : url,
					timeout : 5000,
					success:function(data) {
						if(data == "success"){
							location.reload();
						}else if(data == "fail"){
							alert("此频道下存在子频道或频道下有未删除的文章，不能删除！");
						}
					},
					error : function(response) {
						alert("error");
					}
				});
			}
		}
	});
	
	//添加内容
	$("#addContent").click(function(){
		if(''== clickedId || clickedId == undefined){
			alert("请选择上层频道");
		}else{
			var url = "${contextPath}/cms/content/add/" + clickedId;
			//window.open (url, 'newwindow', 'height=500, width=600, top=0, left=400, top=0, left=0, toolbar=no, menubar=no, scrollbars=no, resizable=no, location=no, status=no'); 
			//$("#dialog-confirm").openWidow({id:"abc",width:800,height:500,title:"添加内容",url:url});
			$.dialog({
				title: "添加内容",
				close: function(){location.reload()},
				content: 'url:' + url,
				width: 860,
				height: 560,
				drag: false,
			    resize: false,
				lock: true
			});
		}
		return false;
	});
});
</script>
