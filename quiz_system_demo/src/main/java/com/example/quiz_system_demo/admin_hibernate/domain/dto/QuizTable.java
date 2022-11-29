package com.example.quiz_system_demo.admin_hibernate.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuizTable {
    private Integer id;
    private Date date;
    private String firstName;
    private String lastName;
    private Integer score;
    private String type;
}
