package ie.sesh.Controllers.Account;

import org.springframework.stereotype.Repository;

@Repository
public interface RegisterDAO {

    boolean registerUser(String name, String username, String email, String password);
}
