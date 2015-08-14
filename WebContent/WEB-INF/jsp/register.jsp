<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
		<div>
			<c:if test="${usernameNotUnique == false }">
				<p>* username is already taken</p>
			</c:if>
			
			<form action="save.htm" method="post">
				UserName: <input type="text" name="username" /><br/>
				Email: <input type="email" name="email" /><br/>
				password: <input type="password" name="password"/><br/>
				passenger<input type="radio" name="userType" value="0" checked="checked"/>&nbsp;&nbsp;
				driver<input type="radio" name="userType" value="1"/><br/>
				<input type="submit" value="Register"/><br/>
			</form>	
		</div>
		
		<footer>
			<jsp:include page="footer.jsp"></jsp:include>
		</footer>
	</body>
</html>