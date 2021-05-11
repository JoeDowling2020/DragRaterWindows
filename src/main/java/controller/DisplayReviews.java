package dragrater.controller;

import dragrater.entity.Rating;
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
 * This class represents a servlet
 * it retrieves the user reviews for display on a JSP
 */
@WebServlet(
        name = "displayReviews", urlPatterns = {"/displayReviews"} )
public class DisplayReviews extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    private GenericDao ratingDao;

    /**
     * Calls the addQueen Method
     * @param request The HttpServletRequest object.
     * @param response The HttpServletResponse object.
     * @throws ServletException ServletException Whether or not the servlet encounters an error.
     * @throws IOException IOException Whether or not an IO exception occurs.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ratingDao = new GenericDao(Rating.class);
        List<Rating> allRatings = ratingDao.getAll();
        request.setAttribute("ratings", allRatings);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/displayReviews.jsp");
        dispatcher.forward(request, response);
    }
}
