package dragrater.persistence;

import dragrater.entity.User;
import dragrater.entity.DragQueen;
import dragrater.entity.Rating;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import dragrater.properties.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DragQueenDaoTest {
    private final Logger logger = LogManager.getLogger(this.getClass());
    GenericDao<DragQueen> queenDao;
    GenericDao ratingDao;
    GenericDao userDao;

    @BeforeEach
    void setUp() {
        queenDao = new GenericDao<>(DragQueen.class);
        ratingDao = new GenericDao(Rating.class);
        userDao = new GenericDao(User.class);
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    @Test
    void getAllSuccess() {
        List<DragQueen> dragQueens = queenDao.getAll();
        assertEquals(2, dragQueens.size());
        logger.debug(dragQueens);
    }
    @Test
    void getByIdSuccess() {
        DragQueen retrievedQueen = (DragQueen)queenDao.getById(1);
        assertNotNull(retrievedQueen);
        assertEquals(1, retrievedQueen.getId());
    }
    /**
     * Verify successful insert of a Role
     */
    @Test
    void insertSuccess() {
        DragQueen newQueen = new DragQueen(4, "Sally Mayo", 6.753);
        int id = queenDao.insert(newQueen);
        assertNotEquals(0,id);
        DragQueen insertedQueen = queenDao.getById(id);
        assertEquals(newQueen, insertedQueen);
    }

    @Test
    void deleteSuccess() {
        queenDao.delete(queenDao.getById(1));
        assertNull(queenDao.getById(1));
    }

    @Test
    void updateSuccess() {
        String newName = "Sarah";
        DragQueen queenToUpdate = (DragQueen)queenDao.getById(1);
        queenToUpdate.setName(newName);
        queenDao.saveOrUpdate(queenToUpdate);
        DragQueen retrievedQueen = (DragQueen)queenDao.getById(1);
        assertEquals(queenToUpdate, retrievedQueen);
    }

    @Test
    void getByPropertyLikeSuccess() {
        List<DragQueen> queens = queenDao.getByPropertyLike("name", "c");
        assertEquals(1, queens.size());
    }

    @Test
    void getByPropertyEqualSuccess() {
        List<DragQueen> queens = queenDao.getByPropertyLike("name", "Crystal Method");
        assertEquals(1, queens.size());
        assertEquals(2, queens.get(0).getId());
    }

}
