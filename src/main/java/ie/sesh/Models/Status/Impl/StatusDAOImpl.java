package ie.sesh.Models.Status.Impl;

import ie.sesh.Models.Status.Status;
import ie.sesh.Models.Status.StatusDAO;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static ie.sesh.Database.SQLConstants.*;
import static ie.sesh.Database.SQLConstants.DELETE_STATUS;
import static ie.sesh.Database.SQLConstants.INSERT_STATUS;
import static java.lang.Math.toIntExact;

@Component
public class StatusDAOImpl implements StatusDAO{
    private static final Logger log = Logger.getLogger(StatusDAOImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Status getStatus(int id) {
        log.info("Getting status by id "+id);
        return (Status)jdbcTemplate.queryForObject(GET_STATUS_BY_ID, new Object[] {id}, new StatusMapper());
    }

    public List<Status> getAllStatus(int id) {
        log.info("Getting statuses by id "+id);
        List<Status> statuses = new ArrayList<Status>();
        List<Map<String,Object>> statusList = jdbcTemplate.queryForList(GET_LIVE_FEED, new Object[]{id});

        for(Map status: statusList){
            Status s = new Status();
            s.setId(toIntExact((Long)(status.get("id"))));
            s.setUser_id(toIntExact((Long)(status.get("user_id"))));
            s.setName((String) status.get("name"));
            s.setUsername((String) status.get("username"));
            s.setProfile_pic((String) status.get("profile_pic"));
            s.setMessage((String) status.get("message"));
            s.setLocation((int) status.get("location"));
            s.setLikes((int)status.get("likes"));
            s.setLiked(checkLikedStatus(((Long)(status.get("user_id"))).intValue(),((Long)(status.get("id"))).intValue()));
            s.setDate((Timestamp) status.get("uploaded"));
            s.setGoing((String)status.get("going"));
            s.setMaybe((String)status.get("maybe"));
            s.setNot_going((String)status.get("not_going"));
            statuses.add(s);
        }
        return statuses;
    }

    public List<Status> getAllUserStatus(int id) {
        log.info("Getting statuses by id "+id);
        List<Status> statuses = new ArrayList<Status>();
        List<Map<String,Object>> statusList = jdbcTemplate.queryForList(GET_USER_POSTS, new Object[]{id});

        for(Map status: statusList){
            Status s = new Status();
            s.setId(toIntExact((Long)(status.get("id"))));
            s.setUser_id(toIntExact((Long)(status.get("user_id"))));
            s.setName((String) status.get("name"));
            s.setUsername((String) status.get("username"));
            s.setProfile_pic((String) status.get("profile_pic"));
            s.setMessage((String) status.get("message"));
            s.setLocation((int) status.get("location"));
            s.setLikes((int)status.get("likes"));
            s.setLiked(checkLikedStatus(((Long)(status.get("user_id"))).intValue(),((Long)(status.get("id"))).intValue()));
            s.setDate((Timestamp) status.get("uploaded"));
            s.setGoing((String)status.get("going"));
            s.setMaybe((String)status.get("maybe"));
            s.setNot_going((String)status.get("not_going"));
            statuses.add(s);
        }
        return statuses;
    }

    public List<Status> getAllUserProfileStatus(String username) {
        log.info("Getting statuses by username "+username);
        List<Status> statuses = new ArrayList<Status>();
        List<Map<String,Object>> statusList = jdbcTemplate.queryForList(GET_STATUS_BY_USERNAME, new Object[]{username});

        for(Map status: statusList){
            Status s = new Status();
            s.setId(toIntExact((Long)(status.get("id"))));
            s.setUser_id(toIntExact((Long)(status.get("user_id"))));
            s.setName((String) status.get("name"));
            s.setUsername((String) status.get("username"));
            s.setProfile_pic((String) status.get("profile_pic"));
            s.setMessage((String) status.get("message"));
            s.setLocation((int) status.get("location"));
            s.setLikes((int)status.get("likes"));
            s.setLiked(checkLikedStatus(((Long)(status.get("user_id"))).intValue(),((Long)(status.get("id"))).intValue()));
            s.setDate((Timestamp) status.get("uploaded"));
            s.setGoing((String)status.get("going"));
            s.setMaybe((String)status.get("maybe"));
            s.setNot_going((String)status.get("not_going"));
            statuses.add(s);
        }
        return statuses;
    }

    public void updateStatus(Status status) {
        log.info("Updating status");
        KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(UPDATE_STATUS, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, status.getUser_id());
            ps.setString(2, status.getMessage());
            ps.setInt(3, status.getLocation());
            ps.setInt(4, status.getLikes());
            ps.setTimestamp(5, status.getDate());
            ps.setString(6, status.getGoing());
            ps.setString(7, status.getMaybe());
            ps.setString(8, status.getNot_going());
            ps.setInt(9, status.getId());
            return ps;
        }, holder);
    }

    public void createStatus(Status status) {
        log.info("Inserting status");
        KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(INSERT_STATUS, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, status.getUser_id());
            ps.setString(2, status.getMessage());
            ps.setInt(3, status.getLocation());
            ps.setInt(4, status.getLikes());
            ps.setTimestamp(5, status.getDate());
            ps.setString(6, status.getGoing());
            ps.setString(7, status.getMaybe());
            ps.setString(8, status.getNot_going());
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

    public boolean checkLikedStatus(int id, int status_id) {
        int check = jdbcTemplate.queryForObject(CHECK_LIKED_STATUS, new Object[]{id,status_id}, Integer.class);

        if(check ==1){
            return true;
        }
        return false;
    }

    public void likeStatus(int id, int status_id) {
        log.info("User: "+id+" likes status: "+status_id);
        KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(LIKE_STATUS, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ps.setInt(2, status_id);
            return ps;
        }, holder);

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(LIKE_STATUS_INCREMENT, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, status_id);
            return ps;
        }, holder);
    }

    public void unlikeStatus(int id, int status_id) {
        KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(UNLIKE_STATUS, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ps.setInt(2, status_id);
            return ps;
        }, holder);

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(UNLIKE_STATUS_DECREMENT, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, status_id);
            return ps;
        }, holder);

    }
}

class StatusMapper implements RowMapper {

    @Override
    public Status mapRow(ResultSet rs, int rowNum) throws SQLException {
        Status status = new Status();
        status.setUser_id(rs.getInt("user_id"));
        status.setMessage(rs.getString("message"));
        status.setLocation(rs.getInt("location"));
        status.setLikes(rs.getInt("likes"));
        status.setDate(rs.getTimestamp("uploaded"));
        status.setGoing(rs.getString("going"));
        status.setMaybe(rs.getString("maybe"));
        status.setNot_going(rs.getString("not_going"));
        return status;
    }
}
