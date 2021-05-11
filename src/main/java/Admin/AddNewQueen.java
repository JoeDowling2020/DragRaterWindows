package dragrater.Admin;

import dragrater.entity.DragQueen;

import dragrater.entity.Rating;
import dragrater.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import dragrater.persistence.GenericDao;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * This class serves to future proof the site
 * When a new season is released the admin is able to
 * Add the new queen as they are announced
 */
@WebServlet("/addNewQueen")
public class AddNewQueen extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    private GenericDao queenDao;

    /**
     * Method to set up the DragQueen Dao
     */
    public void init() {

        queenDao = new GenericDao(DragQueen.class);
    }

    /**
     * Calls the addQueen Method
     * @param request The HttpServletRequest object.
     * @param response The HttpServletResponse object.
     * @throws ServletException ServletException Whether or not the servlet encounters an error.
     * @throws IOException IOException Whether or not an IO exception occurs.
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        addNewQueen(request, response);
    }

    /**
     * Method to redirect to the JSP
     * @param request The HttpServletRequest object.
     * @param response The HttpServletResponse object.
     * @throws ServletException ServletException Whether or not the servlet encounters an error.
     * @throws IOException IOException Whether or not an IO exception occurs.
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.sendRedirect("addNewQueen.jsp");
    }

    /**
     * Method takes the parameters for the new Queen from the html form
     * parses them to ints and inserts them into the database
     * finally a success page is displayed
     * @param request The HttpServletRequest object.
     * @param response The HttpServletResponse object.
     * @throws ServletException ServletException Whether or not the servlet encounters an error.
     * @throws IOException IOException Whether or not an IO exception occurs.
     */
    private void addNewQueen (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String dragQueenId = request.getParameter("dragQueenId");
        String name = request.getParameter("name");
        String dobScore = request.getParameter("dobScore");

        //change values to correct data type
        int dragQueenIdInt = Integer.parseInt(dragQueenId);
        Double dobScoreInt = Double.parseDouble(dobScore);

        DragQueen newQueen = new DragQueen();
        newQueen.setId(dragQueenIdInt);
        newQueen.setName(name);
        newQueen.setDobScore(dobScoreInt);

        //Insert into Database
        queenDao.insert(newQueen);

        RequestDispatcher dispatcher = request.getRequestDispatcher("addQueenSuccess.jsp");
        dispatcher.forward(request, response);
    }
}
