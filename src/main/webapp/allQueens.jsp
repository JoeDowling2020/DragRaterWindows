<%--
  Created by IntelliJ IDEA.
  User: Fractal Man
  Date: 5/1/2021
  Time: 4:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Drag Queens</title>
</head>
<body>
<h1>Drag Queens</h1>
<table>
    <tr>

        <th>Mug Shot</th>
        <th>Drag Queen</th>
        <th>Dusted or Busted Score</th>
        <th>Drag ID</th>
    </tr>
    <c:set var="count" value="0" scope="page" />
    <c:forEach var="dragQueens" items="${dragQueens}" varStatus="status">
        <c:set var="count" value="${count + 1}" scope="page"/>
    <tr>

        <td><img src="${dragQueens.getImageUrl()}"  width="250" height="300"></td>
        <td>${dragQueens.getName()}</td>
        <td>${dobScore[status.index].getDobScore()}</td>
<%--       <td><a href="submitRating?dragId=${dragQueens[status.index].getId()}">Rate Me!</a></td>--%>
    </tr>
    </c:forEach>

</table>
</body>
</html>