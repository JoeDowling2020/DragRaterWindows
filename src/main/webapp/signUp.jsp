<%--
  Created by IntelliJ IDEA.
  User: Fractal Man
  Date: 5/6/2021
  Time: 3:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign Up</title>
</head>
<body>
<h1>Sign Up For a DragRater Account</h1>

<form action="<%=request.getContextPath()%>/signUp" method="post">

    <label for="firstName">First Name</label>
    <input id="firstName" name="firstName" type="text" placeholder="First Name" required>
    <label for="lastName">Last Name</label>
    <input id="lastName" name="lastName" type="text" placeholder="Last Name" required>
    <label for="username">User Name</label>
    <input id="username" name="username" type="text" placeholder="Username" required>
    <label for="password">Password</label>
    <input id="password" name="password" type="password" placeholder="Password" required>
    <label for="email">Email</label>
    <input id="email" name="email" type="text" placeholder="Email" required>
    <button type="submit">Sign Up!</button>
    <button type="reset">Clear Form</button>
</form>
</body>
</html>
