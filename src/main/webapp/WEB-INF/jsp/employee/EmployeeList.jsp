<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee Management Screen</title>
</head>
<body>
	<div align="center">
		<h1>Employee List</h1>
		
		<table class="table table-striped table-bordered" border="2px" bgcolor= "#faebd7">

			<th>Name</th>
			<th>LastName</th>
			<th>Head</th>
			<th>CategoryElement</th>
			<th>CreateDataTime</th>
			<th>LastModifiedDataTime</th>
			<th>Active</th>
			<th>ManualId</th>
			<th>Action</th>

			<c:forEach var="employee" items="${listEmployee}">
				<tr>

					<td>${employee.name}</td>
					<td>${employee.lastName}</td>
					<td>${employee.head}</td>
					<td>${employee.categoryElement}</td>
					<td>${employee.createDataTime}</td>
					<td>${employee.lastModifiedDataTime}</td>
					<td>${employee.active}</td>
					<td>${employee.manualId}</td>
					<td><a href="editEmployee?id=${employee.id}">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="deleteEmployee?id=${employee.id}">Delete</a></td>

				</tr>
			</c:forEach>
		</table>
		<h4>
			New Employee Register <a href="/newEmployee">here</a>
		</h4>


	<br><br><br>

	<a href="/home">Go To The Home Page...</a>
	</div>
</body>
</html>