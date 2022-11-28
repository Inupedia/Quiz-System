package com.example.quiz_system_demo.user_jdbc.dao;

import com.example.quiz_system_demo.user_jdbc.domain.Question;
import com.example.quiz_system_demo.user_jdbc.mapper.QuestionRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QuestionDAO {

    JdbcTemplate jdbcTemplate;
    QuestionRowMapper questionRowMapper;
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public QuestionDAO(JdbcTemplate jdbcTemplate, QuestionRowMapper questionRowMapper, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.questionRowMapper = questionRowMapper;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    // get 10 random questions with the given quiz type id
    public List<Question> getRandomQuestions(int quizTypeId, int numOfQuestions) {
        String sql = "SELECT * FROM question WHERE quiz_type_id = ? ORDER BY RAND() LIMIT ?";
        return jdbcTemplate.query(sql, questionRowMapper, quizTypeId, numOfQuestions);
    }

}
