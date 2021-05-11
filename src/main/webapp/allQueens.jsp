<%--
  Created by IntelliJ IDEA.
  User: Fractal Man
  Date: 5/1/2021
  Time: 4:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import var="head" url="Includes/head.jsp"/>
<c:out value="${head}" escapeXml="false"/>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:import var="nav" url="Includes/nav.jsp"/>
<%--<c:import var="footer" url="Includes/footer.jsp"/>--%>
<!DOCTYPE html>
<html>

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
<h1>Drag Queens</h1>

<table id="resultTable" class="display" width="90%">
    <thead>
    <tr>
        <th>Mug Shot</th>
        <th>Drag Queen</th>
        <th>Rate Me!</th>
        <th>Dusted or Busted Score</th>
        <th>Drag Rater Score</th>
    </tr>
    </thead>
    <tbody>
    <c:set var="count" value="0" scope="page" />
    <c:forEach var="dragQueens" items="${dragQueens}" varStatus="status">
        <c:set var="count" value="${count + 1}" scope="page"/>
    <tr>

        <td><img src="${dragQueens.getImageUrl()}"  width="250" height="300"></td>
        <td>${dragQueens.getName()}</td>
        <td><a href="submitRating?action=add&dragQueenId=${dragQueens.getId()}">Rate Me</a></td>
        <td>${dobScore[status.index].getDobScore()}</td>
        <td><a href="viewDragRating?action=add&dragQueenId=${dragQueens.getId()}">View Your DragRater Score</a></td>
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