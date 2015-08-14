<!DOCTYPE html>
<html>
	<head>
		<link rel="Stylesheet" href="jquery/jquery-ui.css">
		<link rel="Stylesheet" href="css/cabshare.css">
		<script type="text/javascript" src="jquery/jquery-1.8.3.min.js"></script>
		<script type="text/javascript" src="jquery/jquery-ui.js"></script>
		<script type="text/javascript">
			var loginStatus = '$(loginStatus)';
			if(loginStatus!=null && !loginStatus){
					alert("Username and password mismatch!!!");
				}
		</script>
	</head>
	<body>
		<header>
			<jsp:include page="header.jsp" ></jsp:include>
		</header>
		<div>
			<form action="checkLogin.htm" method="post">
				Username: <input type="text" name="username" placeholder="Enter your Username"/><br/>
				Password: <input type="password" name="password" placeholder="********"/><br/>
				passenger<input type="radio" name="userType" value="0" checked="checked"/>&nbsp;&nbsp;
				driver<input type="radio" name="userType" value="1"/><br/>
				<input type="submit" value="LOGIN" />
			</form>
		</div>
		
		<footer>
			<jsp:include page="footer.jsp"></jsp:include>
		</footer>
	</body>
</html>