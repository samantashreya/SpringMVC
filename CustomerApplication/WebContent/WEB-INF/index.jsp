<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Customer details</h1>
	<form action="addCustomer">
		<input type="submit" value="Add Customer"/>
	</form>
	<table border="1">
		<tr>
			<th>Customer Id</th>
			<th>Customer Name</th>
			<th>Customer Gender</th>
			<th>Customer Type</th>
			<th>Customer Rating</th>
			<th>Customer MobileNumber</th>
			<th>Action</th>
		</tr>
		<c:forEach var="cust" items="${customers}">
			<tr>
				<td>${cust.id}</td>
				<td>${cust.name}</td>
				<td>${cust.gender}</td>
				<td>${cust.type}</td>
				<td>${cust.rating}</td>
				<td>${cust.mobile}</td>
				<td>
				<a href="delete?id=${cust.id}">Delete</a>&nbsp;&nbsp;
				<a href="update?id=${cust.id}">Update</a>

			</tr>
		</c:forEach>
	</table>
</body>
</html>