<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<style type="text/css">
/*
.imgLink
{
    background-image: url(${contextPath }/images/leftMenu/bjbjbj.jpg);
    color: red;
    font-size: 12px;
    line-height: 20px;
    text-align: center;
    display: block;
    float: left;
    width: 138px;
    height: 50px;
}
*/
</style>

<div id="navigation-block" style="float: left; margin-right: 10px; width: 200px;">
    <ul id="sliding-navigation">
        <li class="sliding-element"><h3>权限管理</h3></li>
        <li class="sliding-element"><a href="${contextPath }/user/management">用户管理</a></li>
        <li class="sliding-element"><a href="${contextPath }/dept/management">部门管理</a></li>
        <li class="sliding-element"><a href="#">Link 3</a></li>
        <li class="sliding-element"><a href="#">Link 4</a></li>
        <li class="sliding-element"><a href="#">Link 5</a></li>
    </ul>
</div>

<script type="text/javascript">
$(document).ready(function(){
	slide("#sliding-navigation", 25, 15, 100, .8);
});

function slide(navigation_id, pad_out, pad_in, time, multiplier)
{
	// creates the target paths
	var list_elements = navigation_id + " li.sliding-element";
	var link_elements = list_elements + " a";
	
	// initiates the timer used for the sliding animation
	var timer = 0;
	
	// creates the slide animation for all list elements 
	$(list_elements).each(function(i)
	{
		// margin left = - ([width of element] + [total vertical padding of element])
		$(this).css("margin-left","-180px");
		// updates timer
		timer = (timer*multiplier + time);
		$(this).animate({ marginLeft: "0" }, timer);
		$(this).animate({ marginLeft: "15px" }, timer);
		$(this).animate({ marginLeft: "0" }, timer);
	});

	// creates the hover-slide effect for all link elements 		
	$(link_elements).each(function(i)
	{
		$(this).hover(
		function()
		{
			$(this).animate({ paddingLeft: pad_out }, 100);
		},		
		function()
		{
			$(this).animate({ paddingLeft: pad_in }, 100);
		});
	});
}
</script>