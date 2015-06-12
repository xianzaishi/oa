<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="cssBasePath" value="${contextPath}/css" />
<c:set var="scriptBasePath" value="${contextPath}/script" />
<c:set var="imagesBasePath" value="${contextPath}/images" />

   
    
   <div class="left_content">
    <div class="title_box">类别</div>
    
        <ul class="left_menu">
        <li class="odd"><a href="details.html">Power Tools</a></li>
        <li class="even"><a href="details.html">Air Tools</a></li>
         <li class="odd"><a href="details.html">Hand Tools</a></li>
        <li class="even"><a href="details.html">Accessories</a></li>
         <li class="odd"><a href="details.html">Workwear</a></li>
         <li class="even"><a href="details.html">Spare Parts</a></li>
        <li class="odd"><a href="details.html">Power Tools</a></li>
        <li class="even"><a href="details.html">Air Tools</a></li>
         <li class="odd"><a href="details.html">Hand Tools</a></li>
        <li class="even"><a href="details.html">Accessories</a></li>
         <li class="odd"><a href="details.html">Workwear</a></li>
         <li class="even"><a href="details.html">Spare Parts</a></li>
        </ul> 
        
        
     <div class="title_box">本店特色</div>  
     <div class="border_box">
         <div class="product_title"><a href="details.html">Makita 156 MX-VL</a></div>
         <div class="product_img"><a href="details.html"><img src="${contextPath}/images/front-end/p1.jpg" alt="" title="" border="0" /></a></div>
         <div class="prod_price"><span class="reduce">350$</span> <span class="price">270$</span></div>
     </div>  
     
     
     <div class="title_box">通信</div>  
     <div class="border_box">
		<input type="text" name="newsletter" class="newsletter_input" value="your email"/>
        <a href="#" class="join">subscribe</a>
     </div>  
     
     <div class="banner_adds">
     
     <a href="#"><img src="${contextPath}/images/front-end/bann2.jpg" alt="" title="" border="0" /></a>
     </div>    
        
    
   </div><!-- end of left content --> 



   <div class="center_content">
   
           		<div class="oferta">
                	<img src="${contextPath}/images/front-end/p1.png" width="165" height="113" border="0" class="oferta_img" alt="" title="" />
                	
                    <div class="oferta_details">
                            <div class="oferta_title">Power Tools BST18XN Cordless</div>
                            <div class="oferta_text">
                            Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco
                            </div>
                            <a href="details.html" class="prod_buy">详细</a>
                    </div>
                </div>
   
   
   		<div class="center_title_bar">最新产品</div>
   		<c:forEach items="${latestContenList }" var="latestContenList">
	    	<div class="prod_box">
	            <div class="center_prod_box">            
	                 <div class="product_title"><a href="details.html">${latestContenList.title }</a></div>
	                 <c:choose>
		                 <c:when test="${latestContenList.image == ''}">
		                 	<div class="product_img"><a href="details.html"><img src="${contextPath }/images/zwtp.jpg" alt="" title="" border="0" width=94px height=71px/></a></div>
		                 </c:when>
		                 <c:otherwise>
		                 	<div class="product_img"><a href="details.html"><img src="${contextPath}/${latestContenList.image }" alt="" title="" border="0" width=94px height=71px/></a></div>
	                 	</c:otherwise>
                 	</c:choose>
	                 <div class="prod_price"><span class="reduce">350$</span> <span class="price">270$</span></div>                        
	            </div>
	           
	            <div class="prod_details_tab">
	            <a href="buy.html" class="prod_buy">加入购物车</a>          
	            <a href="details.html" class="prod_details">详细</a>            
	            </div>                     
	        </div>
	    </c:forEach>
    
    	<div class="center_title_bar">推荐商品</div>
    
    	<div class="prod_box">

            <div class="center_prod_box">            
                 <div class="product_title"><a href="details.html">Makita 156 MX-VL</a></div>
                 <div class="product_img"><a href="details.html"><img src="${contextPath}/images/front-end/p7.jpg" alt="" title="" border="0" /></a></div>
                 <div class="prod_price"><span class="reduce">350$</span> <span class="price">270$</span></div>                        
            </div>
           
            <div class="prod_details_tab">
            <a href="buy.html" class="prod_buy">加入购物车</a>          
            <a href="details.html" class="prod_details">详细</a>            
            </div>                     
        </div>
    
    	<div class="prod_box">

            <div class="center_prod_box">            
                 <div class="product_title"><a href="details.html">Bosch XC</a></div>
                 <div class="product_img"><a href="details.html"><img src="${contextPath}/images/front-end/p1.jpg" alt="" title="" border="0" /></a></div>
                 <div class="prod_price"><span class="reduce">350$</span> <span class="price">270$</span></div>                        
            </div>
           
            <div class="prod_details_tab">
            <a href="buy.html" class="prod_buy">加入购物车</a>          
            <a href="details.html" class="prod_details">详细</a>            
            </div>                     
        </div>    
 

     	<div class="prod_box">

            <div class="center_prod_box">            
                 <div class="product_title"><a href="details.html">Lotus PP4</a></div>
                 <div class="product_img"><a href="details.html"><img src="${contextPath}/images/front-end/p3.jpg" alt="" title="" border="0" /></a></div>
                 <div class="prod_price"><span class="reduce">350$</span> <span class="price">270$</span></div>                        
            </div>
           
            <div class="prod_details_tab">
            <a href="buy.html" class="prod_buy">加入购物车</a>          
            <a href="details.html" class="prod_details">详细</a>            
            </div>                     
        </div>   
    
   
   </div><!-- end of center content -->



 <div class="right_content">
 
      <div class="title_box">搜索</div>  
     <div class="border_box">
		<input type="text" name="newsletter" class="newsletter_input" value="keyword"/>
        <a href="#" class="join">search</a>
     </div>  
     

     
 
   		<div class="shopping_cart">
        	<div class="title_box">购物车</div>
            
            <div class="cart_details">
            3 items <br />
            <span class="border_cart"></span>
            Total: <span class="price">350$</span>
            </div>
            
            <div class="cart_icon"><a href="#" title=""><img src="${contextPath}/images/front-end/shoppingcart.png" alt="" title="" width="35" height="35" border="0" /></a></div>
        
        </div>
   
   
     <div class="title_box">新品上市</div>  
     <div class="border_box">
         <div class="product_title"><a href="details.html">Motorola 156 MX-VL</a></div>
         <div class="product_img"><a href="details.html"><img src="${contextPath}/images/front-end/p2.jpg" alt="" title="" border="0" /></a></div>
         <div class="prod_price"><span class="reduce">350$</span> <span class="price">270$</span></div>
     </div>  
     
     
     
    <div class="title_box">制造商</div>
    
        <ul class="left_menu">
        <li class="odd"><a href="services.html">Bosch</a></li>
        <li class="even"><a href="services.html">Samsung</a></li>
         <li class="odd"><a href="services.html">Makita</a></li>
        <li class="even"><a href="services.html">LG</a></li>
         <li class="odd"><a href="services.html">Fujitsu Siemens</a></li>
         <li class="even"><a href="services.html">Motorola</a></li>
        <li class="odd"><a href="services.html">Phillips</a></li>
        <li class="even"><a href="services.html">Beko</a></li>
        </ul>      
     
     <div class="banner_adds">
     
     <a href="#"><img src="${contextPath}/images/front-end/bann1.jpg" alt="" title="" border="0" /></a>
     </div>        
     
   </div><!-- end of right content -->   


            
   </div><!-- end of main content -->
   
<script>
$(function(){});
</script>
   
  