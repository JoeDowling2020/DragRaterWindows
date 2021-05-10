package controller;

import entity.DragQueen;
import entity.Rating;
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

@WebServlet(
        name = "displayReviews", urlPatterns = {"/displayReviews"} )
public class DisplayReviews extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    private GenericDao ratingDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        ratingDao = new GenericDao(Rating.class);
        List<Rating> allRatings = ratingDao.getAll();
        req.setAttribute("ratings", allRatings);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/displayReviews.jsp");
        dispatcher.forward(req, resp);
    }
}
