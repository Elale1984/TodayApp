package com.heady.todayapp.business;

import com.heady.todayapp.model.User;
import com.heady.todayapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class UserBusinessServiceImpl implements UserBusinessServiceInterface {

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean authenticateUser(String username, String password) {

      try {
          User user = userRepository.getUserByUsername(username);
          if (user != null) {
              return user.getPassword().equals(password);
          }
      } catch (EmptyResultDataAccessException e) {
          return false;
      }

        return false;
    }

    @Override
    public boolean registerUser(User user) {
        userRepository.createUser(user);
        return true;
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.getUserByUsername(username);
    }


}
