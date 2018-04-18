package ie.sesh.Models.Users.Reviews.Impl;

import ie.sesh.Models.Users.Reviews.Review;
import ie.sesh.Models.Users.Reviews.ReviewDAO;

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

@Component
public class ReviewDAOImpl implements ReviewDAO {

    private static final Logger log = Logger.getLogger(ReviewDAOImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Review getReview(int id) {
        log.info("Getting user");
        return (Review)jdbcTemplate.queryForObject(GET_USER_REVIEW_BY_ID, new Object[] {id}, new ReviewMapper());
    }

    public void updateReview(Review review) {
        log.info("Updating review");
        KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(UPDATE_USER_REVIEW, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, review.getUser_id());
            ps.setInt(2, review.getReviewer_id());
            ps.setInt(3, review.getLocation_id());
            ps.setString(4, review.getMessage());
            ps.setDate(5, review.getUploaded());
            ps.setDouble(6, review.getRating());
            return ps;
        }, holder);
    }

    public void createReview(Review review) {
        log.info("Inserting review");
        KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(INSERT_USER_REVIEW, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, review.getUser_id());
            ps.setInt(2, review.getReviewer_id());
            ps.setInt(3, review.getLocation_id());
            ps.setString(4, review.getMessage());
            ps.setDate(5, review.getUploaded());
            ps.setDouble(6, review.getRating());
            return ps;
        }, holder);
    }

    public void deleteReview(int id) {
        log.info("Deleting review");
        KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(DELETE_USER_REVIEW, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            return ps;
        }, holder);
    }
}

class ReviewMapper implements RowMapper {

    @Override
    public Review mapRow(ResultSet rs, int rowNum) throws SQLException {
        Review review = new Review();
        review.setUser_id(rs.getInt("user_id"));
        review.setReviewer_id(rs.getInt("reviewer_id"));
        review.setLocation_id(rs.getInt("location_id"));
        review.setMessage(rs.getString("message"));
        review.setUploaded(rs.getDate("uploaded"));
        review.setRating(rs.getFloat("rating"));
        return review;
    }
}
