<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h3>
		<font color="green">${successMsg }</font>
	</h3>
	<h3>
		<font color="red">${failedMsg}</font>
	</h3>

	<table>
		<form:form action="savePhone?id=${phoneBook.id}" modelAttribute="phoneBook" method="post">
			<tr>
				<td>Name ::</td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td>email ::</td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td>mobile ::</td>
				<td><form:input path="mobile" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="save"></td>
			</tr>
	</table>

	</form:form>
	
	<a href="allContacts">All Contacts</a>
</body>
</html>