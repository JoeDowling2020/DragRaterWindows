package dragrater.controller;

import dragrater.entity.Role;
import dragrater.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import dragrater.persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Class represents a servlet
 * Allows the user to ediit their profile
 */
@WebServlet(
        name = "editProfile", urlPatterns = {"/editProfile"} )
public class EditProfile extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    private GenericDao userDao;
    private GenericDao roleDao;


    public void init() {

        userDao = new GenericDao(User.class);
        roleDao = new GenericDao(Role.class);

    }

    /**
     * Redirects to the JSP
     * @param request The HttpServletRequest object.
     * @param response The HttpServletResponse object.
     * @throws ServletException ServletException Whether or not the servlet encounters an error.
     * @throws IOException IOException Whether or not an IO exception occurs.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.sendRedirect("editProfile.jsp");
    }

    /**
     * Calls the updateUser method
     * @param request The HttpServletRequest object.
     * @param response The HttpServletResponse object.
     * @throws ServletException ServletException Whether or not the servlet encounters an error.
     * @throws IOException IOException Whether or not an IO exception occurs.
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        updateUser(request, response);
    }

    /**
     * Retrieves the parameters from the HTML form
     * Updates the user in the database
     * @param request The HttpServletRequest object.
     * @param response The HttpServletResponse object.
     * @throws ServletException ServletException Whether or not the servlet encounters an error.
     * @throws IOException IOException Whether or not an IO exception occurs.
     */
    private void updateUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession webSession = request.getSession();
        User webUser = (User) webSession.getAttribute("user");
        User user = (User) userDao.getById(webUser.getId());

        if (request.getParameter("firstName") != "") {
            user.setFirstName(request.getParameter("firstName"));
        }
        if (request.getParameter("lastName") != "") {
            user.setLastName(request.getParameter("lastName"));
        }
        if (request.getParameter("username") != "") {
            user.setUsername(request.getParameter("username"));
        }
        if (request.getParameter("password") != "") {
            user.setPassword(request.getParameter("password"));
        }
        if (request.getParameter("email") != "") {
            user.setEmail(request.getParameter("email"));
        }

        roleDao.saveOrUpdate(user);
        userDao.saveOrUpdate(user);

        RequestDispatcher dispatcher = request.getRequestDispatcher("updateSuccess.jsp");
        dispatcher.forward(request, response);
    }
}
