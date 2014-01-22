<%-- 
    Document   : item
    Created on : May 3, 2013, 4:10:02 PM
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
    <li>  <a href="createitem" title="New Item">New Item</a> </li>
        </ul>

    </div> <!-- end side-menu -->

        <div class="side-content fr">
			
				<div class="content-module">
				
        <table>
            <th>Title</th>
            <th>Specification</th>
            <th>Image Source</th>
            <th>Price</th>
            <th>Stock</th>
            <th>Users</th>
            <th>Remove</th>
                <c:forEach var="item" items="${allItems}">
                <tr>
                    <td>
                        <a href="updateitem.htm?itemId=${item.id}">${item.title}</a>
                    </td>
                    <td>
                        ${item.specification}
                    </td>
                    <td>
                        ${item.imageSource}
                    </td>
                    <td>
                        ${item.price}
                    </td>
                    <td>
                        ${item.stock}
                    </td>
                    <td>
                        ${item.user.firstName}
                    </td>
                    <td>
                        <a href="item.htm?itemId=${item.id}" class="table-actions-button ic-table-delete" ></a>
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
