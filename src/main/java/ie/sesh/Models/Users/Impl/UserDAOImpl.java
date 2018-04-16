package ie.sesh.Models.Users.Impl;

import ie.sesh.Models.Users.User;
import ie.sesh.Models.Users.UserDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.core.RowMapper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.log4j.Logger;

import static ie.sesh.Database.SQLConstants.*;

@Component
public class UserDAOImpl implements UserDAO{

    private static final Logger log = Logger.getLogger(UserDAOImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public User getUser(int id) {
        log.info("Getting user");
        return (User)jdbcTemplate.queryForObject(GET_USER_BY_ID, new Object[] {id}, new UserMapper());
    }

    public void updateUser(User user) {
        log.info("Updating user");
        KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(UPDATE_USER, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getName());
            ps.setInt(2, user.getAge());
            ps.setDate(3, user.getDob());
            ps.setInt(4, user.getLocation());
            ps.setString(5, user.getFavourite_drink());
            ps.setDouble(6, user.getRating());
            ps.setInt(7,user.getId());
            return ps;
        }, holder);
    }

    public void createUser(User user) {
        log.info("Inserting user");
        KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(INSERT_USER, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getName());
            ps.setInt(2, user.getAge());
            ps.setDate(3, user.getDob());
            ps.setInt(4, user.getLocation());
            ps.setString(5, user.getFavourite_drink());
            ps.setDouble(6, user.getRating());
            return ps;
        }, holder);
    }

    public void deleteUser(int id) {
        log.info("Deleting user");
        KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(DELETE_USER, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            return ps;
        }, holder);
    }
}

class UserMapper implements RowMapper {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setName(rs.getString("name"));
        user.setAge(rs.getInt("age"));
        user.setDob(rs.getDate("dob"));
        user.setFavourite_drink(rs.getString("favourite_drink"));
        user.setLocation(rs.getInt("location"));
        user.setRating(rs.getFloat("rating"));
        return user;
    }
}