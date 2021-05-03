<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 3/7/21
  Time: 3:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home Page</title>
</head>
<body>
<h1>Home Page</h1>
<a href="admin.jsp">Admin Page</a>
<a href="allQueens">Drag Queens</a>
<p>Hello World!</p>

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