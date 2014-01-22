<%-- 
    Document   : right
    Created on : May 12, 2013, 1:35:05 PM
    Author     : Tanevski
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div class="right_content">
    <form method="POST" action="advancedSearchQuery">
        <label>Search in category:</label>
        <select style="width:180px;" name="categoryName">
            <c:forEach var="category" items="${allCategories}" >
            <option>${category.name}</option>
            </c:forEach>
        </select>
        <br><br>
        <label>Part or full name:</label>
        <input name="part" type="text"  style="width:180px;"> <br><br>
        <label>In stock:</label>
        <input type="number" name="stock" value="0" min="0">&nbsp;or more<br><br>
        <label>Order by:</label>
        <select name="orderBy">
            <option>Title</option>
            <option>Price</option>
        </select>
        <select name="ascDesc">
            <option>Asc</option>
            <option>Desc</option>
        </select> 
        <br><br>
        <input type="submit" value="Show" >
        <br>
    </form>
    <br>
    <div class="shopping_cart">
        <div class="cart_title">Shopping cart</div>

        <div class="cart_details">
            3 items <br>
            <span class="border_cart"></span>
            Total: <span class="price">350$</span>
        </div>

        <div class="cart_icon"><a href="underconstruction.htm" title="header=[Checkout] body=[&nbsp;] fade=[on]"><img src="<c:url value="/resources/images/shoppingcart.png" />" " title="" width="48" height="48" border="0" /></a></div>

    </div>


    <div class="title_box">What's new</div>  
    <div class="border_box">
        <div class="product_title"><a href="details.html?itemId=${newestItem.id}">${newestItem.title}</a></div>
        <div class="product_img"><a href="details.html?itemId=${newestItem.id}"><img src="/electronix/data/images/${newestItem.imageSource}" alt="" title="" border="0" /></a></div>
        <div class="prod_price"><span class="price">${newestItem.price}$</span></div>
    </div>  

    <!--manufacturers-->

    <a href="underconstruction.htm"><img src="<c:url value="/resources/images/bann1.jpg" />" " alt="" title="" border="0" /></a>
</div>        

</div><!-- end of right content -->   

