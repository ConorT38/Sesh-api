package Models.Status.Comments;

import java.util.Date;

public class Comment {

    private int id;
    private int status_id;
    private int user_id;

    private String message;
    private int likes;
    private Date date;

    public Comment() {
    }

    public Comment(int id, int status_id, int user_id, String message, int likes, Date date) {
        this.id = id;
        this.status_id = status_id;
        this.user_id = user_id;
        this.message = message;
        this.likes = likes;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatus_id() {
        return status_id;
    }

    public void setStatus_id(int status_id) {
        this.status_id = status_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
