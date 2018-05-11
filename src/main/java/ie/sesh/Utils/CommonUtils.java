package ie.sesh.Utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.stereotype.Component;

@Component
public class CommonUtils {
    public static Gson convertDate(String user_data){
        return new GsonBuilder().setDateFormat("yyyy-MM-dd hh:mm").create();
    }

    public Object checkIsNullEmpty(Object value, Object def){
        if(value == null){
            return def;
        }
        return (value !=null || !value.equals(null)  || !value.toString().isEmpty() || value.toString() !=null) ? value : def;
    }
}
