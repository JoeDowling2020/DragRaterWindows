<%--
  Created by IntelliJ IDEA.
  User: Fractal Man
  Date: 5/6/2021
  Time: 3:18 PM
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
<h1>Sign Up For a DragRater Account</h1>

<div class="center">
<form action="<%=request.getContextPath()%>/signUp" method="post">
    <div class="form-group">
    <label for="firstName">First Name</label>
    <input id="firstName" name="firstName" type="text" placeholder="First Name" required class="form-control">
    </div>
    <div class="form-group">
    <label for="lastName">Last Name</label>
    <input id="lastName" name="lastName" type="text" placeholder="Last Name" required class="form-control">
    </div>
    <div class="form-group">
    <label for="username">User Name</label>
    <input id="username" name="username" type="text" placeholder="Username" required class="form-control">
    </div>
    <div class="form-group">
    <label for="password">Password</label>
    <input id="password" name="password" type="password" placeholder="Password" required class="form-control">
    </div>
    <div class="form-group">
    <label for="email">Email</label>
    <input id="email" name="email" type="text" placeholder="Email" required class="form-control">
    </div>
    <div class="form-group">
    <button type="submit" class="btn btn-default">Sign Up!</button>
    <button type="reset" class="btn btn-default">Clear Form</button>
    </div>
</form>
</div>

<a href="login">All ready signed up? Log in here!</a>
<c:out value="${footer}" escapeXml="false"/>
</body>
</html>
