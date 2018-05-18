package ie.sesh.Controllers.Status;

import com.google.gson.Gson;

import ie.sesh.Models.Status.Status;
import ie.sesh.Services.Status.StatusService;
import ie.sesh.Utils.CommonUtils;
import ie.sesh.Utils.StatusUtils;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StatusController {

    private static final Logger log = Logger.getLogger(StatusController.class);

    @Autowired
    StatusService statusService;

    @Autowired
    StatusUtils statusUtils;

    @PostMapping("/get/status")
    @ResponseBody
    public Status getStatus(@RequestParam(name="id") int id) {
        return statusService.getStatus(id);
    }

    @PostMapping("/get/all/status")
    @ResponseBody
    public List<Status> getAllStatus(@RequestBody String user_data) {
        int id = Integer.parseInt(new JSONObject(user_data).getJSONArray("id").get(0).toString());
        List<Status> statuses= statusService.getAllStatus(id);
        for(int i=0; i<statuses.size(); i++) {
            log.info("STATUSES: " + statuses.get(i).getMessage());
        }
        return statusService.getAllStatus(id);
    }

    @PostMapping("/get/all/user/status")
    @ResponseBody
    public List<Status> getAllUserStatus(@RequestBody String user_data) {
        int id = Integer.parseInt(new JSONObject(user_data).getJSONArray("id").get(0).toString());
        List<Status> statuses= statusService.getAllUserStatus(id);
        for(int i=0; i<statuses.size(); i++) {
            log.info("STATUSES: " + statuses.get(i).getMessage());
        }
        return statusService.getAllUserStatus(id);
    }

    @PostMapping("/get/all/user/status/@{username}")
    @ResponseBody
    public List<Status> getAllUserProfileStatus(@PathVariable("username") String username) {
        List<Status> statuses= statusService.getAllUserProfileStatus(username);
        for(int i=0; i<statuses.size(); i++) {
            log.info("STATUSES: " + statuses.get(i).getMessage());
        }
        return statusService.getAllUserProfileStatus(username);
    }

    @PostMapping("/update/status")
    @ResponseBody
    public boolean updateStatus(@RequestBody String status_data) {
        Gson gson = CommonUtils.convertDate(status_data);
        Status status = gson.fromJson(status_data, Status.class);
        statusService.updateStatus(status);
        return true;
    }

    @PostMapping("/create/status")
    @ResponseBody
    public boolean createStatus(@RequestBody String status_data){
        try {
            Status status = statusUtils.buildStatus(status_data);
            statusService.createStatus(status);
            return true;
        }catch (Exception e){
            log.error(e.getMessage());
            return false;
        }
    }

    @PostMapping("/delete/status")
    @ResponseBody
    public boolean deleteStatus(@RequestParam(name="id") int id) {
        statusService.deleteStatus(id);
        return true;
    }

    @PostMapping("/check/liked/status")
    @ResponseBody
    public boolean checkLikedStatus(@RequestBody String status_data) {
        int id = Integer.parseInt(new JSONObject(status_data).getJSONArray("id").get(0).toString());
        int comment_id = Integer.parseInt(new JSONObject(status_data).getJSONArray("status_id").get(0).toString());

        return  statusService.checkLikedStatus(id,comment_id);
    }
}
