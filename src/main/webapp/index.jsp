<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 3/7/21
  Time: 3:37 PM
  To change this template use File | Settings | File Templates.
--%>
  <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
      <html>
        <c:import var="head" url="Includes/head.jsp"/>
        <c:import var="nav" url="Includes/nav.jsp"/>
        <c:import var="footer" url="Includes/footer.jsp"/>
        <c:out value="${head}" escapeXml="false"/>

        <body>
          <c:out value="${nav}" escapeXml="false"/>
          <header class="masthead text-center text-white">
              <div class="masthead-content">
                  <div class="container">
                      <h1 class="masthead-heading mb-0">Welcome to Drag Rater</h1>
                      <h2 class="masthead-subheading mb-0">Start Your Engines!</h2>
                      <a class="btn btn-primary btn-xl rounded-pill mt-5" href="signUp">Start Here!</a>
                  </div>
              </div>
              <div class="bg-circle-1 bg-circle"></div>
             <div class="bg-circle-2 bg-circle"></div>
              <div class="bg-circle-3 bg-circle"></div>
              <div class="bg-circle-4 bg-circle"></div>
          </header>

          <section>
              <div class="container">
                  <div class="row align-items-center">
                      <div class="col-lg-6 order-lg-2">
                          <div class="p-5"><img class="img-fluid rounded-circle" src="assets/img/katya.jpg" alt="..." /></div>
                      </div>
                      <div class="col-lg-6 order-lg-1">
                          <div class="p-5">
                              <h2 class="display-4">Problem Statement</h2>
                              <p>Choosing your favorite Drag Queen can be
                                challenging. There are so many factors to
                                consider. From subjective opinion to cold
                                statistics this website aims to combine user
                                entered data with existing stats to give the
                                user an individual ranking system that they can
                                use to find out who their favorite queen truly is! There is nothing along
                                these lines currently available on the internet
                                and partly due to quarantine Ru Paul’s Drag Race
                                has seen a large boost in viewership and
                                popularity! The goal of this project is to
                                create a fun and interactive space to meet other
                                fans of the show and trade opinions on who truly
                                is the best.</p>
                          </div>
                      </div>
                  </div>
              </div>
          </section>

          <c:out value="${footer}" escapeXml="false"/>
        </body>
      </html>
