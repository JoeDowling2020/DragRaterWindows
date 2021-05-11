package dragrater.controller;

import dragrater.calculator.CalculateFinalScore;
import dragrater.entity.DragQueen;
import dragrater.entity.Rating;
import dragrater.entity.User;
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
import java.util.List;

@WebServlet("/viewDragRating")
public class ViewDragRating extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    private GenericDao ratingDao;
    private GenericDao queenDao;
    private String importedQueenId;

    public void init() {
        queenDao = new GenericDao(DragQueen.class);

    }

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
