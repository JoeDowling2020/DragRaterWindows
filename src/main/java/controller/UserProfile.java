package dragrater.controller;

import dragrater.entity.DragQueen;
import dragrater.entity.Rating;
import dragrater.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import dragrater.persistence.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Class represents a servlet it displays the user's
 * profile information to the JSP
 */
@WebServlet("/userProfile")
public class UserProfile extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());
    private GenericDao userDao;
    private GenericDao queenDao;
    private GenericDao ratingDao;

    /**
     * Initialises the Daos
     */
    public void init() {
        userDao = new GenericDao(User.class);
        queenDao = new GenericDao(DragQueen.class);
        ratingDao = new GenericDao(Rating.class);
    }

    /**
     * Method to retrieve the current users information
     * from the database and prepare it for display on the JSP
     * @param request The HttpServletRequest object.
     * @param response The HttpServletResponse object.
     * @throws ServletException ServletException Whether or not the servlet encounters an error.
     * @throws IOException IOException Whether or not an IO exception occurs.
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession webSession = request.getSession();
        User webUser = (User) webSession.getAttribute("user");
        User user = (User) userDao.getById(webUser.getId());


        int currentUser = webUser.getId();
        String currentUserString = Integer.toString(currentUser);
        System.out.println(currentUserString);
        List<Rating> userRatings = ratingDao.getByPropertyEqualToObject("user", user);

        HashMap<String, String> queenScore = new HashMap<String, String>();


        for (Rating rating: userRatings
             ) {
            String queenName = rating.getDragQueen().getName();
            int ratingId = rating.getReviewId();
            double averageScore = (rating.getHumour() + rating.getHumour() + rating.getMakeup()
                    + rating.getHair() + rating.getFashion() + rating.getPersonality()
                    + rating.getDancing() + rating.getActing() + rating.getLipsync()
                    + rating.getImpersonation() + rating.getBrand()) / 11;
            String stringScores = Double.toString(averageScore);
            queenScore.put(queenName, stringScores);
        }

        request.setAttribute("queen", queenScore);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/userProfile.jsp");
        dispatcher.forward(request, response);
    }
}
