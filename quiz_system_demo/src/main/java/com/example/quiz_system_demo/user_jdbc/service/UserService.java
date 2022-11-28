package com.example.quiz_system_demo.user_jdbc.service;

import com.example.quiz_system_demo.user_jdbc.dao.UserDAO;
import com.example.quiz_system_demo.user_jdbc.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserDAO userDAO;

    @Autowired
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    // create user
    public void createUser(User user) {
        userDAO.createUser(user);
    }


    public Optional<User> getUserByEmail(String email) {
        return userDAO.getUserByEmail(email);
    }

    public boolean validateLogin(String email, String password) {
        return userDAO.validateLogin(email, password);
    }
}
