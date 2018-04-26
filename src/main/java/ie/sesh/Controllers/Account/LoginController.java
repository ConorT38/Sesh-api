package ie.sesh.Controllers.Account;

import com.google.gson.Gson;
import ie.sesh.Utils.Authentication;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {

    private static final Logger log = Logger.getLogger(LoginController.class);


    @Autowired
    LoginDAO loginDAO;

    @PostMapping("/login")
    @ResponseBody
    public String login(@RequestBody String login_data) throws Exception {

        final JSONObject obj = new JSONObject(login_data);
        //String username = Authentication.encrypt(obj.getJSONArray("username").get(0).toString());
        //String password = Authentication.hashPassword(obj.getJSONArray("password").get(0).toString());

        String username = obj.getJSONArray("username").get(0).toString();
        String password = obj.getJSONArray("password").get(0).toString();

        log.info("USERNAME: "+username+"  PASSWORD:  "+password);
        Object result = loginDAO.login(username,password);
        if(result instanceof Boolean){
            return "false";
        }else {
            return new Gson().toJson(new HashMap((Map<String,String>)result));
        }
    }

    @PostMapping("/check/login")
    @ResponseBody
    public boolean checkLogin(@RequestBody String cookie_data) throws Exception {
        System.out.println(cookie_data);
        final JSONObject obj = new JSONObject(cookie_data);
        String cookie = obj.getJSONArray("sesh").get(0).toString();
        if(loginDAO.checkLogged(cookie_data)){
            return true;
        }
        return false;

    }

    @PostMapping("/logout")
    @ResponseBody
    public void logout(@RequestBody String logout_data) throws Exception {

        final JSONObject obj = new JSONObject(logout_data);
        //String username = Authentication.encrypt(obj.getJSONArray("username").get(0).toString());
        //String password = Authentication.encrypt(obj.getJSONArray("password").get(0).toString());

        String id = obj.getJSONArray("id").get(0).toString();

        System.out.println("ID: "+id);
        loginDAO.logout(id);
    }

}
