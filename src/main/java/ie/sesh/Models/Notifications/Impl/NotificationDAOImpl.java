package ie.sesh.Models.Notifications.Impl;

import ie.sesh.Models.Notifications.Notification;
import ie.sesh.Models.Notifications.NotificationDAO;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static ie.sesh.Database.SQLConstants.GET_ALL_NOTIFICATIONS_BY_ID;
import static ie.sesh.Database.SQLConstants.GET_NOTIFICATION_BY_ID;
import static ie.sesh.Utils.NotificationUtils.splitStringToIntArr;
import static java.lang.Math.toIntExact;

public class NotificationDAOImpl implements NotificationDAO {

    private static final Logger log = Logger.getLogger(NotificationDAOImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public Notification getNotification(int notification_id) {
        log.info("Getting notification by id "+notification_id);
        return (Notification)jdbcTemplate.queryForObject(GET_NOTIFICATION_BY_ID, new Object[] {notification_id}, new NotificationMapper());

    }

    public List<Notification> getAllNotifications(int user_id) {
        log.info("Getting notifications by id "+user_id);
        List<Notification> notifications = new ArrayList<Notification>();
        List<Map<String,Object>> notificationList = jdbcTemplate.queryForList(GET_ALL_NOTIFICATIONS_BY_ID, new Object[]{user_id});

        for(Map notification: notificationList){
            Notification n = new Notification();
            n.setId(toIntExact((Long)(notification.get("id"))));
            n.setUser_id(toIntExact((Long)(notification.get("user_id"))));
            n.setSource_users(splitStringToIntArr((String) notification.get("source_users")));
            n.setNotification_type((String) notification.get("type"));
            n.setNotification_data((String) notification.get("data"));
            n.setHide_notification((boolean) notification.get("hidden"));
            n.setRead_notification((boolean) notification.get("seen"));
            n.setDate((Timestamp) notification.get("uploaded"));
            notifications.add(n);
        }
        return notifications;
    }

    public boolean createNotification(Notification notification) {
        return false;
    }

    public boolean hideNotification(int notification_id) {
        return false;
    }

    public boolean readNotification(int notification_id) {
        return false;
    }

}
class NotificationMapper implements RowMapper {

    @Override
    public Notification mapRow(ResultSet rs, int rowNum) throws SQLException {
        Notification n = new Notification();
        n.setId(toIntExact(rs.getInt("id")));
        n.setUser_id(toIntExact(rs.getInt("user_id")));
        n.setSource_users(splitStringToIntArr(rs.getString("source_users")));
        n.setNotification_type(rs.getString("type"));
        n.setNotification_data(rs.getString("data"));
        n.setHide_notification(rs.getBoolean("hidden"));
        n.setRead_notification(rs.getBoolean("seen"));
        n.setDate(rs.getTimestamp("uploaded"));
        return n;
    }
}