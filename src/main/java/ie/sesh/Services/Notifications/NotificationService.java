package ie.sesh.Services.Notifications;

import ie.sesh.Models.Notifications.Notification;
import ie.sesh.Models.Notifications.NotificationDAO;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    private static final Logger log = Logger.getLogger(NotificationService.class);

    @Autowired
    NotificationDAO notificationDAO;

    public NotificationService() {
    }

    public Notification getNotification(int user_id){
        return notificationDAO.getNotification(user_id);
    }

    public List<Notification> getAllNotifications(int user_id){
        return notificationDAO.getAllNotifications(user_id);
    }

    public boolean createNotification(Notification notification){
        return notificationDAO.createNotification(notification);
    }

    public boolean hideNotification(int notification_id){
        return notificationDAO.hideNotification(notification_id);
    }

    public boolean readNotification(int notification_id){
        return notificationDAO.readNotification(notification_id);
    }
}
