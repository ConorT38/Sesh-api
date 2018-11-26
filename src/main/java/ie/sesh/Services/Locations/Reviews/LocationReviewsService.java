package ie.sesh.Services.Locations.Reviews;

import ie.sesh.Models.Locations.Reviews.LocationReview;
import ie.sesh.Models.Locations.Reviews.LocationReviewDAO;
import ie.sesh.Services.Locations.LocationService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationReviewsService {

    private static final Logger log = Logger.getLogger(LocationService.class);

    @Autowired
    LocationReviewDAO locationReviewDAO;

    public LocationReviewsService() {
    }

    public LocationReview getLocationReview(int id){
        return locationReviewDAO.getLocationReview(id);
    }

    public void updateLocationReview(LocationReview locationReview){
        locationReviewDAO.updateLocationReview(locationReview);
    }

    public void createLocationReview(LocationReview locationReview){
        locationReviewDAO.createLocationReview(locationReview);
    }

    public void deleteLocationReview(int id){
        locationReviewDAO.deleteLocationReview(id);
    }
}
