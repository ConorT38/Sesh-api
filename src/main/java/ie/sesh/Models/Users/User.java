package ie.sesh.Models.Users;

import ie.sesh.Models.Locations.Location;

import java.util.Date;

public class User {

    private int id;
    private String name;
    private int age;
    private Date dob;

    private Location location;
    private String favourite_drink;
    private double rating;

    public User(){}

    public User(int id, String name, int age, Date dob, Location location, String favourite_drink, double rating){
        this.id = id;
        this.name = name;
        this.age = age;
        this.dob = dob;
        this.location = location;
        this.favourite_drink = favourite_drink;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getFavourite_drink() {
        return favourite_drink;
    }

    public void setFavourite_drink(String favourite_drink) {
        this.favourite_drink = favourite_drink;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
