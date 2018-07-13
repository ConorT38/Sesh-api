package ie.sesh.Controllers.Notification;

import ie.sesh.Models.Notifications.Notification;
import ie.sesh.Services.Notifications.NotificationService;
import ie.sesh.Utils.CommonUtils;
import ie.sesh.Utils.NotificationUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NotificationController {
    private static final Logger log = Logger.getLogger(NotificationController.class);

    @Autowired
    NotificationService notificationService;

    @Autowired
    NotificationUtils notificationUtils;

    @PostMapping("/get/notifications")
    @ResponseBody
    public Notification getNotification(@RequestParam(name="id") int id) {
        return notificationService.getNotification(id);
    }

    @PostMapping("/get/all/notifications")
    @ResponseBody
    public List<Notification> getAllNotifications(@RequestBody String user_data) {
        int id = CommonUtils.parseIntFromJSON(user_data,"id");
        return notificationService.getAllNotifications(id);
    }

    @PostMapping("/create/notification")
    @ResponseBody
    public boolean createNotification(@RequestBody String notification_data) {
        return notificationService.createNotification(notificationUtils.buildNotification(notification_data));
    }
}
