package ie.sesh.Controllers.Locations;

import com.google.gson.Gson;

import ie.sesh.Models.Locations.Location;
import ie.sesh.Services.Locations.LocationService;
import ie.sesh.Utils.CommonUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LocationController {

    @Autowired
    LocationService locationService;

    @PostMapping("/get/user")
    @ResponseBody
    public Location getLocation(@RequestParam(name="id") int id) {
        return locationService.getLocation(id);
    }

    @PostMapping("/update/user")
    @ResponseBody
    public boolean updateLocation(@RequestBody String location_data) {
        Gson gson = CommonUtils.convertDate(location_data);
        Location location = gson.fromJson(location_data, Location.class);
        locationService.updateLocation(location);
        return true;
    }

    @PostMapping("/create/user")
    @ResponseBody
    public boolean createLocation(@RequestBody String location_data) {
        Gson gson = CommonUtils.convertDate(location_data);
        Location location = gson.fromJson(location_data, Location.class);
        locationService.createLocation(location);
        return true;
    }

    @PostMapping("/delete/user")
    @ResponseBody
    public boolean deleteLocation(@RequestParam(name="id") int id) {
        locationService.deleteLocation(id);
        return true;
    }
}
