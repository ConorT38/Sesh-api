package ie.sesh.Utils;

import ie.sesh.Models.Status.Status;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class StatusUtils {

    public Status buildStatus(String status_data){
        int user_id =  (int) checkIsNullEmpty(Integer.parseInt(new JSONObject(status_data).getJSONArray("id").get(0).toString()),0);
        String name = "";
        String username = "";
        String message = (String) checkIsNullEmpty(new JSONObject(status_data).getJSONArray("message").get(0).toString(),"");
        int location = (int) checkIsNullEmpty(Integer.parseInt(new JSONObject(status_data).getJSONArray("location").get(0).toString()),0);
        int likes = (int) checkIsNullEmpty(Integer.parseInt(new JSONObject(status_data).getJSONArray("likes").get(0).toString()),0);
        Timestamp date = new Timestamp(new java.util.Date().getTime());
        String going = (String) checkIsNullEmpty(new JSONObject(status_data).getJSONArray("going").get(0).toString(),"");
        String maybe = (String) checkIsNullEmpty(new JSONObject(status_data).getJSONArray("maybe").get(0).toString(),"");
        String not_going = (String) checkIsNullEmpty(new JSONObject(status_data).getJSONArray("not_going").get(0).toString(),"");

        return new Status(user_id,name,username,message,location,likes,date,going,maybe,not_going);
    }


    public Object checkIsNullEmpty(Object value, Object def){
        return (!value.toString().isEmpty() || value.toString() !=null) ? value : def;
    }
}
