package com.example.quiz_system_demo.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Question {
    private int id;
    private String questionType;
    private String description;
    private String correctAnswer;
    private int quizTypeId;

}
