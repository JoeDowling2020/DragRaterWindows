package dragrater.calculator;


import dragrater.entity.DragQueen;
import dragrater.entity.Rating;
import dragrater.persistence.GenericDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CalculateFinalScore {

    private GenericDao ratingDao;
    private GenericDao queenDao;



    public Double getRating(DragQueen targetQueen) {
        System.out.println("target queen" + targetQueen);
        ratingDao = new GenericDao(Rating.class);
        queenDao = new GenericDao(DragQueen.class);
        Set<Rating> ratingList = targetQueen.getRatings();
        System.out.println("ratingList: " + ratingList);
        Double finalScore;
        if (ratingList.size() != 0) {
            List<Double> finalRating = new ArrayList<>();
            Double finalAverage = null;
            double averageRating;
            for (Rating rating: ratingList
            ) {
                System.out.println("rating: " + rating);
                System.out.println("rating.getMakeup" + rating.getMakeup());
                averageRating = (rating.getMakeup() +  rating.getHumour() + rating.getHair() + rating.getFashion()
                        + rating.getPersonality() + rating.getDancing() + rating.getActing() + rating.getLipsync()
                        + rating.getImpersonation() + rating.getLyrics() + rating.getBrand()) / 11;
                System.out.println("Average Rating: " + averageRating);
                finalRating.add(averageRating);
            }
            System.out.println("final rating: " + finalRating);
            for (Double averagedRating: finalRating
            ) {
                finalAverage = averagedRating + averagedRating;
            }
            finalAverage = finalAverage / finalRating.size();
            Double dobScore = targetQueen.getDobScore();
            finalScore = finalAverage + dobScore;
        } else {
            finalScore = 0.0;
        }


//        List<Rating> siteRating = ratingDao.getByPropertyEqual("dragQueenId", dragqueenId);
//        List<Double> finalRating = null;
//        for (Rating rating: siteRating
//             ) {
//        double averageRating = rating.getMakeup() +  rating.getHumour() + rating.getHair() + rating.getFashion()
//                + rating.getPersonality() + rating.getDancing() + rating.getActing() + rating.getLipsync()
//                + rating.getImpersonation() + rating.getLyrics() + rating.getBrand() / 11;
//        finalRating.add(averageRating);
//        }
//
//        Double finalAverage = null;
//        for (Double averagedRating: finalRating
//             ) {
//           finalAverage = averagedRating + averagedRating;
//        }
//        finalAverage = finalAverage / finalRating.size();
//        int dragqueenInt = Integer.parseInt(dragqueenId);
//        DragQueen currentQueen = (DragQueen)queenDao.getById(dragqueenInt);
//        Double dobScore = currentQueen.getDobScore();
//        Double finalScore = finalAverage + dobScore;
        System.out.println("finalScore" + finalScore);
            return finalScore;
    }

}
