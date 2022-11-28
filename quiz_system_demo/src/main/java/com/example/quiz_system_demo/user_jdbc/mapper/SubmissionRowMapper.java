package com.example.quiz_system_demo.user_jdbc.mapper;

import com.example.quiz_system_demo.user_jdbc.domain.Submission;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;


@Component
public class SubmissionRowMapper implements RowMapper<Submission> {

    @Override
    public Submission mapRow(ResultSet rs, int rowNum) throws SQLException {
        Submission submission = new Submission();
        submission.setSubmissionId(rs.getInt("submission_id"));
        submission.setUserId(rs.getInt("user_id"));
        submission.setQuizTypeId(rs.getInt("quiz_type_id"));
        submission.setScore(rs.getInt("score"));
        submission.setStartTime(rs.getTimestamp("start_time"));
        submission.setEndTime(rs.getTimestamp("end_time"));
        return submission;
    }
}
