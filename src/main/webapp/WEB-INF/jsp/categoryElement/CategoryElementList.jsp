<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>CategoryElement Management Screen</title>
</head>
<body>
<div align="center">
    <h1>CategoryElement List</h1>

    <table class="table table-striped table-bordered" border="2px" bgcolor="#faebd7">

        <th>Role</th>
        <th>Name</th>
        <th>Category</th>
        <th>CreateDataTime</th>
        <th>LastModifiedDataTime</th>
        <th>Active</th>
        <th>ManualId</th>
        <th>Action</th>

        <c:forEach var="categoryElement" items="${listCategoryElement}">
            <tr>

                <td>${categoryElement.role}</td>
                <td>${categoryElement.name}</td>
                <td>${categoryElement.category.name}</td>
                <td>${categoryElement.createDataTime}</td>
                <td>${categoryElement.lastModifiedDataTime}</td>
                <td>${categoryElement.active}</td>
                <td>${categoryElement.manualId}</td>
                <td><a href="editCategoryElement?id=${categoryElement.id}">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp; <a
                            href="deleteCategoryElement?id=${categoryElement.id}">Delete</a></td>

            </tr>
        </c:forEach>
    </table>
    <h4>
        New CategoryElement Register <a href="/newCategoryElement">here</a>
    </h4>


<br><br><br>

<a href="/home">Go To The Home Page...</a>
</div>
</body>
</html>