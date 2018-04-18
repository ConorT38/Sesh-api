package ie.sesh.Controllers.Locations.Reviews;

import com.google.gson.Gson;

import ie.sesh.Models.Locations.Reviews.LocationReview;
import ie.sesh.Services.Locations.Reviews.LocationReviewsService;
import ie.sesh.Utils.CommonUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LocationReviewController {

    @Autowired
    LocationReviewsService locationReviewService;

    @PostMapping("/get/location/review")
    @ResponseBody
    public LocationReview getLocationReview(@RequestParam(name="id") int id) {
        return locationReviewService.getLocationReview(id);
    }

    @PostMapping("/update/location/review")
    @ResponseBody
    public boolean updateLocationReview(@RequestBody String review_data) {
        Gson gson = CommonUtils.convertDate(review_data);
        LocationReview locationReview = gson.fromJson(review_data, LocationReview.class);
        locationReviewService.updateLocationReview(locationReview);
        return true;
    }

    @PostMapping("/create/location/review")
    @ResponseBody
    public boolean createLocationReview(@RequestBody String review_data) {
        Gson gson = CommonUtils.convertDate(review_data);
        LocationReview locationReview = gson.fromJson(review_data, LocationReview.class);
        locationReviewService.createLocationReview(locationReview);
        return true;
    }

    @PostMapping("/delete/location/review")
    @ResponseBody
    public boolean deleteLocationReview(@RequestParam(name="id") int id) {
        locationReviewService.deleteLocationReview(id);
        return true;
    }
}
