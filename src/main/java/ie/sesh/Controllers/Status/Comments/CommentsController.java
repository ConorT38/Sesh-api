package ie.sesh.Controllers.Status.Comments;

import com.google.gson.Gson;

import ie.sesh.Models.Status.Comments.Comment;
import ie.sesh.Services.Status.Comments.CommentService;
import ie.sesh.Utils.CommonUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CommentsController {

    @Autowired
    CommentService commentService;

    @PostMapping("/get/comment")
    @ResponseBody
    public Comment getComment(@RequestParam(name="id") int id) {
        return commentService.getComment(id);
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
    public boolean createComment(@RequestBody String comment_data) {
        Gson gson = CommonUtils.convertDate(comment_data);
        Comment comment = gson.fromJson(comment_data, Comment.class);
        commentService.createComment(comment);
        return true;
    }

    @PostMapping("/delete/comment")
    @ResponseBody
    public boolean deleteComment(@RequestParam(name="id") int id) {
        commentService.deleteComment(id);
        return true;
    }
}
