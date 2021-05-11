package dragrater.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * This Class represents a servlet which returns the user to the homepage
 * upon being logged out
 * @author jdowling
 */
@WebServlet(
        name = "LogoutAction",
        urlPatterns = {"/logout"}
)
public class LogOutAction extends HttpServlet {
    private final Logger logger = LogManager.getLogger();

    /**
     * Forwards the user to the index page.
     * @param request The HttpServletRequest object.
     * @param response The HttpServletResponse object.
     * @throws ServletException Whether or not the servlet encounters an error.
     * @throws IOException Whether or not an IO exception occurs.
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getRemoteUser();

        HttpSession session = request.getSession();
        session.removeAttribute("user");

        request.logout();
        response.sendRedirect("index.jsp");
    }
}
