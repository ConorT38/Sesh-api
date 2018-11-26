package ie.sesh.Utils;

import ie.sesh.Models.Notifications.Notification;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;


@Component
public class NotificationUtils {

    public Notification buildNotification(String notif_data){
        int id = (int) checkIsNullEmpty(Integer.parseInt(new JSONObject(notif_data).getJSONArray("id").get(0).toString()),0);
        int user_id =  (int) checkIsNullEmpty(Integer.parseInt(new JSONObject(notif_data).getJSONArray("user_id").get(0).toString()),0);
        int[] source_users = splitStringToIntArr((String) checkIsNullEmpty(Integer.parseInt(new JSONObject(notif_data).getJSONArray("source_users").get(0).toString()),""));

        String notification_type = (String) checkIsNullEmpty(Integer.parseInt(new JSONObject(notif_data).getJSONArray("type").get(0).toString()),"");
        String notification_data = (String) checkIsNullEmpty(Integer.parseInt(new JSONObject(notif_data).getJSONArray("data").get(0).toString()),"");

        boolean hide_notification = false;
        boolean read_notification = false;

        Timestamp date =  new Timestamp(new java.util.Date().getTime());

        return new Notification(id, user_id, source_users, notification_type, notification_data, hide_notification, read_notification, date);
    }


    public Object checkIsNullEmpty(Object value, Object def){
        return (!value.toString().isEmpty() || value.toString() !=null) ? value : def;
    }

    public static int[] splitStringToIntArr(String str){
        String[] strArr = str.split(",");
        int[] numArr = new int[strArr.length];
        for(int i=0; i<strArr.length; i++){
            numArr[i] = Integer.parseInt(strArr[i]);
        }
        return numArr;
    }
}
