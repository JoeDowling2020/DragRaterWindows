package entity;

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
     * @param roleTitle the title of the role
     * @param user the user with that role
     */
    public Role(String roleTitle, User user) {
        this.user = user;
        this.roleTitle = roleTitle;
    }

    /**
     * Get the Role ID
     * @return id role id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the Role ID
     * @param id role id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the role title
     * @return the name of the role
     */
    public String getRoleTitle() {
        return roleTitle;
    }

    /**
     * Sets role title
     * @param roleTitle the title of the role
     */
    public void setRoleTitle(String roleTitle) {
        this.roleTitle = roleTitle;
    }

    /**
     * Gets the user
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the user
     * @param user the user
     */
    public void setUser(User user) {
        this.user = user;
    }


    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleTitle='" + roleTitle + '\'' +
                ", user=" + user +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return id == role.id &&
                Objects.equals(roleTitle, role.roleTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roleTitle);
    }
}