package ie.sesh.Models.Locations;

public class Location{

    private int id;
    private String name;
    private String address;
    private String website;
    private String geoLocation;

    private float rating;
    private int visitors;
    private boolean has_promotion;


    public Location(){}

    public Location(int id, String name, String address, String website, String geoLocation, float rating, int visitors, boolean has_promotion) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.website = website;
        this.geoLocation = geoLocation;
        this.rating = rating;
        this.visitors = visitors;
        this.has_promotion = has_promotion;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getGeoLocation() {
        return geoLocation;
    }

    public void setGeoLocation(String geoLocation) {
        this.geoLocation = geoLocation;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getVisitors() {
        return visitors;
    }

    public void setVisitors(int visitors) {
        this.visitors = visitors;
    }

    public boolean isHas_promotion() {
        return has_promotion;
    }

    public void setHas_promotion(boolean has_promotion) {
        this.has_promotion = has_promotion;
    }
}
