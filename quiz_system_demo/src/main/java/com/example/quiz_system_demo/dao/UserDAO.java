package com.example.quiz_system_demo.dao;

import com.example.quiz_system_demo.domain.User;
import com.example.quiz_system_demo.mapper.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserDAO {
    JdbcTemplate jdbcTemplate;
    UserRowMapper userRowMapper;
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public UserDAO(JdbcTemplate jdbcTemplate, UserRowMapper userRowMapper, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.userRowMapper = userRowMapper;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    // create user
    public void createUser(User user) {
        String sql = "INSERT INTO user (first_name, last_name, email, password) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword());
    }

    // get user by email
    public Optional<User> getUserByEmail(String email) {
        String sql = "SELECT * FROM user WHERE email = ?";
        try {
            return Optional.of(jdbcTemplate.queryForObject(sql, userRowMapper, email));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public boolean validateLogin(String email, String password) {
        String sql = "SELECT COUNT(*) FROM user WHERE email = ? AND password = ?";
        int count = jdbcTemplate.queryForObject(sql, Integer.class, email, password);
        return count > 0;
    }
}
