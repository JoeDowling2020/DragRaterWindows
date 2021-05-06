package controller;

import entity.Role;
import entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import persistence.GenericDao;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/signUp")
public class SignUpUser extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    private GenericDao genericDao;
    private GenericDao roleDao;

    public void init() {
        genericDao = new GenericDao(User.class);
        roleDao = new GenericDao(Role.class);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        signUp(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("signUp.jsp");
    }

    private void signUp(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        System.out.println("firstname " + firstName);
        System.out.println("lastname " + lastName);
        System.out.println("uname " + username);
        System.out.println("pass " + password);
        System.out.println("email " + email);

        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);

        Role role = new Role();
        String userName = user.getUsername();
        int userId = user.getId();
        role.setUser(user);
        role.setRoleTitle("user");
        role.setUsername(userName);
        role.setId(userId);
        genericDao.insert(user);
        roleDao.insert(role);

        RequestDispatcher dispatcher = request.getRequestDispatcher("signUpSuccess.jsp");
        dispatcher.forward(request, response);
    }
}
