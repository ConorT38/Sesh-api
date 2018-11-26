package ie.sesh.Models.Users.Reviews;

import org.springframework.stereotype.Repository;

@Repository
public interface ReviewDAO {

    Review getReview(int id);
    void createReview(Review review);
    void updateReview(Review review);
    void deleteReview(int id);
}
