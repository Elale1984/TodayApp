package com.heady.todayapp.business;

import com.heady.todayapp.model.User;

public interface UserBusinessServiceInterface {

    boolean authenticateUser(String username, String password);
    boolean registerUser(User user);
    User getUserByUsername(String username);

}
