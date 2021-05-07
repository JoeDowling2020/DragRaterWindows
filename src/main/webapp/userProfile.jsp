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
    <c:forEach var="user" items="${user}">
        <tr>
            <td>${user.username}</td>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>${user.email}</td>
        </tr>
    </c:forEach>
</table>

<table>
    <tr>
        <th>DragQueen ID</th>
        <th>DragQueen Name</th>
        <th>Humour</th>
        <th>Makeup</th>
        <th>Hair</th>
        <th>Fashion</th>
        <th>Personality</th>
        <th>Dancing</th>
        <th>Acting</th>
        <th>Lipsync</th>
        <th>Impersonation</th>
        <th>Lyrics</th>
        <th>Brand</th>
    </tr>
    <c:set var="count" value="0" scope="page" />
    <c:forEach var="ratings" items="${rating}">
        <c:set var="count" value="${count + 1}" scope="page"/>
        <tr>

            <td>${rating.dragqueenId}</td>
            <td>${queen[status.index].queenName}</td>
            <td>${rating.humour}</td>
            <td>${rating.makeup}</td>
            <td>${rating.hair}</td>
            <td>${rating.fashion}</td>
            <td>${rating.personality}</td>
            <td>${rating.dancing}</td>
            <td>${rating.acting}</td>
            <td>${rating.lipsync}</td>
            <td>${rating.impersonation}</td>
            <td>${rating.lyrics}</td>
            <td>${rating.brand}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
