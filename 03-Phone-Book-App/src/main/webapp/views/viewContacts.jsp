<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="j"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script>
	function deleteConfirm() {
		return confirm("Are Your Sure, You want to delete recored ?");
	}
</script>
</head>
<body>

	<h3>
		<font color="green">${success}</font>
	</h3>
	<h3>
		<font color="red">${failed}</font>
	</h3>

	<a href="/">+Add New Contact</a>
	<br>
	<br>
	<br>
	<table border="1">
		<thead>
			<th>Name</th>
			<th>email</th>
			<th>Mobile</th>
			<th>Action</th>
		</thead>
		<tbody>
			<j:forEach items="${allPhoneBook }" var="pb">
				<tr>
					<td>${pb.name }</td>
					<td>${pb.email }</td>
					<td>${pb.mobile }</td>
					<td><a href="update?id=${pb.id}"> Edit</a> |<a
						href="delete?id=${pb.id}" onclick="return deleteConfirm()">
							Delete </a></td>
				</tr>
			</j:forEach>
		</tbody>

	</table>
	<j:if test="${currentPage>1 }">
		<a href="allContacts?pageNo=${currentPage-1 }">Prev</a>
	</j:if>
	<j:forEach begin="1" end="${tp}" var="pageNo">
		<a href="allContacts?pageNo=${pageNo }">${pageNo}</a>
	</j:forEach>
	<j:if test="${currentPage<tp }">
		<a href="allContacts?pageNo=${currentPage+1 }">Next</a>
	</j:if>
</body>
</html>