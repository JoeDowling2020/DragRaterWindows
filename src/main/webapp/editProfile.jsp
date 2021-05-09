<%--
  Created by IntelliJ IDEA.
  User: Fractal Man
  Date: 5/8/2021
  Time: 7:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Profile</title>
</head>
<body>

<h1>Edit Your Profile!</h1>

<form action="<%=request.getContextPath()%>/editProfile" method="post">

  <label for="firstName">First Name</label>
  <input id="firstName" name="firstName" type="text" placeholder="First Name">
  <label for="lastName">Last Name</label>
  <input id="lastName" name="lastName" type="text" placeholder="Last Name">
  <label for="username">User Name</label>
  <input id="username" name="username" type="text" placeholder="Username">
  <label for="password">Password</label>
  <input id="password" name="password" type="password" placeholder="Password">
  <label for="email">Email</label>
  <input id="email" name="email" type="text" placeholder="Email">
  <button type="submit">Change Profile</button>
  <button type="reset">Clear Form</button>
</form>

</body>
</html>
