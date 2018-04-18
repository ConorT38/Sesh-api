package ie.sesh.Models.Locations;

import org.springframework.stereotype.Repository;

@Repository
public interface LocationDAO {
    Location getLocation(int id);
    void createLocation(Location location);
    void updateLocation(Location location);
    void deleteLocation(int id);
}
