package ie.sesh.Models.Notifications;

import java.util.List;

public interface NotificationDAO {

    Notification getNotification(int user_id);
    List<Notification> getAllNotifications(int user_id);

    boolean createNotification(Notification notification);
    boolean hideNotification(int notification_id);
    boolean readNotification(int notification_id);

}
