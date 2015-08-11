<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Employee</title>
</head>
<body>

	<center>
		<form:form method="post" action="/mavenmvc/update"
			modelAttribute="emp">
			<form:hidden path="id"/>
			<form:input path="name"/>
			<form:input path="age"/>
			<input type = "submit" value = "SAVE" />
		</form:form>
	</center>
</body>
</html>