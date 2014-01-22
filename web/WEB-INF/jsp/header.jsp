<%-- 
    Document   : header
    Created on : May 12, 2013, 1:35:11 PM
    Author     : Tanevski
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252" />
        <title>Electronix Store</title>
        <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>" />
        <script type="text/javascript" src="<c:url value="/resources/js/boxOver.js"/>" ></script>
    </head>
    <body>

        <div id="main_container">
            <div class="top_bar">
                <div class="top_search">
                    <div class="search_text"><a href="#">Advanced Search</a></div>
                    <form method="POST" action="search" >
                        <input type="text" class="search_input" name="search" />
                        <input type="image" formaction="search" src="<c:url value="/resources/images/search.gif" />" class="search_bt" />
                    </form>
                </div>

                <!--languages-->

            </div>
            <div id="header">

                <div id="logo">
                    <a href="home.html"><img src="<c:url value="/resources/images/logo.png" />" alt="" title="" border="0" width="237" height="140" /></a>
                </div>

                <!--offert-->
            </div>

            <div id="main_content"> 

                <div id="menu_tab">
                    <div class="left_menu_corner"></div>
                    <ul class="menu">
                        <li><a href="home.html" class="nav1">  Home </a></li>
                        <li class="divider"></li>
                        <li><a href="home.htm" class="nav2">Products</a></li>
                        <li class="divider"></li>
                        <li><a href="underconstruction.htm" class="nav3">Specials</a></li>
                        <li class="divider"></li>                        
                        <li><a href="underconstruction.htm" class="nav4">Shipping </a></li>
                        <li class="divider"></li>
                        <li><a href="contact.html" class="nav5">Contact Us</a></li>
                        <li class="divider"></li>
                        <li><a href="about.html" class="nav6">About</a></li>
                        <!--curencies-->
                    </ul>

                    <div class="right_menu_corner"></div>
                </div><!-- end of menu tab -->
                <!--<div style="float: right; margin-right:22%; margin-top:1%;"><a href="home.htm?order" style="text-decoration: none;" >Name</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="#" style="text-decoration: none;">Price</a></div>-->
