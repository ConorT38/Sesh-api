package ie.sesh.Utils;

import ie.sesh.Models.Status.Status;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class StatusUtils {

    public Status buildStatus(String status_data){
        int id = (int) getItem(status_data,"id", 0);
        int user_id =  (int) getItem(status_data,"user_id", 0);
        String message = (String) getItem(status_data,"message", "");
        int location = (int) getItem(status_data,"location", 0);
        int likes = (int) getItem(status_data,"likes", 0);
        Timestamp date = new Timestamp(new java.util.Date().getTime());
        String going = (String) getItem(status_data,"going", "");
        String maybe = (String) getItem(status_data,"maybe", "");
        String not_going = (String) getItem(status_data,"not_going", "");

        return new Status(id,user_id,"","","",message,location,likes,false,date,going,maybe,not_going);
    }


    private Object checkIsNullEmpty(Object value, Object def){
        return (!value.toString().isEmpty() || value.toString() !=null) ? value : def;
    }

    private Object getItem(String status_data, String item, Object def){
        if(def instanceof String) {
            return checkIsNullEmpty(new JSONObject(status_data).getJSONArray(item).get(0).toString(), def);
        }else{
            return checkIsNullEmpty(Integer.parseInt(new JSONObject(status_data).getJSONArray(item).get(0).toString()), def);
        }
    }
}
