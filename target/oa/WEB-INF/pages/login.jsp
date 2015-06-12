<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <title>Login</title>
    <link href="${contextPath}/css/login/styles.css" type="text/css" media="screen" rel="stylesheet" />
    <script language="javascript" type="text/javascript" src="${contextPath}/script/jquery-1.7.2.min.js"></script> 
    <script language="javascript" type="text/javascript" src="${contextPath}/script/md5-min.js"></script> 
</head>
<body id="login">
    <div id="wrappertop">
    </div>
    <div id="wrapper">
        <div id="content">
            <div id="header">
                <h1>
                    <a href="javascript:void(0)">
                       <!-- 放置Logo  <img src="" height="50" width="200" alt="logo"/> -->
                    </a>
                </h1>
            </div>
            <div id="darkbanner" class="banner320">
                <h2>系统登陆</h2>
            </div>
            <div id="darkbannerwrap">
            </div>
            <form id="loginForm" method="post" name="Login" action="${contextPath}/j_spring_security_check">
            <fieldset class="form">
                <p>
                    <label class="loginlabel" for="user_name">用户名:</label>
                    <!-- <input class="logininput ui-keyboard-input ui-widget-content ui-corner-all" name="user_name"
                        id="user_name" type="text" value="" /> -->
                    <input id="j_username" name="j_username" class="logininput ui-keyboard-input ui-widget-content ui-corner-all" type="text"/>
                </p>
                <p>
                    <label class="loginlabel" for="user_password">密&nbsp;&nbsp;&nbsp;&nbsp;码:</label>
                    <span>
                        <!-- <input class="logininput"   name="user_password" id="user_password" type="password" /> -->
                        <input id="j_password" name="j_password" class="logininput" type="password" />
                    </span>
                        
                </p>
                
                <button id="loginbtn" type="button" class="positive" name="Submit">
                    <img src="${contextPath}/images/login/key.png" alt="Announcement" />登陆
                </button>
                <ul id="forgottenpassword">
                    <li class="boldtext">|</li>
                    <li>
                        <label for="rememberMe"><a href="${contextPath}/index/">没有账号？访问主页</a></label>
                    </li>
                </ul>
            </fieldset>
            </form>
            
            <center><div><font color="red"><c:out value="${error }" /></font></div></center><br/>
        </div>
    </div>
    <div id="wrapperbottom_branding">
	    <div id="wrapperbottom_branding_text">
		    版权所有:<a href="javascript:void(0)" style='text-decoration: none'>信息科 </a>| 
		    <a href="javascript:void(0)" style='text-decoration: none'>赤峰市第二医院</a>
		</div>
    </div>
</body>
<script type="text/javascript">
$(function(){
	$("#loginbtn").click(function(){
		//if($("#user_name").val().trim() == ""){
		//	alert("用户名不能为空");
		//	return 0;
		//}else if($("#user_password").val().trim() == ""){
		//	alert("密码不能为空");
		//	return 0;
		//}
		//$("#user_password").val(hex_md5($("#user_password").val()));
		$("#loginForm").submit();
	});
	
	$("#j_password").keydown(function(e){ 
		var curKey = e.which; 
		if(curKey == 13){ 
			$("#loginbtn").click(); 
			return false; 
		} 
	}); 
});
</script>
</html>