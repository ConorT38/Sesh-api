package ie.sesh.Services.Status;

import ie.sesh.Models.Status.Status;
import ie.sesh.Models.Status.StatusDAO;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void updateStatus(Status status){
        statusDAO.updateUser(status);
    }

    public void createStatus(Status status){
        statusDAO.createStatus(status);
    }

    public void deleteStatus(int id){
        statusDAO.deleteStatus(id);
    }
}
