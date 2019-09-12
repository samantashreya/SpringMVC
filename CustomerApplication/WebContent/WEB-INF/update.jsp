<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <h1>Add Customer Details</h1>
    <sf:form action="updateCustomer" method="post"
        modelAttribute="customer">
        <table>
            <tr>
                <td><sf:label path="id">Customer Id</sf:label>
                <td><sf:input path="id" readonly="true" /></td>
                <td><sf:errors path="id" cssStyle="color:red"></sf:errors></td>
            </tr>

 

 

            <tr>
                <td><sf:label path="name">Name</sf:label>
                <td><sf:input path="name" /></td>
                <td><sf:errors path="name" cssStyle="color:red"></sf:errors></td>
            </tr>

 

 

            <tr>
                <td><sf:label path="gender">Gender</sf:label>
                <td><sf:radiobutton path="gender" label="Male" value="Male" />
                    <sf:radiobutton path="gender" label="Female" value="Female" /></td>
                <td><sf:errors path="gender" cssStyle="color:red"></sf:errors></td>
            </tr>

 

 

            <tr>
                <td><sf:label path="type">Type</sf:label>
                <td><sf:input path="type" /></td>
                <td><sf:errors path="type" cssStyle="color:red"></sf:errors></td>
            </tr>

 

 

            <tr>
                <td><sf:label path="rating">Rating</sf:label>
                <td><sf:input path="rating" /></td>
                <td><sf:errors path="rating" cssStyle="color:red"></sf:errors></td>
            </tr>
            <tr>
                <td><sf:label path="mobile">Mobile No</sf:label>
                <td><sf:input path="mobile" readonly="true" /></td>
                <td><sf:errors path="mobile" cssStyle="color:red"></sf:errors></td>
            </tr>

 


        </table>
        <input type="submit" value="update" />
    </sf:form>
</body>
</html>