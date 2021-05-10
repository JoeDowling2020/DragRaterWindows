<%--
  Created by IntelliJ IDEA.
  User: Fractal Man
  Date: 5/9/2021
  Time: 4:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>All Site Reviews</title>

    <table>
        <th>Review ID</th>
        <th>User ID</th>
<%--        <th>DragQueen ID</th>--%>
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

        <c:forEach items="${ratings}" var="rating">
    <tr>
        <td>${rating.reviewId.toString()}</td>
        <td>${rating.user.id.toString()}</td>
<%--        <td>${rating.dragQueenId.toString()}</td>--%>
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
        <td><a href="removeRating?action=remove&reviewId=${rating.reviewId.toString()}">Remove</a></td>
    </tr>
        </c:forEach>
    </table>
</head>
<body>

</body>
</html>
