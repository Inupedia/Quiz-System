package com.example.quiz_system_demo.user_jdbc.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class FeedbackDAO {
    JdbcTemplate jdbcTemplate;
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public FeedbackDAO(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    // insert feedback
    public void insertFeedback(String rating, String feedback, int quizTypeId) {
        String sql = "INSERT INTO feedback (rate, comment, quiz_type_id) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, rating, feedback, quizTypeId);
    }
}
