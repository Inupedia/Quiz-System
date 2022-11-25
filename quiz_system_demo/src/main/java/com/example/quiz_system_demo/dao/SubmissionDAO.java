package com.example.quiz_system_demo.dao;

import com.example.quiz_system_demo.mapper.QuizTypeRowMapper;
import com.example.quiz_system_demo.mapper.SubmissionRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public class SubmissionDAO {
    JdbcTemplate jdbcTemplate;
    SubmissionRowMapper submissionRowMapper;
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public SubmissionDAO(JdbcTemplate jdbcTemplate, SubmissionRowMapper submissionRowMapper, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.submissionRowMapper = submissionRowMapper;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    // insert submission, if the quiztypeid already exists, update it with higher score
    public void insertSubmission(int userId, int quizTypeId, int score, Timestamp startTime, Timestamp endTime) {
        String sql = "INSERT INTO submission (user_id, quiz_type_id, score, start_time, end_time) VALUES (?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE score = ?";
        jdbcTemplate.update(sql, userId, quizTypeId, score, startTime, endTime, score);
    }


    // get score by user id and quiz type id
    public int getScoreByUserIdAndQuizTypeId(int userId, int quizTypeId) {
        String sql = "SELECT score FROM submission WHERE user_id = ? AND quiz_type_id = ?";
        // if the user has not taken the quiz, return 0
        try {
            return jdbcTemplate.queryForObject(sql, Integer.class, userId, quizTypeId);
        } catch (Exception e) {
            return 0;
        }
    }

    // delete submission by user id and quiz type id
    public void deleteSubmissionByUserIdAndQuizTypeId(int userId, int quizTypeId) {
        String sql = "DELETE FROM submission WHERE user_id = ? AND quiz_type_id = ?";
        jdbcTemplate.update(sql, userId, quizTypeId);
    }

    // get submission id by user id and quiz type id
    public int getSubmissionIdByUserIdAndQuizTypeId(int userId, int quizTypeId) {
        String sql = "SELECT submission_id FROM submission WHERE user_id = ? AND quiz_type_id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, Integer.class, userId, quizTypeId);
        } catch (Exception e) {
            return 0;
        }
    }
}
