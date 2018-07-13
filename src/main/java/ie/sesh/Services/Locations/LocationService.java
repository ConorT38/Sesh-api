package ie.sesh.Services.Locations;

import ie.sesh.Models.Locations.Location;
import ie.sesh.Models.Locations.LocationDAO;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {

    private static final Logger log = Logger.getLogger(LocationService.class);

    @Autowired
    LocationDAO locationDAO;

    public LocationService() {
    }

    public Location getLocation(int id){
        return locationDAO.getLocation(id);
    }

    public void updateLocation(Location location){
        locationDAO.updateLocation(location);
    }

    public void createLocation(Location location){
        locationDAO.createLocation(location);
    }

    public void deleteLocation(int id){
        locationDAO.deleteLocation(id);
    }
}
