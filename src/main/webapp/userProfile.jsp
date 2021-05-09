<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Fractal Man
  Date: 5/7/2021
  Time: 2:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <th>Username</th>
    <th>First Name</th>
    <th>Last Name</th>
    <th>Email</th>

        <tr>
            <td><c:out value="${user.username}"/></td>
            <td><c:out value="${user.firstName}"/></td>
            <td><c:out value="${user.lastName}"/></td>
            <td><c:out value="${user.email}"/></td>
        </tr>

</table>

<table>
    <tr>
        <th>DragQueen Name</th>
        <th>User Score</th>
    </tr>

    <c:forEach var="queen" items="${queen}">

        <tr>
            <td>${queen.key}</td>
            <td>${queen.value}</td>

        </tr>
    </c:forEach>

</table>

<a href="editProfile">Edit Your Profile</a>

</body>
</html>
