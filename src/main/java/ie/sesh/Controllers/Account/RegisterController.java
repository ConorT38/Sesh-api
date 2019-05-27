package ie.sesh.Controllers.Account;

import ie.sesh.Utils.Authentication;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.core.env.Environment;

@RestController
public class RegisterController {

    private static final Logger log = Logger.getLogger(RegisterController.class);

    @Autowired
    RegisterDAO registerDAO;

    @Autowired
    Environment env;

    @PostMapping("/register/user")
    @ResponseBody
    public String registerUser(@RequestBody String user_data) throws Exception{

        final JSONObject obj = new JSONObject(user_data);
        String username;
        String password;
        String email;
        String name;

        log.info("Submitted data: "+user_data);

        if(env.getProperty("enable.encryption").equals("true")) {

             username = Authentication.encrypt(obj.getJSONArray("username").get(0).toString());
             password = Authentication.hashPassword(obj.getJSONArray("password").get(0).toString());
             email = Authentication.encrypt(obj.getJSONArray("email").get(0).toString());
             name = Authentication.encrypt(obj.getJSONArray("name").get(0).toString());
        }
        else {
             username = obj.getJSONArray("username").get(0).toString();
             password = obj.getJSONArray("password").get(0).toString();
             email = obj.getJSONArray("email").get(0).toString();
             name = obj.getJSONArray("name").get(0).toString();
        }

        log.info("NAME: "+name+"  HAS BEEN ADDED");
        if(registerDAO.registerUser(name,username,email,password)){
            return "true";
        }else {
            return "false";
        }
    }
}
