package entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity(name = "DragQueen")
@Table(name = "drag_queen")
public class DragQueen {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name= "native",strategy= "native")
    private int dragQueenId;

    @Column(name = "name")
    private String name;

    @Column(name = "dobScore")
    private double dobScore;
    @OneToMany(mappedBy= "dragQueen", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Rating> ratings = new HashSet<>();

    public DragQueen() {
        //Tried and true no arg constructor!
    }

    /**
     *
     * @param dragQueenId the queens ID
     * @param name  the name of the queen
     * @param dobScore  the dusted or busted score for the queen
     */
    public DragQueen(int dragQueenId, String name, double dobScore) {
        this.dragQueenId = dragQueenId;
        this.name = name;
        this.dobScore = dobScore;
    }

    /**
     * Get the drag queens ID
     * @return dragQueenId
     */
    public int getId() {
        return dragQueenId;
    }

    /**
     * Sets the DragQueen ID
     * @param dragQueenId the queens ID
     */
    public void setId(int dragQueenId) {
        this.dragQueenId = dragQueenId;
    }

    /**
     * Get the queens name
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the queens name
     * @param name the queens name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the dusted or busted score
     * @return dobScore
     */
    public double getDobScore() {
        return dobScore;
    }

    /**
     * Set dusted or busted score
     * @param dobScore the dusted or busted score
     */
    public void setDobScore(double dobScore) {
        this.dobScore = dobScore;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DragQueen dragQueen = (DragQueen) o;
        return dragQueenId == dragQueen.dragQueenId && Double.compare(dragQueen.dobScore, dobScore) == 0 && Objects.equals(name, dragQueen.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dragQueenId, name, dobScore);
    }

    @Override
    public String toString() {
        return "DragQueen{" +
                "dragQueenId=" + dragQueenId +
                ", name='" + name + '\'' +
                ", dobScore=" + dobScore +
                '}';
    }
}

