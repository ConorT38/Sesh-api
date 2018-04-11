package ie.sesh.Models.Users;

public interface UserDAO {
    User getUser(int id);
    void createUser(User user);
    void updateUser(User user);
    void deleteUser(int id);
}
