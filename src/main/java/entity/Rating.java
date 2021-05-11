package dragrater.entity;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.Objects;
import javax.persistence.Entity;

@Entity(name = "Rating")
@Table(name = "ratings")
public class Rating {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name= "native",strategy= "native")
    private int reviewId;

    @ManyToOne
    @JoinColumn(name = "userId",
            foreignKey = @ForeignKey(name = "ratings_users_id_fk"))
    private User user;

    @ManyToOne
    @JoinColumn(name = "dragQueenId",
            foreignKey = @ForeignKey(name = "ratings_drag_queen_dragQueenId_fk"), referencedColumnName="dragQueenId")
    private DragQueen dragQueen;

    @Column(name = "humour")
    private int humour;

    @Column(name = "makeup")
    private int makeup;

    @Column(name = "hair")
    private int hair;

    @Column(name = "fashion")
    private int fashion;

    @Column(name = "personality")
    private int personality;

    @Column(name = "dancing")
    private int dancing;

    @Column(name = "acting")
    private int acting;

    @Column(name = "lipsync")
    private int lipsync;

    @Column(name = "impersonation")
    private int impersonation;

    @Column(name = "lyrics")
    private int lyrics;

    @Column(name = "brand")
    private int brand;

    public Rating() {
        //Tried and true no arg constructor!
    }

    /**
     * Instantiates a new role
     * @param user    the user's ID
     * @param dragQueen   the queen's ID
     * @param humour    humour score
     * @param makeup make up score
     * @param hair hair score
     * @param fashion fashion score
     * @param personality personality score
     * @param dancing dancing score
     * @param acting acting score
     * @param lipsync lipsync score
     * @param impersonation impersonation score
     * @param lyrics lyric writting score
     * @param brand brand score
     */
    public Rating(User user, DragQueen dragQueen, int humour, int makeup, int hair, int fashion,
                  int personality, int dancing, int acting, int lipsync, int impersonation, int lyrics, int brand) {
        this();
        this.user = user;
        this.dragQueen = dragQueen;
        this.humour = humour;
        this.makeup = makeup;
        this.hair = hair;
        this.fashion = fashion;
        this.personality = personality;
        this.dancing = dancing;
        this.acting = acting;
        this.lipsync = lipsync;
        this.impersonation = impersonation;
        this.lyrics = lyrics;
        this.brand = brand;
    }

    /**
     * Gets the reviews ID
     * @return reviewId
     */
    public int getReviewId() {
        return reviewId;
    }

    /**
     * Sets the reviews ID
     * @param reviewId the reviews id
     */
    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    /**
     * Gets the users ID
     * @return user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the users ID
     * @param user the users ID
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Get the queens ID
     * @return dragQueenId
     */
    public DragQueen getDragQueen() {
        return dragQueen;
    }

    /**
     * Sets the queens Id
     * @param dragQueen queens ID
     */
    public void setDragQueen(DragQueen dragQueen) {
        this.dragQueen = dragQueen;
    }

    /**
     * Get the humour score
     * @return humour
     */
    public int getHumour() {
        return humour;
    }

    /**
     * Sets the humour score
     * @param humour the humour score
     */
    public void setHumour(int humour) {
        this.humour = humour;
    }

    /**
     * Gets the Make up score
     * @return makeup
     */
    public int getMakeup() {
        return makeup;
    }

    /**
     * Sets make up score
     * @param makeup
     */
    public void setMakeup(int makeup) {
        this.makeup = makeup;
    }

    /**
     * Get the hair score
     * @return hair
     */
    public int getHair() {
        return hair;
    }

    /**
     * Sets the hair score
     * @param hair the hair score
     */
    public void setHair(int hair) {
        this.hair = hair;
    }

    /**
     * Get the fashion score
     * @return fashion
     */
    public int getFashion() {
        return fashion;
    }

    /**
     * Sets the fashion score
     * @param fashion the fashion score
     */
    public void setFashion(int fashion) {
        this.fashion = fashion;
    }

    /**
     * Gets the personality score
     * @return personality
     */
    public int getPersonality() {
        return personality;
    }

    /**
     * Sets the personality score
     * @param personality the personality score
     */
    public void setPersonality(int personality) {
        this.personality = personality;
    }

    /**
     * Gets the dancing score
     * @return dancing
     */
    public int getDancing() {
        return dancing;
    }

    /**
     * Sets the dancing score
     * @param dancing the dancing score
     */
    public void setDancing(int dancing) {
        this.dancing = dancing;
    }

    /**
     * Gets the acting score
     * @return acting
     */
    public int getActing() {
        return acting;
    }

    /**
     * Sets the acting score
     * @param acting the acting score
     */
    public void setActing(int acting) {
        this.acting = acting;
    }

    /**
     * Gets the lip-sync score
     * @return lipsync
     */
    public int getLipsync() {
        return lipsync;
    }

    /**
     * Sets the lip-sync score
     * @param lipsync the lips-sync score
     */
    public void setLipsync(int lipsync) {
        this.lipsync = lipsync;
    }

    /**
     * Get the impersonation score
     * @return impersonation
     */
    public int getImpersonation() {
        return impersonation;
    }

    /**
     * Sets the impersonation score
     * @param impersonation the impersonation score
     */
    public void setImpersonation(int impersonation) {
        this.impersonation = impersonation;
    }

    /**
     * Gets the lyrics score
     * @return lyrics
     */
    public int getLyrics() {
        return lyrics;
    }

    /**
     * Sets the lyrics score
     * @param lyrics the lyrics score
     */
    public void setLyrics(int lyrics) {
        this.lyrics = lyrics;
    }

    /**
     * Gets the personal brand score
     * @return brand
     */
    public int getBrand() {
        return brand;
    }

    /**
     * Sets the personal brand score
     * @param brand the personal brand score
     */
    public void setBrand(int brand) {
        this.brand = brand;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rating rating = (Rating) o;
        return reviewId == rating.reviewId && humour == rating.humour && makeup == rating.makeup && hair == rating.hair && fashion == rating.fashion && personality == rating.personality && dancing == rating.dancing && acting == rating.acting && lipsync == rating.lipsync && impersonation == rating.impersonation && lyrics == rating.lyrics && brand == rating.brand;
    }

    @Override
    public int hashCode() {
        return Objects.hash(reviewId, humour, makeup, hair, fashion, personality, dancing, acting, lipsync, impersonation, lyrics, brand);
    }

    @Override
    public String toString() {
        return "Rating{" +
                "reviewId=" + reviewId +
                ", user=" + user +
                ", dragQueenId=" + dragQueen +
                ", humour=" + humour +
                ", makeup=" + makeup +
                ", hair=" + hair +
                ", fashion=" + fashion +
                ", personality=" + personality +
                ", dancing=" + dancing +
                ", acting=" + acting +
                ", lipsync=" + lipsync +
                ", impersonation=" + impersonation +
                ", lyrics=" + lyrics +
                ", brand=" + brand +
                '}';
    }
}

