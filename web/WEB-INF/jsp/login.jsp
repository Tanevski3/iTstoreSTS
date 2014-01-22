<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html lang="en">
<head>
	<meta charset="utf-8">
	<title>SimpleAdmin - Login to CMS</title>
	
	<!-- Stylesheets -->
	<link href='http://fonts.googleapis.com/css?family=Droid+Sans:400,700' rel='stylesheet'>
	<link rel="stylesheet" href="<c:url value="/resources/css/adminstyle.css"/>" >

	<!-- Optimize for mobile devices -->
	<meta name="viewport" content="width=device-width, initial-scale=1.0"/>  
</head>
<body>

	<!-- TOP BAR -->
	<div id="top-bar">
		
		<div class="page-full-width">
		
			<a href="home.htm" class="round button dark ic-left-arrow image-left ">Return to website</a>

		</div> <!-- end full-width -->	
	
	</div> <!-- end top-bar -->
	
	
	
	<!-- HEADER -->
	<div id="header">
		
		<div class="page-full-width cf">
	
			<div id="login-intro" class="fl">
			
				<h1>Login to CMS</h1>
				<h5>Enter your credentials below</h5>
			
			</div> <!-- login-intro -->
			
			<!-- Change this image to your own company's logo -->
			<!-- The logo will automatically be resized to 39px height. -->
			
		</div> <!-- end full-width -->	

	</div> <!-- end header -->
	
	
	
	<!-- MAIN CONTENT -->
	<div id="content">
	
		<form action="item.htm" method="POST" id="login-form">
		
			<fieldset>

				<p>
					<label for="login-username">username</label>
					<input type="text" id="login-username" class="round full-width-input" name="username" maxlength="15" type="text" required="required"   autofocus />
				</p>

				<p>
					<label for="login-password">password</label>
					<input type="password" id="login-password" class="round full-width-input"  name="password"  maxlength="15" type="password" required="required"/>
				</p>
				
				<input type="submit" value="LOGIN" class="button round blue image-right ic-right-arrow">

			</fieldset>

			<br/><div class="information-box round"><p>${validationLabel}</p></div>

		</form>
		
	</div> <!-- end content -->
	
	
	
	<!-- FOOTER -->
	<div id="footer">

		<p>&copy; Copyright 2012 <a href="#">Electronix, LLC</a>. All rights reserved.</p>
		<p><strong>SimpleAdmin</strong> theme by <a href="http://www.adipurdila.com">Adi Purdila</a></p>
	
	</div> <!-- end footer -->

</body>
</html>