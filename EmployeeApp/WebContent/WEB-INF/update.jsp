<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>update Employee Details</h1>
	<sf:form action="updateEmployee" method="post" modelAttribute="employee">
		<table>
			<tr>
				<td><sf:label path="id">Id</sf:label></td>
				<td><sf:input path="id" readonly="true" /></td>
				<td><sf:errors path="id" cssStyle="color:red"/></td>
			</tr>
			<tr>
				<td><sf:label path="name">Name</sf:label></td>
				<td><sf:input path="name" /></td>
				<td><sf:errors path="name" cssStyle="color:red"/></td>
			</tr>
			<tr>
				<td><sf:label path="gender">Gender</sf:label></td>
				<td><sf:radiobutton path="gender" label="Male" value="Male" /></td>
				<td><sf:radiobutton path="gender" label="Female" value="Female" /></td>
				<td><sf:errors path="gender" cssStyle="color:red"/></td>
			</tr>
			<tr>
				<td><sf:label path="age">Age</sf:label></td>
				<td><sf:input path="age" /></td>
				<td><sf:errors path="age" cssStyle="color:red"/></td>
			</tr>
			<tr>
				<td><sf:label path="salary">salary</sf:label></td>
				<td><sf:input path="salary" /></td>
				<td><sf:errors path="salary" cssStyle="color:red"/></td>
			</tr>
			<%-- <tr>
				<td><sf:select path="city">
						<sf:option value="">Select city</sf:option>
						<sf:option value="Bangalore">Bangalore</sf:option>
						<sf:option value="Chennai">Chennai</sf:option>
						<sf:option value="Mumbai">Mumbai</sf:option>
						<sf:option value="Pune">Pune</sf:option>

					</sf:select></td>
			</tr> --%>
		</table>
		<input type="submit" value="Update" />
	</sf:form>
</body>
</html>