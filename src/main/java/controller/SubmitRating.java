package controller;

import entity.DragQueen;
import entity.Rating;
import entity.User;
import persistence.GenericDao;

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
    private GenericDao genericDao;
    private GenericDao userDao;
    private GenericDao queenDao;

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
        response.sendRedirect("submitRating.jsp");
    }

    private void submitRating (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession webSession = request.getSession();
        User webUser = (User) webSession.getAttribute("user");
        User user = (User) userDao.getById(webUser.getId());

        String dragQueenId  = request.getParameter("dragQueenId");
        String humour = request.getParameter("humour");
        String makeup = request.getParameter("makeup");
        String hair = request.getParameter("hair");
        String fashion = request.getParameter("fashion");
        String personality = request.getParameter("personality");
        String dancing = request.getParameter("dancing");
        String acting = request.getParameter("acting");
        String lipsync = request.getParameter("lipsync");
        String impersonation = request.getParameter("impersonation");
        String lyrics = request.getParameter("lyrics");
        String brand = request.getParameter("brand");

        int dragQueenInt = Integer.parseInt(dragQueenId);
        int humourInt = Integer.parseInt(humour);
        int makeupInt = Integer.parseInt(makeup);
        int hairInt = Integer.parseInt(hair);
        int fashionInt = Integer.parseInt(fashion);
        int personalityInt = Integer.parseInt(personality);
        int dancingInt = Integer.parseInt(dancing);
        int actingInt = Integer.parseInt(acting);
        int lipsyncInt = Integer.parseInt(lipsync);
        int impersonationInt = Integer.parseInt(impersonation);
        int lyricsInt = Integer.parseInt(lyrics);
        int brandInt = Integer.parseInt(brand);

        Rating newRating = new Rating();
        newRating.setUser(user);
        DragQueen dragQueen = (DragQueen)queenDao.getById(dragQueenInt);
        newRating.setDragQueen(dragQueen);
        newRating.setHumour(humourInt);
        newRating.setMakeup(makeupInt);
        newRating.setHair(hairInt);
        newRating.setFashion(fashionInt);
        newRating.setPersonality(personalityInt);
        newRating.setDancing(dancingInt);
        newRating.setActing(actingInt);
        newRating.setLipsync(lipsyncInt);
        newRating.setImpersonation(impersonationInt);
        newRating.setLyrics(lyricsInt);
        newRating.setBrand(brandInt);

        genericDao.saveOrUpdate(newRating);

        RequestDispatcher dispatcher = request.getRequestDispatcher("ratingSuccess.jsp");
        dispatcher.forward(request, response);
    }
}
