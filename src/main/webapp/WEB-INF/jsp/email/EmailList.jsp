<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Email Management Screen</title>
</head>
<body>
	<div align="center">
		<h1>Email List</h1>
		
		<table class="table table-striped table-bordered" border="2px" bgcolor= "#faebd7">

			<th>Text</th>
			<th>CategoryElement</th>
			<th>CreateDataTime</th>
			<th>LastModifiedDataTime</th>
			<th>Active</th>
			<th>ManualId</th>
			<th>Action</th>

			<c:forEach var="email" items="${listEmail}">
				<tr>

					<td>${email.text}</td>
					<td>${email.categoryElement}</td>
					<td>${email.createDataTime}</td>
					<td>${email.lastModifiedDataTime}</td>
					<td>${email.active}</td>
					<td>${email.manualId}</td>
					<td><a href="editEmail?id=${email.id}">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="deleteEmail?id=${email.id}">Delete</a></td>

				</tr>
			</c:forEach>
		</table>
		<h4>
			New Email Register <a href="/newEmail">here</a>
		</h4>


	<br><br><br>

	<a href="/home">Go To The Home Page...</a>
	</div>
</body>
</html>