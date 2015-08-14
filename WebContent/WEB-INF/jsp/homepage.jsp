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
			<form action="takearide.htm" method="post">
				Source: <input type="text" name="source"
					placeholder="Enter Pickup location" /><br /> Destination: <input
					type="text" name="destination" placeholder="Enter Destination" /><br />
				<input type="radio" name="ride" value="1" checked> Join a Ride <br>
				<input type="radio" name="ride" value="2"> Take a Ride<br/>
				<input type="submit" value="submit"/>
			</form>
		</div>
		<footer>
			<jsp:include page="footer.jsp"></jsp:include>
		</footer>
	</body>
</html>