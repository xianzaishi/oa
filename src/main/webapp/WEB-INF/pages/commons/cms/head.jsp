<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>赤峰市第二医院</title>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="cssBasePath" value="${contextPath}/css" />
<c:set var="scriptBasePath" value="${contextPath}/script" />
<c:set var="imagesBasePath" value="${contextPath}/images" />
<script language="javascript" type="text/javascript" src="${contextPath}/script/jquery-1.7.2.min.js"></script>
<script language="javascript" type="text/javascript" src="${contextPath}/script/scrolltopcontrol.js"></script> 
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
-->
</style>
<link rel="stylesheet" type="text/css" href="${contextPath}/css/front-end/css.css" />
<style type="text/css">
<!--
a:link {
	text-decoration: none;
}

a:visited {
	text-decoration: none;
}

a:hover {
	text-decoration: none;
}

a:active {
	text-decoration: none;
}


html,body,ul,li{padding:0; margin:0;}
body {font:12px/normal Verdana, Arial, Helvetica, sans-serif; padding:50px;}
ul,li {list-style-type:none; text-transform:capitalize;}
/*menu*/
#nav { display:block;}
#nav .jquery_out {float:left;line-height:1px;display:block; border-right:1px solid #017C6D; text-align:center; color:#017C6D;font:18px/32px "微软雅黑"; background:#062723;}
#nav .jquery_out .smile {padding-left:1em;}
#nav .jquery_inner {margin-left:16px;}
#nav .jquery {margin-right:1px;padding:0 2em;}
#nav .mainlevel {background:#017C6D; float:left; border-right:0px solid #fff; width:104px;/*IE6 only 原宽度118*/}
#nav .mainlevel a {color:#ffffff; text-decoration:none; line-height:32px; display:block; padding:0 15px; width:105px;}
#nav .mainlevel a:hover {color:#fff; text-decoration:none;}
#nav .mainlevel ul {display:none; position:absolute;}
#nav .mainlevel li {border-top:1px solid #fff; background:#017C6D; width:130px;/*IE6 only 原宽度118*/}
-->
</style>


</head>

<body class="bd01">
<table align="center" width="960" border="0" cellpadding="0"
	cellspacing="0">
	<tbody>
		<tr>
			<td scope="col">
			<table width="98%" border="0" cellpadding="0" cellspacing="0">
				<tbody>
					<tr>
						<th scope="col" align="center"><img
							src="${contextPath}/images/front-end/cfsdeyy_05.gif" height="103"
							width="325" /></th>
					</tr>
				</tbody>
			</table>
			</td>
			<th scope="col" valign="bottom">
			<table align="right" height="100" width="300" border="0"
				cellpadding="0" cellspacing="0">
				<tbody>
					<tr>
						<th scope="col">
						<table align="right" width="444" border="0" cellpadding="0"
							cellspacing="0">
							<tbody>
								<tr>
									<th scope="col"><img
										src="${contextPath}/images/front-end/POP.gif" height="23"
										width="206" /></th>
									<td scope="col">
										<c:choose>
											<c:when test="${sessionScope.userName != null}">
												您好，<c:out value="${sessionScope.userName }" />&nbsp;&nbsp; <!-- <security:authentication property="name"/> <%= request.getSession().getAttribute("userName") %> -->
												<a href="${contextPath}/j_spring_security_logout" >登出</a>
											</c:when>
											<c:otherwise>
												<a href="${contextPath}/ums/login" >登陆</a>
											</c:otherwise>
										</c:choose>
									</td>
								</tr>
							</tbody>
						</table>
						</th>
					</tr>
				</tbody>
			</table>
			</th>
		</tr>
	</tbody>
</table>
<table align="center" width="960" border="0" cellpadding="0"
	cellspacing="0">
	<tbody>
		<tr>
			<th scope="col" height="9"></th>
		</tr>
	</tbody>
