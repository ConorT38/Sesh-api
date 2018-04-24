package ie.sesh.Controllers.Account;

import ie.sesh.Utils.Authentication;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    LoginDAO loginDAO;

    @PostMapping("/login")
    @ResponseBody
    public String login(@RequestBody String login_data) throws Exception {

        final JSONObject obj = new JSONObject(login_data);
        String username = Authentication.encrypt(obj.getJSONArray("username").get(0).toString());
        String password = Authentication.encrypt(obj.getJSONArray("password").get(0).toString());

        System.out.println("USERNAME: "+username+"  PASSWORD:  "+password);
        Object result = loginDAO.login(username,password);
        if(result instanceof Boolean){
            return "false";
        }else {
            return result.toString();
        }
    }

    @PostMapping("/check/login")
    @ResponseBody
    public boolean checkLogin(@RequestBody String cookie_data) throws Exception {

        final JSONObject obj = new JSONObject(cookie_data);
        String cookie = obj.getJSONArray("sesh").get(0).toString();
        if(loginDAO.checkLogged(cookie_data)){
            return true;
        }
        return false;

    }

}
