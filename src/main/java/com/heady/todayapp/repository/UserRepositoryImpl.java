package com.heady.todayapp.repository;
import com.heady.todayapp.model.User;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserRepositoryImpl implements UserRepository {

    private static final String INSERT_USER_QUERY="INSERT INTO user(username, password, userid) VALUES (?, ?, ?)";
    private static final String GET_USER_BY_USERNAME_QUERY="SELECT * FROM user WHERE username=?";
    private static final String GET_LAST_USER_QUERY="SELECT userid FROM user WHERE id=(SELECT MAX(id) FROM user)";
    private JdbcTemplate jdbcTemplate;

    @Override
    public User getUserByUsername(String username) {
        return jdbcTemplate.queryForObject(GET_USER_BY_USERNAME_QUERY,(rs, rowNum) -> new User(rs.getString("username"),
                rs.getString("password"),
                rs.getInt("userid")), username);
    }

    @Override
    public boolean createUser(User user) {
        user.setUserid(Integer.parseInt(GET_LAST_USER_QUERY));
        jdbcTemplate.update(INSERT_USER_QUERY, user.getUsername(), user.getPassword(), user.getUserid());
        return true;
    }
}
