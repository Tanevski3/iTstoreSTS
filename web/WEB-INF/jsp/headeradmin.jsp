<%-- 
    Document   : headeradmin
    Created on : May 4, 2013, 6:09:40 PM
    Author     : Tanevski
--%>
<!DOCTYPE html>
<!--[if lt IE 7]> <html class="lt-ie9 lt-ie8 lt-ie7" lang="en"> <![endif]-->
<!--[if IE 7]> <html class="lt-ie9 lt-ie8" lang="en"> <![endif]-->
<!--[if IE 8]> <html class="lt-ie9" lang="en"> <![endif]-->
<!--[if gt IE 8]><!--> <html lang="en"> <!--<![endif]-->
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <meta charset="utf-8">
    <title>SimpleAdmin - Dashboard</title>

    <!-- Stylesheets -->
    <link href='http://fonts.googleapis.com/css?family=Droid+Sans:400,700' rel='stylesheet'>
    <link rel="stylesheet" href="<c:url value="/resources/css/adminstyle.css"/>" >

    <!-- Optimize for mobile devices -->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

    <!-- jQuery & JS files -->
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
    <script src="js/script.js"></script> 

    <!-- TOP BAR -->
    <div id="top-bar">

        <div class="page-full-width cf">

            <ul id="nav" class="fl">

                <li class="v-sep"><a href="#" class="round button dark menu-user image-left">Logged in as <strong><p>${loggedUserName}!</p>&nbsp;</strong> 
                <li><a href="logout" class="round button dark menu-logoff image-left">Log out</a></li> </a>

            </ul> <!-- end nav -->

        </div> <!-- end full-width -->	

    </div> <!-- end top-bar -->
    <br>
    	<div id="content">
		
		<div class="page-full-width cf">
    <div class="side-menu fl" >

        <ul>
            <li><a href="item.htm" title="Item">Item</a></li>
            <li><a href="user.htm" title="User">User</a></li>
            <li><a href="category.htm" title="Category">Category</a></li>
            <li><a href="aboutmanagement.htm" title="About">About</a></li>
            
     