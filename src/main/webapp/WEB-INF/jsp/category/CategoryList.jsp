<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Category Management Screen</title>
</head>
<body>
	<div align="center">
		<h1>Category List</h1>
		
		<table class="table table-striped table-bordered" border="2px" bgcolor= "#faebd7">

			<th>Name</th>
			<th>CreateDataTime</th>
			<th>LastModifiedDataTime</th>
			<th>Active</th>
			<th>ManualId</th>
			<th>Action</th>

			<c:forEach var="category" items="${listCategory}">
				<tr>

					<td>${category.name}</td>
					<td>${category.createDataTime}</td>
					<td>${category.lastModifiedDataTime}</td>
					<td>${category.active}</td>
					<td>${category.manualId}</td>
					<td><a href="editCategory?id=${category.id}">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="deleteCategory?id=${category.id}">Delete</a></td>

				</tr>
			</c:forEach>
		</table>
		<h4>
			New Category Register <a href="/newCategory">here</a>
		</h4>


	<br><br><br>

	<a href="/home">Go To The Home Page...</a>
	</div>
</body>
</html>