<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Fractal Man
  Date: 5/5/2021
  Time: 7:45 PM
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
    <table>
        <th>Mug Shot</th>
        <th>Drag Queen</th>
        <th>Quote</th>

        <tr>
            <td><img src="${dragQueen.getImageUrl()}"  width="250" height="300"></td>
            <td><c:out value="${dragQueen.getName()}"/></td>
            <td><c:out value="${dragQueen.getQuote()}"/></td>
        </tr>

    </table>

<div class="center">
    <form action="submitRating" METHOD="POST">
        <div class="form-group">
        <label for="humour">Humour</label>
        <select name="humour" id="humour" class="btn btn-default">
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
            <option value="5">5</option>
            <option value="6">6</option>
            <option value="7">7</option>
            <option value="8">8</option>
            <option value="9">9</option>
            <option value="10">10</option>
        </select>
        </div>
        <div class="form-group">
        <label for="makeup">Makeup</label>
        <select name="makeup" id="makeup" class="btn btn-default">
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
            <option value="5">5</option>
            <option value="6">6</option>
            <option value="7">7</option>
            <option value="8">8</option>
            <option value="9">9</option>
            <option value="10">10</option>
        </select>
        </div>
        <div class="form-group">
        <label for="hair">Hair</label>
        <select name="hair" id="hair" class="btn btn-default">
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
            <option value="5">5</option>
            <option value="6">6</option>
            <option value="7">7</option>
            <option value="8">8</option>
            <option value="9">9</option>
            <option value="10">10</option>
        </select>
        </div>
        <div class="form-group">
        <label for="fashion">Fashion</label>
        <select name="fashion" id="fashion" class="btn btn-default">
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
            <option value="5">5</option>
            <option value="6">6</option>
            <option value="7">7</option>
            <option value="8">8</option>
            <option value="9">9</option>
            <option value="10">10</option>
        </select>
        </div>
        <div class="form-group">
        <label for="personality">Personality</label>
        <select name="personality" id="personality" class="btn btn-default">
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
            <option value="5">5</option>
            <option value="6">6</option>
            <option value="7">7</option>
            <option value="8">8</option>
            <option value="9">9</option>
            <option value="10">10</option>
        </select>
        </div>
        <div class="form-group">
        <label for="dancing">Dancing</label>
        <select name="dancing" id="dancing" class="btn btn-default">
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
            <option value="5">5</option>
            <option value="6">6</option>
            <option value="7">7</option>
            <option value="8">8</option>
            <option value="9">9</option>
            <option value="10">10</option>
        </select>
        </div>
        <div class="form-group">
        <label for="acting">Acting</label>
        <select name="acting" id="acting" class="btn btn-default">
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
            <option value="5">5</option>
            <option value="6">6</option>
            <option value="7">7</option>
            <option value="8">8</option>
            <option value="9">9</option>
            <option value="10">10</option>
        </select>
        </div>
        <div class="form-group">
        <label for="lipsync">Lipsync</label>
        <select name="lipsync" id="lipsync" class="btn btn-default">
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
            <option value="5">5</option>
            <option value="6">6</option>
            <option value="7">7</option>
            <option value="8">8</option>
            <option value="9">9</option>
            <option value="10">10</option>
        </select>
        </div>
        <div class="form-group">
        <label for="impersonation">Impersonation</label>
        <select name="impersonation" id="impersonation" class="btn btn-default">
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
            <option value="5">5</option>
            <option value="6">6</option>
            <option value="7">7</option>
            <option value="8">8</option>
            <option value="9">9</option>
            <option value="10">10</option>
        </select>
        </div>
        <div class="form-group">
        <label for="lyrics">Lyrics</label>
        <select name="lyrics" id="lyrics" class="btn btn-default">
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
            <option value="5">5</option>
            <option value="6">6</option>
            <option value="7">7</option>
            <option value="8">8</option>
            <option value="9">9</option>
            <option value="10">10</option>
        </select>
        </div>
        <div class="form-group">
        <label for="brand">Brand</label>
        <select name="brand" id="brand" class="btn btn-default">
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
            <option value="4">4</option>
            <option value="5">5</option>
            <option value="6">6</option>
            <option value="7">7</option>
            <option value="8">8</option>
            <option value="9">9</option>
            <option value="10">10</option>
        </select>
        </div>
        <div class="form-group">
        <button type="submit">Submit</button>
        </div>
    </form>
</div>

<c:out value="${footer}" escapeXml="false"/>
</body>
</html>
