<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create User Page</title>


    </head>
    <body>
         <%@include file="headeradmin.jsp" %>
       </ul>

    </div> <!-- end side-menu -->
         <div class="side-content fr">
			
            <div class="content-module">
                <table>
        <form:form commandName="createUserForm">
           <tr><td>  First Name :<form:input path="firstName"/><br></td></tr>
            <tr><td><br></td></tr>
           <tr><td>  Last name :<form:input path="lastName"/><br></td></tr>
            <tr><td><br></td></tr>
            <tr><td> Username :<form:input path="username" required="required"  /><br></td></tr>
             <tr><td><br></td></tr>
           <tr><td>  Password :<form:password path="password" required="required"  /><br></td></tr>
            <tr><td><br></td></tr>
            <tr><td> Active: <form:checkbox path="isActive" /><br></td></tr>
             <tr><td><br></td></tr>
            <tr><td> Email: <form:input path="email" required="required" maxlength="45"/><br></td></tr>
             <tr><td><br></td></tr>
                     <tr><td><br>
         <tr><td><input type="submit" value="Create User!"/>
    </table>
</form:form>
  </table>
   </div><br>
        <p>${validationLabel}</p>
        </div> <!-- end full-width -->
        </div>
         <%@include file="footeradmin.jsp" %>

</body>
</html>
