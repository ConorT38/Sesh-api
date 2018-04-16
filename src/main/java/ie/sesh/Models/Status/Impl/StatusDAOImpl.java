package ie.sesh.Models.Status.Impl;

import ie.sesh.Models.Status.Status;
import ie.sesh.Models.Status.StatusDAO;
import ie.sesh.Models.Users.Impl.UserDAOImpl;
import ie.sesh.Models.Users.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static ie.sesh.Database.SQLConstants.*;
import static ie.sesh.Database.SQLConstants.DELETE_STATUS;
import static ie.sesh.Database.SQLConstants.INSERT_STATUS;

@Component
public class StatusDAOImpl implements StatusDAO{
    private static final Logger log = Logger.getLogger(StatusDAOImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Status getStatus(int id) {
        log.info("Getting user");
        return (Status)jdbcTemplate.queryForObject(GET_STATUS_BY_ID, new Object[] {id}, new StatusMapper());
    }

    public void updateStatus(Status status) {
        log.info("Updating status");
        KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(UPDATE_STATUS, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, status.getName());
            ps.setInt(2, status.getAge());
            ps.setDate(3, status.getDob());
            ps.setInt(4, status.getLocation());
            ps.setString(5, status.getFavourite_drink());
            ps.setDouble(6, status.getRating());
            ps.setInt(7,status.getId());
            return ps;
        }, holder);
    }

    public void createStatus(Status status) {
        log.info("Inserting status");
        KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(INSERT_STATUS, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, status.getUser_id());
            ps.setInt(2, status.getMessage());
            ps.setDate(3, status.getLocation());
            ps.setInt(4, status.getLikes());
            ps.setString(5, status.getDate());
            ps.setInt(6, status.getGoing());
            ps.setInt(4, status.getMaybe());
            ps.setInt(4, status.getNot_going());
            return ps;
        }, holder);
    }

    public void deleteStatus(int id) {
        log.info("Deleting status");
        KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(DELETE_STATUS, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            return ps;
        }, holder);
    }
}

class StatusMapper implements RowMapper {

    @Override
    public Status mapRow(ResultSet rs, int rowNum) throws SQLException {
        Status status = new Status();
        status.setId(rs.getInt("id"));
        status.setName(rs.getString("name"));
        status.setAge(rs.getInt("age"));
        status.setDob(rs.getDate("dob"));
        status.setFavourite_drink(rs.getString("favourite_drink"));
        status.setLocation(rs.getInt("location"));
        status.setRating(rs.getFloat("rating"));
        return user;
    }
}
