<%-- 
    Document   : user
    Created on : May 3, 2013, 1:47:55 PM
    Author     : Tanevski
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Category</title>
    </head>
    <body>
        
        <%@include file="headeradmin.jsp" %>
    <li>  <a href="createcategory" title="New Category">New Category</a> </li>
        </ul>

    </div> <!-- end side-menu -->

        <div class="side-content fr">
			
				<div class="content-module">
                                    
        <table style="width:auto;">
            <th>Name</th>
            <th>Delete</th>

            <c:forEach var="category" items="${allCategories}">

                <tr>
                    <td>
                        <a href="updatecategory.htm?categoryId=${category.id}">${category.name}</a>
                    </td>

                    <td>
                        <a href="category.htm?categoryId=${category.id}"  class="table-actions-button ic-table-delete" ></a>
                    </td>
                </tr>
            </c:forEach>
    
        </table>
            	</div> <!-- end content-module-main -->
				
				</div> <!-- end content-module -->
				
            </div><br>
        <p>${validationLabel}</p>
        </div> <!-- end full-width -->
        </div>
         <%@include file="footeradmin.jsp" %>
        
    </body>
</html>
