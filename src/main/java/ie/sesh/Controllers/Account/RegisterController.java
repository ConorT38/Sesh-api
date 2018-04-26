package ie.sesh.Controllers.Account;

import ie.sesh.Utils.Authentication;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {

    private static final Logger log = Logger.getLogger(RegisterController.class);

    @Autowired
    RegisterDAO registerDAO;

    @PostMapping("/register/user")
    @ResponseBody
    public String registerUser(@RequestBody String user_data) throws Exception{

        final JSONObject obj = new JSONObject(user_data);

        log.info("Submitted data: "+user_data);

        //String username = Authentication.encrypt(obj.getJSONArray("username").get(0).toString());
        //String password = Authentication.hashPassword(obj.getJSONArray("password").get(0).toString());
        //String email = Authentication.encrypt(obj.getJSONArray("email").get(0).toString());
        //String name = Authentication.encrypt(obj.getJSONArray("name").get(0).toString());

        String username = obj.getJSONArray("username").get(0).toString();
        String password = obj.getJSONArray("password").get(0).toString();
        String email = obj.getJSONArray("email").get(0).toString();
        String name = obj.getJSONArray("name").get(0).toString();

        log.info("NAME: "+name+"  HAS BEEN ADDED");
        boolean result = registerDAO.registerUser(name,username,email,password);
        if(result){
            return "true";
        }else {
            return "false";
        }
    }
}
