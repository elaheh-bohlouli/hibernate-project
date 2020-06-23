<%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 5/29/2020
  Time: 7:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <style>
        <%@include file="home.css" %>
    </style>
    <jsp:include page="header_img.jpg"></jsp:include>
    <link rel="stylesheet" type="text/css" href="home.css"/>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
    <script src="js/bootstrap.min.js"></script>
    <script src="jquery-ui-1.12.0/jquery-ui-1.12.0/external/jquery/jquery.js"></script>

</head>
<body>
<div id="main">
    <div id="header"><h1> Hibernate Project HomePage </h1></div>
    <br/>
    <br/>
    <br/>
    <div id="sidebar">
        <div id="menu-box">
            <div class="top-toolbar">Menu</div>
            <div class="bottom-toolbar">
                <label for="category">Choose From Category Actions: </label>
                <select name="Category" id="Category"
                        onchange='window.location = this.options[this.selectedIndex].getAttribute("value")'>
                    <option value="home">CategoryAction</option>
                    <option value="/categoryList">List</option>
                    <option value="/newCategory">New</option>
                </select></div>

            <div class="bottom-toolbar">
                <label for="categoryElement">Choose From CategoryElements Actions: </label>
                <select name="CategoryElement" id="categoryElement"
                        onchange='window.location = this.options[this.selectedIndex].getAttribute("value")'>
                    <option value="home">CategoryElementsAction</option>
                    <option value="/categoryElementList">List</option>
                    <option value="/newCategoryElement">New</option>
                </select></div>

            <div class="bottom-toolbar">
                <label for="employee">Choose From Employee Actions: </label>
                <select name="Employee" id="employee"
                        onchange='window.location = this.options[this.selectedIndex].getAttribute("value")'>
                    <option value="home">EmployeeAction</option>
                    <option value="/employeeList">List</option>
                    <option value="/newEmployee">New</option>
                </select></div>

            <div class="bottom-toolbar">
                <label for="email">Choose From Email Actions: </label>
                <select name="Email" id="email"
                        onchange='window.location = this.options[this.selectedIndex].getAttribute("value")'>
                    <option value="home">EmailAction</option>
                    <option value="/categoryList">List</option>
                    <option value="/newCategory">New</option>
                </select></div>

            <div class="bottom-toolbar">
                <label for="askDayOff">Choose From AskDayOff Actions: </label>
                <select name="AskDayOff" id="askDayOff"
                        onchange='window.location = this.options[this.selectedIndex].getAttribute("value")'>
                    <option value="home">AskDayOffAction</option>
                    <option value="/askDayOff/lis">List</option>
                    <option value="/askDayOff/new">new</option>
                </select></div>

        </div>
    </div>
    <div id="left">FOR FUTURE MODIFICATION</div>
    <div class="clear"></div>
    <br/>
    <br/>
    <br/>
    <div id="footer" align="center"><h3>created by Elaheh</h3></div>
</div>
</body>
</html>
