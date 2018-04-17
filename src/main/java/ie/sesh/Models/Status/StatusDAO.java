package ie.sesh.Models.Status;


public interface StatusDAO {

    Status getStatus(int id);
    void createStatus(Status status);
    void updateStatus(Status status);
    void deleteStatus(int id);
}
