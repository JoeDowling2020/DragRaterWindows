package dragrater.controller;

import dragrater.entity.DragQueen;
import dragrater.entity.Rating;
import dragrater.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import dragrater.persistence.ApiDao;
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
 * Class represents a servlet with two functions
 * Firstly to display relevent information about the queen who is being rated
 * Secondly to retrieve the rating and insert it into the database
 */
@WebServlet("/submitRating")
public class SubmitRating extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    private GenericDao genericDao;
    private GenericDao userDao;
    private GenericDao queenDao;
    private int importedQueenId;

    /**
     * Method to initialise the Daos
     */
    public void init() {

        genericDao = new GenericDao(Rating.class);
        userDao = new GenericDao(User.class);
        queenDao = new GenericDao(DragQueen.class);

    }
    /**
     * Calls the submitRating Method
     * @param request The HttpServletRequest object.
     * @param response The HttpServletResponse object.
     * @throws ServletException ServletException Whether or not the servlet encounters an error.
     * @throws IOException IOException Whether or not an IO exception occurs.
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        submitRating(request, response);
    }

    /**
     * Retrieves dragqueen data from both the database and API
     * to display on the webpage
     * @param request The HttpServletRequest object.
     * @param response The HttpServletResponse object.
     * @throws ServletException ServletException Whether or not the servlet encounters an error.
     * @throws IOException IOException Whether or not an IO exception occurs.
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        importedQueenId = Integer.parseInt(request.getParameter("dragQueenId"));
        logger.info("This here is the drag queen ID! " + importedQueenId);

        ApiDao apiDao = new ApiDao();
        try {
            request.setAttribute("dragQueen", apiDao.getDragQueen(importedQueenId));
        } catch (Exception e) {
            e.printStackTrace();
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/submitRating.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * Retrieves parameters from HTML form, creates new rating Object
     * and inserts it into the database using the current users ID
     * @param request The HttpServletRequest object.
     * @param response The HttpServletResponse object.
     * @throws ServletException ServletException Whether or not the servlet encounters an error.
     * @throws IOException IOException Whether or not an IO exception occurs.
     */
    private void submitRating (HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        //get the current user so the review is inserted correctly
        HttpSession webSession = request.getSession();
        User webUser = (User) webSession.getAttribute("user");
        User user = (User) userDao.getById(webUser.getId());

        //retrieve parameters from the HTML form
        Rating newRating = new Rating();
        newRating.setUser(user);
        DragQueen dragQueen = (DragQueen)queenDao.getById(importedQueenId);
        newRating.setDragQueen(dragQueen);
        newRating.setHumour(Integer.parseInt(request.getParameter("humour")));
        newRating.setMakeup(Integer.parseInt(request.getParameter("makeup")));
        newRating.setHair(Integer.parseInt(request.getParameter("hair")));
        newRating.setFashion(Integer.parseInt(request.getParameter("fashion")));
        newRating.setPersonality(Integer.parseInt(request.getParameter("personality")));
        newRating.setDancing(Integer.parseInt(request.getParameter("dancing")));
        newRating.setActing(Integer.parseInt(request.getParameter("acting")));
        newRating.setLipsync(Integer.parseInt(request.getParameter("lipsync")));
        newRating.setImpersonation(Integer.parseInt(request.getParameter("impersonation")));
        newRating.setLyrics(Integer.parseInt(request.getParameter("lyrics")));
        newRating.setBrand(Integer.parseInt(request.getParameter("brand")));

        //insert new rating
        genericDao.saveOrUpdate(newRating);

        RequestDispatcher dispatcher = request.getRequestDispatcher("ratingSuccess.jsp");
        dispatcher.forward(request, response);
    }
}
