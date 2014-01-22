<%-- 
    Document   : about
    Created on : May 12, 2013, 8:20:29 PM
    Author     : Tanevski
--%>
 <%@include file="header.jsp" %>
   <div class="crumb_navigation">
    Navigation: <a href="home.html">Home</a> &lt; <span class="current">About</span>
    </div>     
  <%@include file="left.jsp" %>
  
 <div class="center_content">
    	 <div class="center_content">
   	<div class="center_title_bar">Contact Us</div>
    
    	<div class="prod_box_big">
            <div class="top_prod_box_big"></div>
            <div class="center_prod_box_big">
                <c:forEach var="about" items="${abouts}" >
                ${about.description}
                <h1>Phone number:</h1>${about.phone}<br>
                <h1>Email:</h1>${about.email}<br>
                <h1>Fax:</h1>${about.fax}<br>
                <h1>Address:</h1>${about.address}<br>
                </c:forEach>
            </div>
            <div class="bottom_prod_box_big"></div>                                
        </div>
         </div>
   </div><!-- end of center content -->

<%@include file="right.jsp" %>
<%@include file="footer.jsp" %>