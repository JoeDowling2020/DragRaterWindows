package controller;

import entity.DragQueen;
import entity.Rating;
import persistence.GenericDao;
import java.util.List;

public class CalculateFinalScore {

    private GenericDao ratingDao;
    private GenericDao queenDao;

    private List<Rating> getRating(String dragqueenId) {
        ratingDao = new GenericDao(Rating.class);
        queenDao = new GenericDao(DragQueen.class);
        List<Rating> ratings = ratingDao.getByPropertyEqual("dragqueenId", dragqueenId);

        return ratings;
    }
}
