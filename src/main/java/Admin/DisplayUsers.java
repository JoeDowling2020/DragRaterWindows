package Admin;

import entity.Rating;
import entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import persistence.GenericDao;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(name = "displayUsers", value = "/displayUsers")
public class DisplayUsers extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        GenericDao<User> userDao = new GenericDao(User.class);
        List<User> users = userDao.getAll();

        request.setAttribute("users", users);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/displayUsers.jsp");
        dispatcher.forward(request, response);

    }
}

