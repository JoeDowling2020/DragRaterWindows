package dragrater.controller;

import dragrater.entity.Role;
import dragrater.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import dragrater.persistence.GenericDao;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Class represents a servlet which takes a new users info
 * from the HTML form and inserts it into the database
 */
@WebServlet("/signUp")
public class SignUpUser extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    private GenericDao genericDao;
    private GenericDao roleDao;

    /**
     * Initialises the Daos
     */
    public void init() {
        genericDao = new GenericDao(User.class);
        roleDao = new GenericDao(Role.class);
    }

    /**
     * Calls the signUp Method
     * @param request The HttpServletRequest object.
     * @param response The HttpServletResponse object.
     * @throws ServletException ServletException Whether or not the servlet encounters an error.
     * @throws IOException IOException Whether or not an IO exception occurs.
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        signUp(request, response);
    }
    /**
     * Redirects to the JSP
     * @param request The HttpServletRequest object.
     * @param response The HttpServletResponse object.
     * @throws ServletException ServletException Whether or not the servlet encounters an error.
     * @throws IOException IOException Whether or not an IO exception occurs.
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("signUp.jsp");
    }

    /**
     * Retrieves the new user parameters from the HTML form
     * builds a User & Role object and inserts it into the database
     * @param request The HttpServletRequest object.
     * @param response The HttpServletResponse object.
     * @throws ServletException ServletException Whether or not the servlet encounters an error.
     * @throws IOException IOException Whether or not an IO exception occurs.
     */
    private void signUp(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        User user = new User();
        user.setFirstName(request.getParameter("firstName"));
        user.setLastName(request.getParameter("lastName"));
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        user.setEmail(request.getParameter("email"));

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
