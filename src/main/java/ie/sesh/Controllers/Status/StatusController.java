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
        int id = CommonUtils.parseIntFromJSON(user_data,"id");
        return statusService.getAllStatus(id);
    }

    @PostMapping("/get/all/user/status")
    @ResponseBody
    public List<Status> getAllUserStatus(@RequestBody String user_data) {
        int id = CommonUtils.parseIntFromJSON(user_data,"id");
        return statusService.getAllUserStatus(id);
    }

    @PostMapping("/get/all/user/status/@{username}")
    @ResponseBody
    public List<Status> getAllUserProfileStatus(@PathVariable("username") String username) {
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
        int id = CommonUtils.parseIntFromJSON(status_data,"id");
        int status_id = CommonUtils.parseIntFromJSON(status_data,"status_id");

        return  statusService.checkLikedStatus(id,status_id);
    }

    @PostMapping("/like/status")
    @ResponseBody
    public boolean likeStatus(@RequestBody String status_data){
        try {
            int id = CommonUtils.parseIntFromJSON(status_data,"id");
            int status_id = CommonUtils.parseIntFromJSON(status_data,"status_id");
            statusService.likeStatus(id,status_id);
            return true;
        }catch (Exception e){
            log.error(e.getMessage());
            return false;
        }
    }

    @PostMapping("/unlike/status")
    @ResponseBody
    public boolean unlikeStatus(@RequestBody String status_data){
        try {
            int id = CommonUtils.parseIntFromJSON(status_data,"id");
            int status_id = CommonUtils.parseIntFromJSON(status_data,"status_id");
            statusService.unlikeStatus(id,status_id);
            return true;
        }catch (Exception e){
            log.error(e.getMessage());
            return false;
        }
    }
}
