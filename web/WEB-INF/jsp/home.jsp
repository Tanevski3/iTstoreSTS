
<%@include file="header.jsp" %>

<div class="crumb_navigation">
    Navigation: <span class="current">Home</span>
</div>  

<%@include file="left.jsp" %>


<!-- center content -->
<div class="center_content">

    <div class="center_title_bar">Latest Products</div>

    <c:set var="begin" value="${from<9?9:from}" scope="page" />

    <c:set var="count" value="0" scope="page" />
    
    <c:forEach var="item" items="${allItems.size()<9?allItems:allItems.subList(begin-9,begin>allItems.size()?allItems.size():begin)}" >

        <c:set var="count" value="${count + 1}" scope="page"/>

        <div class="prod_box">
            <div class="top_prod_box"></div>
            <div class="center_prod_box">            
                <div class="product_title"><a href="details.html?itemId=${item.id}" width="90px">${item.title}</a></div>
                <div class="product_img"><a href="details.html?itemId=${item.id}"><img src="/electronix/data/images/${item.imageSource}" alt="No image available!" title="" border="0" width="100px" height="100px"/></a></div>
                <div class="prod_price"> <span class="price">${item.price}$</span></div>                        
            </div>
            <div class="bottom_prod_box"></div>             
            <div class="prod_details_tab">
                <a href="underconstruction.htm" title="header=[Add to cart] body=[&nbsp;] fade=[on]"><img src="<c:url value="/resources/images/cart.gif" />" alt="" title="" border="0" class="left_bt" /></a>
                <a href="underconstruction.htm" title="header=[Specials] body=[&nbsp;] fade=[on]"><img src="<c:url value="/resources/images/favs.gif" />" alt="" title="" border="0" class="left_bt" /></a>
                <a href="underconstruction.htm" title="header=[Gifts] body=[&nbsp;] fade=[on]"><img src="<c:url value="/resources/images/favorites.gif" />" alt="" title="" border="0" class="left_bt" /></a>           
                <a href="details.html?itemId=${item.id}" class="prod_details">details</a>            
            </div>                     
        </div>
    </c:forEach>

    <div class="center_pagging_bar">
        <c:set var="pageNumber" value="0" scope="page" />
        <c:choose>
            <c:when test="${allItems.size()%9==0}">
                <c:forEach begin="0" step="1" end="${allItems.size()/9-1}" varStatus="counter">
                    <a href="donation.htm?from=${count+9*counter.index}">${counter.index+1}</a>&nbsp;&nbsp;&nbsp;
                </c:forEach>

            </c:when>
            <c:otherwise>
                <c:forEach begin="0" step="1" end="${allItems.size()/9}" varStatus="counter">
                    <a href="home.htm?from=${count+9*counter.index}">${counter.index+1}</a>&nbsp;&nbsp;&nbsp;
                </c:forEach>
                <a href="home.htm?from=${count}">${counter.index}</a>
            </c:otherwise>
        </c:choose>
    </div>
    <!--  <div class="center_pagging_bar"><a href="#">1</a>   <a href="#">2</a>   <a href="#">3</a>   <a href="#">4</a>   <a href="#">5</a></div> -->
    <div class="center_title_bar">Recommended Products</div>

    <c:forEach var="item" items="${recommendedItems}">
        <div class="prod_box">
            <div class="top_prod_box"></div>
            <div class="center_prod_box">            
                <div class="product_title"><a href="details.html?itemId=${item.id}">${item.title}</a></div>
                <div class="product_img"><a href="details.html?itemId=${item.id}"><img src="/electronix/data/images/${item.imageSource}" alt="" title="" border="0" /></a></div>
                <div class="prod_price"> <span class="price">${item.price}</span></div>                        
            </div>
            <div class="bottom_prod_box"></div>             
            <div class="prod_details_tab">
                <a href="underconstruction.htm" title="header=[Add to cart] body=[&nbsp;] fade=[on]"><img src="<c:url value="/resources/images/cart.gif" />" alt="" title="" border="0" class="left_bt" /></a>
                <a href="underconstruction.htm" title="header=[Specials] body=[&nbsp;] fade=[on]"><img src="<c:url value="/resources/images/favs.gif" />"  alt="" title="" border="0" class="left_bt" /></a>
                <a href="underconstruction.htm" title="header=[Gifts] body=[&nbsp;] fade=[on]"><img src="<c:url value="/resources/images/favorites.gif" />" alt="" title="" border="0" class="left_bt" /></a>           
                <a href="details.html" class="prod_details">details</a>            
            </div>                     
        </div>
    </c:forEach>

</div>
<!-- end of center content -->



<%@include file="right.jsp" %>
<%@include file="footer.jsp" %>