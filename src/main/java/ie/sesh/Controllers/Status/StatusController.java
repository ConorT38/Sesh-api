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

import java.text.ParseException;
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
        }catch(ParseException e){
            return false;
        }catch (Exception e){
            return false;
        }
    }

    @PostMapping("/delete/status")
    @ResponseBody
    public boolean deleteStatus(@RequestParam(name="id") int id) {
        statusService.deleteStatus(id);
        return true;
    }
}
