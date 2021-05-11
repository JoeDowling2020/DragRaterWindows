<%--
  Created by IntelliJ IDEA.
  User: Fractal Man
  Date: 5/6/2021
  Time: 5:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<c:import var="head" url="Includes/head.jsp"/>
<c:import var="nav" url="Includes/nav.jsp"/>
<c:import var="footer" url="Includes/footer.jsp"/>
<c:import var="header" url="Includes/header.jsp"/>
<c:out value="${head}" escapeXml="false"/>

<body>
<c:out value="${nav}" escapeXml="false"/>
<header class="masthead text-center text-white">
    <div class="masthead-content">
    </div>
    <div class="bg-circle-1 bg-circle"></div>
    <div class="bg-circle-2 bg-circle"></div>
    <div class="bg-circle-3 bg-circle"></div>
    <div class="bg-circle-4 bg-circle"></div>
</header>
<div class="center">
<h1>Add a New Queen!</h1>

<form action="addNewQueen" method="POST">
    <div class="form-group">
    <label for="dragQueenId"></label>
    <input name="dragQueenId" id="dragQueenId" type="text" placeholder="Drag Queen ID" required class="form-control">
    </div>
    <div class="form-group">
    <label for="name"></label>
    <input name="name" id="name" type="text" placeholder="Drag Queen's Full Name" required class="form-control">
    </div>
    <div class="form-group">
    <label for="dobScore"></label>
    <input name="dobScore" id="dobScore" type="text" placeholder="The Queen's DOB score" required class="form-control">
    </div>
    <div class="form-group">
    <button type="submit" class="btn btn-default">Add Queen</button>
    <button type="reset" class="btn btn-default">Clear Form</button>
    </div>
</form>
</div>
<c:out value="${footer}" escapeXml="false"/>
</body>
</html>
