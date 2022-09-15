package com.heady.todayapp.repository;

import com.heady.todayapp.model.User;

public interface UserRepository {
    User getUserByUsername(String username);
    boolean createUser(User user);

}
