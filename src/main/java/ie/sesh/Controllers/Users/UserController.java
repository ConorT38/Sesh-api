package ie.sesh.Controllers.Users;

import com.google.gson.Gson;
import ie.sesh.Models.Users.User;
import ie.sesh.Services.Users.UserService;
import ie.sesh.Utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/get/user")
    @ResponseBody
    public User getUser(@RequestParam(name="id") int id) {
        return userService.getUser(id);
    }

    @PostMapping("/update/user")
    @ResponseBody
    public boolean updateUser(@RequestBody String user_data) {
        Gson gson = UserUtils.convertDate(user_data);
        User user = gson.fromJson(user_data, User.class);
        userService.updateUser(user);
        return true;
    }

    @PostMapping("/create/user")
    @ResponseBody
    public boolean createUser(@RequestBody String user_data) {
        Gson gson = UserUtils.convertDate(user_data);
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
