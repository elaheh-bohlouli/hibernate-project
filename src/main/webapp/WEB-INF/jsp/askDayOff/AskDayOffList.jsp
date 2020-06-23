<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>AskDayOff Management Screen</title>
</head>
<body>
	<div align="center">
		<h1>AskDayOff List</h1>
		
		<table class="table table-striped table-bordered" border="2px" bgcolor= "#faebd7">

			<th>BeginDate</th>
			<th>EndDate</th>
			<th>Status</th>
			<th>Employee</th>
			<th>CreateDataTime</th>
			<th>LastModifiedDataTime</th>
			<th>Active</th>
			<th>ManualId</th>
			<th>Action</th>

			<c:forEach var="askDayOff" items="${listAskDayOff}">
				<tr>

					<td>${askDayOff.beginDate}</td>
					<td>${askDayOff.endDate}</td>
					<td>${askDayOff.status}</td>
					<td>${askDayOff.employee}</td>
					<td>${askDayOff.createDataTime}</td>
					<td>${askDayOff.lastModifiedDataTime}</td>
					<td>${askDayOff.active}</td>
					<td>${askDayOff.manualId}</td>
					<td><a href="editAskDayOff?id=${askDayOff.id}">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="deleteAskDayOff?id=${askDayOff.id}">Delete</a></td>

				</tr>
			</c:forEach>
		</table>
		<h4>
			New AskDayOff Register <a href="/newAskDayOff">here</a>
		</h4>


	<br><br><br>

	<a href="/home">Go To The Home Page...</a>
	</div>
</body>
</html>