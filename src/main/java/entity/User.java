package entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Entity;

/**
 * This Class represents a User of the Drag Rater App
 * @author Joe Dowling
 */

@Entity(name = "Users")
@Table(name="users") // Case matters!
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name= "native",strategy= "native")
    private int id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy= "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Role> roles = new HashSet<>();

    @OneToMany(mappedBy= "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Rating> ratings = new HashSet<>();

    public User() {
        //Tried and true no arg constructor!
    }

    /**
     * Instantiates a new User.
     * @param firstName the first name
     * @param lastName  the last name
     * @param username  the username
     * @param password  the password
     * @param email the email
     */
    public User(String firstName, String lastName, String username, String password, String email) {
        this();
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;

    }

    /**
     * Gets the user's ID
     * @return id the users ID
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the user's ID
     * @param id the users ID
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets first name
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name
     * @param firstName the users first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name
     * @param lastName the users last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the user's username
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the user's username
     * @param username the users name
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the user's password
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the user's password
     * @param password the users password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * gets Roles set
     * @return roles
     */
    public Set<Role> getRoles() {
        return roles;
    }

    /**
     * Sets the Roles Set
     * @param roles users role
     */
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    /**
     * Adds a role to the user
     * @param role users role
     */
    public void addRole(Role role) {
        roles.add(role);
        role.setUser(this);
    }

    /**
     * removes the users role
     * @param role the users role
     */
    public void removeRole(Role role) {
        roles.remove(role);
        role.setUser( null );
    }

    /**
     * Gets the ratings set
     * @return ratings
     */
    public Set<Rating> getRatings() {
        return ratings;
    }

    /**
     * Sets the ratings set
     * @param ratings the ratings set
     */
    public void setRatings(Set<Rating> ratings) {
        this.ratings = ratings;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", roles=" + roles +
                ", ratings=" + ratings +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(firstName, user.firstName) && Objects.equals(lastName, user.lastName) && Objects.equals(username, user.username) && Objects.equals(password, user.password) && Objects.equals(email, user.email) && Objects.equals(roles, user.roles) && Objects.equals(ratings, user.ratings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, username, password, email, roles, ratings);
    }
}