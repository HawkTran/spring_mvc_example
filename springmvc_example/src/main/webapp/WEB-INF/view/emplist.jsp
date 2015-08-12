<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
 <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<h1>Employee</h1>
			<td class="btn btn-default"><a href="insertEmp">Add New</a></td>
	<table class="table">
		<tr>
			<td>Id</td>
			<td>Name</td>
			<td>Age</td>
			<td>  </td>
			<td>  </td>
			
		</tr>
		<c:forEach var="i" items="${employeeList}" varStatus="status">
			<tr>
				<td>${i.id}</td>
				<td>${i.name}</td>
				<td>${i.age}</td>
				<td class="btn btn-default" ><a href="edit?id=${i.id }" >  Edit</a></td>
				
				<td class="btn btn-danger"><a href="del?id=${i.id}">Delete</a></td>
			</tr>
		</c:forEach>
		
		
	</table>
		
</body>
</html>