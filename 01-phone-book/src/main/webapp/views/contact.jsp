<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contact Form</title>

<p>
	<font color="green">${successMsg}</font>
</p>
<p>
	<font color="red">${failedMsg}</font>
</p>

</head>
<body>
	<table>
		<f:form action="saveContact" modelAttribute="contact" method="post">
			<tr>
				<td>Name :</td>
				<td><f:input path="name" type="text" />
			</tr>
			<tr>
				<td>Mobile Number :</td>
				<td><f:input path="number" type="text" />
			</tr>
			<tr>
				<td>Email :</td>
				<td><f:input path="email" type="text" />
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="save" /></td>
			</tr>
		</f:form>
	</table>
</body>
</html>