package ie.sesh.Models.Users;

import javax.swing.tree.RowMapper;
import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper {

    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setName(rs.getString("name"));
        user.setAge(rs.getInt("age"));
        user.setDob(rs.getDate("dob"));
        user.setFavourite_drink(rs.getString("favourite_drink"));
       // user.setLocation(rs.getInt("location"));
        user.setRating(rs.getFloat("rating"));
        return user;
    }

    public int[] getRowsForPaths(TreePath[] path) {
        return new int[0];
    }
}
