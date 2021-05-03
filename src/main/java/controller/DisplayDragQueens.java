package controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import persistence.ApiDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "allQueens", urlPatterns = {"/allQueens"} )

public class DisplayDragQueens extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ApiDao apiDao = new ApiDao();

        try {
            req.setAttribute("dragQueens", apiDao.getAllDragQueens());
        } catch (Exception e) {
            e.printStackTrace();
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("/allQueens.jsp");
        dispatcher.forward(req, resp);
    }

}
