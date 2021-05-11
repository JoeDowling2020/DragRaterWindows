package dragrater.controller;

import dragrater.entity.DragQueen;
import dragrater.entity.Rating;
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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.sendRedirect("editProfile.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        updateUser(request, response);
    }

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
