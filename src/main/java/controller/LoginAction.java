package dragrater.controller;

import dragrater.entity.User;
import dragrater.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


/**
 * Class represents a servlet which redirects to the index page
 * after a log in attempt
 * @author jdowling
 */

@WebServlet(name = "LoginAction", value = "/login")
public class LoginAction extends HttpServlet {
    private GenericDao userDao = new GenericDao(User.class);
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * After user logs in refirects to the home page
     * @param request The HttpServletRequest object.
     * @param response The HttpServletResponse object.
     * @throws ServletException ServletException Whether or not the servlet encounters an error.
     * @throws IOException IOException Whether or not an IO exception occurs.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String username = request.getRemoteUser();
        logger.info("User " + username + " has logged in");

        List<User> foundUser = (List<User>) userDao.getByPropertyEqual("username", username);
        User user = foundUser.get(0);

        request.setAttribute("username", username);
        request.setAttribute("user", user);
        session.setAttribute("user", user);

        response.sendRedirect(request.getContextPath() + "/index.jsp");

    }
}

