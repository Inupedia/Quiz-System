package com.example.quiz_system_demo.admin_hibernate.domain.dto;

import com.example.quiz_system_demo.admin_hibernate.domain.HibernateOption;
import com.example.quiz_system_demo.admin_hibernate.domain.HibernateQuestion;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class QuizResult {
    private int index;
    private String userAnswer;
    private HibernateQuestion question;
    private List<HibernateOption> options;
}