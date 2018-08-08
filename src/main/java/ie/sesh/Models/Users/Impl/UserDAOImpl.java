package ie.sesh.Models.Users.Impl;

import ie.sesh.Models.Users.User;
import ie.sesh.Models.Users.UserDAO;

import ie.sesh.Utils.CommonUtils;
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

    @Autowired
    CommonUtils commonUtils;

    public User getUser(int id) {
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

        User userL = this.getUser(id);
        int location = userL.getLocation();

        log.info("Getting recommended users by id "+id);
        List<User> users = new ArrayList<User>();
        List<Map<String,Object>> userList = jdbcTemplate.queryForList(GET_RECOMMENDED_USERS, new Object[]{id,location});

        for(Map user: userList){
            User u = new User();
            u.setId(toIntExact((Long)(user.get("id"))));
            u.setName((String) commonUtils.checkIsNullEmpty(user.get("name"),""));
            u.setAge((int)(commonUtils.checkIsNullEmpty(user.get("age"),0)));
            u.setDob((Date) commonUtils.checkIsNullEmpty(user.get("dob"),new Date(new java.util.Date().getTime())));
            u.setLocation((int) commonUtils.checkIsNullEmpty(user.get("location"),0));
            u.setFavourite_drink((String) commonUtils.checkIsNullEmpty(user.get("favourite_drink"),"None"));
            u.setRating(((float) commonUtils.checkIsNullEmpty(user.get("rating"),0.0f)));
            u.setGender((String) commonUtils.checkIsNullEmpty(user.get("gender"),"?"));
            u.setLocal_spot((int) commonUtils.checkIsNullEmpty(user.get("local_spot"),0));
            u.setUsername((String) commonUtils.checkIsNullEmpty(user.get("username"),""));
            u.setEmail((String) commonUtils.checkIsNullEmpty(user.get("email"),""));
            users.add(u);
        }
        return users;
    }

    public void followUser(int id, int user_id) {
        log.info("Following user");
        KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(FOLLOW_USER, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ps.setInt(2, user_id);
            return ps;
        }, holder);
    }

    @Override
    public List<User> getOnlineUsers(int id) {
        log.info("Getting online users by id "+id);
        List<User> users = new ArrayList<User>();
        List<Map<String,Object>> userList = jdbcTemplate.queryForList(GET_ONLINE_USERS, new Object[]{id,id});

        for(Map user: userList){
            User u = new User();
            u.setId(toIntExact((Long)(user.get("id"))));
            u.setName((String) commonUtils.checkIsNullEmpty(user.get("name"),""));
            u.setLocation((int) commonUtils.checkIsNullEmpty(user.get("location"),0));
            u.setRating(((float) commonUtils.checkIsNullEmpty(user.get("rating"),0.0f)));
            u.setUsername((String) commonUtils.checkIsNullEmpty(user.get("username"),""));
            users.add(u);
        }
        return users;
    }

    public User getUserProfile(String username) {
        log.info("Getting user by username "+ username);
        return (User)jdbcTemplate.queryForObject(GET_USER_PROFILE_BY_USERNAME, new Object[] {username}, new UserMapper());
    }
}

class UserMapper implements RowMapper {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setName(rs.getString("name"));
        user.setUsername(rs.getString("username"));
        user.setAge(rs.getInt("age"));
        user.setDob(rs.getDate("dob"));
        user.setFavourite_drink(rs.getString("favourite_drink"));
        user.setLocation(rs.getInt("location"));
        user.setRating(rs.getFloat("rating"));
        return user;
    }
}