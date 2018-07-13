package ie.sesh.Controllers.Account.Impl;

import ie.sesh.Controllers.Account.RegisterDAO;
import ie.sesh.Utils.Authentication;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.UUID;

import static ie.sesh.Database.SQLConstants.*;

@Component
public class RegisterDAOImpl implements RegisterDAO {
    private static final Logger log = Logger.getLogger(RegisterDAOImpl.class);

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public boolean registerUser(String name, String username, String email, String password) {
        log.info("Attempting Registration");

        log.info("Inserting user");
        KeyHolder holder = new GeneratedKeyHolder();
        if(jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(REGISTER_USER, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, password);
            ps.setString(4, username);
            return ps;
        }, holder) >0){
            if(jdbcTemplate.update(connection -> {
                PreparedStatement ps = connection.prepareStatement(REGISTER_USER_FEED, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, username);
                return ps;
            }, holder) >0){
                return true;
            }
        }
        return false;
    }
}
