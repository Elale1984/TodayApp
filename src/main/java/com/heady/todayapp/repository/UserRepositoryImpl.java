package com.heady.todayapp.repository;
import com.heady.todayapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private static final String INSERT_USER_QUERY="INSERT INTO user(username, password) VALUES (?, ?)";
    private static final String GET_USER_BY_USERNAME_QUERY="SELECT * FROM user WHERE username=?";


    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public User getUserByUsername(String username) {
        return jdbcTemplate.queryForObject(GET_USER_BY_USERNAME_QUERY,(rs, rowNum) -> new User(
                rs.getString("username"),
                rs.getString("password")), username);
    }

    @Override
    public boolean createUser(User user) {
        jdbcTemplate.update(INSERT_USER_QUERY, user.getUsername(), user.getPassword());
        return true;
    }
}
