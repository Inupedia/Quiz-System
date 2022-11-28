package com.example.quiz_system_demo.user_jdbc.mapper;

import com.example.quiz_system_demo.user_jdbc.domain.Question;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class QuestionRowMapper implements RowMapper<Question> {
    @Override
    public Question mapRow(ResultSet rs, int rowNum) throws SQLException {
        Question question = new Question();
        question.setId(rs.getInt("question_id"));
        question.setQuestionType(rs.getString("question_type"));
        question.setDescription(rs.getString("description"));
        question.setCorrectAnswer(rs.getString("correct_answer"));
        question.setQuizTypeId(rs.getInt("quiz_type_id"));
        return question;
    }
}
