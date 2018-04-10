package Services.Users;

import Models.Users.Impl.UserDAOImpl;
import Models.Users.User;
import Models.Users.UserDAO;

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
}
