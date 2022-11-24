package com.example.quiz_system_demo.dao;

import com.example.quiz_system_demo.domain.Option;
import com.example.quiz_system_demo.mapper.OptionRowMapper;
import com.example.quiz_system_demo.mapper.QuestionRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OptionDAO {

    JdbcTemplate jdbcTemplate;
    OptionRowMapper optionRowMapper;
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public OptionDAO(JdbcTemplate jdbcTemplate, OptionRowMapper optionRowMapper, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.optionRowMapper = optionRowMapper;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    // get options by question id
    public List<Option> getOptionsByQuestionId(int questionId) {
        String sql = "SELECT * FROM `option` WHERE question_id = ?";
        return jdbcTemplate.query(sql, optionRowMapper, questionId);
    }
}
