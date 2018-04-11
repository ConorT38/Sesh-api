package ie.sesh.Models.Status;

import ie.sesh.Models.Locations.Location;

import java.util.Date;

public class Status {

    private int id;
    private int user_id;

    private String message;
    private Location location;
    private int likes;

    private Date date;

    // uses User ID
    private int[] going;
    private int[] maybe;
    private int[] not_going;

    public Status() {}

    public Status(int id, int user_id, String message, Location location, int likes, Date date, int[] going, int[] maybe, int[] not_going) {
        this.id = id;
        this.user_id = user_id;
        this.message = message;
        this.location = location;
        this.likes = likes;
        this.date = date;
        this.going = going;
        this.maybe = maybe;
        this.not_going = not_going;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
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

    public int[] getGoing() {
        return going;
    }

    public void setGoing(int[] going) {
        this.going = going;
    }

    public int[] getMaybe() {
        return maybe;
    }

    public void setMaybe(int[] maybe) {
        this.maybe = maybe;
    }

    public int[] getNot_going() {
        return not_going;
    }

    public void setNot_going(int[] not_going) {
        this.not_going = not_going;
    }
}
