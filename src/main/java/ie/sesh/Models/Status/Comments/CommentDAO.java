package ie.sesh.Models.Status.Comments;

import java.util.List;

public interface CommentDAO {

    Comment getComment(int id);
    List<Comment> getAllStatusComments(int id);
    void createComment(Comment comment);
    void updateComment(Comment comment);
    void deleteComment(int id);
}
