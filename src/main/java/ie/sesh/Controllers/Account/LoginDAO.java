package ie.sesh.Controllers.Account;

import org.springframework.stereotype.Repository;

@Repository
public interface LoginDAO {

    Object login(String username, String password) throws Exception;
    void logout(String id) throws Exception;
    boolean checkLogged(String cookie) throws Exception;
}
