package com.example.quiz_system_demo.user_jdbc.mapper;

import com.example.quiz_system_demo.user_jdbc.domain.QuizType;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class QuizTypeRowMapper implements RowMapper<QuizType> {
    @Override
    public QuizType mapRow(ResultSet rs, int rowNum) throws SQLException {
        QuizType quizType = new QuizType();
        quizType.setId(rs.getInt("quiz_type_id"));
        quizType.setTypeName(rs.getString("type_name"));
        quizType.setTimeLimit(rs.getInt("time_limit"));
        quizType.setDescription(rs.getString("description"));
        return quizType;
    }
}
