package ie.sesh.Services.Users;

import ie.sesh.Models.Users.User;
import ie.sesh.Models.Users.UserDAO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private static final Logger log = Logger.getLogger(UserService.class);

    @Autowired
    UserDAO userDAO;

    public UserService() {
    }

    public User getUser(int id){
        return userDAO.getUser(id);
    }

    public void updateUser(User user){
        userDAO.updateUser(user);
    }

    public void createUser(User user){
        userDAO.createUser(user);
    }

    public void deleteUser(int id){
        userDAO.deleteUser(id);
    }

    public List<User> getAllRecommendedUsers(int id){
       return userDAO.getAllRecommendedUsers(id);
    }

    public void followUser(int id, int user_id){
        userDAO.followUser(id,user_id);
    }

    public List<User> getOnlineUsers(int id){
        return userDAO.getOnlineUsers(id);
    }

    public User getUserProfile(String username){
        return userDAO.getUserProfile(username);
    }
}
