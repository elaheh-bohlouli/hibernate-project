<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>New/Edit Category</title>
</head>
<body>
<div align="center">
    <h1>New/Edit Category</h1>
    <form:form action="saveCategory" method="post" modelAttribute="category">
        <table class="table table-striped table-bordered" border="2px" bgcolor= "#faebd7">
            <form:hidden path="id"/>
            <tr>
                <td>Name:</td>
                <td><form:input path="name" value="${category.name}"/></td>
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