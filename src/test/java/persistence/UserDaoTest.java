package persistence;

import entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UserDaoTest {
    private final Logger logger = LogManager.getLogger(this.getClass());
    GenericDao genericDao;

    @BeforeEach
    void setUp() {
        genericDao = new GenericDao(User.class);
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
    }

    /**
     * Verifies gets all users successfully.
     */
    @Test
    void getAllUsersSuccess() {
        List<User> users = genericDao.getAll();
        assertEquals(6, users.size());
    }

    /**
     * Verifies a user is returned correctly based on id search
     */
    @Test
    void getByIdSuccess() {
        User retrievedUser = (User)genericDao.getById(1);
        assertNotNull(retrievedUser);
        assertEquals("Joe", retrievedUser.getFirstName());
    }

    /**
     * Verify successful insert of a user
     */
    @Test
    void insertSuccess() {
        User newUser = new User("Jane", "Doe", "jdoe", "supersecret9000", "jdow@gmail.com");
        int id = genericDao.insert(newUser);
        assertNotEquals(0,id);
        User insertedUser = (User)genericDao.getById(id);
        assertEquals(newUser, insertedUser);
    }

    /**
     * Verify successful delete of user
     */
    @Test
    void deleteSuccess() {
        genericDao.delete(genericDao.getById(6));
        assertNull(genericDao.getById(6));
    }

    /**
     * Verify successful update of user
     */
    @Test
    void updateSuccess() {
        String newName = "Hannah";
        User userToUpdate = (User)genericDao.getById(3);
        userToUpdate.setFirstName(newName);
        genericDao.saveOrUpdate(userToUpdate);
        User retrievedUser = (User)genericDao.getById(3);
        assertEquals(userToUpdate, retrievedUser);
    }

    /**
     * Verify successful get by property (like match)
     */
    @Test
    void getByPropertyLikeSuccess() {
        List<User> users = genericDao.getByPropertyLike("firstName", "d");
        assertEquals(3, users.size());
    }

    /**
     * Verify successful get by property (equal match)
     */
    @Test
    void getByPropertyEqualSuccess() {
        List<User> users = genericDao.getByPropertyEqual("firstName", "Joe");
        assertEquals(1, users.size());
        assertEquals(1, users.get(0).getId());
    }
}