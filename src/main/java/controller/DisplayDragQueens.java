package dragrater.controller;

import dragrater.entity.DragQueen;
import dragrater.entity.Rating;
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

/**
 * Class represents a servlet which displays the drag queens
 * and their score to a JSP
 */
@WebServlet(
        name = "allQueens", urlPatterns = {"/allQueens"} )
public class DisplayDragQueens extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    private GenericDao queenDao;
    private GenericDao ratingDao;

    /**
     * Initialises DragQueen Dao
     */
    public void init() {
        queenDao = new GenericDao(DragQueen.class);
    }
    /**
     * Method to retrieve DragQueens from the API and DAO
     * before passing them to a web page
     * @param request The HttpServletRequest object.
     * @param response The HttpServletResponse object.
     * @throws ServletException ServletException Whether or not the servlet encounters an error.
     * @throws IOException IOException Whether or not an IO exception occurs.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ApiDao apiDao = new ApiDao();

        //Create a list of all Drag Queens
        List<DragQueen> dragQueens = queenDao.getAll();
        request.setAttribute("dobScore", dragQueens);

        //Retreive Drag queen data from API
        try {
            request.setAttribute("dragQueens", apiDao.getAllDragQueens());
        } catch (Exception e) {
            e.printStackTrace();
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/allQueens.jsp");
        dispatcher.forward(request, response);
    }

}
