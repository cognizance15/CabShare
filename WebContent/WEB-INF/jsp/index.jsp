<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<link rel="Stylesheet" href="jquery/jquery-ui.css">
		<link rel="Stylesheet" href="css/cabshare.css">
		<script type="text/javascript" src="jquery/jquery-1.8.3.min.js"></script>
		<script type="text/javascript" src="jquery/jquery-ui.js"></script>
		<script type="text/javascript">
		
		</script> 
	</head>
<body>
	<header>
		<jsp:include page="header.jsp" ></jsp:include>
	</header>
	<div class="buttons">
		<!-- <input type="button" value="Register" name="register" onclick="register.htm"/>
		<input type="button" value="LogIn" name="login" onclick="login.htm"/><br/> -->
		<a href="register.htm">Register</a> &nbsp; &nbsp; &nbsp;
		<a href="login.htm">LogIn</a>
	</div>
	<footer>
		<jsp:include page="footer.jsp"></jsp:include>
	</footer>
</body>
</html>