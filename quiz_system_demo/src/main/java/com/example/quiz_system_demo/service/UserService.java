package com.example.quiz_system_demo.service;

import com.example.quiz_system_demo.dao.UserDAO;
import com.example.quiz_system_demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


    public User getUsernameByEmail(String email) {
        return userDAO.getUsernameByEmail(email);
    }

    public boolean validateLogin(String email, String password) {
        return userDAO.validateLogin(email, password);
    }
}
