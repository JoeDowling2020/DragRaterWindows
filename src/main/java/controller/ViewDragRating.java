package dragrater.controller;

import dragrater.calculator.CalculateFinalScore;
import dragrater.entity.DragQueen;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import dragrater.persistence.ApiDao;
import dragrater.persistence.GenericDao;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Class represents a servlet
 * It retrieves data on the selected queen before
 * calling the CalculateFinalScore class and preparing it
 * for display on the JSP
 */
@WebServlet("/viewDragRating")
public class ViewDragRating extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    private GenericDao ratingDao;
    private GenericDao queenDao;
    private String importedQueenId;

    /**
     * Initialise the Doo
     */
    public void init() {
        queenDao = new GenericDao(DragQueen.class);

    }

    /**
     * Retrieves dragqueen data based on the selected queen
     * class the class to calculate the final score and passes it to the JSP
     * @param request The HttpServletRequest object.
     * @param response The HttpServletResponse object.
     * @throws ServletException ServletException Whether or not the servlet encounters an error.
     * @throws IOException IOException Whether or not an IO exception occurs.
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        importedQueenId = request.getParameter("dragQueenId");

        int importedIntId = Integer.parseInt(importedQueenId);
        DragQueen retrievedQueen = (DragQueen)queenDao.getById(importedIntId);

        CalculateFinalScore getFinalScore = new CalculateFinalScore();
        Double dragRaterScore = getFinalScore.getRating(retrievedQueen);

        double dobScore = retrievedQueen.getDobScore();
        request.setAttribute("dobScore", dobScore);
        request.setAttribute("score", dragRaterScore);

        ApiDao apiDao = new ApiDao();
        try {
            request.setAttribute("dragQueen", apiDao.getDragQueen(importedIntId));
        } catch (Exception e) {
            e.printStackTrace();
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/viewDragRating.jsp");
        dispatcher.forward(request, response);
    }
}
