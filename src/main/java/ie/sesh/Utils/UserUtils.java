package ie.sesh.Utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class UserUtils {

    public static Gson convertDate(String user_data){
        return new GsonBuilder().setDateFormat("yyyy-MM-dd").create();

    }
}
