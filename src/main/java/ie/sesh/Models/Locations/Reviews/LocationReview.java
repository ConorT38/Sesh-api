package ie.sesh.Models.Locations.Reviews;

import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class LocationReview {

    private int id;
    private int location_id;
    private int user_id;

    private String review;
    private float rating;
    private Date date;

    public LocationReview() {
    }

    public LocationReview(int id, int location_id, int user_id, String review, float rating, Date date) {
        this.id = id;
        this.location_id = location_id;
        this.user_id = user_id;
        this.review = review;
        this.rating = rating;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLocation_id() {
        return location_id;
    }

    public void setLocation_id(int location_id) {
        this.location_id = location_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
