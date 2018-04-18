package ie.sesh.Models.Users.Reviews;

import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class Review {

    private int id;
    private int user_id;
    private int reviewer_id;
    private int location_id;

    private String message;
    private Date uploaded;
    private float rating;

    public Review() {
    }

    public Review(int id, int user_id, int reviewer_id, int location_id, String message, Date uploaded, float rating) {
        this.id = id;
        this.user_id = user_id;
        this.reviewer_id = reviewer_id;
        this.location_id = location_id;
        this.message = message;
        this.uploaded = uploaded;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getReviewer_id() {
        return reviewer_id;
    }

    public void setReviewer_id(int reviewer_id) {
        this.reviewer_id = reviewer_id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getUploaded() {
        return uploaded;
    }

    public void setUploaded(Date uploaded) {
        this.uploaded = uploaded;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getLocation_id() {
        return location_id;
    }

    public void setLocation_id(int location_id) {
        this.location_id = location_id;
    }
}
