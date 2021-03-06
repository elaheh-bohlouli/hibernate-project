<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>New/Edit Employee</title>
</head>
<body>
<div align="center">
    <h1>New/Edit Employee</h1>
    <form:form action="saveEmployee" method="post" modelAttribute="employee">
        <table class="table table-striped table-bordered" border="2px" bgcolor= "#faebd7">
            <form:hidden path="id"/>
            <tr>
                <td>Name:</td>
                <td><form:input path="name" value="${employee.name}"/></td>
            </tr>
            <tr>
                <td>LastName:</td>
                <td><form:input path="lastName" value="${employee.lastName}"/></td>
            </tr>
            <tr>
                <td>LastName:</td>
                <td><form:input path="head" value="${employee.head}"/></td>
            </tr>
            <tr>
                <td>
                    <form:label path="categoryElement.name">CategoryElement Type:</form:label>
                </td>
                <td>
                    <form:select path="categoryElement.name" cssStyle="width: 150px;">
                        <option value="-1">Select a type</option>
                        <c:forEach items="${categoryElementList}" var="category">
                            <option value="${categoryElement.name}">${categoryElement.name}</option>
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