<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 3/7/21
  Time: 3:36 PM
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
<h1>Login Page</h1>

<FORM ACTION="j_security_check" METHOD="POST" class="toCenter">
    <TABLE>
        <div class="form-group">
            <TR class="center"><TD>User name: <INPUT TYPE="TEXT" NAME="j_username" class="form-control"></TD></TR>
        </div>
        <div class="form-group">
            <TR class="center"><TD>Password: <INPUT TYPE="PASSWORD" NAME="j_password" class="form-control"></TD></TR>
        </div>
        <div class="form-group">
            <TR class="center"><TH><INPUT TYPE="SUBMIT" VALUE="Log In" class="btn btn-default"></TH></TR>
        </div>
        <div class="form-group">
            <TR class="center"><TH><input type="reset" value="Clear" class="btn btn-default"></TH></TR>
        </div>
    </TABLE>
</FORM>
<c:out value="${footer}" escapeXml="false"/>
</body>
</html>