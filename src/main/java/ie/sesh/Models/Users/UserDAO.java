package ie.sesh.Models.Users;

import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO {
    User getUser(int id);
    void createUser(User user);
    void updateUser(User user);
    void deleteUser(int id);
}
