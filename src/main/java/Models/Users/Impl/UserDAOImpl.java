package Models.Users.Impl;

import Models.Users.User;
import Models.Users.UserDAO;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO{

    @Override
    public User getUser(int id) {
        return new User();
    }

    @Override
    public void updateUser(User user) {

    }
}
