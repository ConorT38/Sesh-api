package ie.sesh.Controllers.Users.Reviews;

import com.google.gson.Gson;
import ie.sesh.Models.Users.Reviews.Review;
import ie.sesh.Models.Users.User;
import ie.sesh.Services.Users.Reviews.UserReviewService;
import ie.sesh.Services.Users.UserService;
import ie.sesh.Utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReviewController {

    @Autowired
    UserReviewService userReviewService;

    @PostMapping("/get/user/review")
    @ResponseBody
    public Review getReview(@RequestParam(name="id") int id) {
        return userReviewService.getReview(id);
    }

    @PostMapping("/update/user/review")
    @ResponseBody
    public boolean updateReview(@RequestBody String review_data) {
        Gson gson = CommonUtils.convertDate(review_data);
        Review review = gson.fromJson(review_data, Review.class);
        userReviewService.updateReview(review);
        return true;
    }

    @PostMapping("/create/user/review")
    @ResponseBody
    public boolean createReview(@RequestBody String review_data) {
        Gson gson = CommonUtils.convertDate(review_data);
        Review review = gson.fromJson(review_data, Review.class);
        userReviewService.createReview(review);
        return true;
    }

    @PostMapping("/delete/user/review")
    @ResponseBody
    public boolean deleteReview(@RequestParam(name="id") int id) {
        userReviewService.deleteReview(id);
        return true;
    }
}
