<%-- 
    Document   : aboutmanagement
    Created on : May 15, 2013, 8:46:49 PM
    Author     : Tanevski
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Item</title>
    </head>
    <body>
          <%@include file="headeradmin.jsp" %>
           </ul>

    </div> <!-- end side-menu -->
    
    <div class="side-content fr">
            <div class="content-module">
                <table>
        <form method="POST" action="aboutmanagement">
            <tr><td>
            <label>Address: </label><br>
            <input name="address" type="text" value="${currentAddress}"><br>
            </td>
            </tr>
            <tr><td>
            <label>Email: </label><br>
            <input name="email" type="email" value="${currentEmail}"><br>
            </td></tr>
        <tr><td>
            <label>Phone: </label><br>
            <input name="phone" type="tel" value="${currentPhone}"><br>
            </td></tr>
          <tr><td>
             <label>Fax: </label><br>
            <input name="phone" type="tel" value="${currentPhone}"><br>
            </td></tr>
          <tr><td>
             <label>Description: </label><br>
             <textarea name="description">${currentDescription}</textarea><br>
             </td></tr>
          <tr><td><br></td> </tr>
          <tr><td>
             <input type="Submit" value="Update">
             </td></tr>
        </form>
             
            </table>
 </div><br>
        <p>${validationLabel}</p>
        </div> <!-- end full-width -->
        </div>
         <%@include file="footeradmin.jsp" %>
    </body>
</html>
