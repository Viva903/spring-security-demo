<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<html>

<head>

<title>My Home Page</title>

</head>

<body>
	<h2>My Home Page</h2>
	<hr>
	<p>Welcome to My Company Home Page !!</p>

	<hr>
	
	<!-- Display user name and role -->
	<p>
		User: <security:authentication property="principal.username"/>
		<br><br>
		Role(s) : <security:authentication property="principal.authorities"/>
	</p>
	
	<hr>
	
	<security:authorize access="hasRole('MANAGER')">
		<!-- Add a link to point to /leaders .. this is for the managers -->
		<p>
			<a href="${pageContext.request.contextPath}/leaders">LeaderShip Meeting</a>
			(Only for Manager peeps)
		</p>
	</security:authorize>
	

	<security:authorize access="hasRole('ADMIN')">
		<!-- Add a link to point to /systems .. this is for the admins -->
		<p>
			<a href="${pageContext.request.contextPath}/systems">IT Systems Meeting</a>
			(Only for Admin peeps)
		</p>
	</security:authorize>


	<!-- Display a log out button -->
	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">

		<input type="submit" value="Logout" />
	</form:form>


</body>

</html>