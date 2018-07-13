package ie.sesh.Models.Locations.Reviews;

import org.springframework.stereotype.Repository;

@Repository
public interface LocationReviewDAO {

    LocationReview getLocationReview(int id);
    void createLocationReview(LocationReview locationReview);
    void updateLocationReview(LocationReview locationReview);
    void deleteLocationReview(int id);
}
