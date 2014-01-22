<%-- 
    Document   : updateuser
    Created on : May 3, 2013, 2:03:09 PM
    Author     : Tanevski
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create user</title>
    </head>
    <body>
          <%@include file="headeradmin.jsp" %>
       </ul>

    </div> <!-- end side-menu -->
         <div class="side-content fr">
			
            <div class="content-module">
                <table>
        <form:form commandName="updateUserForm">
             <c:choose>
                <c:when test="${empty param}">
                    ID: <form:input path="id" required="required" /><br>
                </c:when>
                <c:otherwise>
                    <form:hidden path="id" value="${idToUpdate}" /><br>
                </c:otherwise>
            </c:choose>
                    <tr><td> First Name : <form:input path="firstName" maxlength="20" value="${currentFirstName}" /><br></td></tr>
                     <tr><td><br></td></tr>
       <tr><td> Last name : <form:input path="lastName" maxlength="20" value="${currentLastName}" /><br></td></tr>
        <tr><td><br></td></tr>
       <tr><td> Username :   <form:input path="username" maxlength="20" autocomplete="autocomplete" value="${currentUsername}"/><br></td></tr>
        <tr><td><br></td></tr>
       <tr><td> Old password :   <input type="text" maxlength="15" autocomplete="autocomplete" value="${currentPassword}"/><br></td></tr>
        <tr><td><br></td></tr>
       <tr><td> New password :   <form:password path="password" maxlength="15" autocomplete="autocomplete" value="${currentPassword}"/><br></td></tr>
        <tr><td><br></td></tr>
      <tr><td>  Active : <form:checkbox path="isActive" value="isActive" checked="${currentIsActive}"/><br></td></tr>
       <tr><td><br></td></tr>
      <tr><td>  Email : <form:input path="email" maxlength="45" autocomplete="autocomplete" value="${currentEmail}"/><br></td></tr>
              <tr><td><br></td></tr>
     <tr><td>   <input type="submit" value="Update User!" /><br></td></tr>
        </form:form>
        </table>
   </div><br>
        <p>${validationLabel}</p>
        </div> <!-- end full-width -->
        </div>
         <%@include file="footeradmin.jsp" %>
    </body>
</html>
