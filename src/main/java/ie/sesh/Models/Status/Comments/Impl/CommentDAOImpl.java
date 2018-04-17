package ie.sesh.Models.Status.Comments.Impl;

import ie.sesh.Models.Status.Comments.Comment;

import ie.sesh.Models.Status.Comments.CommentDAO;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static ie.sesh.Database.SQLConstants.*;

@Component
public class CommentDAOImpl implements CommentDAO{

    private static final Logger log = Logger.getLogger(CommentDAOImpl.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Comment getComment(int id) {
        log.info("Getting comment");
        return (Comment)jdbcTemplate.queryForObject(GET_STATUS_COMMENT_BY_ID, new Object[] {id}, new CommentMapper());
    }

    public void updateComment(Comment comment) {
        log.info("Updating comment");
        KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(UPDATE_STATUS_COMMENT, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, comment.getStatus_id());
            ps.setInt(2, comment.getUser_id());
            ps.setString(3, comment.getMessage());
            ps.setInt(4, comment.getLikes());
            ps.setDate(5, comment.getDate());
            return ps;
        }, holder);
    }

    public void createComment(Comment comment) {
        log.info("Inserting comment");
        KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(INSERT_STATUS_COMMENT, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, comment.getStatus_id());
            ps.setInt(2, comment.getUser_id());
            ps.setString(3, comment.getMessage());
            ps.setInt(4, comment.getLikes());
            ps.setDate(5, comment.getDate());
            return ps;
        }, holder);
    }

    public void deleteComment(int id) {
        log.info("Deleting comment");
        KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(DELETE_STATUS_COMMENT, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            return ps;
        }, holder);
    }
}

class CommentMapper implements RowMapper {

    @Override
    public Comment mapRow(ResultSet rs, int rowNum) throws SQLException {
        Comment comment = new Comment();
        comment.setStatus_id(rs.getInt("status_id"));
        comment.setUser_id(rs.getInt("user_id"));
        comment.setMessage(rs.getString("message"));
        comment.setLikes(rs.getInt("likes"));
        comment.setDate(rs.getDate("uploaded"));
        return comment;
    }
}
