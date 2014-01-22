<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Create Category</title>

    </head>

    <body>
         <%@include file="headeradmin.jsp" %>
           </ul>

    </div> <!-- end side-menu -->
    
    <div class="side-content fr">
            <div class="content-module">
                <table>
            <form:form commandName="createCategory" >
                  <tr><td>Name:<br>  <form:input path="name" required="required" /><br>  </td>  </tr>
                 <tr><td><br>           </td>  </tr>
                     <tr><td><input type="submit" value="Create" /> </td>  </tr>
            </form:form>
                     <p>${validationLabel}</p>
                     
            </table>
 </div><br>
        <p>${validationLabel}</p>
        </div> <!-- end full-width -->
        </div>
         <%@include file="footeradmin.jsp" %>
</body>
</html>