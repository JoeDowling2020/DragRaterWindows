<%--
  Created by IntelliJ IDEA.
  User: Fractal Man
  Date: 5/8/2021
  Time: 7:30 PM
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
<h1>Edit Your Profile!</h1>

<div class="center">
<form action="<%=request.getContextPath()%>/editProfile" method="post">
  <div class="form-group">
  <label for="firstName">First Name</label>
  <input id="firstName" name="firstName" type="text" placeholder="First Name" class="form-control">
  </div>
  <div class="form-group">
  <label for="lastName">Last Name</label>
  <input id="lastName" name="lastName" type="text" placeholder="Last Name" class="form-control">
  </div>
  <div class="form-group">
  <label for="username">User Name</label>
  <input id="username" name="username" type="text" placeholder="Username" class="form-control">
  </div>
  <div class="form-group">
  <label for="password">Password</label>
  <input id="password" name="password" type="password" placeholder="Password" class="form-control">
  </div>
  <div class="form-group">
  <label for="email">Email</label>
  <input id="email" name="email" type="text" placeholder="Email" class="form-control">
  </div>
  <div class="form-group">
  <button type="submit" class="btn btn-default">Change Profile</button>
  <button type="reset" class="btn btn-default">Clear Form</button>
  </div>
</form>
</div>
<c:out value="${footer}" escapeXml="false"/>
</body>
</html>
