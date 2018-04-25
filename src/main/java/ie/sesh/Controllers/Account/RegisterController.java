package ie.sesh.Controllers.Account;

import ie.sesh.Utils.Authentication;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {

    @Autowired
    RegisterDAO registerDAO;

    @PostMapping("/register/user")
    @ResponseBody
    public String registerUser(@RequestBody String user_data) {

        final JSONObject obj = new JSONObject(user_data);
        String username = obj.getJSONArray("username").get(0).toString();
        String password = obj.getJSONArray("password").get(0).toString();
        String email = obj.getJSONArray("username").get(0).toString();
        String name = obj.getJSONArray("password").get(0).toString();

        System.out.println("USERNAME: "+username+"  PASSWORD:  "+password);
        boolean result = registerDAO.registerUser(name,username,email,password);
        if(result){
            return "true";
        }else {
            return "false";
        }
    }
}
