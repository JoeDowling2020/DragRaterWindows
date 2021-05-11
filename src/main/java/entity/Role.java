package dragrater.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.Objects;
import javax.persistence.Entity;

@Entity(name = "Role")
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "username")
    private String username;

    @Column(name = "role")
    private String roleTitle;

    @ManyToOne
    @JoinColumn(name = "user_id",
            foreignKey = @ForeignKey(name = "role_users_id_fk"))
    private User user;


    public Role() {
        //no argument constructor
    }

    /**
     * Instantiates a new Role
     *
     * @param roleTitle the title of the role
     * @param user      the user with that role
     * @param username  the users name
     */
    public Role(User user, String username, String roleTitle) {
        this.user = user;
        this.username = username;
        this.roleTitle = roleTitle;
    }

    /**
     * Get the Role ID
     *
     * @return id role id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the Role ID
     *
     * @param id role id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the role title
     *
     * @return the name of the role
     */
    public String getRoleTitle() {
        return roleTitle;
    }

    /**
     * Sets role title
     *
     * @param roleTitle the title of the role
     */
    public void setRoleTitle(String roleTitle) {
        this.roleTitle = roleTitle;
    }

    /**
     * Gets the user
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the user
     *
     * @param user the user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Gets the username
     *
     * @return the usersname
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username
     *
     * @param username the usersname
     */
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return id == role.id &&
                Objects.equals(username, role.username) &&
                Objects.equals(roleTitle, role.roleTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, roleTitle);
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", roleTitle='" + roleTitle + '\'' +
                ", user=" + user +
                '}';
    }
}