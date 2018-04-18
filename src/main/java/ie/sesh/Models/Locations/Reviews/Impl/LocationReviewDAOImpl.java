package ie.sesh.Models.Locations.Reviews.Impl;

import ie.sesh.Models.Locations.Reviews.LocationReview;
import ie.sesh.Models.Locations.Reviews.LocationReviewDAO;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static ie.sesh.Database.SQLConstants.*;
import static ie.sesh.Database.SQLConstants.DELETE_LOCATION_REVIEW;
import static ie.sesh.Database.SQLConstants.UPDATE_LOCATION_REVIEW;

@Component
public class LocationReviewDAOImpl implements LocationReviewDAO {

    private static final Logger log = Logger.getLogger(LocationReviewDAOImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public LocationReview getLocationReview(int id) {
        log.info("Getting user");
        return (LocationReview)jdbcTemplate.queryForObject(GET_LOCATION_REVIEW_BY_ID, new Object[] {id}, new LocationReviewMapper());
    }

    public void updateLocationReview(LocationReview locationReview) {
        log.info("Updating locationReview");
        KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(UPDATE_LOCATION_REVIEW, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, locationReview.getLocation_id());
            ps.setInt(2, locationReview.getUser_id());
            ps.setString(3, locationReview.getReview());
            ps.setFloat(4, locationReview.getRating());
            ps.setDate(5, locationReview.getDate());
            return ps;
        }, holder);
    }

    public void createLocationReview(LocationReview locationReview) {
        log.info("Inserting locationReview");
        KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(INSERT_LOCATION_REVIEW, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, locationReview.getLocation_id());
            ps.setInt(2, locationReview.getUser_id());
            ps.setString(3, locationReview.getReview());
            ps.setFloat(4, locationReview.getRating());
            ps.setDate(5, locationReview.getDate());
            return ps;
        }, holder);
    }

    public void deleteLocationReview(int id) {
        log.info("Deleting review");
        KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(DELETE_LOCATION_REVIEW, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            return ps;
        }, holder);
    }
}

class LocationReviewMapper implements RowMapper {

    @Override
    public LocationReview mapRow(ResultSet rs, int rowNum) throws SQLException {
        LocationReview locationReview = new LocationReview();
        locationReview.setLocation_id(rs.getInt("location_id"));
        locationReview.setUser_id(rs.getInt("user_id"));
        locationReview.setReview(rs.getString("locationReview"));
        locationReview.setRating(rs.getInt("rating"));
        locationReview.setDate(rs.getDate("uploaded"));
        return locationReview;
    }

}
