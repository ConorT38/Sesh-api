package ie.sesh.Models.Users.Impl;

import ie.sesh.Models.Users.User;
import ie.sesh.Models.Users.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@PropertySource("classpath:/sql-query.properties")
@Repository
public class UserDAOImpl implements UserDAO{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Value("${user.createuser}")
    private String message;

    @Override
    public User getUser(int id) {
        System.out.println("Hey LOOK:   "+message);
        return new User();
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void createUser(User user) {

    }

    @Override
    public void deleteUser(int id) {

    }
}
