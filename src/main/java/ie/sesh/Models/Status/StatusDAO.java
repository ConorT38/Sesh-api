package ie.sesh.Models.Status;


import java.util.List;

public interface StatusDAO {

    Status getStatus(int id);
    List<Status> getAllStatus(int id);
    List<Status> getAllUserStatus(int id);
    List<Status> getAllUserProfileStatus(String username);
    void createStatus(Status status);
    void updateStatus(Status status);
    void deleteStatus(int id);
    boolean checkLikedStatus(int id, int status_id);
    void likeStatus(int id, int status_id);
    void unlikeStatus(int id, int status_id);
}
