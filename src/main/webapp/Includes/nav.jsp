<nav class="navbar navbar-expand-lg navbar-dark navbar-custom fixed-top">
    <div class="container">
        <a class="navbar-brand" href="index.jsp">Home</a>
        <%
            if (request.getRemoteUser() == null) {
        %>
        <%
        } else {
        %>
        <a class="navbar-brand" href="userProfile">User Profile</a>
        <a class="navbar-brand" href="allQueens">Drag Queens</a>
        <%
            }
        %>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item"><a class="nav-link" href="admin.jsp">Admin</a></li>
                <%
                    if (request.getRemoteUser() == null) {
                %>
                <li class="nav-item"><a class="nav-link" href="login">Log In</a></li>
                <li class="nav-item"><a class="nav-link" href="signUp">Sign Up</a></li>
                <%
                } else {
                %>
                <li class="nav-item"><a class="nav-link" href="logout">Log Out</a></li>
<%--                <li class="nav-item"><a class="nav-link" href="signUp">Sign Up</a></li>--%>
                <%
                    }
                %>
            </ul>
        </div>
    </div>
</nav>
