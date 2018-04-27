package ie.sesh.Controllers.Users;

import com.google.gson.Gson;
import ie.sesh.Models.Users.Impl.UserDAOImpl;
import ie.sesh.Models.Users.User;
import ie.sesh.Services.Users.UserService;
import ie.sesh.Utils.CommonUtils;
import ie.sesh.Utils.UserUtils;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private static final Logger log = Logger.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @PostMapping("/get/user")
    @ResponseBody
    public User getUser(@RequestBody String user_data) {
        log.info("id: "+user_data);
        int id =  Integer.parseInt(new JSONObject(user_data).getJSONArray("id").get(0).toString());
        return userService.getUser(id);
    }

    @PostMapping("/update/user")
    @ResponseBody
    public boolean updateUser(@RequestBody String user_data) {
        Gson gson = CommonUtils.convertDate(user_data);
        User user = gson.fromJson(user_data, User.class);
        userService.updateUser(user);
        return true;
    }

    @PostMapping("/create/user")
    @ResponseBody
    public boolean createUser(@RequestBody String user_data) {
        Gson gson = CommonUtils.convertDate(user_data);
        User user = gson.fromJson(user_data, User.class);
        userService.createUser(user);
        return true;
    }

    @PostMapping("/delete/user")
    @ResponseBody
    public boolean deleteUser(@RequestParam(name="id") int id) {
        userService.deleteUser(id);
        return true;
    }
}
