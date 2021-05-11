<%--
  Created by IntelliJ IDEA.
  User: Fractal Man
  Date: 5/10/2021
  Time: 3:59 PM
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
<table>
    <tr>
        <th>Mug Shot</th>
        <th>Drag Queen</th>
        <th>Quote</th>
        <th>D.O.B. Score</th>
        <th>DragRater Score</th>
    </tr>
    <tr>
        <td><img src="${dragQueen.getImageUrl()}"  width="250" height="300"></td>
        <td><c:out value="${dragQueen.getName()}"/></td>
        <td><c:out value="${dragQueen.getQuote()}"/></td>
        <td>${dobScore}</td>
        <td><c:out value="${score}"/></td>
    </tr>

</table>
</div>
</body>
</html>