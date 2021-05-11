package dragrater.Admin;


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

@WebServlet("/removeUser")
public class RemoveUser extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    private GenericDao userDao;
    private int selectedUserId;

    public void init() {
        userDao = new GenericDao(User.class);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        selectedUserId = Integer.parseInt(request.getParameter("userId"));
        userDao.delete(userDao.getById(selectedUserId));
        RequestDispatcher dispatcher = request.getRequestDispatcher("/removalSuccess.jsp");
        dispatcher.forward(request, response);
    }
}
