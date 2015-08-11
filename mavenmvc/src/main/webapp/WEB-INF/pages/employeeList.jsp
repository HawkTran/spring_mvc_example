<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h1>List</h1>
	<table border="1">
		<tr>
			<td>Id</td>
			<td>Full Name</td>
			<td>Age</td>
			<td>Edit</td>
			<td>Delete</td>
			
		</tr>
		<c:forEach var="i" items="${employeeList}" varStatus="status">
			<tr>
				<td>${i.id}</td>
				<td>${i.name}</td>
				<td>${i.age}</td>
				<td><a href="edit?id=${i.id }" >Edit</a></td>
				<td><a href="delete?id=${i.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
		
</body>
</html>