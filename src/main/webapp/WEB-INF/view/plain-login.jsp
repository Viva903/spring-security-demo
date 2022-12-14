<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="z" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>
	<title>Custom Login Page</title>
	
	<link rel="stylesheet" type="text/css" href="css/style.css">
	
</head>

<body>

	<h3>My Custom Login Page</h3>

	<form:form
		action="${pageContext.request.contextPath}/authenticateTheUser"
		method="POST">

		<z:if test="${param.error != null}">
			<i class="failed">Sorry! You entered invalid username/password.</i>
		</z:if>

		<p>
			User name : <input type="text" name="username" />
		</p>
		<p>
			Password: <input type="password" name="password" />
		</p>
		<input type="submit" value="Login" />
	</form:form>

</body>


</html>