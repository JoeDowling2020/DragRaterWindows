package controller;

import entity.DragQueen;
import entity.Rating;
import entity.Role;
import entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/userProfile")
public class UserProfile extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    private GenericDao userDao;
    private GenericDao queenDao;
    private GenericDao ratingDao;

    public void init() {
        userDao = new GenericDao(User.class);
        queenDao = new GenericDao(DragQueen.class);
        ratingDao = new GenericDao(Rating.class);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession webSession = request.getSession();
        User webUser = (User) webSession.getAttribute("user");
        User user = (User) userDao.getById(webUser.getId());
        request.setAttribute("user", user);

        int currentUser = webUser.getId();
        String currentUserString = Integer.toString(currentUser);
        System.out.println(currentUserString);
        List<Rating> userRatings = ratingDao.getByPropertyEqual("user", currentUserString);
        List<String> queenNames = null;
        for (Rating rating: userRatings) {
            DragQueen currentQueen = rating.getDragQueen();
            queenNames.add(currentQueen.getName());
        }
        request.setAttribute("ratings", userRatings);
        request.setAttribute("queen", queenNames);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/userProfile.jsp");
        dispatcher.forward(request, response);
    }
}
