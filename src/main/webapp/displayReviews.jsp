<%--
  Created by IntelliJ IDEA.
  User: Fractal Man
  Date: 5/9/2021
  Time: 4:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:import var="head" url="Includes/head.jsp"/>
<c:out value="${head}" escapeXml="false"/>
<html>
<c:import var="nav" url="Includes/nav.jsp"/>
<c:import var="footer" url="Includes/footer.jsp"/>


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

<table id="resultTable" class="display" width="70%">
    <thead>
        <tr>
            <th>Review ID</th>
            <th>User ID</th>
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
            <th>Raw Review</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach items="${ratings}" var="rating">
        <tr>
            <td>${rating.reviewId.toString()}</td>
            <td>${rating.user.id.toString()}</td>
            <td>${rating.humour.toString()}</td>
            <td>${rating.makeup.toString()}</td>
            <td>${rating.hair.toString()}</td>
            <td>${rating.fashion.toString()}</td>
            <td>${rating.personality.toString()}</td>
            <td>${rating.dancing.toString()}</td>
            <td>${rating.acting.toString()}</td>
            <td>${rating.lipsync.toString()}</td>
            <td>${rating.impersonation.toString()}</td>
            <td>${rating.lyrics.toString()}</td>
            <td>${rating.brand.toString()}</td>
            <td>${rating}</td>
            <td><a href="removeRating?action=remove&reviewId=${rating.reviewId.toString()}">Remove</a></td>
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
