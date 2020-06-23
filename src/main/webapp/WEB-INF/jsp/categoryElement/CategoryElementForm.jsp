<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>New/Edit CategoryElement</title>
</head>
<body>
<div align="center">
    <h1>New/Edit CategoryElement</h1>
    <form:form action="saveCategoryElement" method="post" modelAttribute="categoryElement">
        <table class="table table-striped table-bordered" border="2px" bgcolor= "#faebd7">
            <form:hidden path="id"/>
            <tr>
                <td>Role:</td>
                <td><form:input path="role" value="${categoryElement.role}"/></td>
            </tr>
            <tr>
                <td>Name:</td>
                <td><form:input path="name" value="${categoryElement.name}"/></td>
            </tr>
            <tr>
                <td>
                    <form:label path="category.name">Category Type:</form:label>
                </td>
                <td>
                    <form:select path="category.name" cssStyle="width: 150px;">
                        <option value="-1">Select a type</option>
                        <c:forEach items="${categoryList}" var="category">
                            <option value="${category.name}">${category.name}</option>
                        </c:forEach>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save"></td>
            </tr>
        </table>
    </form:form>


<br><br><br>

<a href="/home">Go To The Home Page...</a>
</div>
</body>
</html>