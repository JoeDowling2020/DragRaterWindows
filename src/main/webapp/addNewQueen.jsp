<%--
  Created by IntelliJ IDEA.
  User: Fractal Man
  Date: 5/6/2021
  Time: 5:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add a New Queen</title>
</head>
<body>
<h1>Add a New Queen!</h1>

<form action="addNewQueen" method="POST">
    <label for="dragQueenId"></label>
    <input name="dragQueenId" id="dragQueenId" type="text" placeholder="Drag Queen ID" required>
    <label for="name"></label>
    <input name="name" id="name" type="text" placeholder="Drag Queen's Full Name" required>
    <label for="dobScore"></label>
    <input name="dobScore" id="dobScore" type="text" placeholder="The Queen's DOB score" required>
    <button type="submit">Add Queen</button>
    <button type="reset">Clear Form</button>
</form>
</body>
</html>
