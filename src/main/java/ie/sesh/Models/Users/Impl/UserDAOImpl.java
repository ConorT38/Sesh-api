package ie.sesh.Models.Users.Impl;

import ie.sesh.Models.Users.User;
import ie.sesh.Models.Users.UserDAO;
import ie.sesh.Database.SQLConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import static ie.sesh.Database.SQLConstants.INSERT_USER;

@PropertySource("classpath:/sql-query.properties")
@Repository
public class UserDAOImpl implements UserDAO{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public User getUser(int id) {
        System.out.println("Hey LOOK:   ");
        return new User();
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void createUser(User user) {
        KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(INSERT_USER, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getName());
            ps.setInt(2,user.getAge());
            ps.setDate(3,user.getDob());
            ps.setString();
            int date float string int
            return ps;
        }, holder);

        int newUserId = holder.getKey().intValue();
        user.setId(newUserId);
    }

    @Override
    public void deleteUser(int id) {

    }
}
