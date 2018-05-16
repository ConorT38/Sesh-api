package ie.sesh.Models.Users;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDAO {
    User getUser(int id);
    void createUser(User user);
    void updateUser(User user);
    void deleteUser(int id);
    List<User> getAllRecommendedUsers(int id);
    void followUser(int id, int user_id);
    List<User> getOnlineUsers(int id);
    User getUserProfile(String username);
}
