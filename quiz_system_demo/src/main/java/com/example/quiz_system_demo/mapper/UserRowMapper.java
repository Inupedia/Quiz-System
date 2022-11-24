package com.example.quiz_system_demo.mapper;

import com.example.quiz_system_demo.domain.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setUserId(rs.getInt("user_id"));
        user.setFirstName(rs.getString("first_name"));
        user.setLastName(rs.getString("last_name"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        user.setAddress(rs.getString("address"));
        user.setPhone(rs.getString("phone"));
        user.setIsAdmin(rs.getInt("isAdmin"));
        user.setIsActive(rs.getInt("isActive"));
        return user;
    }
}
