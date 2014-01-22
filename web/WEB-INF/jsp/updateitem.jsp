<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!DOCTYPE html>
<html>
    <head>

    <title>Update Item</title>

</head>
<body>
     <%@include file="headeradmin.jsp" %>
       </ul>

    </div> <!-- end side-menu -->
         <div class="side-content fr">
			
            <div class="content-module">
                <table>
        <form:form commandName="updateItemForm">
            <c:choose>
                <c:when test="${empty param}">
                    ID:&nbsp;<form:input path="id" required="required" /><br>
                </c:when>
                <c:otherwise>
                    <form:hidden path="id" value="${idToUpdate}" /><br>
                </c:otherwise>
            </c:choose>
                    <tr>
                        <td>Title:<br><form:input path="title"  maxlength="20" value="${currentTitle}"/><br></td>
                    </tr>
                    <tr>
                        <td>Specification:<br><textarea path="specification" name="specification" rows="5" cols="50" maxlength="500" >${currentSpecification}</textarea><br></td>
                    </tr>
                    <tr>
                        <td>Description:<br><textarea path="description" name="description" rows="10" cols="50" maxlength="500">${currentDescription}</textarea><br></td>
                    </tr>
                    <tr>
              <td>Price:<br><input type="number" path="price"  name="price" value="${currentPrice}"/><br> </td>
                    </tr>
                    <tr>
                        <td>Stock:<br><input type="number" path="stock" name="stock" value="${currentStock}"/><br> </td>
                    </tr>
                    <tr>
                        <td>
            Category:<br><form:select path="category.id" itemValue="${currentCategoryId}" itemLabel="${currentCategoryName}" >
                <c:forEach var="cate" items="${allCategories}">
                    <c:choose>
                        <c:when test="${cate.id==currentCategoryId}">
                            <form:option value="${cate.id}" selected="selected">${cate.name}</form:option>
                        </c:when>
                        <c:otherwise>
                            <form:option value="${cate.id}">${cate.name}</form:option>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </form:select><br>
                        </td>
                    </tr>
                    <tr><td>
            Image:<br><form:input path="imageSource" value="${currentImageSource}"/><br>
                        </td>
                    </tr>
            <form:hidden path="user.id" value="${currentUserId}"/><br>
   <tr><td>
                            <br> </td>
                    </tr>
               <tr><td><input type="submit" value="Update Item!" />  </td>
                    </tr>
        </form:form>
            </table>
   </div><br>
        <p>${validationLabel}</p>
        </div> <!-- end full-width -->
        </div>
         <%@include file="footeradmin.jsp" %>
</body>
</html>