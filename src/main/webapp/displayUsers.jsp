<%--
  Created by IntelliJ IDEA.
  User: Fractal Man
  Date: 5/5/2021
  Time: 4:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table>
    <th>Username</th>
    <th>First Name</th>
    <th>Last Name</th>
    <c:forEach var="users" items="${users}">
        <tr>
            <td>${users.username}</td>
            <td>${users.firstName}</td>
            <td>${users.lastName}</td>
        </tr>
    </c:forEach>
</table>


</body>
</html>
