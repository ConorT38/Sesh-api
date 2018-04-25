package ie.sesh.Controllers.Account.Impl;

import ie.sesh.Controllers.Account.LoginDAO;
import ie.sesh.Utils.Authentication;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;


import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Base64;
import java.util.UUID;

import static ie.sesh.Database.SQLConstants.*;

@Component
public class LoginDAOImpl implements LoginDAO {
    private static final Logger log = Logger.getLogger(LoginDAOImpl.class);

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Object login(String username, String password) throws Exception{
        log.info("Attempting Login");

        int count = jdbcTemplate.queryForObject(LOGIN_ATTEMPT, new Object[] {username,password}, Integer.class);

        if (count == 1) {
            int id = jdbcTemplate.queryForObject(LOGIN_SUCCESS, new Object[] {username,password}, Integer.class);
            final String uuid = UUID.randomUUID().toString().replace("-", "");

            KeyHolder holder = new GeneratedKeyHolder();
            jdbcTemplate.update(connection -> {
                PreparedStatement ps = connection.prepareStatement(LOG_LOGIN_SUCCESS_FIRST, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, uuid);
                ps.setInt(2, id);
                return ps;
            }, holder);
            return uuid;
        }
        return false;
    }

    @Override
    public boolean checkLogged(String cookie) throws Exception {
       // cookie = Authentication.decrypt(cookie);
        final JSONObject obj = new JSONObject(cookie);
        String sesh = obj.getJSONArray("sesh").get(0).toString();
        System.out.println("COOKIE: "+sesh);
        sesh = new String(Base64.getDecoder().decode(sesh));

        int count = jdbcTemplate.queryForObject(GET_LOGIN_TOKEN_ATTEMPT, new Object[] {sesh}, Integer.class);
        if(count == 1){
            return true;
        }
        return false;
    }
}