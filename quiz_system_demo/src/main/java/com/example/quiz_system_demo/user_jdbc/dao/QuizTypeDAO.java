package com.example.quiz_system_demo.user_jdbc.dao;

import com.example.quiz_system_demo.user_jdbc.domain.QuizType;
import com.example.quiz_system_demo.user_jdbc.mapper.QuizTypeRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QuizTypeDAO {
    JdbcTemplate jdbcTemplate;
    QuizTypeRowMapper quizTypeRowMapper;
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public QuizTypeDAO(JdbcTemplate jdbcTemplate, QuizTypeRowMapper quizTypeRowMapper, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.quizTypeRowMapper = quizTypeRowMapper;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    // get all quiz types
    public List<QuizType> getAllQuizTypes() {
        String sql = "SELECT * FROM quizType";
        return jdbcTemplate.query(sql, quizTypeRowMapper);
    }

}
