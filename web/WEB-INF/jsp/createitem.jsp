<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Create Item</title>
    </head>
    <body>
         <%@include file="headeradmin.jsp" %>
           </ul>

    </div> <!-- end side-menu -->
    
    <div class="side-content fr">
            <div class="content-module">
                <table>
        <form:form commandName="createItem">
            <tr><td>
            Title:<br> <form:input path="title" required="required" /><br>
            </td></tr>
             <tr><td>
            Specification:<br><form:textarea path="specification" rows="5" cols="50" maxlength="500"/><br>
            </td></tr>
              <tr><td>
            Description:<br><form:textarea path="description"  rows="10" cols="50" maxlength="1000" /><br> 
            </td></tr>
               <tr><td>
            Price:<br><input type="number" name="price"  required="required" /><br> 
            </td></tr>
                <tr><td>
            Stock:<br><input type="number" name="stock" required="required" /><br> 
            </td></tr>
                 <tr><td>
            Category:<br><form:select path="category.id" >
                <c:forEach var="cate" items="${allCategories}">
                    <form:option value="${cate.id}">${cate.name}</form:option>
                </c:forEach>
            </form:select><br>
            </td></tr>
                 <tr> <td>
            <form:hidden path="user.id" />
            Image:<br><form:input path="imageSource" value="none.jpg" /><br>
                     </td></tr>
            <tr><td><br>           </td>  </tr>
            <tr>  <td><br>      
            <input type="submit" value="Create" />
                   </td></tr>
        </form:form>
            </table>
 </div><br>
        <p>${validationLabel}</p>
        </div> <!-- end full-width -->
        </div>
         <%@include file="footeradmin.jsp" %>
    </body>
</html>