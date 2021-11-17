<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update User Details</title>
</head>
<body>
	<form action="update" method="post">
	<input type="hidden" name="userId" value="${user.userId}"></input>
		UserName: <input type="text" name="userName" value="${user.userName}"></input>
		<br /> <br /> City: <input type="text" name="city" value="${user.city}"></input> <br />
		<br /> Country:<input type="text" name="country" value="${user.country}"></input> <br />
		<br /> <input type="submit" value="Update"></input>
	</form>
	<br/>
<br/>
</body>
</html>