<%-- 
    Document   : left
    Created on : May 12, 2013, 1:34:41 PM
    Author     : Tanevski
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
   <div class="left_content">
       
    <div class="title_box">Categories</div>
    
        <ul class="left_menu">
            
           <c:forEach var="category" items="${allCategories}" varStatus="counter" >
               <c:choose>
                   <c:when test="${counter.index%2!=0}">
                        <li class="odd"><a href="home.html?categoryId=${category.id}" > ${category.name}</a></li>
                   </c:when>
                   <c:otherwise>
                         <li class="even"><a href="home.html?categoryId=${category.id}" > ${category.name}</a></li>
                   </c:otherwise>
               </c:choose>
            </c:forEach>
                         
        </ul> 
        
        
     <div class="title_box">Special Products</div>  
     <div class="border_box">
         <div class="product_title"><a href="details.html?itemId=${specialItem.id}">${specialItem.title}</a></div>
         <div class="product_img"><a href="details.html?itemId=${specialItem.id}"><img src="/electronix/data/images/${specialItem.imageSource}" alt="" title="" border="0" /></a></div>
         <div class="prod_price"><span class="price">${specialItem.price}$</span></div>
     </div>  
     
     
		<!--newsletter-->    
     
     <div class="banner_adds">
     
     <a href="underconstruction.htm"><img src="<c:url value="/resources/images/bann2.jpg" />" alt="" title="" border="0" /></a>
     </div>    
        
    
   </div><!-- end of left content -->
   
