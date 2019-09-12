<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Add Customer Detail</h1>
	<sf:form method="post" action="add" modelAttribute="customer">
		<table>
			<tr>
				<td><sf:label path="id">Customer id </sf:label></td>
				<td><sf:input path="id" /></td>
				<td><sf:errors path="id" cssStyle="color:red"></sf:errors></td>

			</tr>
			<tr>
				<td><sf:label path="name">Customer Name </sf:label></td>
				<td><sf:input path="name" /></td>
				<td><sf:errors path="name" cssStyle="color:red"></sf:errors></td>


			</tr>
			<tr>
				<td><sf:label path="gender">Customer gender </sf:label></td>
				<td><sf:input path="gender" /></td>
				<td><sf:errors path="gender" cssStyle="color:red"></sf:errors></td>


			</tr>
			<tr>
				<td><sf:label path="type">Customer type </sf:label></td>
				<td><sf:input path="type" /></td>
				<td><sf:errors path="type" cssStyle="color:red"></sf:errors></td>


			</tr>
			<tr>
				<td><sf:label path="rating">Customer rating </sf:label></td>
				<td><sf:input path="rating" /></td>
				<td><sf:errors path="rating" cssStyle="color:red"></sf:errors></td>


			</tr>
			<tr>
				<td><sf:label path="mobile">Customer mobile </sf:label></td>
				<td><sf:input path="mobile" /></td>
				<td><sf:errors path="mobile" cssStyle="color:red"></sf:errors></td>


			</tr>
		</table>
		<input type="submit" value="Add" />

	</sf:form>
</body>
</html>