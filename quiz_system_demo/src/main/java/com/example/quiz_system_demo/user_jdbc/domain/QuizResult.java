package com.example.quiz_system_demo.user_jdbc.domain;

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
    private Question question;
    private List<Option> options;
}
