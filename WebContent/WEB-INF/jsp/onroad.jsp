<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<html>
<head>
<meta http-equiv="refresh" content="10">
<link rel="Stylesheet" href="jquery/jquery-ui.css">
<link rel="Stylesheet" href="css/cabshare.css">
<script type="text/javascript" src="jquery/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="jquery/jquery-ui.js"></script>
<script type="text/javascript">
	
</script>
</head>
<body>
	<header>
		<jsp:include page="header.jsp"></jsp:include>
	</header>
	<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/cabshare" user="root" password="root" />

	<sql:query dataSource="${snapshot}" var="result">
SELECT * from userride where urid=1;
</sql:query>
	<div>
		<table border="1" width="30%">
			<tr>
				<th>User Name</th>
				<th>Source</th>
				<th>Destination</th>
				<th>Current Location</th>
				<th>Driver Name</th>
			</tr>
			<c:forEach var="row" items="${result.rows}">
				<tr>
					<td><c:out value="${row.username}" /></td>
					<td><c:out value="${row.source}" /></td>
					<td><c:out value="${row.destination}" /></td>
					<td><c:out value="${row.location}" /></td>
					<td><c:out value="${row.drivername}" /></td>
				</tr>
			</c:forEach>
		</table>
		<c:forEach var="row" items="${result.rows}">
			<c:if test="${row.destination==row.location}">
				<p>
					You have arrived at your destination!!!<br /> Your total fare is :
					<c:out value="${row.fare}" />
				<p>
			</c:if>
		</c:forEach>
	</div>
	<footer>
		<jsp:include page="footer.jsp"></jsp:include>
	</footer>
</body>
</html>