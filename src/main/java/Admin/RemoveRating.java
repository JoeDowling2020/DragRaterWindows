package dragrater.Admin;

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

@WebServlet("/removeRating")
public class RemoveRating extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());
    private GenericDao ratingDao;
    private int importedReview;

    public void init() {
        ratingDao = new GenericDao(Rating.class);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        importedReview = Integer.parseInt(request.getParameter("reviewId"));

        ratingDao.delete(ratingDao.getById(importedReview));
        RequestDispatcher dispatcher = request.getRequestDispatcher("/removeRatingSuccess.jsp");
        dispatcher.forward(request, response);
    }

}
