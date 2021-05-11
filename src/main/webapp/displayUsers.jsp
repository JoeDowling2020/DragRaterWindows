<%--
  Created by IntelliJ IDEA.
  User: Fractal Man
  Date: 5/5/2021
  Time: 4:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import var="head" url="Includes/head.jsp"/>
<c:out value="${head}" escapeXml="false"/>
<html>
<c:import var="nav" url="Includes/nav.jsp"/>
<c:import var="footer" url="Includes/footer.jsp"/>
<c:import var="header" url="Includes/header.jsp"/>

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

<table  id="resultTable" class="display" width="90%">
    <thead>
    <tr>
    <th>Username</th>
    <th>First Name</th>
    <th>Last Name</th>
    <th>Remove User</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="users" items="${users}">
        <tr>
            <td>${users.username}</td>
            <td>${users.firstName}</td>
            <td>${users.lastName}</td>
            <td><a href="removeUser?action=remove&userId=${users.id}">Remove</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<c:out value="${footer}" escapeXml="false"/>
</body>
</html>

<script type="text/javascript" class="init">
    $(document).ready(function () {
        $('#resultTable').DataTable();
    });
</script>
