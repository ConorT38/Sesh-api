package ie.sesh.Models.Notifications;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationDAO {

    Notification getNotification(int user_id);
    List<Notification> getAllNotifications(int user_id);

    boolean createNotification(Notification notification);
    boolean hideNotification(int notification_id);
    boolean readNotification(int notification_id);
    boolean unhideNotification(int notification_id);
    boolean unreadNotification(int notification_id);

}
