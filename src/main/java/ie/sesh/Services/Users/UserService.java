package ie.sesh.Services.Users;

import ie.sesh.Models.Users.Impl.UserDAOImpl;
import ie.sesh.Models.Users.User;
import ie.sesh.Models.Users.UserDAO;

public class UserService {

    public UserService() {
    }

    public User getUser(int id){
        UserDAO userDao = new UserDAOImpl();
        return userDao.getUser(id);
    }

    public void updateUser(User user){
        UserDAO userDao = new UserDAOImpl();
        userDao.updateUser(user);
    }

    public void createUser(User user){
        UserDAO userDao = new UserDAOImpl();
        userDao.createUser(user);
    }

    public void deleteUser(int id){
        UserDAO userDao = new UserDAOImpl();
        userDao.deleteUser(id);
    }
}
