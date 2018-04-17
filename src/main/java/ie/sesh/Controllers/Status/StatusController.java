package ie.sesh.Controllers.Status;

import com.google.gson.Gson;

import ie.sesh.Models.Status.Status;
import ie.sesh.Services.Status.StatusService;
import ie.sesh.Utils.CommonUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StatusController {

    @Autowired
    StatusService statusService;

    @PostMapping("/get/status")
    @ResponseBody
    public Status getStatus(@RequestParam(name="id") int id) {
        return statusService.getStatus(id);
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
    public boolean createStatus(@RequestBody String status_data) {
        Gson gson = CommonUtils.convertDate(status_data);
        Status status = gson.fromJson(status_data, Status.class);
        statusService.createStatus(status);
        return true;
    }

    @PostMapping("/delete/status")
    @ResponseBody
    public boolean deleteStatus(@RequestParam(name="id") int id) {
        statusService.deleteStatus(id);
        return true;
    }
}
