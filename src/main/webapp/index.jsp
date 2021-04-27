<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<c:import var="nav" url="components/nav.jsp" />
<body>

<h2>Home Page</h2>
<header>
    <c:out value="${nav}" escapeXml="false"/>
</header>
<a href="admin.jsp">Click Here To Access Admin Page</a>

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