package Models.Users;

public interface UserDAO {
    User getUser(int id);
    void updateUser(User user);
}
