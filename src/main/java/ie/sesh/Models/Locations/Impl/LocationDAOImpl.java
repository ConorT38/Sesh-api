package ie.sesh.Models.Locations.Impl;

import ie.sesh.Models.Locations.Location;
import ie.sesh.Models.Locations.LocationDAO;
import ie.sesh.Models.Users.Impl.UserDAOImpl;
import ie.sesh.Models.Users.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static ie.sesh.Database.SQLConstants.*;
import static ie.sesh.Database.SQLConstants.INSERT_LOCATION;
import static ie.sesh.Database.SQLConstants.UPDATE_LOCATION;

public class LocationDAOImpl implements LocationDAO {

    private static final Logger log = Logger.getLogger(LocationDAOImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Location getLocation(int id) {
        log.info("Getting location");
        return (Location)jdbcTemplate.queryForObject(GET_LOCATION_BY_ID, new Object[] {id}, new LocationMapper());
    }

    public void updateLocation(Location location) {
        log.info("Updating location");
        KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(UPDATE_LOCATION, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, location.getName());
            ps.setString(2, location.getAddress());
            ps.setString(3, location.getWebsite());
            ps.setString(4, location.getGeoLocation());
            ps.setBoolean(8, location.isHas_promotion());
            ps.setFloat(6, location.getRating());
            ps.setInt(7, location.getVisitors());
            return ps;
        }, holder);
    }

    public void createLocation(Location location) {
        log.info("Inserting location");
        KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(INSERT_LOCATION, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, location.getName());
            ps.setString(2, location.getAddress());
            ps.setString(3, location.getWebsite());
            ps.setString(4, location.getGeoLocation());
            ps.setBoolean(8, location.isHas_promotion());
            ps.setFloat(6, location.getRating());
            ps.setInt(7, location.getVisitors());
            return ps;
        }, holder);
    }

    public void deleteLocation(int id) {
        log.info("Deleting location");
        KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(DELETE_LOCATION, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            return ps;
        }, holder);
    }
}

class LocationMapper implements RowMapper {

    @Override
    public Location mapRow(ResultSet rs, int rowNum) throws SQLException {
        Location location = new Location();
        location.setName(rs.getString("name"));
        location.setAddress(rs.getString("address"));
        location.setWebsite(rs.getString("website"));
        location.setGeoLocation(rs.getString("geolocation"));
        location.setHas_promotion(rs.getBoolean("has_promotion"));
        location.setRating(rs.getFloat("rating"));
        location.setVisitors(rs.getInt("visitors"));
        return location;
    }
}
