package controller;

import entity.User;
import entity.Role;
import persistence.GenericDao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;


@WebServlet(name = "SignupUserServlet", value = "/signupUser")
public class SignUpUser extends HttpServlet {

    private GenericDao userDao = new GenericDao(User.class);
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        User user = new User(firstName, lastName, userName, password, email);
        Role role = new Role(user, userName, "user");
        user.addRole(role);
        int newId = userDao.insert(user);
        logger.info("User with ID of: " + newId + " and the username of: " + user);

        session.setAttribute("userName", user.getUsername());

        RequestDispatcher dispatcher = request.getRequestDispatcher("/signupConfirm.jsp");
        dispatcher.forward(request, response);
    }
}
