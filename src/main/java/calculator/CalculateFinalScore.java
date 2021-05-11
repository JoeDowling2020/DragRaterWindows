package dragrater.calculator;


import dragrater.entity.DragQueen;
import dragrater.entity.Rating;
import dragrater.persistence.GenericDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Class to calculate the final dragrater score
 */
public class CalculateFinalScore {

    private GenericDao ratingDao;
    private GenericDao queenDao;

    public void init() {
        ratingDao = new GenericDao(Rating.class);
        queenDao = new GenericDao(DragQueen.class);
    }

    /** Method to take a drag queen and average out their ratings
     * before combing them with the susted or busted score and returning it
     * @param targetQueen the queen whos score is being calulated
     * @return final score
     */
    public Double getRating(DragQueen targetQueen) {

        //Declare variables used
        Set<Rating> ratingList = targetQueen.getRatings();
        Double finalScore;
        List<Double> finalRating = new ArrayList<>();
        Double finalAverage = null;
        double averageRating = 0;

        //Check if queen has been rated at all yet if not return 0.0
        if (ratingList.size() != 0) {
            //Each rating is averaged
            for (Rating rating: ratingList
            ) {
                averageRating = (rating.getMakeup() +  rating.getHumour() + rating.getHair() + rating.getFashion()
                        + rating.getPersonality() + rating.getDancing() + rating.getActing() + rating.getLipsync()
                        + rating.getImpersonation() + rating.getLyrics() + rating.getBrand()) / 11;
                System.out.println("average rating: " + averageRating);
                finalRating.add(averageRating);
            }
           // The new list of ratings is averaged
            if (finalRating.size() > 1) {
                for (Double averagedRating: finalRating
                ) {
                    finalAverage = averagedRating + averagedRating;
                }
            } else {
                finalAverage = averageRating;
            }
            
            // Final number is combined with DOB score
            finalAverage = finalAverage / finalRating.size();

            Double dobScore = targetQueen.getDobScore();
            System.out.println("dobscore: " + dobScore);

            finalScore = finalAverage + dobScore;
            System.out.println("finalAverage " + finalAverage);
        } else {
            finalScore = 0.0;
        }
        // return final score

        System.out.println("final score" + finalScore);

        System.out.println();
        return finalScore;
    }

}
