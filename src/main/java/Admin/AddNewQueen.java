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

@WebServlet("/addNewQueen")
public class AddNewQueen extends HttpServlet {
    private final Logger logger = LogManager.getLogger(this.getClass());

    private GenericDao queenDao;

    public void init() {

        queenDao = new GenericDao(DragQueen.class);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        addNewQueen(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.sendRedirect("addNewQueen.jsp");
    }

    private void addNewQueen (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String dragQueenId = request.getParameter("dragQueenId");
        String name = request.getParameter("name");
        String dobScore = request.getParameter("dobScore");

        int dragQueenIdInt = Integer.parseInt(dragQueenId);
        Double dobScoreInt = Double.parseDouble(dobScore);

        DragQueen newQueen = new DragQueen();
        newQueen.setId(dragQueenIdInt);
        newQueen.setName(name);
        newQueen.setDobScore(dobScoreInt);

        queenDao.insert(newQueen);

        RequestDispatcher dispatcher = request.getRequestDispatcher("addQueenSuccess.jsp");
        dispatcher.forward(request, response);
    }
}