</table>
<table align="center" width="960" cellpadding="0" cellspacing="0">
	<tbody>
		<tr>
			<td scope="col" align="left" valign="top" bgcolor="017C6D">
				<ul id="nav" style="clear:both; width:960px; margin:0 auto; margin-bottom:30px;">
				    <li class="mainlevel"><a href="${contextPath}/cms/index" style="padding:0 50px;"><b>首页</b></a></li>
				    <li class="mainlevel" style="width:2px;"><img src="${contextPath}/images/front-end/cfsdeyy.jpg"/></li>
				    <li class="mainlevel"><a href="javascript:void(0)" style="padding:0 35px;"><b>信息中心</b></a> 
				    	<ul>
				        	<li><a href="${contextPath}/cms/notice/page/1"><b>单位公告</b></a></li>
				            <li><a href="${contextPath}/cms/official/document/page/1"><b>单位文件</b></a></li>
				            <!-- <li><a href="${contextPath}/mail/page/1"><b>内部邮件</b></a></li> -->
				        </ul>
				    </li>
				    <li class="mainlevel" style="width:2px;"><img src="${contextPath}/images/front-end/cfsdeyy.jpg"/></li>
				    <li class="mainlevel"><a href="${contextPath}/addresslist/index/page/1" style="padding:0 35px;"><b>通讯录</b></a></li>
				    <li class="mainlevel" style="width:2px;"><img src="${contextPath}/images/front-end/cfsdeyy.jpg"/></li>
				    <li class="mainlevel"><a href="javascript:void(0)" style="padding:0 35px;"><b>待开放</b></a>
				    <!-- 
				        <ul>
				        	<li><a href="${contextPath}/content/detail/contentId/170"><b>待开放</b></a></li>
				            <li><a href="${contextPath}/content/detail/contentId/171"><b>待开放</b></a></li>
				            <li><a href="${contextPath}/content/list/channelId/40/page/1"><b>待开放</b></a></li>
				            <li><a href="${contextPath}/content/list/channelId/41/page/1"><b>待开放</b></a></li>
				        </ul>
			         -->
				    </li>
				    <li class="mainlevel" style="width:2px;"><img src="${contextPath}/images/front-end/cfsdeyy.jpg"/></li>
				    <li class="mainlevel"><a href="javascript:void(0)" style="padding:0 35px;"><b>待开放</b></a>
				    <!-- 
				        <ul>
				        	<li><a href="${contextPath}/content/list/channelId/72/page/1"><b>家之宣言</b></a></li>
				            <li><a href="${contextPath}/content/list/channelId/73/page/1"><b>家人风采</b></a></li>
				            <li><a href="${contextPath}/content/list/channelId/74/page/1"><b>家事分享</b></a></li>
				        </ul>
			         -->
				    </li>
				    <li class="mainlevel" style="width:2px;"><img src="${contextPath}/images/front-end/cfsdeyy.jpg"/></li>
				    <li class="mainlevel"><a href="javascript:void(0)" style="padding:0 35px;"><b>待开放</b></a>
				    <!-- 
				        <ul>
				        	<li><a href="${contextPath}/content/list/channelId/82/page/1"><b>预约挂号</b></a></li>
				            <li><a href="${contextPath}/faq/page/1"><b>有问必答</b></a></li>
				            <li><a href="${contextPath}/content/detail/contentId/173"><b>责任链接</b></a></li>
				        </ul>
			         -->
				    </li>
				    <li class="mainlevel" style="width:2px;"><img src="${contextPath}/images/front-end/cfsdeyy.jpg"/></li>
				    <li class="mainlevel"><a href="javascript:void(0)" style="padding:0 35px;"><b>待开放</b></a>
				    </li>
				    <li class="mainlevel" style="width:2px;"><img src="${contextPath}/images/front-end/cfsdeyy.jpg"/></li>
				    <li class="mainlevel"><a href="javascript:void(0)" style="padding:0 35px;"><b>待开放</b></a> 
				    </li>
				    <security:authorize access="hasRole('ROLE_ADMIN')">
					    <li class="mainlevel" style="width:2px;"><img src="${contextPath}/images/front-end/cfsdeyy.jpg"/></li>
					    <li class="mainlevel"><a href="${contextPath}/user/management" style="padding:0 35px;"><b>系统管理</b></a> 
					    </li>
				    </security:authorize>
				</ul>
			</td>
		</tr>
	</tbody>
</table>
<script type="text/javascript">
$(document).ready(function(){
	jQuery.navlevel2 = function(level1,dytime) {
		
	  $(level1).mouseenter(function(){
		  varthis = $(this);
		  delytime=setTimeout(function(){
			varthis.find('ul').slideDown();
		},dytime);
		
	  });
	  $(level1).mouseleave(function(){
		 clearTimeout(delytime);
		 $(this).find('ul').slideUp();
	  });
	  
	};
  $.navlevel2("li.mainlevel",300);
});

function setHomepage() {
	 if (document.all){
        document.body.style.behavior='url(#default#homepage)';
	  	document.body.setHomePage('http://www.cfdeyy.com');
    }
    else if (window.sidebar){
    	if(window.netscape){
	         try{ 
	            netscape.security.PrivilegeManager.enablePrivilege("UniversalXPConnect"); 
	         } 
	         catch (e){ 
	    		alert( "该操作被浏览器拒绝，如果想启用该功能，请在地址栏内输入 about:config,然后将项 signed.applets.codebase_principal_support 值该为true" ); 
	         }
	    }
	    var prefs = Components.classes['@mozilla.org/preferences-service;1'].getService(Components. interfaces.nsIPrefBranch);
	    prefs.setCharPref('browser.startup.homepage','http://www.cfdeyy.com');
	}
}
	 
function addfavorite()
{
   if (document.all)
   {
      window.external.addFavorite('http://www.cfdeyy.com','赤峰市第二医院');
   }
   else if (window.sidebar)
   {
      window.sidebar.addPanel('赤峰市第二医院', 'http://www.cfdeyy.com', '');
   }
} 
</script>