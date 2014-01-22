<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Category</title>

    </head>
    <body>
        <%@include file="headeradmin.jsp" %>
    </ul>

</div> <!-- end side-menu -->

<div class="side-content fr">
    <div class="content-module">
        <table>
            <form:form commandName="updateCategoryForm">
                <c:choose>
                    <c:when test="${empty param}">
                        ID: <form:input path="id" required="required" /><br>
                    </c:when>
                    <c:otherwise>
                        <form:hidden path="id" value="${idToUpdate}" /><br>
                    </c:otherwise>
                </c:choose><tr><td>Type title: <br><form:input path="name"  value="${currentName}" /><br><tr><td>
                 <tr><td><br>           </td>  </tr>
                <tr><td><input type="submit" value="Update category!" />    </td>  </tr>
            </form:form>

        </table>
    </div><br>
    <p>${validationLabel}</p>
</div> <!-- end full-width -->
</div>
<%@include file="footeradmin.jsp" %>
</body>
</html>

