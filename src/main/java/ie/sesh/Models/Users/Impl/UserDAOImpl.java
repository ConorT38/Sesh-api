package ie.sesh.Models.Users.Impl;

import ie.sesh.Models.Status.Status;
import ie.sesh.Models.Users.User;
import ie.sesh.Models.Users.UserDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.jdbc.core.RowMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import static ie.sesh.Database.SQLConstants.*;
import static java.lang.Math.toIntExact;

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

    @Override
    public List<User> getAllRecommendedUsers(int id) {
        log.info("Getting statuses by id "+id);
        List<User> users = new ArrayList<User>();
        List<Map<String,Object>> userList = jdbcTemplate.queryForList(GET_RECOMMENDED_USERS, new Object[]{id});

        for(Map user: userList){
            User u = new User();
            u.setId(toIntExact((Long)(user.get("id"))));
            u.setName((String) user.get("name"));
            u.setAge(toIntExact((Long)(user.get("age"))));
            u.setDob((Date) user.get("dob"));
            u.setLocation((int) user.get("location"));
            u.setFavourite_drink((String) user.get("favourite_drink"));
            u.setRating((float)user.get("rating"));
            u.setGender((String)user.get("gender"));
            u.setLocal_spot((int)user.get("local_spot"));
            u.setUsername((String) user.get("username"));
            u.setEmail((String)user.get("email"));
            users.add(u);
        }
        return users;
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