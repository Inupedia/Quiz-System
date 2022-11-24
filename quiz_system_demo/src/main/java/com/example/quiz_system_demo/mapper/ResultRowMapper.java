package com.example.quiz_system_demo.mapper;

import com.example.quiz_system_demo.domain.Result;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ResultRowMapper implements RowMapper<Result> {
    @Override
    public Result mapRow(ResultSet rs, int rowNum) throws SQLException {
        Result result = new Result();
        result.setResultId(rs.getInt("result_id"));
        result.setUserChoice(rs.getString("user_choice"));
        result.setQuestionId(rs.getInt("question_id"));
        result.setSubmissionId(rs.getInt("submission_id"));
        return result;
    }
}
