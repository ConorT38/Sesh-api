package ie.sesh.Models.Locations.Reviews;

import java.util.Date;

public class Review {

    private int id;
    private int location_id;
    private int user_id;

    private String review;
    private double rating;
    private Date date;

    public Review() {
    }

    public Review(int id, int location_id, int user_id, String review, double rating, Date date) {
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

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
