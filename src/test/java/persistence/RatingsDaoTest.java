package persistence;

import entity.DragQueen;
import entity.Rating;
import entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RatingsDaoTest {
    private final Logger logger = LogManager.getLogger(this.getClass());
    GenericDao ratingDao;
    GenericDao queenDao;
    GenericDao userDao;

    @BeforeEach
    void setUp() {
        ratingDao = new GenericDao(Rating.class);
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }
    
    @Test
    void getAllRatingSuccess() {
        List<Rating> rating = ratingDao.getAll();
        assertEquals(1, rating.size());
    }

    @Test
    void getByIdSuccess() {
        Rating retrievedRating = (Rating)ratingDao.getById(1);
        assertEquals(1, retrievedRating.getReviewId());
        assertEquals("Joe", retrievedRating.getUser().getFirstName());
    }

    @Test
    void insertSuccess() {
        queenDao = new GenericDao(DragQueen.class);
        userDao = new GenericDao(User.class);
        DragQueen dragQueen = (DragQueen)queenDao.getById(1);
        User user = (User)userDao.getById(1);
        int dragQueenId = dragQueen.getId();
        int userId = user.getId();
        Rating newRating = new Rating(user, dragQueen, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);
        int newId = ratingDao.insert(newRating);
        Rating insertedRating = (Rating)ratingDao.getById(newId);
        assertEquals(userId, insertedRating.getUser().getId());
        assertEquals(dragQueenId, insertedRating.getDragQueen().getId());

    }

    @Test
    void deleteSuccess() {
        userDao = new GenericDao(User.class);
        ratingDao.delete(ratingDao.getById(1));
        Rating existingRating = (Rating)ratingDao.getById(1);
        assertNull(ratingDao.getById(1));
        assertEquals(existingRating, ratingDao.getById(1));
    }

    @Test
    void updateSuccess() {
        int newScore = 10;
        Rating ratingToUpdate = (Rating)ratingDao.getById(1);
        ratingToUpdate.setActing(newScore);
        ratingDao.saveOrUpdate(ratingToUpdate);
        Rating retrievedRating = (Rating)ratingDao.getById(1);
        assertEquals(newScore, retrievedRating.getActing());
    }


    @Test
    void getByPropertyEqualSuccess() {
        List<Rating> ratings = ratingDao.getByPropertyEqual("humour", "1");
        assertEquals(1 ,ratings.size());
    }


}
