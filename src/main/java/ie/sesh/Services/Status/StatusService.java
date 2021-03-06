package ie.sesh.Services.Status;

import ie.sesh.Models.Status.Status;
import ie.sesh.Models.Status.StatusDAO;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusService {

    private static final Logger log = Logger.getLogger(StatusService.class);

    @Autowired
    StatusDAO statusDAO;

    public StatusService() {
    }

    public Status getStatus(int id){
        return statusDAO.getStatus(id);
    }

    public List<Status> getAllStatus(int id){
        return statusDAO.getAllStatus(id);
    }

    public List<Status> getAllUserStatus(int id){
        return statusDAO.getAllUserStatus(id);
    }

    public List<Status> getAllUserProfileStatus(String username){
        return statusDAO.getAllUserProfileStatus(username);
    }

    public void updateStatus(Status status){
        statusDAO.updateStatus(status);
    }

    public void createStatus(Status status){
        statusDAO.createStatus(status);
    }

    public void deleteStatus(int id){
        statusDAO.deleteStatus(id);
    }

    public boolean checkLikedStatus(int id, int status_id){
        return statusDAO.checkLikedStatus(id, status_id);
    }

    public void likeStatus(int id, int status_id){
        statusDAO.likeStatus(id, status_id);
    }

    public void unlikeStatus(int id, int status_id){
        statusDAO.unlikeStatus(id, status_id);
    }
}
