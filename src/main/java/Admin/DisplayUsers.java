package dragrater.Admin;

import dragrater.entity.Rating;
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
import java.io.IOException;
import java.util.List;

/**
 * This class displays the sites current users
 * to the admin page
 */
@WebServlet(name = "displayUsers", value = "/displayUsers")
public class DisplayUsers extends HttpServlet {

    /**
     * This method retrieves all users from the database and passes
     * them for display on the JSP
     * @param request The HttpServletRequest object.
     * @param response The HttpServletResponse object.
     * @throws ServletException ServletException Whether or not the servlet encounters an error.
     * @throws IOException IOException Whether or not an IO exception occurs.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        GenericDao<User> userDao = new GenericDao(User.class);
        List<User> users = userDao.getAll();

        request.setAttribute("users", users);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/displayUsers.jsp");
        dispatcher.forward(request, response);

    }
}

