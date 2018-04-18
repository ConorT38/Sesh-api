package ie.sesh.Services.Users.Reviews;

import ie.sesh.Models.Users.Reviews.Review;
import ie.sesh.Models.Users.Reviews.ReviewDAO;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserReviewService {

    private static final Logger log = Logger.getLogger(UserReviewService.class);

    @Autowired
    ReviewDAO reviewDAO;

    public UserReviewService() {
    }

    public Review getReview(int id){
        return reviewDAO.getReview(id);
    }

    public void updateReview(Review review){
        reviewDAO.updateReview(review);
    }

    public void createReview(Review review){
        reviewDAO.createReview(review);
    }

    public void deleteReview(int id){
        reviewDAO.deleteReview(id);
    }
}
