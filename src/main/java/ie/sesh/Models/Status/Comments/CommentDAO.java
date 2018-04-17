package ie.sesh.Models.Status.Comments;

public interface CommentDAO {

    Comment getComment(int id);
    void createComment(Comment comment);
    void updateComment(Comment comment);
    void deleteComment(int id);
}
