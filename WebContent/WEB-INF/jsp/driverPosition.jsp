<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
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
		<div id="driverPosition">
			<form action="changeStop.htm" method="post">
				<input type="text" name= "position" value=${position } readonly="readonly"/><br/>
				<input type="submit" name="nextStop" value="NEXT STOP"/>
			</form>
		</div> 

		<footer>
			<jsp:include page="footer.jsp"></jsp:include>
		</footer>
	</body>
</html>

