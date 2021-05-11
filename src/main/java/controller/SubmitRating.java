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

@WebServlet("/submitRating")
public class SubmitRating extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    private GenericDao genericDao;
    private GenericDao userDao;
    private GenericDao queenDao;
    private int importedQueenId;

    public void init() {

        genericDao = new GenericDao(Rating.class);
        userDao = new GenericDao(User.class);
        queenDao = new GenericDao(DragQueen.class);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        submitRating(request, response);
    }

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

    private void submitRating (HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        HttpSession webSession = request.getSession();
        User webUser = (User) webSession.getAttribute("user");
        User user = (User) userDao.getById(webUser.getId());

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

        genericDao.saveOrUpdate(newRating);

        RequestDispatcher dispatcher = request.getRequestDispatcher("ratingSuccess.jsp");
        dispatcher.forward(request, response);
    }
}
