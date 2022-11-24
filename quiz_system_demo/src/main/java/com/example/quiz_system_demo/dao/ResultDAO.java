package com.example.quiz_system_demo.dao;

import com.example.quiz_system_demo.mapper.ResultRowMapper;
import com.example.quiz_system_demo.mapper.SubmissionRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ResultDAO {

    JdbcTemplate jdbcTemplate;
    ResultRowMapper resultRowMapper;
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public ResultDAO(JdbcTemplate jdbcTemplate, ResultRowMapper resultRowMapper, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.resultRowMapper = resultRowMapper;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    // insert result
    public void insertResult(int submissionId, int questionId, String userChoice) {
        String sql = "INSERT INTO result (submission_id, question_id, user_choice) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, submissionId, questionId, userChoice);
    }

    // delete result by submission id
    public void deleteResultBySubmissionId(int submissionId) {
        String sql = "DELETE FROM result WHERE submission_id = ?";
        jdbcTemplate.update(sql, submissionId);
    }

    // get result by question id
    public String getResultByQuestionId(int questionId) {
        String sql = "SELECT user_choice FROM result WHERE question_id = ?";
        return jdbcTemplate.queryForObject(sql, String.class, questionId);
    }
}
