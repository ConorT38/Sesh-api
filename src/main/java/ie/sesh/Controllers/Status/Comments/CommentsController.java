package ie.sesh.Controllers.Status.Comments;

import com.google.gson.Gson;

import ie.sesh.Models.Status.Comments.Comment;
import ie.sesh.Models.Status.Status;
import ie.sesh.Services.Status.Comments.CommentService;
import ie.sesh.Utils.CommentUtils;
import ie.sesh.Utils.CommonUtils;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentsController {
    private static final Logger log = Logger.getLogger(CommentsController.class);

    @Autowired
    CommentService commentService;

    @Autowired
    CommentUtils commentUtils;

    @PostMapping("/get/comment")
    @ResponseBody
    public Comment getComment(@RequestParam(name="id") int id) {
        return commentService.getComment(id);
    }

    @PostMapping("/get/comments/{id}")
    @ResponseBody
    public List<Comment> getAllStatusComments(@PathVariable("id") String id) {

        List<Comment> comments = commentService.getAllStatusComments(Integer.parseInt(id));
        for(int i=0; i<comments.size(); i++) {
            log.info("STATUSES: " + comments.get(i).getMessage());
        }
        return commentService.getAllStatusComments(Integer.parseInt(id));
    }

    @PostMapping("/update/comment")
    @ResponseBody
    public boolean updateComment(@RequestBody String comment_data) {
        Gson gson = CommonUtils.convertDate(comment_data);
        Comment comment = gson.fromJson(comment_data, Comment.class);
        commentService.updateComment(comment);
        return true;
    }

    @PostMapping("/create/comment")
    @ResponseBody
    public boolean createComment(@RequestBody String comment_data){
        log.info("Comment: "+comment_data);
        try {
            Comment comment = commentUtils.buildComment(comment_data);
            commentService.createComment(comment);
            return true;
        }catch (Exception e){
            log.error(e.getMessage());
            return false;
        }
    }

    @PostMapping("/delete/comment")
    @ResponseBody
    public boolean deleteComment(@RequestParam(name="id") int id) {
        commentService.deleteComment(id);
        return true;
    }
}
