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
        <title>User</title>
    </head>
    <body>
          <%@include file="headeradmin.jsp" %>
    <li>  <a href="createuser" title="New User">New User</a> </li>
        </ul>

    </div> <!-- end side-menu -->

        <div class="side-content fr">
			
				<div class="content-module">
        <table style="width:auto;">
             <th>First Name</th>
            <th>Last Name</th>
            <th>Username</th>
            <th>Active</th>
            <th>E-mail</th>
            
            <c:forEach var="user" items="${allUsers}">
                <tr>
                    <td>
                        <a href="updateuser.htm?userId=${user.id}">${user.firstName}</a>
                    </td>
                    <td>
                        ${user.lastName}
                    </td>
                    <td>
                        ${user.username}
                    </td>
                    <td>
                        ${user.isActive}
                    </td>
                    <td>
                        ${user.email}
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
