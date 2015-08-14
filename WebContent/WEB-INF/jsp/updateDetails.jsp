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
		<div>
			<form action="updateDetails.htm" method="post">
			Name:<input type="text" name="name" /><br/>
			age:<input type="text" name="age"/><br/>
			gender:<input type="text" name="gender"/><br/>
			mobile:<input type="text" name="mobile"/><br/>
			<input type="submit" value="Save"/><br/>
		</form>	
		</div>
		
		<footer>
			<jsp:include page="footer.jsp"></jsp:include>
		</footer>
	</body>
</html>