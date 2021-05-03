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
        <th>Drag Queen</th>
        <th>Mug Shot</th>
    </tr>
    <c:forEach var="dragQueens" items="${dragQueens}">
    <tr>
        <td>${dragQueens.getName()}</td>
        <td><img src="${dragQueens.getImageUrl()}"  width="500" height="600"></td>
    </tr>
    </c:forEach>
</table>
</body>
</html>