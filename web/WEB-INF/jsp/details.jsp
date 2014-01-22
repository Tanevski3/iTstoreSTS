<%-- 
    Document   : details
    Created on : May 12, 2013, 7:49:24 PM
    Author     : Tanevski
--%>
  <%@include file="header.jsp" %>
   <div class="crumb_navigation">
    Navigation: <a href="home.html">Home</a> &lt; <span class="current">${itemCategory}</span>
    
    </div>    
  <%@include file="left.jsp" %>
   
   <div class="center_content">
   	<div class="center_title_bar">${itemTitle}</div>
    
    	<div class="prod_box_big">
        	<div class="top_prod_box_big"></div>
            <div class="center_prod_box_big">            
                 
                 <div class="product_img_big">
                 <a href="javascript:popImage('electronix/data/images/${itemImageSource}','${itemImageSource}')" title="header=[Zoom] body=[&nbsp;] fade=[on]">
                     <img src="/electronix/data/images/${itemImageSource}" alt="" title="" border="0" />
                 </a>
                 <div class="thumbs">
                 <a href="#" title="header=[${itemTitle}] body=[&nbsp;] fade=[on]"><img src="/electronix/data/images/${itemImageSource}" alt="No image available!" title="${itemImageSource}" border="0" style="width: 30px; height:30px;"/></a>
                 <a href="#" title="header=[${itemTitle}] body=[&nbsp;] fade=[on]"><img src="/electronix/data/images/${itemImageSource}" alt="No image available!" title="${itemImageSource}" border="0" style="width: 30px; height:30px;"/></a>
                 <a href="#" title="header=[${itemTitle}] body=[&nbsp;] fade=[on]"><img src="/electronix/data/images/${itemImageSource}" alt="No image available!" title="${itemImageSource}" border="0" style="width: 30px; height:30px;"/></a>
                 </div>
                 </div>
                     <div class="details_big_box">
                         <div class="product_title_big">${itemTitle}</div>
                         <div class="specifications">

                            Specifications: <span class="blue">${itemSpecification}</span><br />
                            
                            Description: <span class="blue">${itemDescription}</span><br />
                            
                         </div>
                         <div class="prod_price_big"><span class="price">${itemPrice}$</span></div>
                         
                         <a href="underconstruction.htm" class="addtocart">add to cart</a>
                         <!--compare-->
                     </div>                        
            </div>
            <div class="bottom_prod_box_big"></div>                                
        </div>
    
    
 

 
 
 <c:if test="${simularItems!=null}">
 
 <div class="center_title_bar">Similar products</div>
   <c:forEach var="simularItem" items="${simularItems}" >
 
      	<div class="prod_box">
        	<div class="top_prod_box"></div>
            <div class="center_prod_box">            
                 <div class="product_title"><a href="details.html?itemId=${simularItem.id}">${simularItem.title}</a></div>
                 <div class="product_img"><a href="details.html?itemId=${simularItem.id}"><img src="/electronix/data/images/${simularItem.imageSource}" alt="" title="" border="0" /></a></div>
                 <div class="prod_price"> <span class="price">${simularItem.price}$</span></div>                        
            </div>
            <div class="bottom_prod_box"></div>             
            <div class="prod_details_tab">
            <a href="underconstruction.htm" title="header=[Add to cart] body=[&nbsp;] fade=[on]"><img src="<c:url value="/resources/images/cart.gif" />" alt="No cart image available!" title="" border="0" class="left_bt" /></a>
            <a href="underconstruction.htm" title="header=[Specials] body=[&nbsp;] fade=[on]"><img src="<c:url value="/resources/images/favs.gif" />" alt="No favs image available!" title="" border="0" class="left_bt" /></a>
            <a href="underconstruction.htm" title="header=[Gifts] body=[&nbsp;] fade=[on]"><img src="<c:url value="/resources/images/favorites.gif" />" alt="No favorites image available!" title="" border="0" class="left_bt" /></a>           
            <a href="details.html?itemId=${simularItem.id}" class="prod_details" >details</a>            
            </div>                     
        </div>
    
       </c:forEach>
 
 </c:if>
   </div><!-- end of center content -->

     <%@include file="right.jsp" %>
       <%@include file="footer.jsp" %>