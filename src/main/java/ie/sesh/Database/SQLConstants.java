package ie.sesh.Database;

public class SQLConstants {

    public static final String INSERT_USER = " INSERT INTO users(name,age,dob,location,favourite_drink,rating) values(?,?,?,?,?,?);";
    public static final String UPDATE_USER = "UPDATE users SET name=?,age=?,dob=?,location=?,favourite_drink=?,rating=? WHERE id=?";
    public static final String GET_USER_BY_ID = "SELECT * FROM users WHERE id = ?";
    public static final String GET_USER_PROFILE_BY_USERNAME = "SELECT * FROM users WHERE username = ? LIMIT 1";
    public static final String DELETE_USER = "DELETE FROM users WHERE id=?";

    public static final String INSERT_LOCATION = "INSERT INTO location(name,address,website,geolocation,has_promotion,rating,visitors) values(?,?,?,?,?,?,?)";
    public static final String UPDATE_LOCATION = "UPDATE location SET name=?,address=?,website=?,geolocation=?,has_promotion=?,rating=?,visitors=? WHERE id=?";
    public static final String GET_LOCATION_BY_ID = "SELECT * FROM location WHERE id = ?";
    public static final String DELETE_LOCATION = "DELETE FROM location WHERE id=?";

    public static final String INSERT_STATUS = "INSERT INTO status(user_id,message,location,likes,uploaded,going,maybe,not_going) values(?,?,?,?,?,?,?,?)";
    public static final String UPDATE_STATUS = "UPDATE status SET user_id=?,message=?,location=?,likes=?,uploaded=?,going=?,maybe=?,not_going=? WHERE id=?";
    public static final String GET_STATUS_BY_ID = "SELECT * FROM status WHERE id = ?";
    public static final String GET_STATUS_BY_USERNAME= "SELECT * FROM status INNER JOIN users ON users.id=status.user_id WHERE users.username = ?";
    public static final String DELETE_STATUS = "DELETE FROM status WHERE id=?";

    public static final String INSERT_STATUS_COMMENT = "INSERT INTO comments (user_id, status_id, message, likes, uploaded) VALUES(?,?,?,?, NOW());";
    public static final String UPDATE_STATUS_COMMENT = "UPDATE comments SET status_id,user_id=?,message=?,likes=?,uploaded=? WHERE id=?";
    public static final String GET_STATUS_COMMENT_BY_ID = "SELECT * FROM comments WHERE id = ?";
    public static final String GET_ALL_STATUS_COMMENTS_BY_ID = "SELECT * FROM comments INNER JOIN users ON comments.user_id=users.id WHERE status_id = ?";
    public static final String DELETE_STATUS_COMMENT = "DELETE FROM comments WHERE id=?";

    public static final String INSERT_LOCATION_REVIEW = "INSERT INTO location_review(location_id,user_id,review,rating,uploaded) values(?,?,?,?,?)";
    public static final String UPDATE_LOCATION_REVIEW = "UPDATE location_review SET location_id=?,user_id=?,review=?,rating=?,uploaded=? WHERE id=?";
    public static final String GET_LOCATION_REVIEW_BY_ID = "SELECT * FROM location_review WHERE id = ?";
    public static final String DELETE_LOCATION_REVIEW = "DELETE FROM location_review WHERE id=?";

    public static final String INSERT_USER_REVIEW = "INSERT INTO user_review(user_id,reviewer_id,location_id,review,uploaded,rating) values(?,?,?,?,?,?)";
    public static final String UPDATE_USER_REVIEW = "UPDATE user_review SET user_id=?,reviewer_id=?,location_id=?,review=?,uploaded=?,rating=?, WHERE id=?";
    public static final String GET_USER_REVIEW_BY_ID = "SELECT * FROM user_review WHERE id = ?";
    public static final String DELETE_USER_REVIEW = "DELETE FROM user_review WHERE id=?";

    public static final String LOGIN_ATTEMPT = "SELECT COUNT(*) FROM users WHERE username = ? AND password = ?";
    public static final String LOGIN_SUCCESS = "SELECT id FROM users WHERE username = ? AND password = ?";
    public static final String GET_LOGIN_TOKEN_ATTEMPT = "SELECT COUNT(*) FROM logged_in WHERE token = ?";
    public static final String GET_LOGIN_TOKEN = "SELECT user_id FROM logged_in WHERE token = ?";
    public static final String LOG_LOGIN_SUCCESS_FIRST = "INSERT INTO logged_in(token,user_id,loggedin) VALUES(?,?,1)";
    public static final String LOG_LOGOUT = "UPDATE logged_in SET token='' AND loggedin=0 WHERE user_id=?";

    public static final String REGISTER_USER = " INSERT INTO users(name,email,password,username) values(?,?,?,?);";
    public static final String REGISTER_USER_FEED = " INSERT INTO user_relationship(user_id, friend_id,type) SELECT id, id, 'friend' FROM users WHERE username=?";

    public static final String GET_LIVE_FEED = "SELECT status.*,users.username,users.name FROM status INNER JOIN user_relationship ON status.user_id=user_relationship.friend_id INNER JOIN users ON users.id=status.user_id WHERE user_relationship.user_id=? AND user_relationship.type='friend' ORDER BY uploaded DESC";
    public static final String GET_USER_POSTS = "SELECT status.*,users.username,users.name FROM status  INNER JOIN users ON users.id=status.user_id WHERE users.id=? ORDER BY uploaded DESC";

    public static final String GET_RECOMMENDED_USERS = "SELECT u.* FROM users as u WHERE u.id NOT IN (SELECT friend_id FROM user_relationship WHERE user_id = ?) AND location=? LIMIT 3";
    public static final String GET_ONLINE_USERS = "SELECT * FROM users WHERE id IN (SELECT friend_id FROM user_relationship WHERE user_id = ? AND friend_id != ?) LIMIT 5";

    public static final String FOLLOW_USER = "INSERT INTO user_relationship(user_id,friend_id,type) VALUES(?,?,'friend')";
}
