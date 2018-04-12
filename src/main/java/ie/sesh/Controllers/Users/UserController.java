package ie.sesh.Controllers.Users;

import ie.sesh.Models.Users.User;
import ie.sesh.Services.Users.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @PostMapping("/get/user")
    @ResponseBody
    public User getUser(@RequestParam(name="id") int id) {
        return new UserService().getUser(id);
    }

    @PostMapping("/update/user")
    @ResponseBody
    public boolean updateUser(@RequestParam(name="user") User user) {
        new UserService().updateUser(user);
        return true;
    }

    @PostMapping("/create/user")
    @ResponseBody
    public boolean createUser(@RequestParam(name="user") User user) {
        new UserService().createUser(user);
        return true;
    }

    @PostMapping("/delete/user")
    @ResponseBody
    public boolean deleteUser(@RequestParam(name="id") int id) {
        new UserService().deleteUser(id);
        return true;
    }
}
