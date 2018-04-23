package ie.sesh.Controllers.Account;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @PostMapping("/login")
    @ResponseBody
    public boolean login(@RequestBody String login_data) {
        System.out.println(login_data);
        // JSONObject obj = new JSONObject(login_data);
        //System.out.println("USERNAME======="+obj.getString("username"));
        //final JSONArray geodata = obj.getJSONArray("geodata");
       /* final int n = geodata.length();
        for (int i = 0; i < n; ++i) {
            final JSONObject person = geodata.getJSONObject(i);
            System.out.println(person.getInt("id"));
            System.out.println(person.getString("name"));
            System.out.println(person.getString("gender"));
            System.out.println(person.getDouble("latitude"));
            System.out.println(person.getDouble("longitude"));
        }*/

        return true;
    }

}
