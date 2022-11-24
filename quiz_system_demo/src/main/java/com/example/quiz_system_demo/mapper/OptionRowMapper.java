package com.example.quiz_system_demo.mapper;

import com.example.quiz_system_demo.domain.Option;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class OptionRowMapper implements RowMapper<Option> {
    @Override
    public Option mapRow(ResultSet rs, int rowNum) throws SQLException {
        Option option = new Option();
        option.setId(rs.getInt("option_id"));
        option.setOptionDescription(rs.getString("description"));
        option.setQuestionId(rs.getInt("question_id"));
        return option;
    }
}
