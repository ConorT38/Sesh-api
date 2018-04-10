package Controllers.Users;

import Models.Users.User;
import Services.Users.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @PostMapping("/get/user")
    public User getUser(@RequestParam(name="id") int id) {
        return new UserService().getUser(id);
    }

    @PostMapping("/update/user")
    public User updateUser(@RequestParam(name="user") User user) {
        return new UserService().updateUser(user);
    }
}
