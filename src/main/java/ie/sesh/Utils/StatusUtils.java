package ie.sesh.Utils;

import ie.sesh.Models.Status.Status;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.text.ParseException;

@Component
public class StatusUtils {

    public Status buildStatus(String status_data) throws ParseException{
        int user_id =  Integer.parseInt(new JSONObject(status_data).getJSONArray("id").get(0).toString());
        String message =  new JSONObject(status_data).getJSONArray("message").get(0).toString();
        int location =  Integer.parseInt(new JSONObject(status_data).getJSONArray("location").get(0).toString());
        int likes =  Integer.parseInt(new JSONObject(status_data).getJSONArray("likes").get(0).toString());
        Timestamp date =  new Timestamp(new java.util.Date().getTime());
        String going =  new JSONObject(status_data).getJSONArray("going").get(0).toString();
        String maybe =  new JSONObject(status_data).getJSONArray("maybe").get(0).toString();
        String not_going =  new JSONObject(status_data).getJSONArray("not_going").get(0).toString();

        return new Status(user_id,message,location,likes,date,going,maybe,not_going);
    }
}
